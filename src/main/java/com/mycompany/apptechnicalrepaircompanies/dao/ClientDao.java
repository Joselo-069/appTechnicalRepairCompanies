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
    
    @Override
    public Client getClientId(int id) {
        try {

            base.prest = base.conec.prepareStatement(SQL_CLIENT_ID);
            base.prest.setInt(1, id);

            base.rt = base.prest.executeQuery();

            if (base.rt.next()) {
                client = new Client(
                        base.rt.getInt("id_cliente"),
                        base.rt.getString("nombre_cliente"),
                        base.rt.getString("mail_cliente"),
                        base.rt.getString("tel_cliente"),
                        base.rt.getString("dir_cliente"),
                        base.rt.getString("ultima_modificacion"));

                return client;
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }

        return client;
    }

    @Override
    public List<Client> getListClients() {
        List<Client> clients = new ArrayList<>();
        try {
            base.prest = base.conec.prepareStatement(SQL_LIST_CLIENTS);
            base.rt = base.prest.executeQuery();

            while (base.rt.next()) {
                Client client = new Client(
                        base.rt.getInt("id_cliente"),
                        base.rt.getString("nombre_cliente"),
                        base.rt.getString("mail_cliente"),
                        base.rt.getString("tel_cliente"),
                        base.rt.getString("dir_cliente"),
                        base.rt.getString("ultima_modificacion")
                );

                clients.add(client);
            }

            return clients;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacion");
        }
        return clients;
    }

    @Override
    public void registerClient(String nombre, String email, String telefono, String direccion, String user) {
        try {
            base.prest = base.conec.prepareStatement(SQL_REGISTER_CLIENT);

            base.prest.setInt(1, 0);
            base.prest.setString(2, nombre);
            base.prest.setString(3, email);
            base.prest.setString(4, telefono);
            base.prest.setString(5, direccion);
            base.prest.setString(6, user);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente Registrado Exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario" + e);
            JOptionPane.showMessageDialog(null, "Error al registrar usuario");
        }
    }

    @Override
    public void updateClient(int id, String nombre, String email, String telefono, String direccion, String user) {
        try {
            
            base.prest = base.conec.prepareStatement(SQL_UPDATE_CLIENT);

            base.prest.setString(1, nombre);
            base.prest.setString(2, email);
            base.prest.setString(3, telefono);
            base.prest.setString(4, direccion);
            base.prest.setString(5, user);
            base.prest.setInt(6, id);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Ciente Modificado");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }
    }
}
