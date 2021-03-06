package mapping;

import bean.Car;
import bean.Car2;
import bean.Home;
import bean.HomeDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Car2Mapping {
    Car2Mapping INSTANCE = Mappers.getMapper(Car2Mapping.class);

    @Mapping(target = "make", source = "make")
    @Mapping(target = "price", constant = "50")
    @Mapping(target = "language", constant = "Zh_TW")
    Car2 carToCar2(Car car);

    /**
     * 如果不加 @InheritConfiguration 同名欄位會自動更新；不同要自己指定
     * 同名欄位不想自動更新，可用 ignore
     * 加了 @InheritConfiguration 會以繼承的方法名更新
     */
    @InheritConfiguration(name = "carToCar2")
    @Mapping(target = "different", source = "constant")
    void updateCar2(Car car, @MappingTarget Car2 car2);

    /**
     * 本來就有一個 Car 轉 Car2 的方法，現在想要一個相反的方法(Car2 轉 Car)
     * 這時有可能會寫很多的 @Mapping，這時可以用 @InheritInverseConfiguration，name 指定另一個方法名稱
     * 只會針對 @Mapping 有 source 的相反挷定
     */
    @InheritInverseConfiguration(name = "carToCar2")
    Car car2ToCar(Car2 car2);
}
