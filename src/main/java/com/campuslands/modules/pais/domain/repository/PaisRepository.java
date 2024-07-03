package com.campuslands.modules.pais.domain.repository;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.pais.domain.models.Pais;


public interface PaisRepository {
    void save(Pais pais);
    void update(Pais pais);
    void delete(int id);
    Optional<Pais> findById(int id);
    List<Pais> getAll();
}
