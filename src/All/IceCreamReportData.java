package All;


/**
 * Created by johnathansaunders on 2/1/18.
 */
public class IceCreamReportData extends Data {
    String report;

    public IceCreamReportData(String dataCode, String report) {
        super(dataCode);
        this.report = report;
    }

    public String getReport() {
        return report;
    }
}
