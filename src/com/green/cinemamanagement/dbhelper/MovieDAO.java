package com.green.cinemamanagement.dbhelper;

import com.green.cinemamanagement.models.Employee;
import com.green.cinemamanagement.models.Movies;
import javafx.scene.control.CheckBox;

import java.sql.*;
import java.util.ArrayList;

public class MovieDAO {
    private static final String QUERY_MOVIES_INFO = "SELECT * FROM MOVIES";
    private static final String UPDATE_MOVIE_INFO = "UPDATE MOVIES SET TITLE = ?, GENRE = ?, RELEASEDATE = ?, RUNNINGTIME = ? " + "WHERE IDMOVIE = ? ";

    public ArrayList<Movies> moviesList(Connection connection){

        ArrayList <Movies> movies = new ArrayList<>();

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_MOVIES_INFO);

            while (resultSet.next()){
                movies.add(new Movies(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), new CheckBox()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        System.out.println(employees.size());
        return movies;
    }

    public void updateMovieInfo(Connection connection, Integer idMovie, String title, String genre, String releaseDate, Integer runningTime){

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(UPDATE_MOVIE_INFO);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, genre);
            preparedStatement.setString(3, releaseDate);
            preparedStatement.setInt(4, runningTime);
            preparedStatement.setInt(5, idMovie);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
