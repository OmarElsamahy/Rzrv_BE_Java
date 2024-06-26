package com.sm7.rzrv.repositories;

import com.sm7.rzrv.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllByOrderByIdAsc();

    Optional<UserEntity> findOneById(Long id);

    Optional<UserEntity> findOneByUsername(String username);

    List<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

}
