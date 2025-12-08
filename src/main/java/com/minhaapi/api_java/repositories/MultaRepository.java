package com.minhaapi.api_java.repositories;

import com.minhaapi.api_java.models.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Long> {

}
