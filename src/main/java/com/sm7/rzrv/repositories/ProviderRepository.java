package com.sm7.rzrv.repositories;

import com.sm7.rzrv.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    List<Provider> findAllByOrderByIdAsc();

    Optional<Provider> findOneById(Long id);

}
