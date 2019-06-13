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

    public Venta(String NumeroTicket, Cliente Cliente, Vuelo Vuelo, LineaAerea LineAaerea, Date FechaVenta, String FormaPago){
        this.setNumeroTicket(NumeroTicket);
        this.setCliente(Cliente);
        this.setVuelo(Vuelo);
        this.setFechaVenta(FechaVenta);
        this.setFormaPago(FormaPago);
    }

    public String setNumeroTicket(){
        return NumeroTicket;
    }
    public void setNumeroTicket(String NumeroTicket) {
        this.NumeroTicket = NumeroTicket;
    }

    public Cliente setCliente(){
        return Cliente;
    }
    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }
    public Vuelo setVuelo(){
        return Vuelo;
    }
    public void setVuelo(Vuelo Vuelo) {
        this.Vuelo = Vuelo;
    }
    public Date setFechaVenta(){
        return FechaVenta;
    }
    public void setFechaVenta(Date FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public String setFormaPago(){
        return FormaPago;
    }
    public void setFormaPago(String FormaPago) {
        this.FormaPago = FormaPago;
    }

}
