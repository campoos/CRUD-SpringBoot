package com.minhaapi.api_java.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String marca;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = false)
    private int ano;

    //Criando a relação entre carro e usuario
    //Muitos carros pertencem a um usuario
    @ManyToOne
    //Referenciando que o nome da coluna da chave estrangeira é id_usuario
    @JoinColumn(name = "id_usuario", nullable = false)
    //pq tem q ser o objeto user e n um long id_usuario direto?
    //O JPA trabalha com relação entre os modelos que criamos, entao precisamos associar, dizendo que
    //o usuário ao qual atributos a FK é de um tipo User, e vai ser controlado pelo atributo usuario.
    //A variavel id_usuario ele cria automaticamente
    @JsonBackReference
    private User usuario;

    //cascade serve para falar que tudo o que acontecer no pai afeta o filho
    @OneToMany(mappedBy = "carro", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Multa> multas = new ArrayList<>();

    public Carro(){}

    //Construtor
    public Carro(String marca, String modelo, int ano, User usuario){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.usuario = usuario;
    }

    public Long getId(){
        return id;
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public int getAno(){
        return ano;
    }

    public User getUsuario(){
        return usuario;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public void setUsuario(User usuario){
        this.usuario = usuario;
    }
}