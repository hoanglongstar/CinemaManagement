package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.dbhelper.DBDAO;
import com.green.cinemamanagement.manager.DBManager;
import com.green.cinemamanagement.models.UserInfo;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;

public class LoginWindowController  extends BaseController{
    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldPassword;

    @FXML
    private Button buttonLogin;

    @FXML
    private Label labelLoginStatus;

    public LoginWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void onButtonLoginClicked(ActionEvent event) {
        //        System.out.println("button clicked");
//        Connection connection = new DBManager().getDBConnection();

        UserInfo userInfo = new UserInfo(textFieldEmail.getText(), textFieldPassword.getText());

        DBDAO dbdao = new DBDAO();

        if(dbdao.checkUserInfo(viewFactory.getDbManager().getDBConnection(), userInfo)){
            viewFactory.showMainWindow();
            Stage stage = (Stage) buttonLogin.getScene().getWindow();
            viewFactory.closeStage(stage);
//            System.out.println("login success");
        } else {
            labelLoginStatus.setText("Email/ Password is incorrect!");
        }
    }

}
