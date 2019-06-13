package com.company.Cliente.Direccion.Pais;

public class Pais {

    private String nombre;

    public Pais(String nombre){ this.setNombre(nombre);}

    //GETTERS & SETTERS
    private void setNombre(String nombre) { this.nombre = nombre; }
    public String getNombre(){ return nombre; }

    public Pais getOrCreatePaisByName(String nombre){
     return  searchPais(nombre) ? this : new Pais(nombre);
    }
    private boolean searchPais(String nombre){

        return false;
    }
}
