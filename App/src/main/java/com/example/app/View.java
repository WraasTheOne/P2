package com.example.app;

public enum View {
    HELLO("hello-view.fxml"),
    LoggedIn("LoggedIn.fxml"),
    Signup("signUp.fxml"),
    LOGIN("Loggin.fxml");


    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
