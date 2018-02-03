package All;



/**
 * Created by johnathansaunders on 2/1/18.
 */
public class IceCreamReport implements Observable{
    public IceCreamReport() {
        update(new IceCreamReportData("ice_cream_report","report stuff"));
    }

    private void update(Data data){
        observerManager.notifyAllUpdate(data);
    }
}
