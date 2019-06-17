package com.company.Cliente;

import com.company.Util.txtPersistance.FilesManager;

public class ClienteDAOFileImplementation implements ClienteDAO {


    @Override
    public Cliente searchCliente(String dni) {
        FilesManager fm = new FilesManager();
        return(fm.getCliente(dni));}

    @Override
    public boolean saveCliente(Cliente cli) {
        FilesManager fm = new FilesManager();
        return (fm.saveCliente(cli));
    }

    @Override
    public boolean deleteCliente(String dni) {
        FilesManager fm = new FilesManager();
        return fm.deleteCliente(dni);
    }

    @Override
    public boolean updateCliente(Cliente cli) {
        FilesManager fm = new FilesManager();
        return fm.updateCliente(cli);
    }
}
