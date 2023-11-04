package com.fiap.paquimetro.controller;

import com.fiap.paquimetro.dto.RegistroDto;
import com.fiap.paquimetro.services.RegistroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/registros")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping
    public ResponseEntity<Page<RegistroDto>> buscarRegistro(Pageable pageable){
        return ResponseEntity.ok(registroService.buscarRegistros(pageable)) ;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RegistroDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(registroService.buscarRegistroPorId(id));
    }

    @PostMapping
    public ResponseEntity<RegistroDto> salvar(@Valid @RequestBody RegistroDto registroDto){
        registroService.salvarRegistros(registroDto);
        return ResponseEntity.created(URI.create("")).body(registroDto);
    }

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        registroService.deletarRegistros(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<RegistroDto> atualizarRegistro(@PathVariable Long id,@Valid @RequestBody RegistroDto registroDto){
        registroService.atualizarRegistro(id, registroDto);
        return  ResponseEntity.ok(registroDto);

    }

}
