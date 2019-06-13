package com.company.Util;

import com.company.Aeropuerto.Aeropuerto;
import com.company.Aeropuerto.ListaAeropuerto;
import com.company.Cliente.Cliente;
import com.company.Cliente.Direccion.Direccion;
import com.company.Cliente.Direccion.Pais.Pais;
import com.company.Cliente.Direccion.Provincia.Provincia;
import com.company.Cliente.Pasaporte.Pasaporte;
import com.company.Cliente.Telefono.Telefono;
import com.company.Cliente.ViajeroFrecuente.ViajeroFrecuente;

import java.io.*;

public class FilesManager {

    private String rutaClientes = "Clientes.txt";
    private String rutaAeropuerto = "Aeropuertos.txt";
    private String rutaTempClientes = "ClienteTemp.txt";
    private String rutaPaises = "Paises.txt";
    private String rutaProvincias = "Provincias.txt";
    private String rutaPlanes = "Planes.txt";
    private BufferedReader br;
    private BufferedWriter bw;

    public FilesManager(){

//Creacion de Archivos

        File fCli = new File(this.rutaClientes);
        if (!fCli.exists()){
            try{
                fCli.createNewFile();
            }
            catch (Exception e){
                System.out.print(e.getMessage());
            }
        }

        File fPlan = new File(this.rutaPlanes);
        if (!fPlan.exists()){
            try{
                fPlan.createNewFile();
            }
            catch (Exception e){
            }
        }

    }


    //Clientes
    //Save new Cliente on .txt file

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

    //util method for Cliente Object
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

        Pasaporte Pas = new Pasaporte(partes[2], partes[3], partes[4], partes[5], partes[6]);
        Telefono tel = new Telefono(partes[10], partes[11], partes[12]);
        ViajeroFrecuente viajeroFrecuente = new ViajeroFrecuente(partes[13], partes[14], partes[15],partes[16]);
        Direccion dir = new Direccion(partes[17],partes[18],partes[19],getProvincia(partes[20]),getPais(partes[21]),partes[22]);

        Cliente Cli = new Cliente(partes[0], partes[1],Pas, partes[7],partes[8],partes[9],tel,viajeroFrecuente,dir);
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
    private String getThing(String nombre, boolean band, File filePais) throws IOException {
        String linea;
        FileReader fileReader = new FileReader(filePais);
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

}
