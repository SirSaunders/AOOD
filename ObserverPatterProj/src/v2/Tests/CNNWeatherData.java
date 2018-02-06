package v2.Tests;

import v2.TopicPublisher;
import v2.annotations.Topic;

public class CNNWeatherData {
  @Topic
  private TopicPublisher<String> dailyWeatherPub;

  public CNNWeatherData() {
    dailyWeatherPub = new TopicPublisher<>("CNNDailyWeather");
  }

  public void publish() {
    dailyWeatherPub.pushData("today is sunny i hope :) from CNN");
  }
}
