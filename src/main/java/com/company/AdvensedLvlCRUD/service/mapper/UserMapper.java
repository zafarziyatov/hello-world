package com.company.AdvensedLvlCRUD.service.mapper;

import com.company.AdvensedLvlCRUD.dto.requestDto.RequestUserDto;
import com.company.AdvensedLvlCRUD.dto.responseDto.ResponseUserDto;
import com.company.AdvensedLvlCRUD.modul.User;
import org.mapstruct.*;

import java.text.Collator;

@Mapper(componentModel = "spring", imports = Collator.class)
public abstract class UserMapper {


    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "cardId", ignore = true)
    public abstract User toEntity(RequestUserDto dto);


    @Mapping(target = "cards")
    public abstract ResponseUserDto toDto(User user);



    @Mapping(target = "cards", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = User.class)
    public abstract User updateUser(RequestUserDto dto, @MappingTarget User user);


}
