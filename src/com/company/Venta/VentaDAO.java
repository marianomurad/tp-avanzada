package com.company.Venta;

public interface VentaDAO {
    public Venta BuscarVenta(String NroVenta);
    public boolean ConfirmarVenta(Venta VentaDTO);
    public boolean EliminarVenta(String NroVenta);
    public boolean ModificarVenta(Venta VentaDTO);
}
