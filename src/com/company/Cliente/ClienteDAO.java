package com.company.Cliente;

public interface ClienteDAO {

        public Cliente searchCliente(String dni);

        public boolean saveCliente(Cliente cli);

        public boolean deleteCliente(String dni);

        public boolean updateCliente(Cliente cli);

}




