package All;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public interface Observer {
    ObserverManager observerManger = ObserverManager.getInstance();
     void notifyUpdated(Data data);


}
