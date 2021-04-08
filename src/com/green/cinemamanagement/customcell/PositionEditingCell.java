package com.green.cinemamanagement.customcell;

import com.green.cinemamanagement.models.Employee;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;

public class PositionEditingCell extends TableCell<Employee, String>{
    ComboBox<String> comboBox;

    public PositionEditingCell() {
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Staff","Manager");
    }

    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            createComboBox();
            setText(null);
            setGraphic(comboBox);
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(comboBox.getValue());
        setGraphic(null);
    }

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (comboBox != null) {
                    comboBox.setValue(getText());
                }
                setText(null);
                setGraphic(comboBox);
            } else {
                setText(item);
//                System.out.println(item);
                setGraphic(null);
            }
        }
    }

    private void createComboBox(){
//        comboBox.valueProperty().set(getText());
        comboBox.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        comboBox.setOnAction((e) -> {
            System.out.println("Committed: " + comboBox.getSelectionModel().getSelectedItem());
            commitEdit(comboBox.getSelectionModel().getSelectedItem());
        });
    }
}
