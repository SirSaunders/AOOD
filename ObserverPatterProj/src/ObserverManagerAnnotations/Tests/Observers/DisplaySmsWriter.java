package ObserverManagerAnnotations.Tests.Observers;


import ObserverManagerAnnotations.Data;
import ObserverManagerAnnotations.Observer;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class DisplaySmsWriter  {

    public DisplaySmsWriter() {

    }

    @Observer
    public void notifyUpdated(Data data) {
        if(data.dataCode().equals("sms_writer")){
            System.out.println("got sms stuff");
        }
    }
}
