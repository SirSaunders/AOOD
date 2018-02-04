package ObserverManager.Tests.Observables.ObservableData;

import ObserverManager.Data;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class WifiData extends Data {
    boolean hasWifi;

    public WifiData(String dataCode, boolean hasWifi) {
        super(dataCode);
        this.hasWifi = hasWifi;
    }

}
