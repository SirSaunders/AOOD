package ObserverManagerAnnotations.Tests.Observers;


import ObserverManagerAnnotations.Data;
import ObserverManagerAnnotations.Observer;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class DisplayWifRadio  {

    public DisplayWifRadio() {

    }

    @Observer
    public void notifyUpdated(Data data) {
        if(data.dataCode().equals("wifi_radio")){
            System.out.println("got radio stuff");
        }
    }
}
