package mapping;

import bean.Car;
import bean.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Date;

@Mapper(imports = Date.class)
public interface CarMapping { // 也可用抽象類別
  CarMapping INSTANCE = Mappers.getMapper(CarMapping.class);

  //  @Mapping(target = "make", source = "make") // 欄位名稱一樣可省略，欄位類型為基本型態和 String 可互轉，但轉不過會報錯
  @Mapping(target = "seatCount", source = "numberOfSeats")
  @Mapping(target = "constant", constant = "xxx")
  @Mapping(target = "price", source="price", numberFormat = "#.0" /*, ignore = true*/)
  @Mapping(target = "date", expression = "java(new Date())")
  @Mapping(target = "dateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
  @Mapping(target = "type", source = "car.carType.type")
  CarDto carToCarDto(Car car);

  // @Mappings 和 @Mapping：@Mappings 包含多個 @Mapping
  @Mappings({
    @Mapping(target = "seatCount", source = "numberOfSeats"),
    @Mapping(target = "constant", constant = "xxx"),
    @Mapping(target = "price", source = "price", numberFormat = "#.00" /*, ignore = true*/),
    @Mapping(target = "date", expression = "java(new Date())"),
    @Mapping(target = "dateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
    @Mapping(target = "type", source = "car.carType.type")
  })
  CarDto carToCarDto2(Car car);
}
