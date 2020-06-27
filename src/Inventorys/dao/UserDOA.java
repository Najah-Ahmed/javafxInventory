package Inventorys.dao;

import java.sql.*;


import Inventorys.models.*;

import Inventorys.utils.DButils;
import javafx.scene.control.Alert;

public class UserDOA {
    private Connection connection;
    public UserDOA(){
        connection=DButils.setConnect();
    }
    public User getUser(String username, String password) throws SQLException {
        String sql ="SELECT * FROM Users WHERE  username=? AND password=?";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setString( 1,username);
        ps.setString(2,password);
        ResultSet rs =ps.executeQuery();
        User user =new User(username,password);
        while(rs.next()){
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setId(rs.getInt("id"));
        }


        return user;
    }
    public void  addUser(User user) throws SQLException {
        String sql = "INSERT INTO Users (userName,email,password )VALUES('"+user.getUsername() + "','"+ user.getEmail()+"','"+user.getPassword()+"' )";
        //System.out.println(sql);
        //Create statement
        Statement statement =connection.createStatement();
        //execute the statement
        int r=statement.executeUpdate(sql);
        if (r>0){
            Alert alert =new Alert(Alert.AlertType.INFORMATION, r+ "Inserted new User");
            alert.show();
        }
    }



}
