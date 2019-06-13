package com.company.Venta;

public class VentaDAOFileImplementation implements VentaDAO {
    @Override
    public Venta BuscarVenta(String NroVenta) {
        return null;
    }

    @Override
    public boolean ConfirmarVenta(Venta VentaDTO) {
        return false;
    }

    @Override
    public boolean EliminarVenta(String NroVenta) {
        return false;
    }

    @Override
    public boolean ModificarVenta(Venta VentaDTO) {
        return false;
    }
}
