package com.example.app;

public enum View {
    HELLO("hello-view.fxml"),
    MAINPAGE("Main_Page.fxml"),
    Signup("signUp.fxml"),
    LOGIN("Loggin.fxml"),
    MAINPAGEADMIN("Main_Page_Admin.fxml");
    //ACHINES("VMs.fxml");


    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
