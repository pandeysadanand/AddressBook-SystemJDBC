package com.bl.JDBC;

import com.bl.JDBC.AddressBookMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddressBook {
    Scanner scanner = new Scanner(System.in);
    PreparedStatement preparedStatement = null;
    AddressBookMain addressBookMain = new AddressBookMain();

    public void createTable(Connection con) throws Exception{
        try{
            String query = "create table contact_details(id int not null auto_increment primary key, first_name varchar(10) not null, last_name varchar(10) not null, address varchar(10), city varchar(10) not null, state varchar(10) not null, zip int(6), phone int(12) not null, email varchar(20) unique)";
            Statement statement = null;
            if (con != null) {
                statement = con.createStatement();
                int result = statement.executeUpdate(query);
                if (result != 0) {
                    System.out.println("Table created successfully");
                } else {
                    System.out.println("Table creation failed");
                }
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
 }
