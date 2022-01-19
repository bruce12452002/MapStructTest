package mapping;

import bean.Ccc;
import bean.Ddd;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;

public class EntityFactory {
  @ObjectFactory
  public Ccc createEntity(Ddd ddd, @TargetType Class<Ccc> entityClass) {
    Ccc ccc = null;
    try {
      if (null != ddd && null != ddd.getName()) {
        ccc = entityClass.newInstance();
        return ccc;
      }
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return ccc;
  }
}
