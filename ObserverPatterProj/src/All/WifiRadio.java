package All;



/**
 * Created by johnathansaunders on 2/1/18.
 */
public class WifiRadio implements Observable{
    public WifiRadio() {
        update(new WifiData("wifi_radio",true));
    }

    private void update(Data data){
        observerManager.notifyAllUpdate(data);
    }
}
