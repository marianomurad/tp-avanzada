package com.company.Cliente.Pasaporte;

import com.company.Cliente.Direccion.Pais.Pais;

import java.util.Date;

public class Pasaporte {

    String numPasaporte;
    Pais paisEmision;
    String autoridadEmision;
    Date fechaEmision;
    Date fechaVencimiento;


    public Pasaporte(String numPasaporte, Pais paisEmision, String autoridad, Date emision, Date vencimiento)
    {
        this.setNumPasaporte(numPasaporte);
        this.setPaisEmision(paisEmision);
        this.setAutoridadEmision(autoridad);
        this.setFechaEmision(emision);
        this.setFechaVencimiento(vencimiento);
    }

    //GETTERS & SETTERS
    //Numero Pasaporte
    public String getNumPasaporte() { return numPasaporte; }
    public void setNumPasaporte(String numPasaporte) { this.numPasaporte = numPasaporte; }

    //Pais de Emision
    public Pais getPaisEmision() { return paisEmision; }
    public void setPaisEmision(Pais paisEmision) { this.paisEmision = paisEmision; }

    //Autoridad Emisora
    public String getAutoridadEmision() { return autoridadEmision; }
    public void setAutoridadEmision(String autoridadEmision) { this.autoridadEmision = autoridadEmision; }

    //Fecha Emision
    public Date getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(Date fechaEmision) { this.fechaEmision = fechaEmision; }

    //Fecha Vencimiento
    public Date getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(Date fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

}
