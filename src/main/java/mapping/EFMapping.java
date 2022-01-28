package mapping;

import bean.Eee;
import bean.Fff;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EFMapping {
  EFMapping INSTANCE = Mappers.getMapper(EFMapping.class);

  Fff eeeToFff(Eee aaa, @Context int id, @Context String name);

  List<Fff> getFffs(List<Eee> eees, @Context int id, @Context String name);
}
