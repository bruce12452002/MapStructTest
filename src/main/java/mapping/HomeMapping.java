package mapping;

import bean.Address;
import bean.AddressDto;
import bean.Home;
import bean.HomeDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class HomeMapping {
    public static HomeMapping INSTANCE = Mappers.getMapper(HomeMapping.class);

    @Mapping(target = "addressDto", source = "address")
    public abstract HomeDto homeToHomeDto(Home home);

    /**
     * 加了以下的方法，上面的 homeToHomeDto 才會知道要塞什麼值，否則是 null，不會報錯
     */
    @Mapping(target = "addId", source = "addName")
    public abstract AddressDto AddressToAddressDto(Address car);

    /**
     * @MappingTarget 表示已賦值過的
     * @AfterMapping @BeanMapping 表示在 homeToHomeDto 之前或之後會調用
     */
    @AfterMapping
//    @BeanMapping
    public void setXxxOfHomeDto(@MappingTarget HomeDto homeDto) {
        homeDto.setXxx("12345".equals(homeDto.getAddressDto().getAddId()));
    }
}
