package com.minhaapi.api_java.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.minhaapi.api_java.models.Carro;
import jakarta.persistence.*;

import java.time.LocalDate;

public class MultaDTO {

    @Column(nullable = false, length = 150, name = "tipo_infracao")
    private String tipoInfracao;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false, name = "local_ocorrido")
    private String localOcorrido;

    @Column(nullable = false)
    private Long idCarro;

    public Long getIdCarro(){
        return idCarro;
    }

    public void setIdCarro(Long idCarro){
        this.idCarro = idCarro;
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
}
