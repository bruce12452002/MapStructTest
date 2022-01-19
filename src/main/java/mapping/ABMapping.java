package mapping;

import bean.Aaa;
import bean.Bbb;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/** @Mapper 屬性測試類別，可以用這個類別試試裡面的屬性 */
@Mapper(/*unmappedSourcePolicy = ReportingPolicy.ERROR*/ )
public interface ABMapping {
  ABMapping INSTANCE = Mappers.getMapper(ABMapping.class);

  Bbb aaaToBbb(Aaa car);

  /** 如果有多個 source，可以使用 @Context，aaaToBbbByContext 和 changeNameByBbb 的 @Context 全加或全不加才會成功 */
  Bbb aaaToBbbByContext(Aaa source, @Context String name);

  @AfterMapping
  default void changeNameByBbb(@MappingTarget Bbb target, @Context String name) {
    target.setName(name);
  }
}
