package com.minhaapi.api_java.services;

import com.minhaapi.api_java.dto.MultaDTO;
import com.minhaapi.api_java.models.Carro;
import com.minhaapi.api_java.models.Multa;
import com.minhaapi.api_java.repositories.CarroRepository;
import com.minhaapi.api_java.repositories.MultaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MultaService {
    private MultaRepository multaRepository;
    private CarroRepository carroRepository;

    public MultaService(MultaRepository multaRepository, CarroRepository carroRepository){
        this.multaRepository = multaRepository;
        this.carroRepository = carroRepository;
    }

    public List<Multa> getAllMultas(){
        return multaRepository.findAll();
    }

    public Multa getMultaById(Long id){
        Optional<Multa> multa = multaRepository.findById(id);
        return multa.orElse(null);
    }

    public Multa createMulta (MultaDTO dto){
        Carro carro = carroRepository.findById(dto.getIdCarro())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado."));

        Multa multa = new Multa();
        multa.setTipoInfracao(dto.getTipoInfracao());
        multa.setData(dto.getData());
        multa.setValor(dto.getValor());
        multa.setLocalOcorrido(dto.getLocalOcorrido());
        multa.setCarro(carro);

        return multaRepository.save(multa);
    }

    public Multa updateMulta(Long id, MultaDTO dto){
        Multa multaExistente = multaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Multa não encontrada."));

        multaExistente.setTipoInfracao(dto.getTipoInfracao());
        multaExistente.setData(dto.getData());
        multaExistente.setValor(dto.getValor());
        multaExistente.setLocalOcorrido(dto.getLocalOcorrido());

        if (dto.getIdCarro() != null){
            Carro carro = carroRepository.findById(dto.getIdCarro())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado"));

            multaExistente.setCarro(carro);
        }

        return multaRepository.save(multaExistente);
    }

    public Boolean deleteMulta(Long id){
        if(multaRepository.existsById(id)){
            multaRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
