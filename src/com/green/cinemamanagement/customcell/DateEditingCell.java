package com.green.cinemamanagement.customcell;

import com.green.cinemamanagement.models.Employee;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateEditingCell extends TableCell<Employee, Date> {

    private DatePicker datePicker;

    public DateEditingCell() {
    }

    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            createDatePicker();
            setText(null);
            setGraphic(datePicker);
            System.out.println(datePicker.getValue());
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(datePicker.getValue().toString());
//        System.out.println(datePicker.getValue().toString());
        System.out.println("cancelEdit");
        setGraphic(null);
    }

    @Override
    public void updateItem(Date item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (datePicker != null) {
                    datePicker.setValue(LocalDate.now());
                    System.out.println("updateItem");
                }
                setText(null);
                setGraphic(datePicker);
            } else {
                if(datePicker != null){
                    System.out.println("asdasf");
                    setText(datePicker.getValue().toString());
                    setGraphic(null);
                } else {
                    System.out.println("123456");
                    setText(item.clone().toString());
                    setGraphic(null);
                }
            }
        }
    }

    private void createDatePicker() {
        datePicker = new DatePicker(LocalDate.now());
        datePicker.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        datePicker.setOnAction((e) -> {
//            System.out.println("Committed: " + datePicker.getValue().toString());
            commitEdit(Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        });
    }

//    private LocalDate getDate() {
//        ZonedDateTime zonedDateTime = getDate().atStartOfDay(ZoneId.systemDefault());
//        Instant instant = zonedDateTime.toInstant();
//        return getItem() == null ? LocalDate.now() : instant.atZone(ZoneId.systemDefault()).toLocalDate();
//    }
}
