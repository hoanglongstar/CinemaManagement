package com.green.cinemamanagement.controllers;

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

    @FXML
    void buttonCancelClicked(ActionEvent event) {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    void buttonOKClicked(ActionEvent event) {

        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    public AddEmployeeController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

}
