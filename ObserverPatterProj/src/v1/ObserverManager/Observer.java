package v1.ObserverManager;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public interface Observer {
     void notifyUpdated(Data data);
    String getListnerCode();

}
