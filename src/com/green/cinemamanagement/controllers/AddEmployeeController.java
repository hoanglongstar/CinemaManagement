package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.dbhelper.DBDAO;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEmployeeController extends BaseController{

    @FXML
    private TextField textFieldFullname;

    @FXML
    private TextField textFieldPhoneNumber;

    @FXML
    private TextField textFieldPosition;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonOK;

    private static Boolean windowIsClosed = false;

    @FXML
    void buttonCancelClicked(ActionEvent event) {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        viewFactory.closeStage(stage);
        windowIsClosed = false;
    }

    @FXML
    void buttonOKClicked(ActionEvent event) {

        DBDAO dbdao = new DBDAO();
        dbdao.insertEmployee(viewFactory.getDbManager().getDBConnection(), textFieldFullname.getText(), textFieldPhoneNumber.getText(), textFieldPosition.getText());
        windowIsClosed = true;
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    public AddEmployeeController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
        getWindowIsClosed();
    }

    public static Boolean getWindowIsClosed(){
        return windowIsClosed;
    }

}
