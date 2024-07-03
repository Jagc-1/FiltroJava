package com.campuslands.modules.actor.domain.models;

public class Actor {
    private int id;
    private String nombre;      
    private int idnacionalidad; 
    private int edad;
    private int idgenero;

    public Actor(){
        
    }

    public Actor(String nombre, int idnacionalidad, int edad, int idgenero) {
        this.nombre = nombre;
        this.idnacionalidad = idnacionalidad;
        this.edad = edad;
        this.idgenero = idgenero;
    }
    
    public Actor(int id, String nombre, int idnacionalidad, int edad, int idgenero) {
        this.id = id;
        this.nombre = nombre;
        this.idnacionalidad = idnacionalidad;
        this.edad = edad;
        this.idgenero = idgenero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdnacionalidad() {
        return idnacionalidad;
    }

    public void setIdnacionalidad(int idnacionalidad) {
        this.idnacionalidad = idnacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    
}
