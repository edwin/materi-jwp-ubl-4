package com.ubl.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * <pre>
 * contoh dari concrete class yang menggunakan interface
 * </pre>
 *
 * @author edwin < edwinkun at gmail dot com >
 *
 */
public class TestingService implements IService {

    @Override
    public String selectAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM testing";
        try {
            connection = DatabaseService.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            
            StringBuilder json = new StringBuilder("");
            
            // open json
            json.append("[");
            while (resultSet.next()) {
                json.append("{\"id\":\""+resultSet.getString(1)+"\", \"name\":\""+resultSet.getString(2)+"\", \"address\":\""+resultSet.getString(3)+"\"},");
            }
            // remove koma terakhir, jika json ada isinya
            if(json.toString().endsWith(",")) 
                json.delete(json.length()-1, json.length());
            
            // close json
            json.append("]");
            
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    DatabaseService.closeConnection(connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // create failed json
        return "{\"status\":0, \"keterangan\":\"Gagal\"}";
    }

    @Override
    public String selectOne(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM testing where id = ?";
        try {
            connection = DatabaseService.getConnection();
            statement = connection.prepareStatement(query);
            
            // set id menggunakan prepared statement
            statement.setInt(1, id);
            
            resultSet = statement.executeQuery();
            
            StringBuilder json = new StringBuilder("");
            
            // open json
            json.append("[");
            while (resultSet.next()) {
                json.append("{\"id\":\""+resultSet.getString(1)+"\", \"name\":\""+resultSet.getString(2)+"\", \"address\":\""+resultSet.getString(3)+"\"},");
            }
            // remove koma terakhir, jika json ada isinya
            if(json.toString().endsWith(",")) 
                json.delete(json.length()-1, json.length());
            
            // close json
            json.append("]");
            
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    DatabaseService.closeConnection(connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // create failed json
        return "{\"status\":0, \"keterangan\":\"Gagal\"}";
    }

    @Override
    public String insert(String name, String address) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = "INSERT INTO TESTING(name, address) values(?, ?)";
        try {
            connection = DatabaseService.getConnection();
            statement = connection.prepareStatement(query);
            
            statement.setString(1, name);
            statement.setString(2, address);
            
            statement.executeUpdate();
            
            // create success json
            return "{\"status\":1, \"keterangan\":\"Sukses\"}";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    DatabaseService.closeConnection(connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // create failed json
        return "{\"status\":0, \"keterangan\":\"Gagal\"}";
    }
}
