import annotations.Subscriber;
import annotations.Topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.lang.reflect.*;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

//supressing unchecked warnings since we are manually verifying the generic types of callback functions and TopicPublishers
@SuppressWarnings("unchecked")
public class InformationNetwork {
    private List<TopicPublisher> publishers;

    private Map<Consumer, Method> subscribers;

    public InformationNetwork(){
        publishers = new ArrayList<>();
        subscribers = new HashMap<>();
    }


    //use this method to add publishers or subscribers lol
    public void add(Object obj){

        //check all methods of this object to see if it has subscribers to add to the information network
        for( Method method : obj.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(Subscriber.class)){
                Class newMethodDataClass = method.getParameterTypes()[0].getDeclaringClass();
                String newMethodCategory = method.getAnnotation(Subscriber.class).topicCategory();

                publishers.forEach(pub -> {
                    //if the category matches, then we'll bother with checking the generic type of the pub and creating a lambda
                    if(pub.getCategoryString().equals(newMethodCategory)){
                        //check if the types match
                        Class publisherDataType =
                                (Class)
                                        ((ParameterizedType)
                                                pub.getClass()
                                                        .getGenericSuperclass())
                                                .getActualTypeArguments()[0];
                        //check that the generic type of the publisher matches the method's first parameter
                        if(publisherDataType.equals(newMethodDataClass)){
                            //now we have the go-ahead to do crazy madman stuff
                            //create a lambda function which invokes this method on this object
                            // with the given data (given in the future by the TopicPublisher) as a parameter
                            Consumer func = data -> {
                                try {
                                    method.invoke(obj, data);
                                } catch(Exception e) {
                                    //if any exceptions, just give up at this point lmao
                                }
                            };
                            pub.AddObserver(func);
                        }
                    }
                });
            }
        }

        //check all fields of this object to see if it has topic publishers to add to the information network
        for( Field field : obj.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(Topic.class) && field.getType().equals(TopicPublisher.class)) {
                try {
                    TopicPublisher publisher = (TopicPublisher) field.get(obj);
                    //get the type of the publisher object
                    Class publisherDataType =
                            (Class)
                                    ((ParameterizedType)
                                            publisher.getClass()
                                                    .getGenericSuperclass())
                                            .getActualTypeArguments()[0];
                    subscribers.entrySet().forEach(entry -> {
                                Consumer func = entry.getKey();
                                Method method = entry.getValue();
                                //get the input type of our function
                                Class existingFuncDataType =
                                        (Class)
                                                ((ParameterizedType)
                                                        func.getClass()
                                                                .getGenericSuperclass())
                                                        .getActualTypeArguments()[0];
                                String methodCategory = method.getAnnotation(Subscriber.class).topicCategory();

                                //if both the data type and the category match this new topic,
                                // then add it to the topic's function list
                                if(publisherDataType.equals(existingFuncDataType) && publisher.getCategoryString().equals(methodCategory)){
                                    publisher.AddObserver(func);
                                }
                            }
                    );
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
