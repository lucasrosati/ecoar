package com.brencorp.presentation;

import com.brencorp.business.CatadorService;
import com.brencorp.model.Catador;

import java.util.List;

public class CatadorController {
    private CatadorService catadorService = new CatadorService();

    public void createCatador(Catador catador) {
        catadorService.createCatador(catador);
    }

    public Catador readCatador(int id) {
        return catadorService.readCatador(id);
    }

    public List<Catador> getAllCatadores() {
        return catadorService.getAllCatadores();
    }

    public void updateCatador(Catador catador) {
        catadorService.updateCatador(catador);
    }

    public void deleteCatador(int id) {
        catadorService.deleteCatador(id);
    }
}
//teste