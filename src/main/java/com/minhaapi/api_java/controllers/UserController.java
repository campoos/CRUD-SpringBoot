package com.minhaapi.api_java.controllers;

import com.minhaapi.api_java.models.User;
import com.minhaapi.api_java.services.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Indica ao Java que está classe recebe requisições HTTP
@RestController
// Referenciando a rota HTTP
@RequestMapping("/usuarios")
public class UserController {

    // Instanciando o service para uso aqui na controller
    private final UserService userService;

    // Construtor da controller
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User novoUser = userService.createUser(user);
        return ResponseEntity.ok(novoUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        User user = userService.getUserById(id);

        if(user == null){
            return ResponseEntity.status(404).body("Usuário não encontrado.");
        }

        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User user) {
        User userAtualizado = userService.updateUser(id, user);

        if (userAtualizado != null){
            return ResponseEntity.ok(userAtualizado);
        }else {
            return ResponseEntity.status(404).body("Usuário não encontrado.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        boolean userDeletado = userService.deleteUser(id);

        if (userDeletado){
            return ResponseEntity.ok("Usuário deletado com sucesso!");
        }else {
            return ResponseEntity.status(404).body("Usuário não encontrado.");
        }
    }
}
