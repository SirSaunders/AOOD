package v1.ObserverManager.Tests;


import v1.ObserverManager.Tests.Observables.IceCreamReport;
import v1.ObserverManager.Tests.Observables.SMSWriter;
import v1.ObserverManager.Tests.Observables.WifiRadio;
import v1.ObserverManager.Tests.Observers.DisplayIcreCreamReport;
import v1.ObserverManager.Tests.Observers.DisplaySmsWriter;
import v1.ObserverManager.Tests.Observers.DisplayWifRadio;

/**
 * Created by johnathansaunders on 2/5/18.
 */
public class Test {
    static public void start_test(){
        new DisplayIcreCreamReport();
        new DisplaySmsWriter();
        new DisplayWifRadio();

        IceCreamReport report = new IceCreamReport();
        WifiRadio radio = new WifiRadio();
        SMSWriter sms = new SMSWriter();


        report.update();
        radio.update();
        sms.update();
        try {
            Thread.sleep(1000);
            sms.update();
            Thread.sleep(1000);
            sms.update();
            Thread.sleep(2000);
            radio.update();
            Thread.sleep(2000);
            report.update();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
