package com.company.Factory;

import com.company.Aeropuerto.ListaAeropuertoDAO;
import com.company.Aeropuerto.ListaAeropuertoDAOFileImplementation;
import com.company.Cliente.ClienteDAO;
import com.company.Cliente.ClienteDAOFileImplementation;


public abstract class FactoryDAO {


    public static final int FILE = 1;

    //PARA CADA METODO DE PERSISTENCIA 1 CASE.

    public static ClienteDAO getClienteFactory(int valor){
        switch(valor){
            case FILE:
                return new ClienteDAOFileImplementation();
            default:
                throw new IllegalArgumentException();
        }
    }


    public static ListaAeropuertoDAO getAeropuertoFactory(int valor){
        switch(valor){
            case FILE:
                return new ListaAeropuertoDAOFileImplementation();
            default:
                throw new IllegalArgumentException();
        }
    }



}
