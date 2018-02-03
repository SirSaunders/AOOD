package All;


/**
 * Created by johnathansaunders on 2/1/18.
 */
public class SMSWriter implements Observable{
    public SMSWriter() {
        update(new SmsWriterData("sms_writer",2));
    }

    private void update(Data data){
        observerManager.notifyAllUpdate(data);
    }
}
