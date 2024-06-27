package com.sm7.rzrv.services.providers;

import com.sm7.rzrv.mappers.providers.ProviderDto;
import com.sm7.rzrv.mappers.providers.ProviderMapper;
import com.sm7.rzrv.models.Provider;
import com.sm7.rzrv.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService{

    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private ProviderMapper providerMapper;

    public List<ProviderDto> getAllProviders(){
        List<Provider> providers =  providerRepository.findAllByOrderByIdAsc();
        return providerMapper.providerModelListtoDtoList(providers);
    }
    public ProviderDto getProvider(Long id){
        Provider provider =  providerRepository.findOneById(id).orElseThrow();
        return providerMapper.providerModelToDto(provider);
    }
    public ProviderDto createProvider(Provider provider){
        Provider savedProvider = providerRepository.save(provider);
        return providerMapper.providerModelToDto(savedProvider);
    }
}
