package com.sm7.rzrv.services.users;

import com.sm7.rzrv.mappers.RegisterDto;
import com.sm7.rzrv.mappers.providers.ProviderMapper;
import com.sm7.rzrv.mappers.users.UserDto;
import com.sm7.rzrv.mappers.users.UserMapper;
import com.sm7.rzrv.models.Role;
import com.sm7.rzrv.models.UserEntity;
import com.sm7.rzrv.repositories.RoleRepository;
import com.sm7.rzrv.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAllByOrderByIdAsc();
        return userMapper.userModelListtoDtoList(users);
    }

    @Override
    public UserDto getUser(Long id) {
        return userMapper.userModelToDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public UserDto createUser(RegisterDto registerDto) {
        if(userRepository.existsByUsername(registerDto.getUsername())){
            return null;
        }
        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Role role = roleRepository.findByName("USER").orElseThrow();
        user.setRoles(Collections.singletonList(role));
        userRepository.save(user);
        return userMapper.userModelToDto(user);
    }
}
