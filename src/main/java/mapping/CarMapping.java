package mapping;

import bean.Car;
import bean.Car2;
import bean.CarDto;
import bean.named.Language;
import enu.CheeseType;
import enu.CheeseTypeSuffixed;
import enu.MyEnum;
import enu.MyEnum2;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Mapper 表示些類別要使用 mapStruct，會通過「繼承或實現」去實現，預設類別名稱叫 xxxImpl，可使用 implementationName 去改 imports：表示
 * xxxImpl 需要用到的 package uses：將其他的 class 包進來，其他類別寫 @Mapper 並不會去找，如以下範例的 @Named
 * implementationName：生成的子類別名稱 unmappedSourcePolicy：source 沒有映射到 target 的策略，預設是忽略
 * unmappedTargetPolicy：target 沒有映射到 source 的策略，預設是警告 typeConversionPolicy：類型轉換策略，預設是忽略
 * nullValueMappingStrategy：source 值是 null 值的策略，預設是 null componentModel：依賴注入，如有整合 spring，給 spring
 * 會生成 @Component
 */
@Mapper(imports = Date.class, uses = Language.class)
@MapperConfig
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
   * 有些欄位不想 mapping，可以用 ignore，但有些情況是有非常多的欄位都想 ignore，那要寫很多 所以使用 @BeanMapping 的 ignoreByDefault
   * 可以忽略預設的行為，然後將想 mapping 的欄位打出來即可
   */
  @BeanMapping(ignoreByDefault = true)
  //  @Mapping(target = "make", source="make", ignore = true)
  //  @Mapping(target = "price", source="price", ignore = true)
  @Mapping(target = "make", source = "make")
  Car2 carToCar2(Car car);

  /** 如果有 Car 轉 CarDto 的映射，變成 List 和 Set 可以自動轉換 */
  List<CarDto> carsToCarDtos(List<Car> car);

  @Mapping(
      target = "language",
      qualifiedByName = {"lang", "taiwan"})
  Car2 carToCar2ByLanguage(Car car);

  // @Mapping 的 qualifiedByName 可以找到 @Named，
  // 但 @Mapper 的 uses 如果有加其他的 class 且 @Named 也相同會報錯
  //    @Named("taiwan")
  //    default String toTaiwan(String lan) {
  //        return "中文2";
  //    }

  /** 集合轉換 */
  @IterableMapping(numberFormat = "$#.00")
  List<String> intToString(List<Integer> ints);

  /** Map 轉換 */
  @MapMapping(keyDateFormat = "yyyy--MM--dd HH==mm", valueNumberFormat = "0.00")
  Map<String, String> mapToMap(Map<Date, Double> sourceMap);

  /**
   * enum 轉換
   * 一個 source 可以對應到多個 target，相反則不行
   *
   * MappingConstants.ANY_REMAINING 和 MappingConstants.ANY_UNMAPPED 的差異看生成的源始碼可以知道
   * ※ANY_UNMAPPED：在 @ValueMapping 沒有寫出來的，直接在最後是 default
   * ※ANY_REMAINING：在 @ValueMapping 沒有寫出來的，還會繼續對應同名的，以這個例子還有 case MY_ENUM_C 的對應關係
   */
  @ValueMappings({
    @ValueMapping(target = "MY_ENUM_E", source = "MY_ENUM_A"),
    @ValueMapping(target = "MY_ENUM_D", source = "MY_ENUM_B"),
    @ValueMapping(
        target = "MY_ENUM_C",
        source = MappingConstants.ANY_UNMAPPED), // 和 ANY_REMAINING，都是沒對應到時的策略
    @ValueMapping(target = "MY_ENUM_C", source = MappingConstants.NULL) // 傳進來是 null 時的策略
  })
  MyEnum2 enumMapping(MyEnum myEnum);

  /**
   * @ValueMapping 是針對名稱的對應；@EnumMapping 是針對有固定名稱的轉換，如此例是固定另一個 enum 最後都有 _TYPE
   */
  @EnumMapping(nameTransformationStrategy = "suffix", configuration = "_TYPE")
  CheeseTypeSuffixed enum2Mapping(CheeseType cheese);
}
