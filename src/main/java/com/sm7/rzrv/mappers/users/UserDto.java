package com.sm7.rzrv.mappers.users;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UserDto {
    private long id;
    private String username;
    private Instant createdAt;
    private Instant updatedAt;
}
