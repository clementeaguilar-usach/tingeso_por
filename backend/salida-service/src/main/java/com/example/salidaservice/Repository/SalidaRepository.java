package com.example.salidaservice.Repository;

import com.example.salidaservice.Model.SalidaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalidaRepository extends CrudRepository<SalidaEntity, Integer> {
}
