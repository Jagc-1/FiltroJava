package com.campuslands.modules.formato.domain.repository;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.formato.domain.models.Formato;


public interface FormatoRepository {
    void save(Formato formato);
    void update(Formato formato);
    Optional<Formato> findById(int id);
    void delete(int id);
    List<Formato> findAll();
}
