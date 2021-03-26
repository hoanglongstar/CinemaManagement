package com.green.cinemamanagement.dbhelper;

import com.green.cinemamanagement.models.Employee;
import com.green.cinemamanagement.models.UserInfo;
import javafx.scene.control.CheckBox;

import java.sql.*;
import java.util.ArrayList;

public class DBDAO {

//    private final ObservableList<Employee> employees = FXCollections.observableArrayList();

    private static final String QUERY_USER_INFO = "SELECT * FROM USER";
    private static final String INSERT_EMPLOYEE = "INSERT INTO USER(FULLNAME, PHONENUMBER, POSITION) VALUES (?,?,?)";
    private static final String UPDATE_EMPLOYEE_INFO = "UPDATE USER SET FULLNAME = ?, PHONENUMBER = ?, POSITION = ? " + "WHERE ID = ? ";
    private static final String DELETE_EMPLOYEE = "DELETE FROM USER WHERE ID = ?";

    public Boolean checkUserInfo(Connection connection, UserInfo userInfo){

        Statement statement = null;
        Boolean logInSuccess = false;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_USER_INFO);
            while(resultSet.next()){
//                System.out.println(resultSet.getString(2));
                if(userInfo.getUsername().equals(resultSet.getString(1))
                        && userInfo.getPassword().equals(resultSet.getString(2)) ){
                    logInSuccess = true;
//                    System.out.println("true");
                    break;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("check user's account");
        }
        return logInSuccess;
    }

    public ArrayList<Employee> employeeInfo(Connection connection){

        ArrayList <Employee> employees = new ArrayList<>();

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_USER_INFO);

            while (resultSet.next()){
                employees.add(new Employee(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), new CheckBox()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        System.out.println(employees.size());
        return employees;
    }

    public void insertEmployee(Connection connection, String fullname, String phoneNumber, String position){

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, position);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateEmployeeInfo(Connection connection, int id, String fullname, String phoneNumber, String position){

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_INFO);
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, position);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteEmployee(Connection connection, int id){

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
