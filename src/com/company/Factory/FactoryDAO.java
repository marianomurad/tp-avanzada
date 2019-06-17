package com.company.Factory;

import com.company.Aeropuerto.ListaAeropuertoDAO;
import com.company.Aeropuerto.ListaAeropuertoDAOFileImplementation;
import com.company.Cliente.ClienteDAO;
import com.company.Cliente.ClienteDAOFileImplementation;
import com.company.OptionsList.OptionsListDAO;
import com.company.OptionsList.OptionsListDAOFileImplementation;
import com.company.Venta.VentaDAO;
import com.company.Venta.VentaDAOFileImplementation;


public abstract class FactoryDAO {


    public static final int FILE = 1;

    //PARA CADA METODO DE PERSISTENCIA 1 CASE.

    public static ClienteDAO getClienteFactory(int value){
        switch(value){
            case FILE:
                return new ClienteDAOFileImplementation();
            default:
                throw new IllegalArgumentException();
        }
    }


    public static ListaAeropuertoDAO getAeropuertoFactory(int value){
        switch(value){
            case FILE:
                return new ListaAeropuertoDAOFileImplementation();
            default:
                throw new IllegalArgumentException();
        }
    }

    public static OptionsListDAO getOptionsListFactory(int value){
        switch(value){
            case FILE:
                return new OptionsListDAOFileImplementation();
            default:
                throw new IllegalArgumentException();
        }
    }


    public static VentaDAO getVentas(int value) {
        switch(value){
            case FILE:
                return new VentaDAOFileImplementation();
            default:
                throw new IllegalArgumentException();
        }    }
}
