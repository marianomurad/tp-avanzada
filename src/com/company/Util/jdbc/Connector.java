package com.company.Util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {



    public static void main(String[]args){
        Connection con;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:1433;DatabaseName=aeropuerto", "sa", "");
            if(!con.isClosed()){
                System.out.println("Conexion established");
            }
            System.out.println("Conexion not established");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
