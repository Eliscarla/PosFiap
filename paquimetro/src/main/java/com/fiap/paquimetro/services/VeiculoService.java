package com.fiap.paquimetro.services;

import com.fiap.paquimetro.dto.TabelaPrecoDto;
import com.fiap.paquimetro.dto.VeiculoDto;
import com.fiap.paquimetro.entities.TabelaPreco;
import com.fiap.paquimetro.entities.Veiculo;
import com.fiap.paquimetro.repositories.VeiculoRepository;
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
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional(readOnly = true)
    public Page<VeiculoDto> buscarVeiculos(Pageable pageable){
        Page<Veiculo> veiculos = veiculoRepository.findAll(pageable);
        return veiculos.map(x -> new VeiculoDto(x));
    };

    @Transactional(readOnly = true)
    public VeiculoDto buscarVeiculoPorId(Long id){
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Veículo não encontrado")
        );
        return new VeiculoDto(veiculo);
    };

    public VeiculoDto salvarVeiculo(VeiculoDto veiculoDto){
        Veiculo veiculo = new Veiculo(veiculoDto);
        veiculoRepository.save(veiculo);
        veiculoDto.setId(veiculo.getId());
        return new VeiculoDto(veiculo);
    };

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletarVeiculoPorId(Long id){

        if (!veiculoRepository.existsById(id)){
            throw new ResourceNotFoundException("Veículo não encontrado");
        }

        try {
            veiculoRepository.deleteById(id);

        } catch (DataIntegrityViolationException e){
            throw new DataBaseException("Falha de integridade referencial");
        }
    };

    public VeiculoDto atualizarVeiculo(Long id, VeiculoDto veiculoDto){
        try {
            Veiculo veiculo = veiculoRepository.getReferenceById(id);
            veiculo.setPlaca(veiculoDto.getPlaca());
            veiculo.setAno(veiculoDto.getAno());
            veiculo.setModelo(veiculoDto.getModelo());

            VeiculoDto dto = new VeiculoDto(veiculo);
            return dto;
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Veículo não encontrado");
        }
    }
}
