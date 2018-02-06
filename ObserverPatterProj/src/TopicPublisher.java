import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

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

    //also not super memory safe. What happens if the object this callback is operating on is not being used anymore
    //this callback must be cleaned from this list to enable the garbage collector to remove the object from memory
    public void AddObserver(Consumer<T> callback){
        subscribers.add(callback);
    }

    public void PushData(T data){
        //not the safest code, as client code is being invoked from the subject class without knowing
        //what it does
        subscribers.forEach(ob -> ob.accept(data));
    }
}
