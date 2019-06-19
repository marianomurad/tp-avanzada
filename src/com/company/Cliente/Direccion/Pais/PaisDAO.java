package com.company.Cliente.Direccion.Pais;

public interface PaisDAO {
    public Pais searchPais(String nombre);

    public boolean savePais(Pais pais);

    public boolean deletePais(String nombre);

    public boolean updatePais(Pais pais);
}
