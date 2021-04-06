package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.dbhelper.MovieDAO;
import com.green.cinemamanagement.models.Movies;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class AddMovieController extends BaseController {

    public interface IAddMovieController{
        void onMovieAdded(Movies movies);
    }

    public IAddMovieController listener;

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

    public AddMovieController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    public AddMovieController(ViewFactory viewFactory, String fxmlName, IAddMovieController listener) {
        super(viewFactory, fxmlName);
        this.listener = listener;
    }

    @FXML
    void buttonOKAddMovieClicked(ActionEvent event) {
        if(listener != null){
            listener.onMovieAdded(new Movies(0, textFieldTitle.getText(), textFieldGenre.getText(), textFieldReleaseDate.getText(),Integer.valueOf(textFieldRunningTime.getText()), new CheckBox()));
            Stage stage = (Stage) buttonCancel.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void buttonCancelAddMovieClicked(ActionEvent event) {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }
}
