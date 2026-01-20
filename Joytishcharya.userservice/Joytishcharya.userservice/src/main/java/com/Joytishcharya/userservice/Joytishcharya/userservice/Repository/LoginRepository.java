package com.Joytishcharya.userservice.Joytishcharya.userservice.Repository;

import com.Joytishcharya.userservice.Joytishcharya.userservice.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Optional<Login> findByUsername(String username);

    Optional<Login> findByEmail(String email);



    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}