package com.campuslands.modules.pais.infraestruture.out;

import com.campuslands.modules.actor.aplication.ActorService;
import com.campuslands.modules.actor.infrastructure.in.ActorAdapter;
import com.campuslands.modules.actor.infrastructure.out.ActorMySQL;

public class PaisOutModule {


    protected ActorMySQL MySQL;
    protected ActorService service;
    protected ActorAdapter adapter;

    public PaisOutModule() {
        MySQL = new ActorMySQL();
        service = new ActorService(MySQL);
        adapter = new ActorAdapter(service);

    }

    public ActorAdapter module() {
        return adapter;
    }

    
}
