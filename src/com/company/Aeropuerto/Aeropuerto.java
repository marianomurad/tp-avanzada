package com.company.Aeropuerto;

import com.company.Cliente.Direccion.Pais.Pais;
import com.company.Cliente.Direccion.Provincia.Provincia;

public class Aeropuerto {

    private String identif;
    private String Ciudad;
    private Provincia Provincia;
    private Pais Pais;
    private String Nombre;

    public Aeropuerto(String ident,String nombre, String Ciudad, Provincia prov, Pais pais){
        this.setIdentif(ident);
        this.setNombre(nombre);
        this.setCiudad(Ciudad);
        this.setProvincia(prov);
        this.setPais(pais);
    }
    //GETTERS & SETTERS
    //ID
    public String getIdentif() { return identif; }
    public void setIdentif(String identif) { this.identif = identif; }

    //Ciudad
    public String getCiudad() { return Ciudad; }
    public void setCiudad(String ciudad) { Ciudad = ciudad; }

    //Provincia
    public Provincia getProvincia() { return Provincia; }
    public void setProvincia(Provincia provincia) { Provincia = provincia; }

    //Pais
    public Pais getPais() { return Pais; }
    public void setPais(Pais pais) { Pais = pais; }

    //Nombre
    public String getNombre() { return Nombre; }
    public void setNombre(String nombre) { Nombre = nombre; }
}
