package com.fiap.paquimetro.repositories;


import com.fiap.paquimetro.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
