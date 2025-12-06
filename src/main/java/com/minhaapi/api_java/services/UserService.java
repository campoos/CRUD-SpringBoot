package com.minhaapi.api_java.services;

import com.minhaapi.api_java.models.User;
import com.minhaapi.api_java.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //instanciando o repository com autoWired
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Listar todos os usuários
    public List<User> getAllUsers() {
        return usuarioRepository.findAll();
    }

    //Listar por ID
    public User getUserById(Long id) {

        // o Optional é para o caso de não encontrar usuário nao quebrar o código
        Optional<User> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public User createUser (User user){
        return usuarioRepository.save(user);
    }

    public User updateUser(Long id, User newUserData){
        Optional<User> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            User usuario = usuarioExistente.get();

            usuario.setNome(newUserData.getNome());
            usuario.setEmail(newUserData.getEmail());
            usuario.setIdade(newUserData.getIdade());

            return usuarioRepository.save(usuario);
        }

        return null;
    }

    public boolean deleteUser(Long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
