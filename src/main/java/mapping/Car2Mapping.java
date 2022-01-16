package mapping;

import bean.Car;
import bean.Car2;
import bean.Home;
import bean.HomeDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Car2Mapping {
    Car2Mapping INSTANCE = Mappers.getMapper(Car2Mapping.class);

    @Mapping(target = "make", source = "make")
    @Mapping(target = "price", constant = "50")
    @Mapping(target = "language", constant = "Zh_TW")
    Car2 carToCar2(Car car);

    /**
     * 同名屬性會自動更新；不同名要自己指定
     * 同名屬性不想自動更新，可用 ignore
     */
    @Mapping(target = "different", source = "constant")
    void updateCar2(Car car, @MappingTarget Car2 car2);

    /**
     * 本來就有一個 Car 轉 Car2 的方法，現在想要一個相反的方法(Car2 轉 Car)
     * 這時有可能會寫很多的 @Mapping，這時可以用 @InheritInverseConfiguration，name 指定另一個方法名稱
     * 只會針對 @Mapping 相反挷定
     */
    @InheritInverseConfiguration(name = "carToCar2")
    Car car2ToCar(Car2 car2);
}
