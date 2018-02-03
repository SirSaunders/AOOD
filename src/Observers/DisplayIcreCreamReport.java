package Observers;

import ObserverManager.Data;
import ObserverManager.Observer;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class DisplayIcreCreamReport implements Observer{

    public DisplayIcreCreamReport() {
        observerManger.addObserver(this);
    }

    @Override
    public void notifyUpdated(Data data) {
        if(data.getDataCode().equals("ice_cream_report")){
            System.out.println("got icecream report");
        }
    }
}
