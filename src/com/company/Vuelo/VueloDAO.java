package com.company.Vuelo;

public interface VueloDAO {
    public Vuelo buscarVuelo(String Nro);
    public boolean guardarCliente(Vuelo vuelo);
    public boolean borrarCliente(String Nro);
    public boolean actualizarCliente(Vuelo Vuelo);
}
