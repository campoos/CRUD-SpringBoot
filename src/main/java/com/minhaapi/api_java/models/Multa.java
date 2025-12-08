package com.minhaapi.api_java.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "multas")
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150, name = "tipo_infracao")
    private String tipoInfracao;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false, name = "local_ocorrido")
    private String localOcorrido;

    @ManyToOne
    @JoinColumn(name = "id_carro", nullable = false)
    @JsonBackReference
    private Carro carro;

    public Multa(){}

    public Multa(String tipoInfracao, LocalDate data, Double valor, String localOcorrido, Carro carro){
        this.tipoInfracao = tipoInfracao;
        this.data = data;
        this.valor = valor;
        this.localOcorrido = localOcorrido;
        this.carro = carro;
    }

    public Long getId(){
        return id;
    }

    public String getTipoInfracao(){
        return tipoInfracao;
    }

    public void setTipoInfracao(String tipoInfracao){
        this.tipoInfracao = tipoInfracao;
    }

    public LocalDate getData(){
        return data;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public Double getValor(){
        return valor;
    }

    public void setValor(Double valor){
        this.valor = valor;
    }

    public String getLocalOcorrido(){
        return localOcorrido;
    }

    public void setLocalOcorrido(String localOcorrido){
        this.localOcorrido = localOcorrido;
    }

    public Carro getCarro(){
        return carro;
    }

    public void setCarro(Carro carro){
        this.carro = carro;
    }
}
