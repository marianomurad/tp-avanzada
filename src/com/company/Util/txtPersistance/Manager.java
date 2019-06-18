package com.company.Util.txtPersistance;

import GUI.Panels.LineasAereas.PanelAltaLineasAereas;
import GUI.Panels.Venta.PanelAltaVenta;
import GUI.Panels.Vuelos.PanelAltaVuelos;
import GUI.Panels.Vuelos.PanelBMCVuelos;
import com.company.Aeropuerto.Aeropuerto;
import com.company.Aeropuerto.ListaAeropuerto;
import com.company.Aeropuerto.ListaAeropuertoDAO;
import com.company.Cliente.Cliente;
import com.company.Cliente.ClienteDAO;
import com.company.Cliente.Direccion.Direccion;
import com.company.Cliente.Direccion.Pais.Pais;
import com.company.Cliente.Direccion.Provincia.Provincia;
import com.company.Cliente.Pasaporte.Pasaporte;
import com.company.Cliente.Telefono.Telefono;
import com.company.Cliente.ViajeroFrecuente.ViajeroFrecuente;
import com.company.Factory.FactoryDAO;
import com.company.LineaAerea.LineaAerea;
import com.company.OptionsList.OptionsList;
import com.company.OptionsList.OptionsListDAO;
import GUI.Panels.Cliente.PanelAltaCliente;
import com.company.Venta.Venta;
import com.company.Venta.VentaDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;


public class Manager {
    //---------------------------------------AltaClientes------------------------------------------------------------------------
    public static boolean persistCliente() throws ParseException {

        ClienteDAO dao = FactoryDAO.getClienteFactory(FactoryDAO.FILE);

        //pasaporte
        String txtNumeroDePasaporte = PanelAltaCliente.txtNumeroDePasaporte.getText();
        Pais paisDeEmision =  (Pais)PanelAltaCliente.cbxPaisDeEmision.getSelectedItem();
        String autoridadDeEmision = PanelAltaCliente.txtAutoridadDeEmision.getText();
        String fechaDeEmision = PanelAltaCliente.txtFechaDeEmision.getText();
        Date dateFechaEmision = new SimpleDateFormat("dd/MM/yyyy").parse(fechaDeEmision);
        String fechaDeVencimiento = PanelAltaCliente.txtFechaDeVencimiento.getText();
        Date dateFechaVencimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaDeVencimiento);
        Pasaporte pasaporte = new Pasaporte(txtNumeroDePasaporte,paisDeEmision,autoridadDeEmision,dateFechaEmision,dateFechaVencimiento);

        //telefono
        String numeroPersonal = PanelAltaCliente.txtNumeroPersonal.getText();
        String numeroCelular = PanelAltaCliente.txtNumeroCelular.getText();
        String numeroLaboral = PanelAltaCliente.txtNumeroLaboral.getText();

        Telefono telefono = new Telefono(numeroPersonal,numeroCelular,numeroLaboral);

        //viajero frecuente
        String alianza =  (String)PanelAltaCliente.cbxAlianza.getSelectedItem();
        LineaAerea aerolinea =  (LineaAerea)PanelAltaCliente.cbxAerolinea.getSelectedItem();
        String numeroViajeroFrecuente = PanelAltaCliente.txtViajeroFrecuente.getText();
        String categoria = PanelAltaCliente.txtCategoria.getText();
        ViajeroFrecuente viajeroFrecuente = new ViajeroFrecuente(alianza,aerolinea,numeroViajeroFrecuente,categoria);

        //direccion
        String calle = PanelAltaCliente.txtCalle.getText();
        String altura = PanelAltaCliente.txtAltura.getText();
        String ciudad = PanelAltaCliente.txtCiudad.getText();
        String Pais =  (String)PanelAltaCliente.cbxPais.getSelectedItem();
        Pais pais = (com.company.Cliente.Direccion.Pais.Pais) createThing(Pais,"Pais");
        String Provincia =  (String)PanelAltaCliente.cbxProvincia.getSelectedItem();
        Provincia provincia = (com.company.Cliente.Direccion.Provincia.Provincia) createThing(Provincia, "Provincia");
        String cp = PanelAltaCliente.txtCp.getText();

        Direccion direccion = new Direccion(calle,altura,ciudad,provincia,pais,cp);

        //cliente
        String nombreyApellido = PanelAltaCliente.txtNombreyApellido.getText();
        String dni = PanelAltaCliente.txtDni.getText();
        String cuit = PanelAltaCliente.txtCuit.getText();
        String fechaDeNacimiento = PanelAltaCliente.txtFechaDeNacimiento.getText();
        Date dateFechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaDeNacimiento);
        String email = PanelAltaCliente.txtEmail.getText();


        return dao.saveCliente(new Cliente(nombreyApellido,dni,pasaporte,cuit,dateFechaNacimiento,email,telefono,viajeroFrecuente,direccion));


    }
    private static Object createThing(String name, String type){
        if(type.equals("Pais")) return new Pais(name);
        return new Provincia(name);
    }

    public static void loadOptionsBoxListaArchivos(String pathArchivo, int optionsBox){
            OptionsListDAO dao = FactoryDAO.getOptionsListFactory(FactoryDAO.FILE);
            OptionsList lista = dao.checkFiles(pathArchivo);
            Iterator<String> Iterador = lista.getOptionsList().iterator();
            switch (optionsBox){
                case 1:
                    while (Iterador.hasNext()) {
                        String item = Iterador.next();
                        PanelAltaCliente.cbxPais.addItem(item);// Usarlo para el Panel que corresponda
                        PanelAltaCliente.cbxPaisDeEmision.addItem(item);
                    }
                    break;

                case 2:
                    while (Iterador.hasNext()) {
                        String item = Iterador.next();
                        PanelAltaCliente.cbxAerolinea.addItem(item);
                    }
                    break;
                case 3:
                    while (Iterador.hasNext()) {
                        String item = Iterador.next();
                        PanelAltaCliente.cbxAlianza.addItem(item);
                    }
                    break;
                case 4:
                    while (Iterador.hasNext()) {
                        String item = Iterador.next();
                        PanelAltaCliente.cbxProvincia.addItem(item);
                    }
                    break;
//                case 5:
//                    while (Iterador.hasNext()) {
//                        String item = Iterador.next();
//                        PanelAltaLineasAereas.cbxAerolinea.addItem(item);
//                    }
//                    break;
//                case 6:
//                    while (Iterador.hasNext()) {
//                        String item = Iterador.next();
//                        PanelAltaLineasAereas.cbxAlianzaAerea.addItem(item);
//                    }
//                    break;
//                case 7:
//                    while (Iterador.hasNext()) {
//                        String item = Iterador.next();
//                        PanelBMCVuelos.cbxAerolineas.addItem(item);
//                    }
//                    break;
//                case 8:
//                    while (Iterador.hasNext()) {
//                        String item = Iterador.next();
//                        PanelAltaLineasAereas.cbxAlianzaAerea.addItem(item);
//                    }
//                    break;
//                case 9:
//                    while (Iterador.hasNext()) {
//                        String item = Iterador.next();
//                        PanelAltaVenta.cbxFormaPago.addItem(item);
//                    }
//                    break;
                default:
                    break;
            }
        }



////	AltaVuelos
//        public static void CargarComboListaAeropuerto(int value){
//            ListaAeropuertoDAO dao = FactoryDAO.getAeropuertoFactory(FactoryDAO.FILE);
//            ListaAeropuerto lista = dao.ConsultarAeropuertos();
//            Iterator<Aeropuerto> Iterador = lista.Lista.iterator();
//            switch (value){
//                case 1:
//                    while (Iterador.hasNext()) {
//                        String item = Iterador.next().getIdentif();
//                        PanelAltaVuelos.cbxAeropuertoSalida.addItem(item);
//                        PanelAltaVuelos.cbxAeropuertoLlegada.addItem(item);
//                    }
//
//                    break;
//
//
//            }
//        }
//
//        public static void VisualizarItemsAeropuerto(String IdentAeropuerto, int IdentifCombo){
////	Aeropuerto a = dao.ListaAeropuertoDTO.getInstance().buscarAeropuerto(IdentAeropuerto);
//            ListaAeropuertoDAO dao = FactoryDAO.getAeropuertoFactory(FactoryDAO.FILE);
//            ListaAeropuerto lista = dao.ConsultarAeropuertos();
//            Aeropuerto a = lista.buscarAeropuerto(IdentAeropuerto);
//            switch (IdentifCombo){
//                case 1:
//                    PanelAltaVuelos.txtNombreAeropuertoSalida.setText(a.getNombre());
//                    PanelAltaVuelos.txtCiudadAeropuertoSalida.setText(a.getCiudad());
//                    PanelAltaVuelos.txtProvinciaAeropuertoSalida.setText(a.getProvincia());
//                    PanelAltaVuelos.txtPaisAeropuertoSalida.setText(a.getPais());
//                    break;
//                case 2:
//                    PanelAltaVuelos.txtNombreAeropuertoLlegada.setText(a.getNombre());
//                    PanelAltaVuelos.txtCiudadAeropuertoLlegada.setText(a.getCiudad());
//                    PanelAltaVuelos.txtProvinciaAeropuertoLlegada.setText(a.getProvincia());
//                    PanelAltaVuelos.txtPaisAeropuertoLlegada.setText(a.getPais());
//                    break;
//            }
//



//Alta Ventas

    public static void viewItemsVenta(String nroTicket,int IdOptions){
       VentaDAO dao = FactoryDAO.getVentas(FactoryDAO.FILE);
       Venta venta1 = dao.searchVenta(nroTicket);
        switch (IdOptions){
            case 1:
//                PanelAltaVuelos.txtNombreAeropuertoSalida.setText(a.getNombre());
//                PanelAltaVuelos.txtCiudadAeropuertoSalida.setText(a.getCiudad());
//                PanelAltaVuelos.txtProvinciaAeropuertoSalida.setText(a.getProvincia());
//                PanelAltaVuelos.txtPaisAeropuertoSalida.setText(a.getPais());
//                break;
            case 2:
//                PanelAltaVuelos.txtNombreAeropuertoLlegada.setText(a.getNombre());
//                PanelAltaVuelos.txtCiudadAeropuertoLlegada.setText(a.getCiudad());
//                PanelAltaVuelos.txtProvinciaAeropuertoLlegada.setText(a.getProvincia());
//                PanelAltaVuelos.txtPaisAeropuertoLlegada.setText(a.getPais());
//                break;
        }
    }

}




