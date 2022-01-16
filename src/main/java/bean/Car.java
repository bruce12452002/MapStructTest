package bean;

import java.time.LocalDateTime;
import java.util.Date;

public class Car {
  private String make;
  private String make2;
  private int numberOfSeats;
  private String constant;
  private double price;
  private Date date;
  private LocalDateTime dateTime;
  private CarType carType;
  private String language;

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getMake2() {
    return make2;
  }

  public void setMake2(String make2) {
    this.make2 = make2;
  }

  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(int numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  public String getConstant() {
    return constant;
  }

  public void setConstant(String constant) {
    this.constant = constant;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public CarType getCarType() {
    return carType;
  }

  public void setCarType(CarType carType) {
    this.carType = carType;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }
}
