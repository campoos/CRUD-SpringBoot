package com.minhaapi.api_java.controllers;

import com.minhaapi.api_java.dto.CorDTO;
import com.minhaapi.api_java.models.Cor;
import com.minhaapi.api_java.services.CorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cores")
public class CorController {

    private final CorService corService;

    public CorController(CorService corService){
        this.corService = corService;
    }

    @PostMapping
    public ResponseEntity<Cor> create(@RequestBody CorDTO dto){
        return ResponseEntity.ok(corService.createCor(dto));
    }

    @GetMapping
    public ResponseEntity<List<Cor>> getAll(){
        return ResponseEntity.ok(corService.getAllCores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Cor cor = corService.getCorById(id);

        if(cor == null){
            return ResponseEntity.status(404).body("Cor não encontrada.");
        }

        return ResponseEntity.ok(cor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cor> update(@PathVariable Long id, @RequestBody CorDTO dto){
        return ResponseEntity.ok(corService.updateCor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Boolean deleted = corService.deleteCor(id);

        if(deleted){
            return ResponseEntity.ok("Cor deletada com sucesso");
        } else {
            return ResponseEntity.status(404).body("Cor não encontrada.");
        }
    }
}