package v1.ObserverManager.Tests.Observables;


import v1.ObserverManager.Data;
import v1.ObserverManager.ObserverManager;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class IceCreamReport {
    ObserverManager observerManager;
    public IceCreamReport() {
        observerManager = ObserverManager.getInstance();

    }

    public void update(){
        observerManager.notifyAllUpdate(new Data("ice_cream_report"));
    }
}
