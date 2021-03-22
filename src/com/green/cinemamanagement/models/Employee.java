package com.green.cinemamanagement.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Employee {

    private SimpleIntegerProperty ID;
    private SimpleStringProperty fullname;
    private SimpleStringProperty phoneNumber;
    private SimpleStringProperty position;


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

    public Employee(int id, String fullname, String phoneNumber, String position) {
        this.ID = new SimpleIntegerProperty(id);
        this.fullname = new SimpleStringProperty(fullname);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.position = new SimpleStringProperty(position);
    }
}
