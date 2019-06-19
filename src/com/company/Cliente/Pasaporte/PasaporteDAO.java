package com.company.Cliente.Pasaporte;

public interface PasaporteDAO {

    public Pasaporte searchPasaporte(String numPasaporte);

    public boolean savePasaporte(Pasaporte pasaporte);

    public boolean deletePasaporte(String numPasaporte);

    public boolean updatePasaporte(Pasaporte pasaporte);
}
