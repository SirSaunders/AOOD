package v2.Tests;

import v2.annotations.Subscriber;

public class CNNDisplay {
  @Subscriber(topicCategory = "CNNDailyWeather")
  public void printOnRain(String weatherDescription) {
    System.out.println("Daily weather notification: " + weatherDescription);
  }
}
