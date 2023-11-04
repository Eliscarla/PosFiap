package com.fiap.paquimetro.controller;

import com.fiap.paquimetro.dto.CondutorDto;
import com.fiap.paquimetro.dto.TabelaPrecoDto;
import com.fiap.paquimetro.dto.VeiculoDto;
import com.fiap.paquimetro.services.CondutorService;
import com.fiap.paquimetro.services.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<Page<VeiculoDto>> buscarVeiculo(Pageable pageable){
        return ResponseEntity.ok(veiculoService.buscarVeiculos(pageable)) ;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VeiculoDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(veiculoService.buscarVeiculoPorId(id));
    }

    @PostMapping
    public ResponseEntity<VeiculoDto> salvarVeiculo(@Valid @RequestBody VeiculoDto veiculoDto){
        veiculoService.salvarVeiculo(veiculoDto);
        return ResponseEntity.created(URI.create("")).body(veiculoDto);
    };

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        veiculoService.deletarVeiculoPorId(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<VeiculoDto> atualizarVeiculo(@PathVariable Long id,@Valid @RequestBody VeiculoDto veiculoDto){
        veiculoService.atualizarVeiculo(id, veiculoDto);
        return  ResponseEntity.ok(veiculoDto);

    }

}
