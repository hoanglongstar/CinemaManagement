package com.green.cinemamanagement.dbhelper;

import com.green.cinemamanagement.models.UserInfo;

import java.sql.*;

public class UserInfoDAO {
    private static final String QUERY_USER_LOGIN_INFO = "SELECT * FROM USERINFO WHERE EMAIL = ";

    public Boolean checkUserInfo(Connection connection, UserInfo userInfo){

        Statement statement = null;
        Boolean logInSuccess = false;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_USER_LOGIN_INFO + '\'' + userInfo.getUsername() + '\'');
            while(resultSet.next()){
//                System.out.println(resultSet.getString(2));
                if(userInfo.getUsername().equals(resultSet.getString(2))
                        && userInfo.getPassword().equals(resultSet.getString(3)) ){
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
}
