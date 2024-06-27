package com.sm7.rzrv.controllers;
import com.sm7.rzrv.models.Provider;
import com.sm7.rzrv.mappers.providers.ProviderDto;
import com.sm7.rzrv.services.providers.ProviderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/providers")
public class ProviderController {
    @Autowired
    ProviderService providerService;

    @GetMapping("")
    public List<ProviderDto> getAllProviders() {
        return providerService.getAllProviders();
    }

    @GetMapping("/{id}")
    public ProviderDto getProvider(@PathVariable("id") Long id) {
        return providerService.getProvider(id);
    }

    @PostMapping("")
    public ProviderDto createProvider(@Valid @RequestBody Provider provider) {
        return providerService.createProvider(provider);
    }
}
