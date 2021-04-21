package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

//        String url="jdbc:sqlserver:.;databaseName=customer";
//        String user="root";
//        String password="123456";
//        try {
//            Connection connection = DriverManager.getConnection(url,user,password);
//        }catch(SQLException e)
//        {
//            e.printStackTrace();
//        }
//        try {
//
//            java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8081/javaproject", "root", "");
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("INSERT INTO tested (name) VALUES ('mohamad')");
//            System.out.println("insert");
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM tested");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("name"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
         SpringApplication.run(DemoApplication.class, args);

    }
}
