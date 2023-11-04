package com.fiap.paquimetro.services;

import com.fiap.paquimetro.dto.CondutorDto;
import com.fiap.paquimetro.dto.CustomError;
import com.fiap.paquimetro.entities.Condutor;
import com.fiap.paquimetro.repositories.CondutorRepository;
import com.fiap.paquimetro.services.exceptions.DataBaseException;
import com.fiap.paquimetro.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CondutorService {

    @Autowired
    private CondutorRepository condutorRepository;

    @Transactional(readOnly = true)
    public Page<CondutorDto> buscarCondutores(Pageable pageable){
        Page<Condutor> condutores = condutorRepository.findAll(pageable);
        return condutores.map(x -> new CondutorDto(x));
    };

    @Transactional(readOnly = true)
    public CondutorDto buscarCondutorporId(Long id){
        Condutor condutor = condutorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Condutor não encontrado")
        );
        return new CondutorDto(condutor);
    };

    public CondutorDto salvarCondutores(CondutorDto condutorDto){
        Condutor condutor = new Condutor(condutorDto.getCPF(), condutorDto.getNome(), condutorDto.getCPF());
        condutorRepository.save(condutor);
        condutorDto.setId(condutor.getId());
        return new CondutorDto(condutor);
    };

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletarCondutorporId(Long id){

        if (!condutorRepository.existsById(id)){
            throw new ResourceNotFoundException("Condutor não encontrado");
        }

        try {
            condutorRepository.deleteById(id);

        } catch (DataIntegrityViolationException e){
            throw new DataBaseException("Falha de integridade referencial");
        }
    };

    public CondutorDto atualizarCondutor(Long id, CondutorDto condutorDto){
        try {
            Condutor condutor = condutorRepository.getReferenceById(id);
            condutor.setCPF(condutorDto.getCPF());
            condutor.setNome(condutorDto.getNome());
            condutor.setTelefone(condutorDto.getTelefone());
            condutor = condutorRepository.save(condutor);
            CondutorDto dto = new CondutorDto(condutor);
            return dto;
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Condutor não encontrado");
        }
    }

}

