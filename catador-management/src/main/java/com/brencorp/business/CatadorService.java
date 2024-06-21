package com.brencorp.business;

import com.brencorp.model.Catador;
import com.brencorp.persistence.CatadorRepository;

import java.util.List;

public class CatadorService {
    private CatadorRepository catadorRepository = new CatadorRepository();

    public void createCatador(Catador catador) {
        catadorRepository.create(catador);
    }

    public Catador readCatador(int id) {
        return catadorRepository.read(id);
    }

    public List<Catador> getAllCatadores() {
        return catadorRepository.getAll();
    }

    public void updateCatador(Catador catador) {
        catadorRepository.update(catador);
    }

    public void deleteCatador(int id) {
        catadorRepository.delete(id);
    }
}
