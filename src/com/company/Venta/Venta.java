package com.company.Venta;

import com.company.Cliente.Cliente;
import com.company.LineaAerea.LineaAerea;
import com.company.Vuelo.Vuelo;

import java.util.Date;

public class Venta {
    private String NumeroTicket;
    private Cliente Cliente;
    private Vuelo Vuelo;
    private Date FechaVenta;
    private String FormaPago;
    private LineaAerea lineaAerea;

    public Venta(String NumeroTicket, Cliente Cliente, Vuelo Vuelo, LineaAerea lineaAerea, Date FechaVenta, String FormaPago){
        this.setNumeroTicket(NumeroTicket);
        this.setCliente(Cliente);
        this.setVuelo(Vuelo);
        this.setLineaAerea(lineaAerea);
        this.setFechaVenta(FechaVenta);
        this.setFormaPago(FormaPago);
    }

    public String getNumeroTicket(){
        return NumeroTicket;
    }
    public void setNumeroTicket(String NumeroTicket) {
        this.NumeroTicket = NumeroTicket;
    }

    public LineaAerea getLineaAerea(){return lineaAerea;}
    private void setLineaAerea(LineaAerea lineaAerea) { this.lineaAerea = lineaAerea; }

    public Cliente getCliente(){
        return Cliente;
    }
    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public Vuelo getVuelo(){
        return Vuelo;
    }
    public void setVuelo(Vuelo Vuelo) {
        this.Vuelo = Vuelo;
    }

    public Date getFechaVenta(){
        return FechaVenta;
    }
    public void setFechaVenta(Date FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public String getFormaPago(){
        return FormaPago;
    }
    public void setFormaPago(String FormaPago) {
        this.FormaPago = FormaPago;
    }

}
