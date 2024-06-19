package com.mycompany.apptechnicalrepaircompanies.utils;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Design {

    @FunctionalInterface
    public interface NameExtractor<T> {
        String extractName(T obj);
    }

    public static void viewSizeFrame(JFrame frame, String user, int width, int height, String title) {
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
    }

    public static <T> void populateComboBox(JComboBox<String> comboBox, List<T> items, NameExtractor<T> extractor) {
        DefaultComboBoxModel<String> modelComboBox = new DefaultComboBoxModel<>();
        for (T item : items) {
            modelComboBox.addElement(extractor.extractName(item));
        }
        comboBox.setModel(modelComboBox);
    }
}
