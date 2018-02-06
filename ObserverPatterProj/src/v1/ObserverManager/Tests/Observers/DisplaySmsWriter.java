package v1.ObserverManager.Tests.Observers;


import v1.ObserverManager.Data;
import v1.ObserverManager.Observer;
import v1.ObserverManager.ObserverManager;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class DisplaySmsWriter  {

    public DisplaySmsWriter() {

        ObserverManager.getInstance().addObserver(new Observer() {
            @Override
            public void notifyUpdated(Data data) {
                System.out.println(data.getDataCode());

            }

            @Override
            public String getListnerCode() {
                return "sms_writer";
            }
        });
    }


}
