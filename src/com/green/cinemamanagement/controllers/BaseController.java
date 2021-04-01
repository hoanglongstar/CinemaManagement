package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.views.ViewFactory;

public class BaseController {
    private String fxmlName;
    protected ViewFactory viewFactory;

    public BaseController(ViewFactory viewFactory, String fxmlName){
        this.fxmlName = fxmlName;
        this.viewFactory = viewFactory;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
