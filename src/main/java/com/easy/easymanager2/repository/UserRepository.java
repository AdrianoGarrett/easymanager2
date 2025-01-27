package com.easy.easymanager2.repository;

import com.easy.easymanager2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Consulta por nome de usuário
    Optional<User> findByLogin(String username);
}
