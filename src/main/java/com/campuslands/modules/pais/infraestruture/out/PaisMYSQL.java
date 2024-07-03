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
import com.campuslands.modules.pais.domain.repository.PaisRepository;


public class PaisMYSQL extends MySQL implements PaisRepository{

    public PaisMySQL() {
            super();
        }

    @Override
    public void save(Actor actor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO actor (name,idnacionalidad,edad,idgenero) values (?,?,?,?) ";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, actor.getNombre());
                statement.setInt(2, actor.getIdnacionalidad());
                statement.setInt(3, actor.getEdad());
                statement.setInt(4, actor.getIdgenero());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Actor actor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE actor SET name=?,idnacionalidad=?,edad=?,idgenero=?) WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, actor.getNombre());
                statement.setInt(2, actor.getIdnacionalidad());
                statement.setInt(3, actor.getEdad());
                statement.setInt(4, actor.getIdgenero());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Actor> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,name,idnacionalidad,edad,idgenero FROM actor WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Actor actor = new Actor(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("idnacionalidad"),
                                resultSet.getInt("edad"),
                                resultSet.getInt("idgenero"));
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
    public List<Actor> getAll() {
        List<Actor> actors = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,name,idnacionalidad,edad,idgenero FROM actor WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Actor actor = new Actor(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("idnacionalidad"),
                            resultSet.getInt("edad"),
                            resultSet.getInt("idgenero"));
                    actors.add(actor);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;

    }

}
