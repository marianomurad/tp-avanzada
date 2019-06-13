package com.company.Aeropuerto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaAeropuerto {
    private static ListaAeropuerto instance = new ListaAeropuerto();
    public List<Aeropuerto> Lista = new ArrayList<Aeropuerto>();

    public void CargarAeropuerto(Aeropuerto ap){

        Lista.add(ap);
    }

    public Aeropuerto buscarAeropuerto(String IdentAeropu){
        Iterator<Aeropuerto> Iterador = Lista.iterator();
        while (Iterador.hasNext()){
            Aeropuerto a = Iterador.next();
            if (a.getIdentif().equals(IdentAeropu)){
                return a;
            }

        }
        return null;
    }

    public static ListaAeropuerto getInstance() {
        if (instance == null) instance = new ListaAeropuerto();

        return instance;
    }

    public static void setInstance(ListaAeropuerto instance) {
        ListaAeropuerto.instance = instance;
    }

}
