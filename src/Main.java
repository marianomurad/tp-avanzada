import com.company.Aeropuerto.Aeropuerto;
import com.company.Cliente.Cliente;
import com.company.Cliente.Direccion.Direccion;
import com.company.Cliente.Direccion.Pais.Pais;
import com.company.Cliente.Direccion.Provincia.Provincia;
import com.company.Cliente.Pasaporte.Pasaporte;
import com.company.Cliente.Telefono.Telefono;
import com.company.Cliente.ViajeroFrecuente.ViajeroFrecuente;
import com.company.GUI.App.App;
import com.company.LineaAerea.LineaAerea;
import com.company.Util.txtPersistance.FilesManager;
import com.company.Venta.Venta;
import com.company.Vuelo.Vuelo;

import java.awt.*;
import java.util.Date;


public class Main {

    /**
     * Launch the application.
     * @wbp.parser.entryPoint
     */
    public static void main2(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                App window = new App();
                window.getFrame().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String [] args){
        Pais pais = new Pais("Argentina");
        Pais pais2 = new Pais("Estados Unidos");
        Provincia provincia = new Provincia("Buenos Aires");
        Provincia provincia2 = new Provincia("Florida");
        Aeropuerto aeropuerto = new Aeropuerto("EZE","Ezeiza","Buenos Aires",provincia,pais);
        Aeropuerto aeropuerto2 = new Aeropuerto("MIA","Miami Itl. Airport","Miami",provincia2,pais2);
        Date salida = new Date(121423123);
        Date llegada = new Date(121423123);
        Vuelo vuelo = new Vuelo("123",20,20,aeropuerto,aeropuerto2,salida,llegada,12);
        Pasaporte pasaporte = new Pasaporte("38617779-N",pais,"Argentina",salida,llegada);
        Telefono telefono = new Telefono("1121834410","1121834410","1121834410");
        LineaAerea lineaAerea = new LineaAerea("American Airlines","One World");
        Direccion direccion = new Direccion("panamericana pilar km 45","La lomada lote 155","buenos aires",provincia,pais,"1669");
        ViajeroFrecuente viajeroFrecuente = new ViajeroFrecuente("One World",lineaAerea,"11321","Gold");
        Cliente cliente = new Cliente("Mariano Murad","38617779",pasaporte,"38617779-2",llegada,"marianomurad21@gmail.com",telefono,viajeroFrecuente,direccion);
        Venta venta = new Venta("A23",cliente,vuelo,lineaAerea,salida,"efectivo");

        FilesManager fm = new FilesManager();
        fm.saveVenta(venta);
        fm.saveCliente(cliente);
        fm.saveProvincia(provincia);
        fm.saveProvincia(provincia2);
        fm.savePais(pais);
        fm.savePais(pais2);
        fm.saveVuelo(vuelo);
        fm.saveLineaAerea(lineaAerea);
        fm.saveAeropuerto(aeropuerto);
        fm.saveAeropuerto(aeropuerto2);
    }
}
