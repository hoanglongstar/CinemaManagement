package com.green.cinemamanagement;

import com.green.cinemamanagement.manager.DBManager;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory(new DBManager());
        viewFactory.showEmployeeWindow();
    }
}
