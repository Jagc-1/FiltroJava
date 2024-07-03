package com.campuslands.modules.pais.infraestruture.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campuslands.core.MySQL;
import com.campuslands.modules.pais.domain.models.Pais;
import com.campuslands.modules.pais.domain.repository.PaisRepository;


public class PaisMYSQL extends MySQL implements PaisRepository{

    public PaisMYSQL() {
        super();
    }

    @Override
    public void save(Pais pais) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO pais (description) values (?) ";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, pais.getDescription());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pais pais) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE pais SET description=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, pais.getDescription());
                statement.setInt(2, pais.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Pais> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,description FROM pais WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Pais pais = new Pais(
                                resultSet.getInt("id"),
                                resultSet.getString("description"));
                        return Optional.of(pais);
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
            String query = "DELETE FROM pais WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pais> findAll() {
        List<Pais> paises = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,description FROM pais";
            try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Pais pais = new Pais(
                            resultSet.getInt("id"),
                            resultSet.getString("description"));
                    paises.add(pais);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paises;

    }

}
