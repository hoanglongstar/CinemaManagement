package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.dbhelper.DBDAO;
import com.green.cinemamanagement.models.Employee;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeWindowController extends BaseController implements Initializable {

    private ObservableList<Employee> data = FXCollections.observableArrayList();
    private DBDAO dbdao = new DBDAO();

    @FXML
    private TableView<Employee> tableViewEmployee;

    @FXML
    private TableColumn<Employee, Integer> columnID;

    @FXML
    private TableColumn<Employee, String> columnFullname;

    @FXML
    private TableColumn<Employee, String> columnPhoneNumber;

    @FXML
    private TableColumn<Employee, String> columnPosition;

    @FXML
    private TableColumn<Employee, CheckBox> columnSelect;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDelete;



    @FXML
    void buttonAddClicked(ActionEvent event) {

        Boolean addEmployee = viewFactory.showAddEmployeeWindow();
        if(addEmployee){
            data.setAll(dbdao.employeeInfo(viewFactory.getDbManager().getDBConnection()));
        }
    }

    @FXML
    void buttonDeleteClicked(ActionEvent event) {

        ObservableList<Employee> employeeRemoveList = FXCollections.observableArrayList();

        for(Employee emp : data){
            if(emp.getSelect().isSelected()){
                employeeRemoveList.add(emp);
                dbdao.deleteEmployee(viewFactory.getDbManager().getDBConnection(), emp.getId());
            }
        }
        data.removeAll(employeeRemoveList);

    }

    public EmployeeWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        data.setAll(dbdao.employeeInfo(viewFactory.getDbManager().getDBConnection()));

        printDataFromDBToTableView();

        System.out.println("changed");
    }

    private void printDataFromDBToTableView(){

        tableViewEmployee.setEditable(true);


        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));

        columnFullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        editFullnameCell();

        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        editPhoneNumberCell();

        columnPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        editPositionCell();

        columnSelect.setCellValueFactory(new PropertyValueFactory<>("select"));


        tableViewEmployee.setItems(data);
    }

    private void editPositionCell (){
        columnPosition.setCellFactory(TextFieldTableCell.forTableColumn());
        columnPosition.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, String> cellEditing) {
                ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).setPosition(cellEditing.getNewValue());

                dbdao.updateEmployeeInfo(viewFactory.getDbManager().getDBConnection(),
                        ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).getId(),
                        ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).getFullname(),
                        ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).getPhoneNumber(),
                        ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).getPosition()
                );
            }
        });
    }

    private void editPhoneNumberCell (){
        columnPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        columnPhoneNumber.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, String> cellEditing) {
                ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).setPhoneNumber(cellEditing.getNewValue());

                dbdao.updateEmployeeInfo(viewFactory.getDbManager().getDBConnection(),
                        ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).getId(),
                        ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).getFullname(),
                        ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).getPhoneNumber(),
                        ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).getPosition()
                );
            }
        });
    }

    private void editFullnameCell (){
        columnFullname.setCellFactory(TextFieldTableCell.forTableColumn());
        columnFullname.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, String> cellEditing) {
                ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).setFullname(cellEditing.getNewValue());

                dbdao.updateEmployeeInfo(viewFactory.getDbManager().getDBConnection(),
                        ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).getId(),
                        ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).getFullname(),
                        ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).getPhoneNumber(),
                        ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).getPosition()
                );
            }
        });
    }
}
