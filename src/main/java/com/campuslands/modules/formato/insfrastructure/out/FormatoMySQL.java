package com.campuslands.modules.formato.insfrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.core.MySQL;
import com.campuslands.modules.formato.domain.models.Formato;
import com.campuslands.modules.formato.domain.repository.FormatoRepository;


public class FormatoMySQL extends  MySQL implements FormatoRepository{
 public FormatoMySQL() {
        super();
    }

    @Override
    public void save(Formato formato) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO formato (descripcion) values (?) ";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, formato.getDescription());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Formato formato) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE formato SET descripcion=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, formato.getDescription());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Formato> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,descripcion FROM formato WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Formato actor = new Formato(
                                resultSet.getInt("id"),
                                resultSet.getString("descripcion")
                                );
                        return Optional.of(actor);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM actor WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Formato> findAll() {
        List<Formato> actors = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,descripcion FROM formato";
            try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Formato actor = new Formato(
                        resultSet.getInt("id"),
                        resultSet.getString("descripcion"));
                    actors.add(actor);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;

    }
}
