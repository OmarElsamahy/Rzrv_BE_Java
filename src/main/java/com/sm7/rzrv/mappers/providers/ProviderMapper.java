package com.sm7.rzrv.mappers.providers;

import com.sm7.rzrv.models.Provider;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper(componentModel = "spring")
@Component
public interface ProviderMapper {
    ProviderDto providerModelToDto(Provider provider);
    List<ProviderDto> providerModelListtoDtoList(List<Provider> providerList);
}
