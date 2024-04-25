package com.company.AdvensedLvlCRUD.service.mapper;

import com.company.AdvensedLvlCRUD.dto.requestDto.RequestCardDto;
import com.company.AdvensedLvlCRUD.dto.responseDto.ResponseCardDto;
import com.company.AdvensedLvlCRUD.modul.Card;
import com.company.AdvensedLvlCRUD.modul.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class CardMapper {


    @Mapping(target = "cardId", ignore = true)
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "cardName", source = "cardName")
    @Mapping(target = "cardCode", expression = "java(\"0000\")")
    public abstract Card toEntity(RequestCardDto dto);

    @Mapping(target = "users", ignore = true)
    public abstract ResponseCardDto toDo(Card card);

    @Mapping(target = "cardId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Card.class)
    public abstract Card updateCard(RequestCardDto dto, @MappingTarget Card card);

}
