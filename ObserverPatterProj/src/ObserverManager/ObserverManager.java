package ObserverManager;

import java.util.List;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class ObserverManager {
     List<Observer> observers;
    static private ObserverManager observerManager;

    private ObserverManager(){

    }

  synchronized static public ObserverManager getInstance(){
        if (observerManager == null){
            observerManager = new ObserverManager();
        }
        return observerManager;
    }
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    public void notifyAllUpdate(Data data){
        for (Observer observer:observers) {
            observer.notifyUpdated(data);
        }
    }
}
