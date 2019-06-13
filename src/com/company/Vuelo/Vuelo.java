package com.company.Vuelo;

import com.company.Aeropuerto.Aeropuerto;

import java.util.Date;

public class Vuelo {

    private String NroVuelo;
    private int CantAsiento;
    private int CantAsientoDisp;
    private Aeropuerto AeropuertoSal;
    private Aeropuerto AeropuertoLleg;
    private Date FechaSalida;
    private Date FechaLlegada;
    private String Turnaround;

    public Vuelo (String NroVuelo, int CantAsiento, int CantAsientoDisp, Aeropuerto AeroSal, Aeropuerto AeroLleg, Date FHSal, Date FHLleg, String TurnAround){
        this.setNroVuelo(NroVuelo);
        this.setCantAsiento(CantAsiento);
        this.setCantAsientoDisp(CantAsientoDisp);
        this.setAeropuertoSal(AeroSal);
        this.setAeropuertoLleg(AeroLleg);
        this.setFechaSalida(FHSal);
        this.setFechaLlegada(FHLleg);
        this.setTurnaround(TurnAround);
    }

    public int getCantAsiento() {
        return CantAsiento;
    }
    public void setCantAsiento(int cantAsiento) {
        CantAsiento = cantAsiento;
    }
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
    public String getTurnaround() {
        return Turnaround;
    }
    public void setTurnaround(String turnaround) {
        Turnaround = turnaround;
    }

    public int getCantAsientoDisp() {
        return CantAsientoDisp;
    }

    public void setCantAsientoDisp(int cantAsientoDisp) {
        CantAsientoDisp = cantAsientoDisp;
    }
}
