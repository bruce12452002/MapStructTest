package mapping;

import bean.Address;
import bean.AddressDto;
import bean.Home;
import bean.HomeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HomeMapping { // 也可用抽象類別
  HomeMapping INSTANCE = Mappers.getMapper(HomeMapping.class);

  @Mapping(target = "addressDto", source = "address")
  HomeDto homeToHomeDto(Home home);

  /**
   * 加了以下的方法，上面的 homeToHomeDto 才會知道要塞什麼值，否則是 null，不會報錯
   */
  @Mapping(target = "addId", source = "addName")
  AddressDto AddressToAddressDto(Address car);
}
