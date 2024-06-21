package com.brencorp.persistence;

import com.brencorp.model.Catador;

import java.util.ArrayList;
import java.util.List;

public class CatadorRepository {
    private List<Catador> database = new ArrayList<>();

    public void create(Catador catador) {
        database.add(catador);
    }

    public Catador read(int id) {
        return database.stream().filter(catador -> catador.getId() == id).findFirst().orElse(null);
    }

    public List<Catador> getAll() {
        return new ArrayList<>(database);
    }

    public void update(Catador catador) {
        Catador existingCatador = read(catador.getId());
        if (existingCatador != null) {
            existingCatador.setName(catador.getName());
            existingCatador.setEmail(catador.getEmail());
        }
    }

    public void delete(int id) {
        database.removeIf(catador -> catador.getId() == id);
    }
}
