package com.company.Util.txtPersistance;

import com.company.Aeropuerto.Aeropuerto;
import com.company.Aeropuerto.ListaAeropuerto;
import com.company.Cliente.Cliente;
import com.company.Cliente.Direccion.Direccion;
import com.company.Cliente.Direccion.Pais.Pais;
import com.company.Cliente.Direccion.Provincia.Provincia;
import com.company.Cliente.Pasaporte.Pasaporte;
import com.company.Cliente.Telefono.Telefono;
import com.company.Cliente.ViajeroFrecuente.ViajeroFrecuente;
import com.company.GUI.OptionsList.OptionsList;
import com.company.LineaAerea.LineaAerea;
import com.company.Venta.Venta;
import com.company.Vuelo.Vuelo;

import java.io.*;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class FilesManager {

    private String rutaClientes = "Clientes.txt";
    private String rutaAeropuerto = "Aeropuertos.txt";
    private String rutaTempClientes = "ClienteTemp.txt";
    private String rutaTempVentas = "VentasTemp.txt";
    private String rutaPaises = "Paises.txt";
    private String rutaProvincias = "Provincias.txt";
    private String rutaPlanes = "Planes.txt";
    private String rutaVentas = "Ventas.txt";
    private String rutaVuelos = "Vuelos.txt";
    private String rutaLineaAerea = "LineaAerea.txt";
    private BufferedReader br;
    private BufferedWriter bw;

    public FilesManager(){

      //Creacion de Archivos
        getOrCreate(rutaClientes);
        getOrCreate(rutaAeropuerto);
        getOrCreate(rutaVuelos);
        getOrCreate(rutaVentas);
        getOrCreate(rutaProvincias);
        getOrCreate(rutaPaises);
        getOrCreate(rutaPlanes);
        getOrCreate(rutaLineaAerea);

    }

    private void getOrCreate(String route) {
        File file = new File(route);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }

    //Clientes
    public Cliente getCliente(String dni){ //Busco por dni en el archivo y devuelvo el Cliente.
        String linea;
        boolean band = false;
        try{
            File fCli = new File(this.rutaClientes);
            linea = getThing(dni, band, fCli);
        }
        catch (Exception e){
            return null;
        }
        return(this.decodeCliente(linea));
    }

    //util methods for Cliente Object
    private String encodeCliente(Cliente Cli){ //Aca paso el ClienteDTO a la cadena de string para guardar en archivo.
        String txt = Cli.getNombreYApellido()+";"+Cli.getDni()+";"+Cli.getPasaporte().getNumPasaporte()+";"+Cli.getPasaporte().getPaisEmision()+";"+Cli.getPasaporte().getAutoridadEmision()+";"+Cli.getPasaporte().getFechaEmision()+";"+";"+Cli.getPasaporte().getFechaVencimiento()
                +";"+Cli.getCuit()+";"+Cli.getFechaNac()+";"+Cli.getEmail()+";"+
                Cli.getTelefono().getNumPersonal()+";"+Cli.getTelefono().getNumCelular()+";"+Cli.getTelefono().getNumLaboral()
                +";"+Cli.getPasajerofrec().getAlianza()+";"+Cli.getPasajerofrec().getAerolinea()+";"+Cli.getPasajerofrec().getNumero()+";"+Cli.getPasajerofrec().getCategoria()
                +";"+Cli.getDireccion().getCalle()+";"+Cli.getDireccion().getAltura()+";"+Cli.getDireccion().getCiudad()+";"+Cli.getDireccion().getProvincia()
                +";"+Cli.getDireccion().getPais()+";"+Cli.getDireccion().getCodPostal()+"\n";
        return txt;
    }

    private Cliente decodeCliente(String txt){//Recibo la cadena de string del archivo y devuelvo un ClienteDTO (previamente armo los atributos compuestos).

        String[] partes = txt.split(";");
        Pais pais = new Pais(partes[3]);
        Date emision = new Date(parseInt(partes[5]));
        Date vencimiento = new Date(parseInt(partes[6]));
        Pasaporte Pas = new Pasaporte(partes[2],pais, partes[4], emision, vencimiento);
        Telefono tel = new Telefono(partes[10], partes[11], partes[12]);
        LineaAerea lineaAerea = new LineaAerea(partes[14],"OneWorld");
        ViajeroFrecuente viajeroFrecuente = new ViajeroFrecuente(partes[13], lineaAerea, partes[15],partes[16]);
        Direccion dir = new Direccion(partes[17],partes[18],partes[19],getProvincia(partes[20]),getPais(partes[21]),partes[22]);

        Date nacimiento = new Date(parseInt(partes[8]));
        Cliente Cli = new Cliente(partes[0], partes[1],Pas, partes[7],nacimiento,partes[9],tel,viajeroFrecuente,dir);
        return Cli;
    }

    //CRUD Cliente
    public boolean saveCliente(Cliente Cli){
        try{
            File fCli = new File(this.rutaClientes);
            FileWriter fw = new FileWriter(fCli, true);
            bw = new BufferedWriter(fw);
            bw.write(this.encodeCliente(Cli));
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean deleteCliente(String dni){
        String linea;
        try{
            File fCli = new File(this.rutaClientes);
            File ftmpCli = new File(this.rutaTempClientes);
            FileReader fr = new FileReader(fCli);
            PrintWriter pw = new PrintWriter(new FileWriter(ftmpCli));
            br = new BufferedReader(fr);
            while((linea = br.readLine())!= null){
                // guardo en la lista todos, menos el cliente a eliminar.
                if (!linea.split(";")[1].equalsIgnoreCase(dni)){

                    pw.println(linea);
                    pw.flush();}

            }
            closeAll(fr, pw);
            try{
                ftmpCli.renameTo(fCli); //Renombro el nuevo archivo como el original.
            }catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
            return fCli.delete();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
            return false;
        }
    }
    public boolean updateCliente(Cliente cliente){
        deleteCliente(cliente.getDni());
        return saveCliente(cliente);
    }

    private void closeAll(FileReader fr, PrintWriter pw) throws IOException {
        pw.close();
        fr.close();
        br.close();
    }


    //PAIS
    private Pais getPais(String nombre){
        String linea;
        boolean band = false;
        try{
            File filePais = new File(this.rutaPaises);
            linea = getThing(nombre, band, filePais);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return new Pais(linea);
    }

    //PROVINCIA
    private Provincia getProvincia(String nombre){
        String linea;
        boolean band = false;
        try{
            File filePais = new File(this.rutaProvincias);
            linea = getThing(nombre, band, filePais);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return new Provincia(linea);
    }

    //util method to get any type of object from .txt file
    private String getThing(String nombre, boolean band, File file) throws IOException {
        String linea;
        FileReader fileReader = new FileReader(file);
        br = new BufferedReader(fileReader);
        while(((linea = br.readLine())!= null) && (!band)) {
            if (linea.split(";")[1].equalsIgnoreCase(nombre)) {
                band = true;
            }

        }
        fileReader.close();
        br.close();
        return linea;
    }


    //Aeropuertos

    public ListaAeropuerto getListaAeropuerto (){
        ListaAeropuerto lap = new ListaAeropuerto();
        File fAeropuerto = new File(this.rutaAeropuerto);
        String linea;
        if (fAeropuerto.exists()){
            try{
                FileReader fr = new FileReader(fAeropuerto);
                br = new BufferedReader(fr);
                while((linea = br.readLine())!= null){
                    lap.CargarAeropuerto(decodeAeropuerto(linea));
                }
                fr.close();
                br.close();
            }
            catch (Exception e){

                System.out.print(e.getMessage());
                return null;
            }

        }
        return lap;
    }

    private Aeropuerto decodeAeropuerto(String txt){//Recibo la cadena de string del archivoAeropuerto y devuelvo un Aeropuerto.
        String[] partes = txt.split(";");
        Aeropuerto ap = new Aeropuerto(partes[0], partes[1], partes[2], getProvincia(partes[3]), getPais(partes[4]));
        return ap;
    }

    private String encodeAeropuerto(Aeropuerto aeropuerto) {
        String txt = aeropuerto.getNombre()+";"+aeropuerto.getIdentif()+";"+aeropuerto.getCiudad()+";"+
                aeropuerto.getProvincia()+";"+aeropuerto.getPais()+"\n";
        return txt;
    }

    //Para list of options to use
    public OptionsList getOptionsList (String pathArchivo){//Recorro el archivo y devuelvo una lista.
        OptionsList optionsList = new OptionsList();
        File f = new File(pathArchivo);
        String linea;
        if (f.exists()){
            try{
                FileReader fr = new FileReader(f);
                br = new BufferedReader(fr);
                while((linea = br.readLine())!= null){
                    optionsList.loadLine(linea);
                }
                fr.close();
                br.close();
            }
            catch (Exception e){

                return null;
            }

        }
        return optionsList;
    }


    //VUELO
    private Vuelo getVuelo(String nroVuelo) {
        String linea;
        boolean band = false;
        try{
            File file = new File(this.rutaVuelos);
            linea = getThing(nroVuelo, band, file);
        }
        catch (Exception e){
            return null;
        }
        return(this.decodeVuelo(linea));
    }

    private Vuelo decodeVuelo(String linea) {
        String[] parts = linea.split(";");
        ListaAeropuerto listaAeropuerto = new ListaAeropuerto();
        Aeropuerto aeropuertoSalida  = listaAeropuerto.buscarAeropuerto(parts[3]);
        Aeropuerto aeropuertoLlegada = listaAeropuerto.buscarAeropuerto(parts[4]);
        Date fechaSalida = new Date(parseInt(parts[5]));
        Date fechaLlegada = new Date(parseInt(parts[6]));
        int tiempoVuelo = parseInt(parts[7]);

        Vuelo vuelo = new Vuelo(parts[0],parseInt(parts[1]),parseInt(parts[2]),aeropuertoSalida,aeropuertoLlegada,fechaSalida,fechaLlegada,tiempoVuelo);
        return vuelo;
    }

    //LINEA AEREA / AEROLINEA
    private LineaAerea getLineaAerea(String nombre) {
        String linea;
        boolean band = false;
        try{
            File file = new File(this.rutaLineaAerea);
            linea = getThing(nombre, band, file);
        }
        catch (Exception e){
            return null;
        }
        return(this.decodeLineaAerea(linea));
    }

    private LineaAerea decodeLineaAerea(String linea) {
        String[] partes = linea.split(";");
        String nombre = partes[0];
        String alianza = partes[1];
        Vuelo vuelo = getVuelo(partes[2]);


        LineaAerea lineaAerea = new LineaAerea(nombre,alianza);
        lineaAerea.setVuelo(vuelo);
        return lineaAerea;
    }


    //VENTA
    public Venta getVenta(String nroVenta) {
        String linea;
        boolean band = false;
        try{
            File fCli = new File(this.rutaClientes);
            linea = getThing(nroVenta, band, fCli);
        }
        catch (Exception e){
            return null;
        }
        return(this.decodeVenta(linea));    }

    //util methods for Venta Object
    private Venta decodeVenta(String linea) {
        String[] partes = linea.split(";");
        String nroTicket = partes[0];
        Cliente cliente = decodeCliente(partes[1]);
        Vuelo vuelo = getVuelo(partes[2]);
        LineaAerea  lineaAerea  = getLineaAerea(partes[3]);
        Date fechaVenta = new Date(parseInt(partes[4]));
        String formaPago = partes[5];


        Venta venta = new Venta(nroTicket,cliente,vuelo,lineaAerea,fechaVenta,formaPago);

        return venta;    }

    private String encodeVenta(Venta venta) {

        String txt = venta.getNumeroTicket()+";"+venta.getCliente()+";"+venta.getVuelo()+";"+
                venta.getLineaAerea()+";"+venta.getFechaVenta()+";"+venta.getFormaPago()+"\n";

        return txt;
    }

    //CRUD 4 VENTA
    public boolean saveVenta(Venta venta) {
        try{
            File fCli = new File(this.rutaVentas);
            FileWriter fw = new FileWriter(fCli, true);
            bw = new BufferedWriter(fw);
            bw.write(this.encodeVenta(venta));
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean deleteVenta(String nroVenta) {
        String linea;
        try{
            File fVenta = new File(this.rutaVentas);
            File ftmpVenta = new File(this.rutaTempVentas);
            FileReader fr = new FileReader(fVenta);
            PrintWriter pw = new PrintWriter(new FileWriter(ftmpVenta));
            br = new BufferedReader(fr);
            while((linea = br.readLine())!= null){
                // guardo en la lista todos, menos el cliente a eliminar.
                if (!linea.split(";")[1].equalsIgnoreCase(nroVenta)){

                    pw.println(linea);
                    pw.flush();}

            }
            closeAll(fr, pw);
            try{
                ftmpVenta.renameTo(fVenta); //Renombro el nuevo archivo como el original.
            }catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
            return fVenta.delete();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
            return false;
        }
    }

    public boolean updateVenta(Venta venta) {
            deleteVenta(venta.getNumeroTicket());
            return saveVenta(venta);
    }

    public boolean saveProvincia(Provincia provincia) {
        try{
            File file = new File(this.rutaProvincias);
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(provincia.getNombre());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e){
            return false;
        }
        return true;

    }

    public boolean savePais(Pais pais) {

        try{
            File file = new File(this.rutaPaises);
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(pais.getNombre());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean saveVuelo(Vuelo vuelo) {
        try{
            File file = new File(this.rutaVuelos);
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(encodeVuelo(vuelo));
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    private String encodeVuelo(Vuelo vuelo) {
            String txt = vuelo.getNroVuelo()+";"+
                         vuelo.getAeropuertoLleg()+";"+vuelo.getAeropuertoSal()+";"+
                         vuelo.getCantAsientos()+";"+vuelo.getCantAsientoDisp()+";"+
                         vuelo.getFechaLlegada()+";"+vuelo.getFechaSalida()+";"+
                         vuelo.getTiempoVuelo()+"\n";
            return txt;
    }

    public boolean saveLineaAerea(LineaAerea lineaAerea) {
        try{
            File file = new File(this.rutaLineaAerea);
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(lineaAerea.getAerolinea());
            bw.write(lineaAerea.getAlianza());
            if(lineaAerea.getVuelo() != null)
            bw.write(encodeVuelo(lineaAerea.getVuelo()));
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean saveAeropuerto(Aeropuerto aeropuerto) {
        try{
            File file = new File(this.rutaAeropuerto);
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(encodeAeropuerto(aeropuerto));
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e){
            return false;
        }
        return true;    }

}
