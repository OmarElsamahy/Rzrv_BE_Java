package com.sm7.rzrv.services.users;

import com.sm7.rzrv.mappers.RegisterDto;
import com.sm7.rzrv.mappers.providers.ProviderDto;
import com.sm7.rzrv.mappers.users.UserDto;
import com.sm7.rzrv.models.Provider;
import com.sm7.rzrv.models.UserEntity;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUser(Long id);
    UserDto createUser(RegisterDto registerDto);
}
