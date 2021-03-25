package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.dbhelper.DBDAO;
import com.green.cinemamanagement.models.Employee;
import com.green.cinemamanagement.views.EditingCell;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

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
    private Button buttonRefresh;



    @FXML
    void buttonAddClicked(ActionEvent event) {

//        ViewFactory vFactory = viewFactory.showAddEmployeeWindow();
        Boolean addEmployee = viewFactory.showAddEmployeeWindow();
        if(addEmployee){
            data.setAll(dbdao.employeeInfo(viewFactory.getDbManager().getDBConnection()));
        }


    }

    @FXML
    void buttonRefreshClicked(ActionEvent event) {
//        for(Employee name : data){
//            System.out.println(name.getFullname());
//        }
//        if(AddEmployeeController.getWindowIsClosed()){
//            printDataFromDBToTableView();
//        }

//        data.setAll(dbdao.employeeInfo(viewFactory.getDbManager().getDBConnection()));
//        System.out.println(data.get(data.size()-1).getFullname());
    }

//    private Boolean checkBoxIsSelected(){
//        Boolean isSelected = false;
//
//        for (int i = 0; i < data.size(); i++){
//            if(data.get(i).getSelect().isSelected()){
//                isSelected = true;
//            }
//        }
//
//        return isSelected;
//    }

    public EmployeeWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        buttonRefresh.setDisable(false);

//        DBDAO dbdao = new DBDAO();

        data.setAll(dbdao.employeeInfo(viewFactory.getDbManager().getDBConnection()));

//        data = FXCollections.observableArrayList(dbdao.employeeInfo(viewFactory.getDbManager().getDBConnection()));

//        if(checkBoxIsSelected() == true){
//            buttonDelete.setDisable(false);
//        }
//        for (int i = 0; i < data.size(); i++){
//            data
//        }




//        System.out.println("initialize");

//        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
//        columnFullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
//        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
//        columnPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
//        columnSelect.setCellValueFactory(new PropertyValueFactory<>("select"));
//        tableViewEmployee.setEditable(true);
//        tableViewEmployee.setItems(data);

        printDataFromDBToTableView();

        System.out.println("changed");
    }

    private void printDataFromDBToTableView(){

        tableViewEmployee.setEditable(true);


        columnID.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        columnID.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        columnID.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, Integer> employeeIntegerCellEditEvent) {
                ((Employee) employeeIntegerCellEditEvent.getTableView().getItems().get(employeeIntegerCellEditEvent.getTablePosition().getRow())).setID(employeeIntegerCellEditEvent.getNewValue());
                //Viet them ham update tren DAO Class
            }
        });

        columnFullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
//        columnFullname.setCellFactory(cellFactory);
//        columnFullname.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>() {
//            @Override
//            public void handle(CellEditEvent<Employee, String> employeeStringCellEditEvent) {
//                ((Employee) employeeStringCellEditEvent.getTableView().getItems().get(employeeStringCellEditEvent.getTablePosition().getRow())).setFullname(employeeStringCellEditEvent.getNewValue());
//            }
//        });

        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        columnPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        columnSelect.setCellValueFactory(new PropertyValueFactory<>("select"));

        tableViewEmployee.setItems(data);
    }
}
