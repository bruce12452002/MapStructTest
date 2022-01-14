package org.example;

import bean.Car;
import bean.CarDto;
import bean.CarType;
import mapping.CarMapping;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class AppTest {
  @Test
  public void test1() {
    CarDto carDto = CarMapping.INSTANCE.carToCarDto(getCar());
    System.out.println(carDto.getMake());
    System.out.println(carDto.getMake2());
    System.out.println(carDto.getSeatCount());
    System.out.println(carDto.getConstant());
    System.out.println(carDto.getPrice());
    System.out.println(carDto.getDate());
    System.out.println(carDto.getDateTime());
    System.out.println(carDto.getType());
  }

  private Car getCar() {
    Car car = new Car();
    car.setMake("make");
    car.setMake2("999");
    car.setNumberOfSeats(6);
    car.setPrice(123.456D);
    car.setDate(new Date());
    car.setDateTime(LocalDateTime.now());

    CarType carType = new CarType();
    carType.setType("my type");
    car.setCarType(carType);
    return car;
  }
}
