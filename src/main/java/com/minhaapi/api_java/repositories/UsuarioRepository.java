package com.minhaapi.api_java.repositories;

import com.minhaapi.api_java.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Interface em que o Spring usa para acessar o banco de dados.
// O JpaRepository é uma interface do spring que ja vem com todas as operações prontas do banco, como:
//    save
//    findById
//    findAll
//    delete
//    existsById
//    etc.

// o <User, Long> diz: o User define qual entidade o repositório vai manipular, e o Long é o tipo da chave primária.
public interface UsuarioRepository extends JpaRepository<User, Long> {

}
