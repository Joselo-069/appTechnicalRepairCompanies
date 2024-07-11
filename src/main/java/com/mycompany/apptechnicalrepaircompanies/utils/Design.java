package com.mycompany.apptechnicalrepaircompanies.utils;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Design {

    public static void viewSizeFrame(JFrame frame, String user, int width, int height, String title) {
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
    }
}
