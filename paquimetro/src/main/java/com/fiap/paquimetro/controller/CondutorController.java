package com.fiap.paquimetro.controller;

import com.fiap.paquimetro.dto.CondutorDto;
import com.fiap.paquimetro.services.CondutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.net.URI;

@RestController
@RequestMapping(value = "/condutores")
public class CondutorController {

    @Autowired
    private CondutorService condutorService;

    @GetMapping
    public ResponseEntity<Page<CondutorDto>> buscarCondutor(Pageable pageable){
        return ResponseEntity.ok(condutorService.buscarCondutores(pageable)) ;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CondutorDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(condutorService.buscarCondutorporId(id));
    }

    @PostMapping
    public ResponseEntity<CondutorDto> salvarCondutor(@Valid @RequestBody CondutorDto condutorDto){
        condutorService.salvarCondutores(condutorDto);
        return ResponseEntity.created(URI.create("")).body(condutorDto);
    };

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        condutorService.deletarCondutorporId(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<CondutorDto> atualizarCondutor(@PathVariable Long id,@Valid @RequestBody CondutorDto condutorDto){
        condutorService.atualizarCondutor(id, condutorDto);
        return  ResponseEntity.ok(condutorDto);

    }

}
