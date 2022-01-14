package bean;

import java.time.LocalDateTime;
import java.util.Date;

public class CarDto {
  private String make;
  private int make2;
  private int seatCount;
  private String constant;
  private double price;
  private Date date;
  private LocalDateTime dateTime;
  private String type;

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public int getMake2() {
    return make2;
  }

  public void setMake2(int make2) {
    this.make2 = make2;
  }

  public int getSeatCount() {
    return seatCount;
  }

  public void setSeatCount(int seatCount) {
    this.seatCount = seatCount;
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
