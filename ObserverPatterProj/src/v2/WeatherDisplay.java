package v2;

import v2.annotations.Subscriber;

public class WeatherDisplay {
  @Subscriber(topicCategory = "dailyWeather")
  public void printOnRain(String weatherDescription) {
    System.out.println("Daily weather notification: " + weatherDescription);
  }
}
