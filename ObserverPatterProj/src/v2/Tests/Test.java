package v2.Tests;

import v2.InformationNetwork;

/**
 * Created by johnathansaunders on 2/5/18.
 */
public class Test {
    static public void start_test(){
        //need to make a class using the subscriber annotation and instantiate that
        //need to make a class using the topic publishers and instantiate that
        //need to add them to the v2.InformationNetwork and then booyah its hooked up


        InformationNetwork net = new InformationNetwork();

        //weather 1
        WeatherData data = new WeatherData();
        WeatherDisplay observer = new WeatherDisplay();


        //CNN Weather
        NYCWeatherData nycWeatherData = new NYCWeatherData();
        NYCWeatherDisplay nycWeatherDisplay = new NYCWeatherDisplay();

        //NYC Weather
        CNNWeatherData cnnWeatherData = new CNNWeatherData();
        CNNDisplay cnnWeatherDisplay = new CNNDisplay();

        //add data sources to be observed
        net.add(data);
        net.add(cnnWeatherData);
        net.add(nycWeatherData);

        //add displays
        net.add(nycWeatherDisplay);
        net.add(observer);
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
