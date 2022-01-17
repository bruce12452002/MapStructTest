package mapping;

import bean.Aaa;
import bean.Bbb;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @Mapper 屬性測試類別，可以用這個類別試試裡面的屬性
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface ABMapping {
    ABMapping INSTANCE = Mappers.getMapper(ABMapping.class);

    Bbb aaaToBbb(Aaa car);

}
