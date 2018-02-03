package All;


/**
 * Created by johnathansaunders on 2/1/18.
 */
public class DisplaySmsWriter implements Observer {

    public DisplaySmsWriter() {
        observerManger.addObserver(this);
    }

    @Override
    public void notifyUpdated(Data data) {
        if(data.getDataCode().equals("sms_writer")){
            System.out.println("got sms stuff"+((SmsWriterData)data).getMessage_id());
        }
    }
}