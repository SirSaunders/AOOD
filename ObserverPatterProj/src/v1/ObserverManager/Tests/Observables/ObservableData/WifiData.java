package v1.ObserverManager.Tests.Observables.ObservableData;


import v1.ObserverManager.Data;

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
