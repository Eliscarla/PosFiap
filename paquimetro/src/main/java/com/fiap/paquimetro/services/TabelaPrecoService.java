package com.fiap.paquimetro.services;

import com.fiap.paquimetro.dto.TabelaPrecoDto;
import com.fiap.paquimetro.entities.TabelaPreco;
import com.fiap.paquimetro.repositories.TabelaPrecoRepository;
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
public class TabelaPrecoService {

    @Autowired
    private TabelaPrecoRepository tabelaPrecoRepository;

    @Transactional(readOnly = true)
    public Page<TabelaPrecoDto> buscarTabelas(Pageable pageable){
        Page<TabelaPreco> tabelaPrecos = tabelaPrecoRepository.findAll(pageable);
        return tabelaPrecos.map(x -> new TabelaPrecoDto(x));
    };

    @Transactional(readOnly = true)
    public TabelaPrecoDto buscarTabelaCondutorporId(Long id){
        TabelaPreco tabelaPreco = tabelaPrecoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Tabela não encontrada")
        );
        return new TabelaPrecoDto(tabelaPreco);
    };

    public TabelaPrecoDto salvarTabelas(TabelaPrecoDto tabelaPrecoDto){
        TabelaPreco tabelaPreco = new TabelaPreco(tabelaPrecoDto.getTempoMinimo(), tabelaPrecoDto.getValorHora());
        tabelaPrecoRepository.save(tabelaPreco);
        tabelaPrecoDto.setId(tabelaPreco.getId());
        return new TabelaPrecoDto(tabelaPreco);
    };

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletarTabelaPorId(Long id){

        if (!tabelaPrecoRepository.existsById(id)){
            throw new ResourceNotFoundException("Tabela não encontrada");
        }

        try {
            tabelaPrecoRepository.deleteById(id);

        } catch (DataIntegrityViolationException e){
            throw new DataBaseException("Falha de integridade referencial");
        }
    };

    public TabelaPrecoDto atualizarTabela(Long id, TabelaPrecoDto tabelaPrecoDto){
        try {
            TabelaPreco tabelaPreco = tabelaPrecoRepository.getReferenceById(id);
            tabelaPreco.setTempoMinimo(tabelaPrecoDto.getTempoMinimo());
            tabelaPreco.setValorHora(tabelaPrecoDto.getValorHora());

            TabelaPrecoDto dto = new TabelaPrecoDto(tabelaPreco);
            return dto;
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Tabela não encontrada");
        }
    }
}
