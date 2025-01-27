package com.easy.easymanager2.controller;

import com.easy.easymanager2.model.User;
import com.easy.easymanager2.record.LoginRequest;
import com.easy.easymanager2.record.LoginResponse;
import com.easy.easymanager2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class Login {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.username();
        String password = loginRequest.password();

        // Verificar se o usuário existe no banco de dados
        Optional<User> user = userRepository.findByLogin(username);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            // Retornar o tipo de usuário
            return ResponseEntity.ok(new LoginResponse("success", user.get().getRole()));
        } else {
            // Retornar erro de autenticação
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse("error", "Credenciais inválidas!"));
        }
    }
}
