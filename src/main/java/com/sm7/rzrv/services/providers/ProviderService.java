package com.sm7.rzrv.services.providers;

import com.sm7.rzrv.mappers.providers.ProviderDto;
import com.sm7.rzrv.models.Provider;
import com.sm7.rzrv.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProviderService {
    List<ProviderDto> getAllProviders();
    ProviderDto getProvider(Long id);
    ProviderDto createProvider(Provider provider);
}
