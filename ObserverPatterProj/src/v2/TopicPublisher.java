package v2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TopicPublisher<T> {
    private List<Consumer<T>> subscribers;
    private String categoryString;

    public TopicPublisher(String categoryString){
        this.categoryString = categoryString;
        subscribers = new ArrayList<>();
    }

    public String getCategoryString(){
        return categoryString;
    }

    public void addObserver(Consumer<T> callback){
        subscribers.add(callback);
    }

    public void pushData(T data) {
        subscribers.forEach(ob -> ob.accept(data));
    }
}
