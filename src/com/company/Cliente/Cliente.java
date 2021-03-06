package com.company.Cliente;

import com.company.Cliente.Direccion.Direccion;
import com.company.Cliente.Pasaporte.Pasaporte;
import com.company.Cliente.Telefono.Telefono;
import com.company.Cliente.ViajeroFrecuente.ViajeroFrecuente;

import java.util.Date;

public class Cliente {

    private String nombreYApellido;
    private String dni;
    private Pasaporte pasaporte;
    private String cuit;
    private Date fechaNac;
    private String email;
    private Telefono telefono;
    private ViajeroFrecuente viajeroFrecuente;
    private Direccion direccion;


    public Cliente(String nombreyapellido, String dni, Pasaporte pasaporte, String cuit, Date fechaNacimiento,
                   String email, Telefono telefono, ViajeroFrecuente numViajeroFrecuente, Direccion direccion)
    {
        this.setNombreYApellido(nombreyapellido);
        this.setDni(dni);
        this.setPasaporte(pasaporte);
        this.setCuit(cuit);
        this.setFechaNac(fechaNacimiento);
        this.setEmail(email);
        this.setTelefono(telefono);
        this.setViajeroFrecuente(numViajeroFrecuente);
        this.setDirecccion(direccion);
    }

    //SETTERS & GETTERS
    //ViajeroFrecuente
    public ViajeroFrecuente getPasajerofrec() { return viajeroFrecuente; }
    public void setViajeroFrecuente(ViajeroFrecuente numViajeroFrecuente) { this.viajeroFrecuente= numViajeroFrecuente; }

    //Direccion
    public Direccion getDireccion() { return direccion; }
    public void setDirecccion(Direccion dircompleta) { this.direccion = dircompleta; }

    //Pasaporte
    public Pasaporte getPasaporte() { return pasaporte; }
    public void setPasaporte(Pasaporte pasaporte) { this.pasaporte = pasaporte; }

    //Telefono
    public Telefono getTelefono() { return telefono; }
    public void setTelefono(Telefono tel) { this.telefono = tel; }

    //Nombre Y Apellido
    public String getNombreYApellido() { return nombreYApellido; }
    public void setNombreYApellido(String nombreyapellido) { this.nombreYApellido = nombreyapellido; }

    //DNI
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    //CUIT
    public String getCuit() { return cuit; }
    public void setCuit(String cuit) { this.cuit = cuit; }

    //Fecha de Nacimiento
    public Date getFechaNac() { return fechaNac; }
    public void setFechaNac(Date fechaNac) { this.fechaNac = fechaNac; }

    //Email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }



}
