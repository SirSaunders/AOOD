import ObserverManagerAnnotations.ObserverManager;
import ObserverManagerAnnotations.Tests.Observables.ObservableData.IceCreamReportData;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

         ObserverManager.getInstance().notifyAllUpdata(new IceCreamReportData("test"));
    }
}
