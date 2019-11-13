package com.company.GUI.Panels.Cliente;

import com.company.GUI.App.IndexMenu;
import com.company.Util.txtPersistance.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class PanelAltaCliente extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    public static JPanel panel;

    public static JTextField txtNombreyApellido;
    public static JTextField txtDni;
    public static JTextField txtEmail;
    public static JTextField txtNumeroDePasaporte;
    public static JTextField txtAutoridadDeEmision;
    public static JTextField txtFechaDeEmision;
    public static JTextField txtFechaDeVencimiento;
    public static JTextField txtCuit;
    public static JTextField txtFechaDeNacimiento;
    public static JTextField txtNumeroPersonal;
    public static JTextField txtNumeroCelular;
    public static JTextField txtNumeroLaboral;
    public static JTextField txtViajeroFrecuente;
    public static JTextField txtCategoria;
    public static JTextField txtCalle;
    public static JTextField txtAltura;
    public static JTextField txtCiudad;
    public static JTextField txtCp;

    public static JComboBox<String> cbxPaisDeEmision;
    public static JComboBox<String> cbxPais;
    public static JComboBox<String> cbxProvincia;
    public static JComboBox<String> cbxAerolinea;
    public static JComboBox<String> cbxAlianza;

    public String pathPaises = "Paises.txt";
    public String pathAerolineas = "Aerolineas.txt";
    public String pathAlianzas = "Alianzas.txt";
    public String pathProvincias = "Provincias.txt";

    private JButton btnAccept;
    private JButton btnCancel;
    /**
     * Create the panel.
     */
    public PanelAltaCliente() {
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre y Apellido:");
        lblNombre.setBounds(10, 41, 132, 14);
        add(lblNombre);

        txtNombreyApellido = new JTextField();
        txtNombreyApellido.setBounds(152, 35, 193, 20);
        add(txtNombreyApellido);
        txtNombreyApellido.setColumns(10);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(10, 69, 46, 14);
        add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(152, 63, 193, 20);
        add(txtDni);
        txtDni.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(11, 150, 46, 14);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(152, 150, 193, 20);
        add(txtEmail);
        txtEmail.setColumns(10);

        btnAccept = new JButton("Aceptar");
        add(btnAccept);
        btnAccept.setBounds(553, 370, 103, 43);
        btnAccept.addActionListener(this);

        btnCancel = new JButton("Cancelar");
        add(btnCancel);
        btnCancel.setBounds(677, 370, 103, 43);
        btnCancel.addActionListener(this);


        JLabel lblPasaporte = new JLabel("PASAPORTE:");
        lblPasaporte.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPasaporte.setBounds(291, 195, 86, 14);
        add(lblPasaporte);

        txtNumeroDePasaporte = new JTextField();
        txtNumeroDePasaporte.setBounds(427, 217, 114, 20);
        add(txtNumeroDePasaporte);
        txtNumeroDePasaporte.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de pasaporte:");
        lblNewLabel_1.setBounds(291, 220, 114, 14);
        add(lblNewLabel_1);

        JLabel lblPasDeEmisin = new JLabel("Pa\u00EDs de emisi\u00F3n:");
        lblPasDeEmisin.setBounds(291, 253, 114, 14);
        add(lblPasDeEmisin);

        JLabel lblAutoridadDeEmisin = new JLabel("Autoridad de emisi\u00F3n:");
        lblAutoridadDeEmisin.setBounds(291, 283, 140, 14);
        add(lblAutoridadDeEmisin);

        txtAutoridadDeEmision = new JTextField();
        txtAutoridadDeEmision.setColumns(10);
        txtAutoridadDeEmision.setBounds(427, 278, 114, 20);
        add(txtAutoridadDeEmision);

        JLabel lblFechaDeEmisin = new JLabel("Fecha de emisi\u00F3n:");
        lblFechaDeEmisin.setBounds(291, 308, 114, 14);
        add(lblFechaDeEmisin);

        txtFechaDeEmision = new JTextField();
        txtFechaDeEmision.setColumns(10);
        txtFechaDeEmision.setBounds(427, 305, 114, 20);
        add(txtFechaDeEmision);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 180, 969, 14);
        add(separator);

        JLabel lblFechaDeVencimiento = new JLabel("Fecha de vencimiento:");
        lblFechaDeVencimiento.setBounds(291, 333, 140, 14);
        add(lblFechaDeVencimiento);

        txtFechaDeVencimiento = new JTextField();
        txtFechaDeVencimiento.setColumns(10);
        txtFechaDeVencimiento.setBounds(427, 333, 114, 20);
        add(txtFechaDeVencimiento);

        JLabel lblCuit = new JLabel("CUIT:");
        lblCuit.setBounds(10, 97, 46, 14);
        add(lblCuit);

        txtCuit = new JTextField();
        txtCuit.setColumns(10);
        txtCuit.setBounds(152, 91, 193, 20);
        add(txtCuit);

        JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
        lblFechaDeNacimiento.setBounds(10, 125, 132, 14);
        add(lblFechaDeNacimiento);

        txtFechaDeNacimiento = new JTextField();
        txtFechaDeNacimiento.setColumns(10);
        txtFechaDeNacimiento.setBounds(152, 122, 193, 20);
        add(txtFechaDeNacimiento);

        JLabel lblDatosPersonales = new JLabel("DATOS PERSONALES:");
        lblDatosPersonales.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDatosPersonales.setBounds(10, 11, 140, 14);
        add(lblDatosPersonales);

        JSeparator separator_2 = new JSeparator();
        separator_2.setOrientation(SwingConstants.VERTICAL);
        separator_2.setBounds(365, 0, 2, 178);
        add(separator_2);

        JLabel lblTelefonosDeContacto = new JLabel("TELEFONOS DE CONTACTO:");
        lblTelefonosDeContacto.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTelefonosDeContacto.setBounds(10, 200, 170, 14);
        add(lblTelefonosDeContacto);

        JLabel lblNmeroPersonal = new JLabel("N\u00FAmero personal:");
        lblNmeroPersonal.setBounds(10, 228, 120, 14);
        add(lblNmeroPersonal);

        JLabel lblNmeroCelular = new JLabel("N\u00FAmero celular:");
        lblNmeroCelular.setBounds(10, 256, 95, 14);
        add(lblNmeroCelular);

        JLabel lblNmeroLaboral = new JLabel("N\u00FAmero laboral:");
        lblNmeroLaboral.setBounds(10, 287, 95, 14);
        add(lblNmeroLaboral);

        txtNumeroPersonal = new JTextField();
        txtNumeroPersonal.setColumns(10);
        txtNumeroPersonal.setBounds(128, 225, 132, 20);
        add(txtNumeroPersonal);

        txtNumeroCelular = new JTextField();
        txtNumeroCelular.setColumns(10);
        txtNumeroCelular.setBounds(128, 253, 132, 20);
        add(txtNumeroCelular);

        txtNumeroLaboral = new JTextField();
        txtNumeroLaboral.setColumns(10);
        txtNumeroLaboral.setBounds(128, 281, 132, 20);
        add(txtNumeroLaboral);

        JLabel lblPasajeroFrecuente = new JLabel("Viajero Frecuente:");
        lblPasajeroFrecuente.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPasajeroFrecuente.setBounds(566, 195, 147, 14);
        add(lblPasajeroFrecuente);

        JLabel lblAlianza = new JLabel("Alianza:");
        lblAlianza.setBounds(566, 223, 114, 14);
        add(lblAlianza);

        cbxAlianza = new JComboBox<>();
        cbxAlianza.setBounds(640, 217, 140, 20);
        add(cbxAlianza);

        JLabel lblAerolinea = new JLabel("Aerol\u00EDnea:");
        lblAerolinea.setBounds(566, 256, 74, 14);
        add(lblAerolinea);

        cbxAerolinea = new JComboBox<>();
        cbxAerolinea.setBounds(640, 250, 140, 20);
        add(cbxAerolinea);

        JLabel lblNmero = new JLabel("N\u00FAmero:");
        lblNmero.setBounds(566, 283, 74, 14);
        add(lblNmero);

        txtViajeroFrecuente = new JTextField();
        txtViajeroFrecuente.setColumns(10);
        txtViajeroFrecuente.setBounds(640, 280, 140, 20);
        add(txtViajeroFrecuente);

        JLabel lblCategora = new JLabel("Categor\u00EDa:");
        lblCategora.setBounds(566, 308, 74, 14);
        add(lblCategora);

        txtCategoria = new JTextField();
        txtCategoria.setColumns(10);
        txtCategoria.setBounds(640, 305, 140, 20);
        add(txtCategoria);

        JSeparator separator_3 = new JSeparator();
        separator_3.setOrientation(SwingConstants.VERTICAL);
        separator_3.setBounds(279, 181, 2, 178);
        add(separator_3);

        JLabel lblDireccionCompleta = new JLabel("DIRECCION COMPLETA:");
        lblDireccionCompleta.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDireccionCompleta.setBounds(377, 11, 170, 14);
        add(lblDireccionCompleta);

        JSeparator separator_4 = new JSeparator();
        separator_4.setBounds(0, 359, 959, 14);
        add(separator_4);

        JLabel lblCalle = new JLabel("Calle:");
        lblCalle.setBounds(376, 35, 36, 14);
        add(lblCalle);

        txtCalle = new JTextField();
        txtCalle.setColumns(10);
        txtCalle.setBounds(481, 32, 299, 20);
        add(txtCalle);

        JLabel lblAltura = new JLabel("Altura:");
        lblAltura.setBounds(377, 66, 36, 14);
        add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setColumns(10);
        txtAltura.setBounds(481, 63, 83, 20);
        add(txtAltura);

        JLabel lblCiudad = new JLabel("Ciudad:");
        lblCiudad.setBounds(377, 153, 94, 14);
        add(lblCiudad);

        txtCiudad = new JTextField();
        txtCiudad.setColumns(10);
        txtCiudad.setBounds(481, 147, 299, 20);
        add(txtCiudad);

        JLabel lblProvincia = new JLabel("Provincia:");
        lblProvincia.setBounds(377, 125, 94, 14);
        add(lblProvincia);

        cbxProvincia = new JComboBox<>();
        cbxProvincia.setBounds(481, 122, 299, 20);
        add(cbxProvincia);

        JLabel lblPas = new JLabel("Pa\u00EDs:");
        lblPas.setBounds(377, 94, 70, 14);
        add(lblPas);

        cbxPais = new JComboBox<>();
        cbxPais.setBounds(481, 94, 299, 20);
        add(cbxPais);

        JLabel lblCp = new JLabel("CP:");
        lblCp.setBounds(592, 69, 24, 14);
        add(lblCp);

        txtCp = new JTextField();
        txtCp.setColumns(10);
        txtCp.setBounds(626, 63, 154, 20);
        add(txtCp);

        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(551, 181, 2, 178);
        add(separator_1);

        cbxPaisDeEmision = new JComboBox<>();
        cbxPaisDeEmision.setBounds(427, 250, 114, 20);
        add(cbxPaisDeEmision);

        Manager.loadOptionsBoxListaArchivos(pathPaises, 1);
        Manager.loadOptionsBoxListaArchivos(pathAerolineas, 2);
        Manager.loadOptionsBoxListaArchivos(pathAlianzas, 3);
        Manager.loadOptionsBoxListaArchivos(pathProvincias, 4);

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAccept){
            try {
                if (Manager.persistCliente()){
                        JOptionPane.showMessageDialog(null, "Cliente Guardado correctamente");
                }
                else {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el Cliente");
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == btnCancel){
            IndexMenu mp = IndexMenu.getInstance();
            IndexMenu.habilitarMenu();
            mp.setContentPane(IndexMenu.emptyPanel);
            mp.setVisible(true);
        }
    }
}
