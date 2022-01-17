package decorate;

import bean.Car;
import bean.Car2;
import mapping.Car3Mapping;

public abstract class MyDecorate implements Car3Mapping {
  private final Car3Mapping proxy;

  public MyDecorate(Car3Mapping proxy) {
    this.proxy = proxy;
  }

  @Override
  public Car2 carToCar2ByLanguage(Car car) {
    Car2 car2 = proxy.carToCar2ByLanguage(car);
    // 自定的邏輯
    if (!car2.getLanguage().isEmpty()) {
      car2.setLanguage("*" + car2.getLanguage() + "*");
    }
    return car2;
  }
}
