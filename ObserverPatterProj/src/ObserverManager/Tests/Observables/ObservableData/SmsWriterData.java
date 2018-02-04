package ObserverManager.Tests.Observables.ObservableData;

import ObserverManager.Data;

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
