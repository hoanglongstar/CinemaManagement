package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.dbhelper.DBDAO;
import com.green.cinemamanagement.models.Employee;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeWindowController extends BaseController implements Initializable {

    @FXML
    private TableView<Employee> tableViewStaff;

    @FXML
    private TableColumn<Employee, Integer> columnID;

    @FXML
    private TableColumn<Employee, String> columnFullname;

    @FXML
    private TableColumn<Employee, String> columnPhoneNumber;

    @FXML
    private TableColumn<Employee, String> columnPosition;

    @FXML
    private TableColumn<Employee, String> columnEmail;

    @FXML
    private Button buttonAdd;

    @FXML
    void buttonAddClicked(ActionEvent event) {
//        DBDAO dbdao = new DBDAO();
//        dbdao.insertStaff(viewFactory.getDbManager().getDBConnection(), "abc","0199999","manager");
        viewFactory.showAddEmployeeWindow();
    }

    public EmployeeWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBDAO dbdao = new DBDAO();

        ObservableList<Employee> data = FXCollections.observableArrayList(dbdao.employeeInfo(viewFactory.getDbManager().getDBConnection()));

        System.out.println(data.get(0).getFullname());

        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnFullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        columnPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        tableViewStaff.setEditable(true);
        tableViewStaff.setItems(data);
    }
}
