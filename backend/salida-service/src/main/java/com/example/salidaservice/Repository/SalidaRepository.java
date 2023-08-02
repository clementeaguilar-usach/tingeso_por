package com.example.salidaservice.Repository;

import com.example.salidaservice.Model.SalidaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SalidaRepository extends CrudRepository<SalidaEntity, Integer> {

    @Query("SELECT e FROM SalidaEntity e ")
    ArrayList<SalidaEntity> getAllSalidas();
}
