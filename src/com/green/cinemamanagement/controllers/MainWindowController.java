package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainWindowController extends BaseController{

    private String TAG = "MainWindowController";

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    public void menuOptionAction(ActionEvent event){
        System.out.println(TAG + "::menuOptionAction()");
        viewFactory.showOptionWindow();
    }
}
