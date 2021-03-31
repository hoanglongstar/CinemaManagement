package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.dbhelper.MovieDAO;
import com.green.cinemamanagement.models.Employee;
import com.green.cinemamanagement.models.Movies;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.VerticalDirection;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class MoviesWindowController extends BaseController implements Initializable {

    private ObservableList<Movies> data = FXCollections.observableArrayList();
    MovieDAO movieDAO = new MovieDAO();

    @FXML
    private TableView<Movies> tableViewMovies;

    @FXML
    private TableColumn<Movies, Integer> columnIDMovie;

    @FXML
    private TableColumn<Movies, String> columnTitle;

    @FXML
    private TableColumn<Movies, String> columnGenre;

    @FXML
    private TableColumn<Movies, String> columnReleaseDate;

    @FXML
    private TableColumn<Movies, Integer> columnRunningTime;

    @FXML
    private TableColumn<Movies, CheckBox> columnSelectMovie;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDelete;

    public MoviesWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    public interface MovieWindowDelegate{
        void addNewMovie();
    }

//    public MovieWindowDelegate delegate;
//
//    public MoviesWindowController(MovieWindowDelegate delegate){
//        super();
//        this.delegate = delegate;
//    }

    @FXML
    void buttonAddMovieClicked(ActionEvent event) {

    }

    @FXML
    void buttonDeleteMovieClicked(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        data.setAll(movieDAO.moviesList(viewFactory.getDbManager().getDBConnection()));
        printDataFromDBToTableView();
    }

    private void printDataFromDBToTableView(){

        tableViewMovies.setEditable(true);

        columnIDMovie.setCellValueFactory(new PropertyValueFactory<>("IDMovie"));

        columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        editTitleCell();

        columnGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        editGenreCell();

        columnReleaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        editReleaseDateCell();

        columnRunningTime.setCellValueFactory(new PropertyValueFactory<>("runningTime"));
        editRunningTimeCell();

        columnSelectMovie.setCellValueFactory(new PropertyValueFactory<>("select"));

        tableViewMovies.setItems(data);
    }

    private void editTitleCell(){
        columnTitle.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTitle.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Movies, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Movies, String> cellEditing) {
                cellEditing.getRowValue().setTitle(cellEditing.getNewValue());

                movieDAO.updateMovieInfo(viewFactory.getDbManager().getDBConnection(),
                        cellEditing.getRowValue().getIDMovie(), cellEditing.getRowValue().getTitle(),
                        cellEditing.getRowValue().getGenre(), cellEditing.getRowValue().getReleaseDate(),
                        cellEditing.getRowValue().getRunningTime());
            }
        });
    }

    private void editGenreCell(){
        columnGenre.setCellFactory(TextFieldTableCell.forTableColumn());
        columnGenre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Movies, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Movies, String> cellEditing) {
                cellEditing.getRowValue().setGenre(cellEditing.getNewValue());

                movieDAO.updateMovieInfo(viewFactory.getDbManager().getDBConnection(),
                        cellEditing.getRowValue().getIDMovie(), cellEditing.getRowValue().getTitle(),
                        cellEditing.getRowValue().getGenre(), cellEditing.getRowValue().getReleaseDate(),
                        cellEditing.getRowValue().getRunningTime());
            }
        });
    }

    private void editReleaseDateCell(){
        columnReleaseDate.setCellFactory(TextFieldTableCell.forTableColumn());
        columnReleaseDate.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Movies, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Movies, String> cellEditing) {
                cellEditing.getRowValue().setReleaseDate(cellEditing.getNewValue());

                movieDAO.updateMovieInfo(viewFactory.getDbManager().getDBConnection(),
                        cellEditing.getRowValue().getIDMovie(), cellEditing.getRowValue().getTitle(),
                        cellEditing.getRowValue().getGenre(), cellEditing.getRowValue().getReleaseDate(),
                        cellEditing.getRowValue().getRunningTime());
            }
        });
    }

    private void editRunningTimeCell(){
        columnRunningTime.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        columnRunningTime.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Movies, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Movies, Integer> cellEditing) {
                cellEditing.getRowValue().setRunningTime(cellEditing.getNewValue());

                movieDAO.updateMovieInfo(viewFactory.getDbManager().getDBConnection(),
                        cellEditing.getRowValue().getIDMovie(), cellEditing.getRowValue().getTitle(),
                        cellEditing.getRowValue().getGenre(), cellEditing.getRowValue().getReleaseDate(),
                        cellEditing.getRowValue().getRunningTime());
            }
        });
    }
}
