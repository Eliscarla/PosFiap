package com.fiap.paquimetro.controller;


import com.fiap.paquimetro.dto.TabelaPrecoDto;
import com.fiap.paquimetro.services.TabelaPrecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.Time;

@RestController
@RequestMapping(value = "/tabelas")
public class TabelaPrecoController {

    @Autowired
    private TabelaPrecoService tabelaPrecoService;

    @GetMapping
    public ResponseEntity<Page<TabelaPrecoDto>> buscarTabela(Pageable pageable){
        return ResponseEntity.ok(tabelaPrecoService.buscarTabelas(pageable)) ;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TabelaPrecoDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(tabelaPrecoService.buscarTabelaCondutorporId(id));
    }

    @PostMapping
    public ResponseEntity<TabelaPrecoDto> salvarTabela(@Valid @RequestBody TabelaPrecoDto tabelaDto){
        tabelaPrecoService.salvarTabelas(tabelaDto);
        return ResponseEntity.created(URI.create("")).body(tabelaDto);
    };

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        tabelaPrecoService.deletarTabelaPorId(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<TabelaPrecoDto> atualizarTabela(@PathVariable Long id,@Valid @RequestBody TabelaPrecoDto tabelaPrecoDto){
        tabelaPrecoService.atualizarTabela(id, tabelaPrecoDto);
        return  ResponseEntity.ok(tabelaPrecoDto);

    }

}

