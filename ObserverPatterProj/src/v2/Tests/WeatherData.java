package v2.Tests;

import v2.annotations.Topic;
import v2.TopicPublisher;

public class WeatherData {
  @Topic
  private TopicPublisher<String> dailyWeatherPub;

  public WeatherData() {
    dailyWeatherPub = new TopicPublisher<>("dailyWeather");
  }

  public void publish() {
    dailyWeatherPub.pushData("today is sunny i hope :)");
  }
}
