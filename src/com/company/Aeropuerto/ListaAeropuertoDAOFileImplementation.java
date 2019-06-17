package com.company.Aeropuerto;

import com.company.Util.txtPersistance.FilesManager;

public class ListaAeropuertoDAOFileImplementation implements ListaAeropuertoDAO {
    @Override
    public ListaAeropuerto ConsultarAeropuertos() {
        FilesManager fm = new FilesManager();
        return fm.getListaAeropuerto();
    }
}
