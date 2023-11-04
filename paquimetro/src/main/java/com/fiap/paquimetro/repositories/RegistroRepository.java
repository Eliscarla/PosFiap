package com.fiap.paquimetro.repositories;

import com.fiap.paquimetro.entities.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
}
