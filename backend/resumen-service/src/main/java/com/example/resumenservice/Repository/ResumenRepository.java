package com.example.resumenservice.Repository;

import com.example.resumenservice.Model.ResumenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumenRepository extends CrudRepository<ResumenEntity, Integer> {
}
