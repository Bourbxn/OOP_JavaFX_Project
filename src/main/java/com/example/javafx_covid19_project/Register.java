package com.example.javafx_covid19_project;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.sql.Connection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Register {

    public Register() {

    }

    @FXML
    private Button button;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;



    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        Main m = new Main();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = String.format("SELECT * FROM population WHERE username = '%s' AND password = '%s'"
                ,username.getText().toString(),password.getText().toString());

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            /*
            while(queryOutput.next()){
                System.out.println(usernameStr);
            }*/

            if(!queryOutput.isBeforeFirst()){
                System.out.println("ERROR INPUT");
            }
            else{
                m.changeScene("AfterLogin.fxml");
                System.out.println("wrong input");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
