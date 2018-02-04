package ObserverManagerAnnotations.Tests.Observers;


import ObserverManagerAnnotations.Data;
import ObserverManagerAnnotations.Observer;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class DisplayIcreCreamReport {

    public DisplayIcreCreamReport() {
    }


    @Observer
    public void notifyUpdated(Data data) {
        if(data.dataCode().equals("ice_cream_report")){
            System.out.println("got icecream report");
        }
    }
}
