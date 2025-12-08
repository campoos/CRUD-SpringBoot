package com.minhaapi.api_java.services;

import com.minhaapi.api_java.dto.CarroDTO;
import com.minhaapi.api_java.models.Carro;
import com.minhaapi.api_java.models.User;
import com.minhaapi.api_java.repositories.CarroRepository;
import com.minhaapi.api_java.repositories.CorRepository;
import com.minhaapi.api_java.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private final CarroRepository carroRepository;
    private final UsuarioRepository usuarioRepository;
    private final CorRepository corRepository;

    public CarroService(CarroRepository carroRepository, UsuarioRepository usuarioRepository, CorRepository corRepository) {
        this.carroRepository = carroRepository;
        this.usuarioRepository = usuarioRepository;
        this.corRepository = corRepository;
    }

    public List<Carro> getAllCarros(){
        return carroRepository.findAll();
    }

    public Carro getCarroById(Long id){
        Optional<Carro> carro = carroRepository.findById(id);
        return carro.orElse(null);
    }

    public Carro createCarro(CarroDTO dto) {
        User usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        // cria a entidade Carro usando o user carregado
        Carro carro = new Carro();
        carro.setMarca(dto.getMarca());
        carro.setModelo(dto.getModelo());
        carro.setAno(dto.getAno());
        carro.setUsuario(usuario);

        if(dto.getCoresIds() != null){
            dto.getCoresIds().forEach(idCor -> {
                var cor = corRepository.findById(idCor)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cor ID \" + idCor + \" não encontrada"));
                carro.getCores().add(cor);
            });
        }

        return carroRepository.save(carro);
    }

    public Carro updateCarro(Long id, CarroDTO dto){
        Carro carroExistente = carroRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado"));

        carroExistente.setMarca(dto.getMarca());
        carroExistente.setModelo(dto.getModelo());
        carroExistente.setAno(dto.getAno());

        // Atualiza o usuario (se veio no DTO)
        if (dto.getIdUsuario() != null) {
            User usuario = usuarioRepository.findById(dto.getIdUsuario())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

            carroExistente.setUsuario(usuario);
        }

        if(dto.getCoresIds() != null){
            carroExistente.getCores().clear(); //removendo as cores para atualizar
            dto.getCoresIds().forEach(idCor -> {
                var cor = corRepository.findById(idCor)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cor ID \" + idCor + \" não encontrada"));
                carroExistente.getCores().add(cor);
            });
        }

        return carroRepository.save(carroExistente);
    }

    public Boolean deleteCarro(Long id){
        if(carroRepository.existsById(id)){
            carroRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
