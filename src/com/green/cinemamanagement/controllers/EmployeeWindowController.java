package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.customcell.DateEditingCell;
import com.green.cinemamanagement.customcell.PositionEditingCell;
import com.green.cinemamanagement.dbhelper.EmployeeDAO;
import com.green.cinemamanagement.models.Employee;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class EmployeeWindowController extends BaseController implements Initializable {

    private ObservableList<Employee> data = FXCollections.observableArrayList();
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @FXML
    private TableView<Employee> tableViewEmployee;

    @FXML
    private TableColumn<Employee, Integer> columnID;

    @FXML
    private TableColumn<Employee, String> columnFullname;

    @FXML
    private TableColumn<Employee, Date> columnDateOfBirth;

    @FXML
    private TableColumn<Employee, String> columnAddress;

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
            data.setAll(employeeDAO.employeeInfo(viewFactory.getDbManager().getDBConnection()));
        }
    }

    @FXML
    void buttonDeleteClicked(ActionEvent event) {

        ObservableList<Employee> employeeRemoveList = FXCollections.observableArrayList();

        for(Employee emp : data){
            if(emp.getSelect().isSelected()){
                employeeRemoveList.add(emp);
                employeeDAO.deleteEmployee(viewFactory.getDbManager().getDBConnection(), emp.getId());
            }
        }
        data.removeAll(employeeRemoveList);

    }

    public EmployeeWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            data.setAll(employeeDAO.employeeInfo(viewFactory.getDbManager().getDBConnection()));

            printDataFromDBToTableView();

            System.out.println(data.get(0).getAddress());
            System.out.println("changed");
    }

    private void printDataFromDBToTableView(){

        tableViewEmployee.setEditable(true);

        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));

        columnFullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        editFullnameCell();


        columnDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
//        columnDateOfBirth.setCellValueFactory(cellData -> cellData.getValue().dateOfBirthProperty());
        editDateOfBirthCell();

        columnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        editAddressCell();

        columnPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        editPositionCell();

        columnSelect.setCellValueFactory(new PropertyValueFactory<>("select"));


        tableViewEmployee.setItems(data);
    }

    private void editPositionCell (){
        columnPosition.setCellValueFactory(cellData -> cellData.getValue().positionProperty());
        columnPosition.setCellFactory(dataCellFactory -> new PositionEditingCell());
        columnPosition.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, String> cellEditing) {
                ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).setPosition(cellEditing.getNewValue());

                employeeDAO.updateEmployeeInfo(viewFactory.getDbManager().getDBConnection(),
                        cellEditing.getRowValue().getId(),
                        cellEditing.getRowValue().getFullname(),
                        new java.sql.Date(cellEditing.getRowValue().getDateOfBirth().getTime()),
                        cellEditing.getRowValue().getAddress(),
                        cellEditing.getRowValue().getPosition()
                );
            }
        });
    }

    private void editDateOfBirthCell(){
//        Callback<TableColumn<Employee, Date>, TableCell<Employee, Date>> dateCellFactory =(TableColumn<Employee, Date> param) -> new DateEditingCell();
//        columnDateOfBirth.setCellFactory(dateCellFactory);
//        columnDateOfBirth.setOnEditCommit((TableColumn.CellEditEvent<Employee, Date> t) -> {
//            ((Employee)t.getTableView().getItems().get(t.getTablePosition().getRow())).setDateOfBirth(t.getNewValue());
//        });
        columnDateOfBirth.setCellValueFactory(cellData -> cellData.getValue().dateOfBirthProperty());
        columnDateOfBirth.setCellFactory(dataCellFactory -> new DateEditingCell());
        columnDateOfBirth.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, Date>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, Date> cellEditing) {
                ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).setDateOfBirth(cellEditing.getNewValue());

                employeeDAO.updateEmployeeInfo(viewFactory.getDbManager().getDBConnection(),
                        cellEditing.getRowValue().getId(),
                        cellEditing.getRowValue().getFullname(),
                        new java.sql.Date(cellEditing.getRowValue().getDateOfBirth().getTime()),
                        cellEditing.getRowValue().getAddress(),
                        cellEditing.getRowValue().getPosition()
                );
            }
        });
    }

    private void editAddressCell(){
        columnAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        columnAddress.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, String> cellEditing) {
                ((Employee) cellEditing.getTableView().getItems().get(cellEditing.getTablePosition().getRow())).setAddress(cellEditing.getNewValue());

                employeeDAO.updateEmployeeInfo(viewFactory.getDbManager().getDBConnection(),
                        cellEditing.getRowValue().getId(),
                        cellEditing.getRowValue().getFullname(),
                        new java.sql.Date(cellEditing.getRowValue().getDateOfBirth().getTime()),
                        cellEditing.getRowValue().getAddress(),
                        cellEditing.getRowValue().getPosition()
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

                employeeDAO.updateEmployeeInfo(viewFactory.getDbManager().getDBConnection(),
                        cellEditing.getRowValue().getId(),
                        cellEditing.getRowValue().getFullname(),
                        new java.sql.Date(cellEditing.getRowValue().getDateOfBirth().getTime()),
                        cellEditing.getRowValue().getAddress(),
                        cellEditing.getRowValue().getPosition()
                );
            }
        });
    }
}
