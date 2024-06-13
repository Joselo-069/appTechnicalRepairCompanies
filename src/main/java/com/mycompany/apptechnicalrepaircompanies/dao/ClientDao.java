package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Client;
import com.mycompany.apptechnicalrepaircompanies.utils.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClientDao implements IClientDao {

    Conexion base = Conexion.getInstance();
    Client client = new Client();
    List<Client> clients = new ArrayList<>();
    
    @Override
    public Client getClientId(int id) {
        try {

            base.prest = base.conec.prepareStatement(SQL_CLIENT_ID);
            base.prest.setInt(1, id);

            base.rt = base.prest.executeQuery();

            if (base.rt.next()) {
                client = new Client(
                        base.rt.getInt("id"),
                        base.rt.getString("name"),
                        base.rt.getString("email"),
                        base.rt.getString("phone"),
                        base.rt.getString("address"),
                        base.rt.getString("last_update"));
                return client;
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }

        return client;
    }

    @Override
    public List<Client> getListClients() {
        
        try {
            base.prest = base.conec.prepareStatement(SQL_LIST_CLIENTS);
            base.rt = base.prest.executeQuery();

            while (base.rt.next()) {
                client = new Client(
                        base.rt.getInt("id"),
                        base.rt.getString("name"),
                        base.rt.getString("email"),
                        base.rt.getString("phone"),
                        base.rt.getString("address"),
                        base.rt.getString("last_update"));

                clients.add(client);
            }

            return clients;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacion");
        }
        return clients;
    }

    @Override
    public void registerClient(String name, String email, String phone, String address, String user) {
        try {
            base.prest = base.conec.prepareStatement(SQL_REGISTER_CLIENT);

            base.prest.setInt(1, 0);
            base.prest.setString(2, name);
            base.prest.setString(3, email);
            base.prest.setString(4, phone);
            base.prest.setString(5, address);
            base.prest.setString(6, user);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente Registrado Exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario" + e);
            JOptionPane.showMessageDialog(null, "Error al registrar usuario");
        }
    }

    @Override
    public void updateClient(int id, String name, String email, String phone, String address, String user) {
        try {
            
            base.prest = base.conec.prepareStatement(SQL_UPDATE_CLIENT);

            base.prest.setString(1, name);
            base.prest.setString(2, email);
            base.prest.setString(3, phone);
            base.prest.setString(4, address);
            base.prest.setString(5, user);
            base.prest.setInt(6, id);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Ciente Modificado");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }
    }
}
