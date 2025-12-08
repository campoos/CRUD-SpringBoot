package com.minhaapi.api_java.dto;

import com.minhaapi.api_java.models.Cor;
import jakarta.persistence.Column;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

public class CarroDTO {

    @Column(nullable = false, length = 100)
    private String marca;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    private Long idUsuario;

    @Column(nullable = false)
    private List<Long> coresIds;

    // getters e setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Long> getCoresIds() {
        return coresIds;
    }

    public void setCoresIds(List<Long> coresIds) {
        this.coresIds = coresIds;
    }
}
