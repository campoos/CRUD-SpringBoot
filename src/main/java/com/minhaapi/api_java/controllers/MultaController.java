package com.minhaapi.api_java.controllers;

import com.minhaapi.api_java.dto.MultaDTO;
import com.minhaapi.api_java.models.Multa;
import com.minhaapi.api_java.services.MultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/multas")
public class MultaController {

    private final MultaService multaService;

    public MultaController(MultaService multaService){
        this.multaService = multaService;
    }

    @PostMapping
    public ResponseEntity<Multa> create(@RequestBody MultaDTO multa){
        Multa novaMulta = multaService.createMulta(multa);
        return ResponseEntity.ok(novaMulta);
    }

    @GetMapping
    public ResponseEntity<List<Multa>> getAll(){
        return ResponseEntity.ok(multaService.getAllMultas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Multa multa = multaService.getMultaById(id);

        if (multa == null){
            return ResponseEntity.status(404).body("Multa não encontrada");
        }

        return ResponseEntity.ok(multa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MultaDTO multa){
        Multa multaAtualizada = multaService.updateMulta(id, multa);

        if (multaAtualizada != null){
            return ResponseEntity.ok(multaAtualizada);
        } else {
            return ResponseEntity.status(404).body("Multa não encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Boolean multaDeletada = multaService.deleteMulta(id);

        if(multaDeletada){
            return ResponseEntity.ok("Multa deletada com sucesso!");
        } else {
            return ResponseEntity.status(404).body("Carro não encontrado.");
        }
    }


}
