package com.company.Venta;

public interface VentaDAO {
    Venta searchVenta(String nroVenta);
    boolean confirmVenta(Venta venta);
    boolean deleteVenta(String nroVenta);
    boolean modifyVenta(Venta venta);
}
