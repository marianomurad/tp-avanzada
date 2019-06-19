package com.company.Cliente.Direccion.Provincia;


public interface ProvinciaDAO {
    public Provincia searchProvincia(String nombre);

    public boolean saveProvincia(Provincia provincia);

    public boolean deleteProvincia(String nombre);

    public boolean updateProvincia(Provincia provincia);
}
