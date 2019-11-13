package com.company.GUI.App;

import javax.swing.*;

public class App {

    private JFrame frame;


    /**
     * Create the application.
     * @wbp.parser.entryPoint
     */
    public App() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * @wbp.parser.entryPoint
     */
    private void initialize() {
        frame = IndexMenu.getInstance();
        frame.setBounds(100, 100, 800, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getFrame() { return frame;}
}
