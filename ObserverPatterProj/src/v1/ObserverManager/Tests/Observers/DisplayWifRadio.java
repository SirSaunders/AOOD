package v1.ObserverManager.Tests.Observers;


import v1.ObserverManager.Data;
import v1.ObserverManager.Observer;
import v1.ObserverManager.ObserverManager;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class DisplayWifRadio  {

    public DisplayWifRadio() {
       ObserverManager.getInstance().addObserver(new Observer() {
            @Override
            public void notifyUpdated(Data data) {
                System.out.println(data.getDataCode());
            }

        },"wifi_radio");
    }


}
