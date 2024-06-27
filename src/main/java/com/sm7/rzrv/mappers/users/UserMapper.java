package com.sm7.rzrv.mappers.users;

import com.sm7.rzrv.mappers.users.UserDto;
import com.sm7.rzrv.models.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    UserDto userModelToDto(UserEntity user);
    List<UserDto> userModelListtoDtoList(List<UserEntity> providerList);
}
