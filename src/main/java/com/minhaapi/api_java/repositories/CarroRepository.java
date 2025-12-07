package com.minhaapi.api_java.repositories;

import com.minhaapi.api_java.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}
