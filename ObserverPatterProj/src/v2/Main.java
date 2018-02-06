package v2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

         //ObserverManager.getInstance().notifyAllUpdata(new IceCreamReportData("test"));

         //need to make a class using the subscriber annotation and instantiate that
         //need to make a class using the topic publishers and instantiate that
         //need to add them to the v2.InformationNetwork and then booyah its hooked up

         InformationNetwork net = new InformationNetwork();
         WeatherData data = new WeatherData();
         WeatherDisplay observer = new WeatherDisplay();
         net.add(data);
         net.add(observer);
         data.publish();
    }
}
