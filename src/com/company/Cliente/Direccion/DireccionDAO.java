package com.company.Cliente.Direccion;

public interface DireccionDAO {
    public Direccion searchDireccion(String codPostal);

    public boolean saveDireccion(Direccion direccion);

    public boolean deleteDireccion(String codPostal);

    public boolean updateDireccion(Direccion direccion);
}
