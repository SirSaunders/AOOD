package v1.ObserverManager;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public interface Observer {
     void notifyUpdated(Data data);

    /**
     * Must return a string of data the observer is listening for
     * @return data code Observer is listening for
     */
    String getListnerCode();

}
