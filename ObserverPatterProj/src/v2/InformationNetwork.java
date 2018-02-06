package v2;

import v2.annotations.Subscriber;
import v2.annotations.Topic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

//supressing unchecked warnings since we are manually verifying the generic types of callback functions and TopicPublishers
@SuppressWarnings("unchecked")
public class InformationNetwork {

    private Map<Field, TopicPublisher> publishers;
    private Map<Consumer, Method> subscribers;

    public InformationNetwork() {
        publishers = new HashMap<>();
        subscribers = new HashMap<>();
    }

    // Add publishers or subscribers
    public void add(Object obj) {

        // Check all methods of this object to see if it has subscribers to add to the information network
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscriber.class)) {
                addObserverToNetwork(obj, method);
            }
        }

        // Check all fields of this object to see if it has topic publishers to add to the information network
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Topic.class) && field.getType().equals(TopicPublisher.class)) {
                addTopicPublisherToNetwork(obj, field);
            }
        }
    }

    private void addObserverToNetwork(Object obj, Method method) {
        Class newMethodDataClass = method.getParameterTypes()[0];
        String newMethodCategory = method.getAnnotation(Subscriber.class).topicCategory();
        Consumer func = data -> {
            try {
                method.invoke(obj, data);
            } catch (Exception e) {
                //if any exceptions, just give up at this point lmao
                System.out.println("wtf");
            }
        };
        publishers.forEach((field, pub) -> {

            //if the category matches, then we'll bother with checking the generic type of the pub and creating a lambda
            if (pub.getCategoryString().equals(newMethodCategory)) {
                //check if the types match
                ParameterizedType topPublisherType = (ParameterizedType) field.getGenericType();
                Class<?> publisherDataType = (Class<?>) topPublisherType.getActualTypeArguments()[0];

                //check that the generic type of the publisher matches the method's first parameter
                if (publisherDataType.equals(newMethodDataClass)) {
                    //now we have the go-ahead to do crazy madman stuff
                    //create a lambda function which invokes this method on this object
                    // with the given data (given in the future by the v2.TopicPublisher) as a parameter

                    pub.addObserver(func);

                }
            }

        });
        subscribers.put(func, method);
    }

    private void addTopicPublisherToNetwork(Object obj, Field field) {
        try {
            field.setAccessible(true);
            TopicPublisher publisher = (TopicPublisher) field.get(obj);
            //get the type of the publisher object
            ParameterizedType topPublisherType = (ParameterizedType) field.getGenericType();
            Class<?> publisherDataType = (Class<?>) topPublisherType.getActualTypeArguments()[0];

            subscribers.forEach((func, method) -> {
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
                if (publisherDataType.equals(existingFuncDataType) && publisher.getCategoryString().equals(methodCategory)) {
                    publisher.addObserver(func);
                }
            });
            publishers.put(field, publisher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
