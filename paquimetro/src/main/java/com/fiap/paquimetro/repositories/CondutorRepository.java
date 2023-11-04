package com.fiap.paquimetro.repositories;

import com.fiap.paquimetro.entities.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {
}
