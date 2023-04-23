package com.example.app.View;

public enum View {
    HELLO("hello-view.fxml"),
    LoggedIn("LoggedIn.fxml"),
    LoggedInCenterCoop("LoggedIn-CenterCoop.fxml"),
    LoggedInAdmin("LoggedIn-Admin.fxml"),
    Signup("signUp.fxml"),

    Tabelview("Tabelview.fxml"),
    LOGIN("Login.fxml"),
    BigBag("BigBag.fxml"),
    USERMANAGEMENT("UserManagement.fxml"),
    ChangeProcess("ChangeProcess");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
