package v2.Tests;

import v2.annotations.Subscriber;

public class WeatherDisplay {
  @Subscriber(topicCategory = "dailyWeather")
  public void printOnRain(String weatherDescription) {
    System.out.println("Daily weather notification: " + weatherDescription);
  }
}
