package com.green.cinemamanagement.dbhelper;

import com.green.cinemamanagement.models.Employee;
import com.green.cinemamanagement.models.UserInfo;
import javafx.scene.control.CheckBox;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeDAO {

//    private final ObservableList<Employee> employees = FXCollections.observableArrayList();

    private static final String QUERY_EMPLOYEE_INFO = "SELECT * FROM EMPLOYEEINFO";
    private static final String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEEINFO(FULLNAME, DATEOFBIRTH, ADDRESS, POSITION) VALUES (?,?,?,?)";
    private static final String UPDATE_EMPLOYEE_INFO = "UPDATE EMPLOYEEINFO SET FULLNAME = ?, DATEOFBIRTH = ?, ADDRESS = ?, POSITION = ? " + "WHERE ID = ? ";
    private static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEEINFO WHERE ID = ?";

    public ArrayList<Employee> employeeInfo(Connection connection){

        ArrayList <Employee> employees = new ArrayList<>();

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_EMPLOYEE_INFO);

            while (resultSet.next()){
                employees.add(new Employee(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3) , resultSet.getString(4), resultSet.getString(5), new CheckBox()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        System.out.println(employees.size());
        return employees;
    }

    public void insertEmployee(Connection connection, String fullname, String dateofbirth, String address, String position){

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, dateofbirth);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, position);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateEmployeeInfo(Connection connection, Integer id, String fullname, String dateofbirth, String address, String position){

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_INFO);
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, dateofbirth);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, position);
            preparedStatement.setInt(5, id);
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
