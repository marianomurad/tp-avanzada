package com.company.Cliente.ViajeroFrecuente;

import com.company.LineaAerea.LineaAerea;

public class ViajeroFrecuente {

    String alianza;
    LineaAerea aerolinea;
    String numero;
    String categoria;

    public ViajeroFrecuente(String alianza, LineaAerea aerolinea, String numero, String categoria)
    {
        this.setAlianza(alianza);
        this.setAerolinea(aerolinea);
        this.setNumero(numero);
        this.setCategoria(categoria);
    }

    //GETTERS & SETTERS
    //Alianza
    public String getAlianza() { return alianza; }
    public void setAlianza(String alianza) { this.alianza = alianza; }

    //Aerolinea
    public LineaAerea getAerolinea() { return aerolinea; }
    public void setAerolinea(LineaAerea aerolinea) { this.aerolinea = aerolinea; }

    //Numero
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    //Categoria
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

}
