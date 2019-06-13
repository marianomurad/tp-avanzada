package com.company.Cliente.Pasaporte;

public class Pasaporte {

    String numPasaporte;
    String paisEmision;
    String autoridadEmision;
    String fechaEmision;
    String fechaVencimiento;


    public Pasaporte(String numPasaporte, String paisEmision,String autoridad,String emision,String vencimiento)
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
    public String getPaisEmision() { return paisEmision; }
    public void setPaisEmision(String paisEmision) { this.paisEmision = paisEmision; }

    //Autoridad Emisora
    public String getAutoridadEmision() { return autoridadEmision; }
    public void setAutoridadEmision(String autoridadEmision) { this.autoridadEmision = autoridadEmision; }

    //Fecha Emision
    public String getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(String fechaEmision) { this.fechaEmision = fechaEmision; }

    //Fecha Vencimiento
    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

}
