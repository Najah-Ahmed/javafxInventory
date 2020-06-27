package Inventorys.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import Inventorys.dao.UserDOA;
import Inventorys.models.User;

import java.io.IOException;
import java.sql.SQLException;

public class LoginSignupController {
    UserDOA userDAO=new UserDOA();
    //login
    @FXML
    private Label alertDanger;

    @FXML
    private TextField userLogin;

    @FXML
    private PasswordField pwdLogin;

    @FXML
    private Button logIn;

    @FXML
    private Hyperlink linkSignup;

    //signup
    @FXML
    private Button signUp;

    @FXML
    private TextField userSignup;

    @FXML
    private TextField userEmail;

    @FXML
    private PasswordField userPwd;

    @FXML
    private Hyperlink linkLogin;



    @FXML
    void onLoginLink(ActionEvent event) {
        try{

            Parent root = FXMLLoader.load(getClass().getResource("/Inventory/app/login.fxml"));

            Stage login =new Stage();
            login.setTitle("login ");
            login.getIcons().add(new Image("/Inventorys/images/iconfinder_inventory-maintenance_49590.png"));
            login.setScene(new Scene(root ,700,400));
            login.show();
            userSignup.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onSignup(ActionEvent event)  {
        try{  String userName=userSignup.getText().toString();
            String email=userEmail.getText().toString();
            String password=userPwd.getText().toString();
            User user =new User(userName,email,password);
            userDAO.addUser(user);
        }
        catch (NullPointerException ne){
            System.err.println(ne.getStackTrace());

        }
        catch (NumberFormatException nf){
            System.err.println(nf.getStackTrace());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onLogin(ActionEvent event) throws SQLException {
        User user= userDAO.getUser(userLogin.getText().toString(),pwdLogin.getText().toString());

        if (user.getUsername() != null ){

            try{
                Stage dashboardStage=new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/Inventory/app/invontory.fxml"));
                dashboardStage.getIcons().add(new Image("/Inventorys/images/iconfinder_inventory-maintenance_49590.png"));
                dashboardStage.setTitle("Dashboard");
                Scene scene =new Scene(root,700,400);
                dashboardStage.setScene(scene);
                //to close so hel one of contollers
                userLogin.getScene().getWindow().hide();
                dashboardStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            alertDanger.setVisible(true);
        }

    }

    @FXML
    void onSignuplink(ActionEvent event) {
        try{

            Parent root = FXMLLoader.load(getClass().getResource("/Inventory/app/signup.fxml"));

            Stage signup =new Stage();
            signup.setTitle("signup");
            signup.getIcons().add(new Image("/Inventorys/images/iconfinder_inventory-maintenance_49590.png"));
            signup.setScene(new Scene(root ,700,400));
            signup.show();
            userLogin.getScene().getWindow().hide();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
