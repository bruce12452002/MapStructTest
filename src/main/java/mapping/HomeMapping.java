package mapping;

import bean.Address;
import bean.AddressDto;
import bean.Home;
import bean.HomeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;

@Mapper(imports = Date.class)
public interface HomeMapping { // 也可用抽象類別
  HomeMapping INSTANCE = Mappers.getMapper(HomeMapping.class);

  @Mapping(target = "addressDto", source = "address")
  HomeDto homeToHomeDto(Home home);

  @Mapping(target = "addId", source = "addName")
  AddressDto AddressToAddressDto(Address car);
}
