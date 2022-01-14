package org.example;

import bean.*;
import mapping.CarMapping;
import mapping.HomeMapping;
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

  @Test
  public void test2() {
    Address address = new Address();
    address.setAddName("xxxxxxxxxxxxxxxxxxxx");

    Home home = new Home();
    home.setAddress(address);

    HomeDto homeDto = HomeMapping.INSTANCE.homeToHomeDto(home);
    System.out.println(homeDto.getAddressDto().getAddId());
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
