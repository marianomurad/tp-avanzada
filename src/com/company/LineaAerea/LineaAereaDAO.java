package com.company.LineaAerea;

import com.company.Cliente.Cliente;

public interface LineaAereaDAO {
    public LineaAerea searchLineaArea(String nombre);
    public boolean saveLineaAerea(LineaAerea la);
    public boolean deleteLineaAerea(String nombre);
    public boolean updateLineaAerea(Cliente cli);
}
