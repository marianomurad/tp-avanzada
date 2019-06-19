package com.company.Cliente.Telefono;

import com.company.Cliente.Cliente;

public interface TelefonoDAO {

    public Telefono searchTelefono(String tel);

    public boolean saveTelefono(Telefono tel);

    public boolean deleteTelefono(String telefono);

    public boolean updateTelefono(Telefono tel);
}
