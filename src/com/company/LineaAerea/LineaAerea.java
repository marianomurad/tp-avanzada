package com.company.LineaAerea;
import com.company.Vuelo.Vuelo;

public class LineaAerea {

    private String nombreAerolinea;
    private String alianza;
    private Vuelo vuelo;

    public LineaAerea( String aerolinea, String alianza, Vuelo vuelo){
        this.setAerolinea(aerolinea);
        this.setAlianza(alianza);
        this.setVuelo(vuelo);
    }

    public String getAerolinea() { return nombreAerolinea; }
    public void setAerolinea(String aerolinea) { this.nombreAerolinea = aerolinea; }

    public String getAlianza() { return alianza; }
    public void setAlianza(String alianza) { this.alianza = alianza; }

    public Vuelo getVuelo() { return vuelo; }
    public void setVuelo(Vuelo vuelo) { this.vuelo = vuelo; }


}
