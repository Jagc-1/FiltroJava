package com.campuslands.modules.formato.insfrastructure.out;

import com.campuslands.modules.formato.aplication.FormatoService;
import com.campuslands.modules.formato.insfrastructure.in.FormatoAdapter;

public class FormatoOutModule {
  protected FormatoMySQL MySQL;
    protected FormatoService service;
    protected FormatoAdapter adapter;

    public FormatoOutModule() {
        MySQL = new FormatoMySQL();
        service = new FormatoService(MySQL);
        adapter = new FormatoAdapter(service);

    }

    public FormatoAdapter module() {
        return adapter;
    }

}
