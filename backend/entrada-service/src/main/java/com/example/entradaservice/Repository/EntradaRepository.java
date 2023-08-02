package com.example.entradaservice.Repository;

import com.example.entradaservice.Model.EntradaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EntradaRepository extends CrudRepository<EntradaEntity, Integer> {

    @Query("SELECT e FROM EntradaEntity e ")
    ArrayList<EntradaEntity> getAllEntradas();
}
