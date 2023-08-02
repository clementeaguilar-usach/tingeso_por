package com.example.entradaservice.Repository;

import com.example.entradaservice.Model.EntradaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository extends CrudRepository<EntradaEntity, Integer> {
}
