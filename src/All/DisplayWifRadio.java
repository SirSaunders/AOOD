package All;


/**
 * Created by johnathansaunders on 2/1/18.
 */
public class DisplayWifRadio implements Observer {

    public DisplayWifRadio() {
        observerManger.addObserver(this);
    }

    @Override
    public void notifyUpdated(Data data) {
        if(data.getDataCode().equals("wifi_radio")){
            System.out.println("got radio stuff"+((WifiData)data).isWifiOn());
        }
    }
}
