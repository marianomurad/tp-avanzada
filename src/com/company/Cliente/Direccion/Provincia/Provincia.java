package com.company.Cliente.Direccion.Provincia;

import com.sun.xml.internal.ws.api.pipe.helper.PipeAdapter;

public class Provincia {
    private String nombre;
    public Provincia(String nombre) {
        setNombre(nombre);
    }

    //GETTER & SETTER
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

}

