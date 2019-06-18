package com.company.Vuelo;

import com.company.Aeropuerto.Aeropuerto;

import java.util.Date;

public class Vuelo {

    private String NroVuelo;
    private int CantAsientos;
    private int CantAsientoDisp;
    private Aeropuerto AeropuertoSal;
    private Aeropuerto AeropuertoLleg;
    private Date FechaSalida;
    private Date FechaLlegada;
    private int tiempoVuelo;

    public Vuelo (String NroVuelo, int CantAsientos, int CantAsientoDisp, Aeropuerto AeroSal, Aeropuerto AeroLleg, Date FHSal, Date FHLleg, int tiempoVuelo){
        this.setNroVuelo(NroVuelo);
        this.setCantAsientos(CantAsientos);
        this.setCantAsientoDisp(CantAsientoDisp);
        this.setAeropuertoSal(AeroSal);
        this.setAeropuertoLleg(AeroLleg);
        this.setFechaSalida(FHSal);
        this.setFechaLlegada(FHLleg);
        this.setTiempoVuelo(tiempoVuelo);
    }

    //GETTERS & SETTERS
    public int getCantAsientos() {
        return CantAsientos;
    }
    public void setCantAsientos(int cantAsientos) { CantAsientos = cantAsientos; }

    public String getNroVuelo() {
        return NroVuelo;
    }
    public void setNroVuelo(String nroVuelo) {
        NroVuelo = nroVuelo;
    }

    public Aeropuerto getAeropuertoSal() {
        return AeropuertoSal;
    }
    public void setAeropuertoSal(Aeropuerto aeropuertoSal) {
        AeropuertoSal = aeropuertoSal;
    }

    public Aeropuerto getAeropuertoLleg() {
        return AeropuertoLleg;
    }
    public void setAeropuertoLleg(Aeropuerto aeropuertoLleg) {
        AeropuertoLleg = aeropuertoLleg;
    }

    public Date getFechaSalida() {
        return FechaSalida;
    }
    public void setFechaSalida(Date fechaSalida) {
        FechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return FechaLlegada;
    }
    public void setFechaLlegada(Date fechaLlegada) {
        FechaLlegada = fechaLlegada;
    }

    public int getTiempoVuelo() { return tiempoVuelo; }
    public void setTiempoVuelo(int turnaround) {
        tiempoVuelo = tiempoVuelo;
    }

    public int getCantAsientoDisp() {
        return CantAsientoDisp;
    }
    public void setCantAsientoDisp(int cantAsientoDisp) {
        CantAsientoDisp = cantAsientoDisp;
    }
}
