package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.dbhelper.MovieDAO;
import com.green.cinemamanagement.models.Movies;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class AddMovieController extends BaseController {
    @FXML
    private TextField textFieldTitle;

    @FXML
    private TextField textFieldGenre;

    @FXML
    private TextField textFieldReleaseDate;

    @FXML
    private TextField textFieldRunningTime;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonOK;

    public onMovieAdded listener;

    public void setOnListener(onMovieAdded listener){
        this.listener = listener;
//        listener.result(textFieldTitle.getText(),textFieldGenre.getText(), textFieldReleaseDate.getText(), Integer.valueOf(textFieldRunningTime.getText()));
    }

    public AddMovieController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void buttonCancelAddMovieClicked(ActionEvent event) {

    }

    @FXML
    void buttonOKAddMovieClicked(ActionEvent event) {
        listener.result(textFieldTitle.getText(),textFieldGenre.getText(), textFieldReleaseDate.getText(), Integer.valueOf(textFieldRunningTime.getText()));
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Stage stage = (Stage) textFieldGenre.getScene().getWindow();
//        stage.showAndWait();
//    }

    public interface onMovieAdded{
        void result(String title, String genre, String releaseDate, Integer runningTime);
    }





    public void addMovie(){
        listener.result(textFieldTitle.getText(),textFieldGenre.getText(), textFieldReleaseDate.getText(), Integer.valueOf(textFieldRunningTime.getText()));
    }
}
