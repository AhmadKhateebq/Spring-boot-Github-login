package com.example.githublogin.mapper;

import com.example.githublogin.controller.dto.UserDto;
import com.example.githublogin.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapStruct {
    MapStruct INSTANCE = Mappers.getMapper (MapStruct.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "socialId", source = "socialId")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "name", source = "name")
    UserDto USER_DTO(User user);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "socialId", source = "socialId")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "name", source = "name")
    User USER_DTO(UserDto user);


}
