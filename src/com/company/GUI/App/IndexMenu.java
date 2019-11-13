package com.company.GUI.App;


import com.company.GUI.Panels.Cliente.PanelAltaCliente;
import com.company.GUI.Panels.Cliente.PanelBMCliente;
import com.company.GUI.Panels.LineasAereas.PanelAltaLineasAereas;
import com.company.GUI.Panels.Venta.PanelAltaVenta;
import com.company.GUI.Panels.Venta.PanelBMCVenta;
import com.company.GUI.Panels.Vuelos.PanelAltaVuelos;
import com.company.GUI.Panels.Vuelos.PanelBMCVuelos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexMenu extends JFrame implements ActionListener {


        /**
         *
         */
        private static final long serialVersionUID = 1L;
        public static PanelAltaCliente pac;// = new PanelAltaCliente();
        public static PanelAltaLineasAereas pla;
        public static PanelAltaVuelos pav = new PanelAltaVuelos();
        public static PanelBMCVuelos pbmcv;// = new PanelBMCVuelos();
        public static PanelAltaVenta pv = new PanelAltaVenta();
        public static PanelBMCVenta pbmcve  = new PanelBMCVenta();
        public static PanelBMCliente pbmcc;
        private static IndexMenu instance = new IndexMenu();

        public static JPanel emptyPanel = new JPanel();
        private JMenuItem mntmAltasClientes;
        private JMenuItem mntmAltasLineasAereas;
        private JMenuItem mntmBMyCCLineasAereas;
        private JMenuItem mntmSalirDelSistema;
        private JMenuItem mntmVentaDeVuelos;
        private JMenuItem mntmBMCVentaDeVuelos;
        private JMenuItem mntmBMCventas;
        private JMenuItem mntmSobreLaAplicacion;
        private JMenuItem mntmBMyCClientes;
        public static JPanel panel;
        public static JMenuBar menuBar = new JMenuBar();
        private static JMenu mnAcercaDe;
        private static JMenu mnLineasAereas;
        private static JMenu mnVentas;
        private static JMenu mnSalir;
        private static JMenu mnClientes;




        public IndexMenu() {

            setMenu();
            setSize(790, 460);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            getContentPane().setLayout(new FlowLayout());
            setVisible(true);


        }


        private void setMenu(){
            JMenuBar menuBar = new JMenuBar();

            mnClientes = new JMenu("Clientes");
            menuBar.add(mnClientes);

            mntmAltasClientes = new JMenuItem("Altas");
            mnClientes.add(mntmAltasClientes);
            mntmAltasClientes.addActionListener(this);

            mnLineasAereas = new JMenu("Lineas Aereas");
            menuBar.add(mnLineasAereas);

            mntmAltasLineasAereas = new JMenuItem("Altas");
            mnLineasAereas.add(mntmAltasLineasAereas);
            mntmAltasLineasAereas.addActionListener(this);

            mntmBMyCCLineasAereas = new JMenuItem("BMyC");
            mnLineasAereas.add(mntmBMyCCLineasAereas);
            mntmBMyCCLineasAereas.addActionListener(this);

            mnVentas = new JMenu("Ventas");
            menuBar.add(mnVentas);


            mntmVentaDeVuelos = new JMenuItem("Venta de Vuelos");
            mnVentas.add(mntmVentaDeVuelos);
            mntmVentaDeVuelos.addActionListener(this);

            mntmBMCventas = new JMenuItem("BMC de Ventas");
            mnVentas.add(mntmBMCventas);
            mntmBMCventas.addActionListener(this);

            setJMenuBar(menuBar);

            mnAcercaDe = new JMenu("Acerca de");
            menuBar.add(mnAcercaDe);

            mntmBMyCClientes = new JMenuItem("BMyC");
            mnClientes.add(mntmBMyCClientes);
            mntmBMyCClientes.addActionListener(this);

            mntmSobreLaAplicacion = new JMenuItem("Sobre la Aplicacion");
            mnAcercaDe.add(mntmSobreLaAplicacion);
            mntmSobreLaAplicacion.addActionListener(this);

            mnSalir = new JMenu("Salir");
            menuBar.add(mnSalir);

            mntmSalirDelSistema = new JMenuItem("Salir del Sistema");
            mnSalir.add(mntmSalirDelSistema);
            mntmSalirDelSistema.addActionListener(this);

        }

        private void deshabilitarMenu(){
            mnAcercaDe.setEnabled(false);
            mnLineasAereas.setEnabled(false);
            mnVentas.setEnabled(false);
            mnSalir.setEnabled(false);
            mnClientes.setEnabled(false);
        }

        public static void habilitarMenu(){
            mnAcercaDe.setEnabled(true);
            mnLineasAereas.setEnabled(true);
            mnVentas.setEnabled(true);
            mnSalir.setEnabled(true);
            mnClientes.setEnabled(true);
        }

        public static IndexMenu getInstance() {
            if (instance == null)
                instance = new IndexMenu();

            return instance;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == mntmAltasLineasAereas){
//                deshabilitarMenu();
//                setContentPane(pla = new PanelAltaLineasAereas());
//                repaint();
//                printAll(getGraphics());
//            }
            if (e.getSource() == mntmAltasClientes){
                deshabilitarMenu();
                setContentPane(pac = new PanelAltaCliente());
                repaint();
                printAll(getGraphics());
            }
//            if (e.getSource() == mntmBMyCCLineasAereas){
//                deshabilitarMenu();
//                setContentPane(pbmcv = new PanelBMCVuelos());
//                repaint();
//                printAll(getGraphics());
//            }
//            if (e.getSource() == mntmBMyCClientes){
//                deshabilitarMenu();
//                setContentPane(pbmcc = new PanelBMCliente());
//                repaint();
//                printAll(getGraphics());
//            }
//            if (e.getSource() == mntmVentaDeVuelos){
//                deshabilitarMenu();
//                setContentPane(pv = new PanelAltaVenta());
//                repaint();
//                printAll(getGraphics());
//            }
//            if (e.getSource() == mntmBMCventas){
//                deshabilitarMenu();
//                setContentPane(pbmcve = new PanelBMCVenta());
//                repaint();
//                printAll(getGraphics());
//            }

            if (e.getSource() == mntmSalirDelSistema){
                System.exit(0);

            }
            if (e.getSource() == mntmSobreLaAplicacion){
                JOptionPane.showMessageDialog(this, "GESTION DE AEROLINEAS, Programacion Avanzada",
                        "GESTION DE AEROLINEAS", JOptionPane.INFORMATION_MESSAGE);
            }

        }
}

