package v1.ObserverManager;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class ObserverManager {
    HashMap<String, LinkedList<Observer>>  observers;
    static private ObserverManager observerManager;

    private ObserverManager(){
    observers = new HashMap<String, LinkedList<Observer>>();
    }

  synchronized static public ObserverManager getInstance(){
        if (observerManager == null){
            observerManager = new ObserverManager();
        }
        return observerManager;
    }

    /**
     * @param observer
     * @param subscriptionCode
     */
    public void addObserver(Observer observer,String subscriptionCode){
      LinkedList<Observer> observersList = observers.get(subscriptionCode);
        if(observersList == null) {
            observersList = new LinkedList<Observer>();
            observers.put(subscriptionCode,observersList);
        }
        observersList.add(observer);

    }
    public void removeObserver(Observer observer){
        for(String key: observers.keySet()) {
            LinkedList<Observer> observersList = observers.get(key);
            if(observersList !=null) {
                observersList.remove(observer);
            }
        }
    }

    /**
     * checks if any observers are subscribed, if they are then it will only notified those subscribed
     * @param data
     */
    public void notifyAllUpdate(Data data){
        if(data.dataCode != null) {
            LinkedList<Observer> observersList =observers.get(data.dataCode);
                if(observersList != null) {
                    for (Observer observer : observersList) {
                        observer.notifyUpdated(data);
                    }
                }
        }
    }
}
