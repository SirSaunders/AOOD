package v1.ObserverManager.Tests.Observables.ObservableData;


import v1.ObserverManager.Data;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class SmsWriterData extends Data {
    int message_id;

    public SmsWriterData(String dataCode, int message_id) {
        super(dataCode);
        this.message_id = message_id;
    }
}
