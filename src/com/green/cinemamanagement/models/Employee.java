package com.green.cinemamanagement.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

import java.util.Date;

public class Employee {

    private SimpleIntegerProperty ID;
    private SimpleStringProperty fullname;
    private SimpleStringProperty dateOfBirth;
    private SimpleStringProperty address;
    private SimpleStringProperty position;

//    public Date getDateOfBirth() {


    public String getDateOfBirth() {
        return dateOfBirth.get();
    }

    public SimpleStringProperty dateOfBirthProperty() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }

    public int getID() {
        return ID.get();
    }

    public SimpleIntegerProperty IDProperty() {
        return ID;
    }

    private CheckBox select;

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public void setFullname(String fullname) {
        this.fullname.set(fullname);
    }

//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth.set(dateOfBirth);
//    }

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

//    public String getDateOfBirth() {
//        return dateOfBirth.get();
//    }

//    public SimpleStringProperty dateOfBirthProperty() {
//        return dateOfBirth;
//    }

    public String getPosition() {
        return position.get();
    }

    public SimpleStringProperty positionProperty() {
        return position;
    }

    public Employee(Integer ID, String fullname, String dateofbirth, String address, String position, CheckBox select) {
        this.ID = new SimpleIntegerProperty(ID);
        this.fullname = new SimpleStringProperty(fullname);
        this.dateOfBirth = new SimpleStringProperty(dateofbirth);
        this.address = new SimpleStringProperty(address);
        this.position = new SimpleStringProperty(position);
        this.select = select;
    }
}
