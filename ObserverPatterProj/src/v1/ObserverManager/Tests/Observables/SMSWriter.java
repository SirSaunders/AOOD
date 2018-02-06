package v1.ObserverManager.Tests.Observables;


import v1.ObserverManager.Data;
import v1.ObserverManager.ObserverManager;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class SMSWriter {
    ObserverManager observerManager;
    public SMSWriter() {
        observerManager = ObserverManager.getInstance();

    }

    public void update(){
        observerManager.notifyAllUpdate(new Data("sms_writer"));
    }
}
