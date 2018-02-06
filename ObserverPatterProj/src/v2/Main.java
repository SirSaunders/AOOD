package v2;

import v2.Tests.Test;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

         //ObserverManager.getInstance().notifyAllUpdata(new IceCreamReportData("test"));

         //need to make a class using the subscriber annotation and instantiate that
         //need to make a class using the topic publishers and instantiate that
         //need to add them to the v2.InformationNetwork and then booyah its hooked up

        Test.start_test();
    }
}
