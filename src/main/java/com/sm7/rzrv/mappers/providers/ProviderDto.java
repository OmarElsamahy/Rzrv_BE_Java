package com.sm7.rzrv.mappers.providers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;


@Setter
@Getter
@NoArgsConstructor
public class ProviderDto {
    private long id;
    private String name;
    private Instant createdAt;
    private Instant updatedAt;
}
