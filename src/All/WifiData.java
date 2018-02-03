package All;


/**
 * Created by johnathansaunders on 2/1/18.
 */
public class WifiData extends Data {
    boolean hasWifi;

    public WifiData(String dataCode, boolean hasWifi) {
        super(dataCode);
        this.hasWifi = hasWifi;
    }

    public boolean isWifiOn() {
        return hasWifi;
    }
}
