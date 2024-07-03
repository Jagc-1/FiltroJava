package com.campuslands.modules.pais.infraestruture.out;

import com.campuslands.modules.pais.aplication.PaisService;
import com.campuslands.modules.pais.infraestruture.in.PaisAdapter;

public class PaisOutModule {


    protected PaisMYSQL MySQL;
    protected PaisService service;
    protected PaisAdapter adapter;

    public PaisOutModule() {
        MySQL = new PaisMYSQL();
        service = new PaisService(MySQL);
        adapter = new PaisAdapter(service);

    }

    public PaisAdapter module() {
        return adapter;
    }

    
}
