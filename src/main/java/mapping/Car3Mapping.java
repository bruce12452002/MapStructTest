package mapping;

import annotation.QualifierTest;
import annotation.Taiwan;
import bean.Car;
import bean.Car2;
import bean.qualifier.Lang;
import decorate.MyDecorate;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = Lang.class)
//@DecoratedWith(MyDecorate.class) 裝飾者，可處理自定義邏輯
public interface Car3Mapping {
    Car3Mapping INSTANCE = Mappers.getMapper(Car3Mapping.class);

    @Mapping(target = "language", qualifiedBy = {QualifierTest.class, Taiwan.class})
    Car2 carToCar2ByLanguage(Car car);

}
