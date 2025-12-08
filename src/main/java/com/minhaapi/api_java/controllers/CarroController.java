package com.minhaapi.api_java.controllers;

import com.minhaapi.api_java.dto.CarroDTO;
import com.minhaapi.api_java.models.Carro;
import com.minhaapi.api_java.models.User;
import com.minhaapi.api_java.services.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService){
        this.carroService = carroService;
    }

    @PostMapping
    public ResponseEntity<Carro> create(@RequestBody CarroDTO carro){
        Carro novoCarro = carroService.createCarro(carro);
        return ResponseEntity.ok(novoCarro);
    }

    @GetMapping
    public ResponseEntity<List<Carro>> getAll(){
        return ResponseEntity.ok(carroService.getAllCarros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Carro carro = carroService.getCarroById(id);

        if(carro == null){
            return ResponseEntity.status(404).body("Carro não encontrado.");
        }

        return ResponseEntity.ok(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CarroDTO carro){
        Carro carroAtualizado = carroService.updateCarro(id, carro);

        if (carroAtualizado != null){
            return ResponseEntity.ok(carroAtualizado);
        } else {
            return ResponseEntity.status(404).body("Carro não encontrado.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Boolean carroDeletado = carroService.deleteCarro((id));

        if(carroDeletado){
            return ResponseEntity.ok("Carro deletado com sucesso");
        } else {
            return ResponseEntity.status(404).body("Carro não encontrado.");
        }
    }
}
