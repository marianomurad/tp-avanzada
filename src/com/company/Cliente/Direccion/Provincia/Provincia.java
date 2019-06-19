package com.company.Cliente.Direccion.Provincia;

import com.company.Cliente.Direccion.Pais.Pais;
import com.sun.xml.internal.ws.api.pipe.helper.PipeAdapter;

public class Provincia {
    private String nombre;
    private Pais pais;
    public Provincia(String nombre) {
        setNombre(nombre);
    }

    //GETTER & SETTER
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public String getPais(){return nombre;}
    public void setPais(Pais pais){this.pais = pais;}

}

