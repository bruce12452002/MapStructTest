package mapping;

import bean.Car;
import bean.Car2;
import bean.CarDto;
import bean.named.Language;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;

/**
 * @Mapper 表示些類別要使用 mapStruct，會通過「繼承或實現」去實現，類別名稱叫 xxxImpl
 * imports：表示 xxxImpl 需要用到的 package
 * uses：將其他的 class 包進來，其他類別寫 @Mapper 並不會去找，如以下範例的 @Named
 */
@Mapper(imports = Date.class, uses = Language.class)
public interface CarMapping { // 也可用抽象類別
    CarMapping INSTANCE = Mappers.getMapper(CarMapping.class);

    //  @Mapping(target = "make", source = "make") // 欄位名稱一樣可省略，欄位類型為基本型態和 String 可互轉，但轉不過會報錯
    @Mapping(target = "seatCount", source = "numberOfSeats")
    @Mapping(target = "constant", constant = "xxx")
    @Mapping(target = "price", source = "price", numberFormat = "#.0" /*, ignore = true*/)
    @Mapping(target = "date", expression = "java(new Date())")
    @Mapping(target = "dateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "type", source = "car.carType.type")
    CarDto carToCarDto(Car car);

    // @Mappings 和 @Mapping：@Mappings 包含多個 @Mapping
//  @Mappings({
//    @Mapping(target = "seatCount", source = "numberOfSeats"),
//    @Mapping(target = "constant", constant = "xxx"),
//    @Mapping(target = "price", source = "price", numberFormat = "#.00" /*, ignore = true*/),
//    @Mapping(target = "date", expression = "java(new Date())"),
//    @Mapping(target = "dateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
//    @Mapping(target = "type", source = "car.carType.type")
//  })
//  CarDto carToCarDto2(Car car);

    /**
     * 有些欄位不想 mapping，可以用 ignore，但有些情況是有非常多的欄位都想 ignore，那要寫很多
     * 所以使用 @BeanMapping 的 ignoreByDefault 可以忽略預設的行為，然後將想 mapping 的欄位打出來即可
     */
    @BeanMapping(ignoreByDefault = true)
//  @Mapping(target = "make", source="make", ignore = true)
//  @Mapping(target = "price", source="price", ignore = true)
    @Mapping(target = "make", source = "make")
    Car2 carToCar2(Car car);

    List<CarDto> carsToCarDtos(List<Car> car);

    @Mapping(target = "language", qualifiedByName = {"lang", "taiwan"})
    Car2 carToCar2ByLanguage(Car car);

    // @Mapping 的 qualifiedByName 可以找到 @Named，
    // 但 @Mapper 的 uses 如果有加其他的 class 且 @Named 也相同會報錯
//    @Named("taiwan")
//    default String toTaiwan(String lan) {
//        return "中文2";
//    }
}
