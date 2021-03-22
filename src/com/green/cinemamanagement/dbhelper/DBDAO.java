package com.green.cinemamanagement.dbhelper;

import com.green.cinemamanagement.models.Employee;
import com.green.cinemamanagement.models.UserInfo;

import java.sql.*;
import java.util.ArrayList;

public class DBDAO {

    private static final String QUERY_USER_INFO = "SELECT * FROM USER";
    private static final String INSERT_STAFF = "INSERT INTO USER(FULLNAME, PHONENUMBER, POSITION) VALUES (?,?,?)";

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
        ArrayList<Employee> employees = new ArrayList<>();

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_USER_INFO);

            while (resultSet.next()){
                employees.add(new Employee(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employees;
    }

    public void insertStaff(Connection connection, String fullname, String phoneNumber, String position){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(INSERT_STAFF);
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, position);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
