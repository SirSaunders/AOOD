package ObserverManagerAnnotations.Tests.Observables.ObservableData;

import ObserverManagerAnnotations.Data;

import java.lang.annotation.Annotation;

/**
 * Created by johnathansaunders on 2/1/18.
 */
@ObserverManagerAnnotations.Data(dataCode="wifi_radio")
public class IceCreamReportData implements Data {
    String report;

    public IceCreamReportData( String report) {
        this.report = report;
    }

    @Override
    public String dataCode() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
