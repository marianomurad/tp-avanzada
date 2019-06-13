package com.company.Cliente.Telefono;

public class Telefono {

    String nroPersonal;
    String nroCelular;
    String nroLaboral;

    public Telefono(String numeroPer,String numeroCelular,String numeroLaboral)
    {
        this.setNumPersonal(numeroPer);
        this.setNumCelular(numeroCelular);
        this.setNumLaboral(numeroLaboral);
    }

    //GETTERS & SETTERS
    //Personal
    public String getNumPersonal() { return nroPersonal; }
    public void setNumPersonal(String nroPersonal) { this.nroPersonal = nroPersonal; }

    //Celular
    public String getNumCelular() { return nroCelular; }
    public void setNumCelular(String nroCelular) { this.nroCelular = nroCelular; }

    //Laboral
    public String getNumLaboral() { return nroLaboral; }
    public void setNumLaboral(String nroLaboral) { this.nroLaboral = nroLaboral; }
}
