package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.dbhelper.UserInfoDAO;
import com.green.cinemamanagement.instances.Announcements;
import com.green.cinemamanagement.models.UserInfo;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginWindowController  extends BaseController{
    @FXML
    private TextField textFieldEmail;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button buttonLogin;

    @FXML
    private Label labelLoginStatus;

    public LoginWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void onButtonLoginClicked(ActionEvent event) {

        UserInfo userInfo = new UserInfo(textFieldEmail.getText(), passwordField.getText());

        UserInfoDAO userInfoDAO = new UserInfoDAO();

        if(userInfo.getUsername().equals("")){
            showAlert(Announcements.EMAIL_IS_NOT_ENTERED);
        } else if(userInfoDAO.checkUserInfo(viewFactory.getDbManager().getDBConnection(), userInfo)){
            viewFactory.showMainWindow();
            Stage stage = (Stage) buttonLogin.getScene().getWindow();
            viewFactory.closeStage(stage);
        } else {
            labelLoginStatus.setText(Announcements.WRONG_PASSWORD);
        }
    }

    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
