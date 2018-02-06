package v2.Tests;

import v2.InformationNetwork;

/**
 * Created by johnathansaunders on 2/5/18.
 */
public class Test {
    static public void start_test(){
        //weather 1
        InformationNetwork net = new InformationNetwork();
        WeatherData data = new WeatherData();
        WeatherDisplay observer = new WeatherDisplay();
        net.add(data);
        net.add(observer);

        //CNN Weather
        NYCWeatherData nycWeatherData = new NYCWeatherData();
        NYCWeatherDisplay nycWeatherDisplay = new NYCWeatherDisplay();
        net.add(nycWeatherData);
        net.add(nycWeatherDisplay);


        //NYC Weather
        CNNWeatherData cnnWeatherData = new CNNWeatherData();
        CNNDisplay cnnWeatherDisplay = new CNNDisplay();
        net.add(cnnWeatherData);
        net.add(cnnWeatherDisplay);

        try {

            data.publish();
            nycWeatherData.publish();
            cnnWeatherData.publish();
            Thread.sleep(1000);
            cnnWeatherData.publish();

            Thread.sleep(1000);
            nycWeatherData.publish();

            Thread.sleep(2000);
            data.publish();

            Thread.sleep(2000);
            nycWeatherData.publish();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
