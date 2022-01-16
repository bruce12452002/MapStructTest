package org.example;

import bean.*;
import mapping.Car2Mapping;
import mapping.Car3Mapping;
import mapping.CarMapping;
import mapping.HomeMapping;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AppTest {
    private final Car car = new Car();

    @Test
    public void test1() {
        CarDto carDto = CarMapping.INSTANCE.carToCarDto(car);
//    CarDto carDto = CarMapping.INSTANCE.carToCarDto2(getCar());
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
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car);
        List<CarDto> carDtos = CarMapping.INSTANCE.carsToCarDtos(cars);

        carDtos.forEach(carDto -> {
            System.out.println(carDto.getMake());
            System.out.println(carDto.getMake2());
            System.out.println(carDto.getSeatCount());
            System.out.println(carDto.getConstant());
            System.out.println(carDto.getPrice());
            System.out.println(carDto.getDate());
            System.out.println(carDto.getDateTime());
            System.out.println(carDto.getType());
            System.out.println("-----------------------");
        });
    }

    @Test
    public void test3() {
        Car2 car2 = CarMapping.INSTANCE.carToCar2(car);
        System.out.println(car2.getMake());
        System.out.println(car2.getPrice());
    }

    @Test
    public void test4() {
        Car2 car2 = CarMapping.INSTANCE.carToCar2ByLanguage(car);
        System.out.println(car2.getMake());
        System.out.println(car2.getPrice());
        System.out.println(car2.getLanguage());
    }

    @Test
    public void test5() {
        Address address = new Address();
        address.setAddName("12345");

        Home home = new Home();
        home.setAddress(address);

        HomeDto homeDto = HomeMapping.INSTANCE.homeToHomeDto(home);
        System.out.println(homeDto.getAddressDto().getAddId());
        System.out.println(homeDto.isXxx());
    }

    @Test
    public void test6() {
        Car2 car2 = Car2Mapping.INSTANCE.carToCar2(car);
        System.out.println(car2.getMake());
        System.out.println(car2.getPrice());
        System.out.println(car2.getLanguage());

        Car car = new Car();
        car.setLanguage("en_US");
        car.setConstant("ooo");
        Car2Mapping.INSTANCE.updateCar2(car, car2);
        System.out.println("-----------------------");
        System.out.println(car2.getLanguage());
        System.out.println(car2.getDifferent());
    }

    @Test
    public void test7() {
        Car2 car2 = new Car2();
        car2.setMake("make");
        car2.setPrice(123.456D);
        car2.setLanguage("zh_TW");
        car2.setDifferent("xxx");

        Car car = Car2Mapping.INSTANCE.car2ToCar(car2);
        System.out.println(car.getMake());
        System.out.println(car.getPrice());
        System.out.println(car.getLanguage());
    }

    @Test
    public void test8() {
        Car2 car2 = Car3Mapping.INSTANCE.carToCar2ByLanguage(car);
        System.out.println(car2.getLanguage());
    }

    @Test
    public void test9() {
        List<String> strings = CarMapping.INSTANCE.intToString(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(strings);
    }


    @Before
    public void getCar() {
        car.setMake("make");
        car.setMake2("999");
        car.setNumberOfSeats(6);
        car.setPrice(123.456D);
        car.setDate(new Date());
        car.setDateTime(LocalDateTime.now());

        CarType carType = new CarType();
        carType.setType("my type");
        car.setCarType(carType);
    }
}
