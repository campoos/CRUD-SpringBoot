package com.minhaapi.api_java.models;

//Para mapear objetos java para o banco com @Entity, @Table, @Id, @Column, etc.:
import jakarta.persistence.*;

// Definindo que a clasee java vai referenciar uma tabela no banco de dados
@Entity
// Dizendo a qual tabela ele se referencia no banco de dados
@Table(name = "usuarios")
public class User {

    // Dizendo que determinando atributo é ID
    @Id
    // Dizendo que ele vai gerar automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Posso alterar algumas caracteristicas das colunas
    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false)
    private int idade;

    public User(){}

    //Construtor
    public User(String nome, String email, int idade){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public int getIdade(){
        return idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }
}
