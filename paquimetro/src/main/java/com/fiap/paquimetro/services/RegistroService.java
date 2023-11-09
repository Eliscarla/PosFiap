package com.fiap.paquimetro.services;

import com.fiap.paquimetro.dto.RegistroDto;
import com.fiap.paquimetro.entities.Registro;
import com.fiap.paquimetro.repositories.RegistroRepository;
import com.fiap.paquimetro.services.exceptions.DataBaseException;
import com.fiap.paquimetro.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistroService {
    @Autowired
    private RegistroRepository registroRepository;

    @Transactional(readOnly = true)
    public Page<RegistroDto> buscarRegistros(Pageable pageable){
        Page<Registro> registros = registroRepository.findAll(pageable);
        return registros.map(x -> new RegistroDto(x));
    };

    @Transactional(readOnly = true)
    public RegistroDto buscarRegistroPorId(Long id){
        Registro registro = registroRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Registro não encontrado")
        );
        return new RegistroDto(registro);
    };

    public RegistroDto salvarRegistros(RegistroDto registroDto){
        Registro registro = new Registro(registroDto);
        registroRepository.save(registro);
     //   registroDto.setId(registro.getId());
        return new RegistroDto(registro);
    };

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletarRegistros(Long id){

        if (!registroRepository.existsById(id)){
            throw new ResourceNotFoundException("Registro não encontrado");
        }

        try {
            registroRepository.deleteById(id);

        } catch (DataIntegrityViolationException e){
            throw new DataBaseException("Falha de integridade referencial");
        }
    };

    public RegistroDto atualizarRegistro(Long id, RegistroDto registroDto){
        try {
            Registro registro = registroRepository.getReferenceById(id);
            registro.setEtrada(registroDto.getEntrada());
            registro.setSaida(registroDto.getSaida());
          //  registro.getPermanecia();
            RegistroDto dto = new RegistroDto(registro);
            return dto;
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Registro não encontrado");
        }
    }
}
