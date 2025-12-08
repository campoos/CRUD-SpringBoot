package com.minhaapi.api_java.services;

import com.minhaapi.api_java.dto.CorDTO;
import com.minhaapi.api_java.models.Cor;
import com.minhaapi.api_java.repositories.CorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CorService {

    private final CorRepository corRepository;

    public CorService(CorRepository corRepository) {
        this.corRepository = corRepository;
    }

    public List<Cor> getAllCores() {
        return corRepository.findAll();
    }

    public Cor getCorById(Long id) {
        return corRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cor não encontrada"));
    }

    public Cor createCor(CorDTO dto) {
        Cor cor = new Cor();
        cor.setNome(dto.getNome());
        return corRepository.save(cor);
    }

    public Cor updateCor(Long id, CorDTO dto){
        Cor corExistente = corRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cor não encontrada"));

        corExistente.setNome(dto.getNome());
        return corRepository.save(corExistente);
    }

    public Boolean deleteCor(Long id){
        if(corRepository.existsById(id)){
            corRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
