package com.campuslands.modules.actor.domain.repository;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.actor.domain.models.Actor;

public interface ActorRepository {

    void save(Actor actor);
    void update(Actor actor);
    void delete(int id);
    Optional<Actor> findById(int id);
    List<Actor> getAll();
}
