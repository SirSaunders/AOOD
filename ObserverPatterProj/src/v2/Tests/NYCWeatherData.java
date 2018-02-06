package v2.Tests;

import v2.TopicPublisher;
import v2.annotations.Topic;

public class NYCWeatherData {
  @Topic
  private TopicPublisher<String> dailyWeatherPub;

  public NYCWeatherData() {
    dailyWeatherPub = new TopicPublisher<>("NYCDailyWeather");
  }

  public void publish() {
    dailyWeatherPub.pushData("today is sunny i hope :) in NYC");
  }
}
