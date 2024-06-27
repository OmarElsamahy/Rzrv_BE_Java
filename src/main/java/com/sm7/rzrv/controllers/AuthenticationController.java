package com.sm7.rzrv.controllers;

import com.sm7.rzrv.mappers.AuthDto;
import com.sm7.rzrv.mappers.LoginDto;
import com.sm7.rzrv.mappers.RegisterDto;
import com.sm7.rzrv.mappers.users.UserDto;
import com.sm7.rzrv.models.UserEntity;
import com.sm7.rzrv.repositories.RoleRepository;
import com.sm7.rzrv.repositories.UserRepository;
import com.sm7.rzrv.security.JWTGenerator;
import com.sm7.rzrv.services.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @Autowired
    private JWTGenerator jwtGenerator;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        UserDto created_user = userService.createUser(registerDto);
        if(created_user == null){
           return new ResponseEntity<>("Username exists!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User Registered Successfully!", HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<AuthDto> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthDto(token), HttpStatus.OK);
    }

}
