package v1.ObserverManager.Tests.Observables.ObservableData;


import v1.ObserverManager.Data;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class IceCreamReportData extends Data {
    String report;

    public IceCreamReportData(String dataCode, String report) {
        super(dataCode);
        this.report = report;
    }
}
