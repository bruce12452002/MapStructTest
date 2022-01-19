package mapping;

import bean.Ccc;
import bean.Ddd;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = EntityFactory.class)
public interface CDMapping {
  CDMapping INSTANCE = Mappers.getMapper(CDMapping.class);

  Ccc dddToCcc(Ddd ddd);
}
