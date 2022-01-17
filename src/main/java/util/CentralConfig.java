package util;

import org.mapstruct.MapperConfig;

/** 這是公用配置，@MapperConfig 裡的屬性大部分和 @Mapper 一樣 @Mapper 使用 config 屬性，指定這個類別，就可以使用這裡設定的值 */
@MapperConfig(
// uses = Xxx.class
// ...
)
public class CentralConfig {}
