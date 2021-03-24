package com.green.cinemamanagement.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class Employee {

    private SimpleIntegerProperty ID;
    private SimpleStringProperty fullname;
    private SimpleStringProperty phoneNumber;
    private SimpleStringProperty position;
    private CheckBox select;

    public CheckBox getSelect() {
        return select;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public void setFullname(String fullname) {
        this.fullname.set(fullname);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }

    public int getId() {
        return ID.get();
    }

    public SimpleIntegerProperty idProperty() {
        return ID;
    }

    public String getFullname() {
        return fullname.get();
    }

    public SimpleStringProperty fullnameProperty() {
        return fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public String getPosition() {
        return position.get();
    }

    public SimpleStringProperty positionProperty() {
        return position;
    }

    public Employee(int id, String fullname, String phoneNumber, String position, CheckBox checkBox) {
        this.ID = new SimpleIntegerProperty(id);
        this.fullname = new SimpleStringProperty(fullname);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.position = new SimpleStringProperty(position);
        this.select = checkBox;
    }
}
