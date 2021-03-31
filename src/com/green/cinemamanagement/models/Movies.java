package com.green.cinemamanagement.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class Movies {
    private SimpleIntegerProperty IDMovie;
    private SimpleStringProperty title;
    private SimpleStringProperty genre;
    private SimpleStringProperty releaseDate;
    private SimpleIntegerProperty runningTime;

    private CheckBox select;

    public Movies(Integer IDMovie, String  title, String genre, String releaseDate, Integer runningTime, CheckBox select) {
        this.IDMovie = new SimpleIntegerProperty(IDMovie);
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);
        this.releaseDate = new SimpleStringProperty(releaseDate);
        this.runningTime = new SimpleIntegerProperty(runningTime);
        this.select = select;
    }

    public int getIDMovie() {
        return IDMovie.get();
    }

    public SimpleIntegerProperty IDMovieProperty() {
        return IDMovie;
    }

    public void setIDMovie(int IDMovie) {
        this.IDMovie.set(IDMovie);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getGenre() {
        return genre.get();
    }

    public SimpleStringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public String getReleaseDate() {
        return releaseDate.get();
    }

    public SimpleStringProperty releaseDateProperty() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate.set(releaseDate);
    }

    public Integer getRunningTime() {
        return runningTime.get();
    }

    public SimpleIntegerProperty runningTimeProperty() {
        return runningTime;
    }

    public void setRunningTime(Integer runningTime) {
        this.runningTime.set(runningTime);
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }
}
