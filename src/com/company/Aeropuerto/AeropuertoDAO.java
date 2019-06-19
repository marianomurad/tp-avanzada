package com.company.Aeropuerto;

public interface AeropuertoDAO {
    public Aeropuerto searchAeropuerto(String identif);

    public boolean saveAeropuerto(Aeropuerto aeropuerto);

    public boolean deleteAeropuerto(String identif);

    public boolean updateAeropuerto(Aeropuerto aeropuerto);
}
