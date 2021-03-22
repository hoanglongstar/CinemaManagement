package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.enumerations.ColorTheme;
import com.green.cinemamanagement.enumerations.FontSize;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionWindowController extends BaseController implements Initializable {

    @FXML
    private Slider sliderFontSize;

    @FXML
    private ChoiceBox<ColorTheme> choiceBoxColorTheme;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonApply;

    @FXML
    void buttonApplyCliked(ActionEvent event) {
        System.out.println("OptionWindowController::buttonApplyCliked");
        closeStage();
    }

    @FXML
    void buttonCancelClicked(ActionEvent event) {
        System.out.println("OptionWindowController::buttonCancelClicked");
        closeStage();
    }


    private void closeStage(){
        Stage stage = (Stage) buttonApply.getScene().getWindow();
        viewFactory.closeStage(stage);
    }


    public OptionWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initSliderFontSize();
        initChoiceBoxTheme();
    }

    private void initSliderFontSize(){
        sliderFontSize.setMin(0);
        sliderFontSize.setMax(FontSize.values().length - 1);
        sliderFontSize.setValue(viewFactory.getFontSize().ordinal());
        sliderFontSize.setMajorTickUnit(1);
        sliderFontSize.setMinorTickCount(0);
        sliderFontSize.setBlockIncrement(1);
        sliderFontSize.setSnapToTicks(true);
        sliderFontSize.setShowTickLabels(true);
        sliderFontSize.setShowTickMarks(true);
        sliderFontSize.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                int i = aDouble.intValue();
                return FontSize.values()[i].toString();
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });
    }

    private void initChoiceBoxTheme(){
        choiceBoxColorTheme.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        choiceBoxColorTheme.setValue(viewFactory.getColorTheme());
    }
}
