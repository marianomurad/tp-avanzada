package com.company.Venta;

import com.company.Util.txtPersistance.FilesManager;

public class VentaDAOFileImplementation implements VentaDAO {


    @Override
    public Venta searchVenta(String nroVenta) {
        FilesManager fm = new FilesManager();
        return(fm.getVenta(nroVenta));
    }

    @Override
    public boolean confirmVenta(Venta venta) {
        FilesManager filesManager = new FilesManager();
        return filesManager.saveVenta(venta);

    }

    @Override
    public boolean deleteVenta(String nroVenta) {

        FilesManager filesManager = new FilesManager();
        return filesManager.deleteVenta(nroVenta);
    }

    @Override
    public boolean modifyVenta(Venta venta) {
        FilesManager filesManager = new FilesManager();
        return filesManager.updateVenta(venta);
    }
}
