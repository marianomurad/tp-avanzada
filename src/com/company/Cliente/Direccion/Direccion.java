package com.company.Cliente.Direccion;

import com.company.Cliente.Direccion.Pais.Pais;
import com.company.Cliente.Direccion.Provincia.Provincia;

public class Direccion {
    String calle;
    String altura;
    String ciudad;
    Provincia provincia;
    Pais pais;
    String codPostal;

    public Direccion(String calle,String altura,String ciudad,Provincia provincia,Pais pais,String codPostal)
    {
        this.setCalle(calle);
        this.setAltura(altura);
        this.setCiudad(ciudad);
        this.setProvincia(provincia);
        this.setPais(pais);
        this.setCodPostal(codPostal);
    }

    //Calle
    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    //Altura
    public String getAltura() { return altura; }
    public void setAltura(String altura) { this.altura = altura; }

    //Ciudad
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    //Provicia
    public Provincia getProvincia() { return provincia; }
    public void setProvincia(Provincia provincia) { this.provincia = provincia; }

    //Pais
    public Pais getPais() { return pais; }
    public void setPais(Pais pais) { this.pais = pais; }

    //Codigo Postal
    public String getCodPostal() { return codPostal; }
    public void setCodPostal(String codPostal) { this.codPostal = codPostal; }

}
