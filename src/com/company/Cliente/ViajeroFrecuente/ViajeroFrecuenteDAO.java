package com.company.Cliente.ViajeroFrecuente;


public interface ViajeroFrecuenteDAO {
    public ViajeroFrecuente searchViajeroFrecuente(String alianza);

    public boolean saveViajeroFrecuente(ViajeroFrecuente cli);

    public boolean deleteViajeroFrecuente(String alianza);

    public boolean updateViajeroFrecuente(ViajeroFrecuente cli);
}
