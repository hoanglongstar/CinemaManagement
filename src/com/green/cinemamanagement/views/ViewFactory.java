package com.green.cinemamanagement.views;

import com.green.cinemamanagement.controllers.*;
import com.green.cinemamanagement.enumerations.ColorTheme;
import com.green.cinemamanagement.enumerations.FontSize;
import com.green.cinemamanagement.manager.DBManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    private FontSize fontSize = FontSize.SMALL;
    private ColorTheme colorTheme = ColorTheme.DEFAULT;

    private DBManager dbManager;

    public DBManager getDbManager() {
        return dbManager;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public ViewFactory (DBManager dbManager){
        this.dbManager = dbManager;
    }

    public void showLoginScreen(){
        System.out.println("showing login window");
        BaseController controller = new LoginWindowController(this, "LoginWindow.fxml");
        initializeStage(controller);
    }

    public void showMainWindow(){
        System.out.println("showing main window");
        BaseController controller = new MainWindowController(this, "MainWindow.fxml");
        initializeStage(controller);
    }

    public void showOptionWindow(){
        BaseController controller = new OptionWindowController(this, "OptionWindow.fxml");
        initializeStage(controller,true);
    }

    public void showEmployeeWindow(){
        BaseController controller = new EmployeeWindowController(this, "EmployeesWindow.fxml");
        initializeStage(controller);
    }

    public void showAddEmployeeWindow(){
        BaseController controller = new AddEmployeeController(this, "AddEmployeeWindow.fxml");
        initializeStage(controller,true);
    }

    public void closeStage(Stage stage){
        stage.close();
    }

    private void initializeStage(BaseController controller){
        initializeStage(controller,false);
    }

    private void initializeStage(BaseController controller, boolean isModal){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);

        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            System.out.println("initializeStage: failed to load fxml");
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        if(isModal){
            stage.initModality(Modality.APPLICATION_MODAL);
        }
        stage.setScene(scene);
        stage.show();
    }
}
