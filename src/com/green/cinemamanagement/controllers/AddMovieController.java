package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.models.Movies;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddMovieController {
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

    @FXML
    void buttonCancelClicked(ActionEvent event) {

    }

    @FXML
    void buttonOKClicked(ActionEvent event) {

    }

    private onMovieAdded onMovieAdded;

    public interface onMovieAdded{
        void result(Movies movies);
    }

}
