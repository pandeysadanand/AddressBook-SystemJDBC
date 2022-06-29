package com.bl.JDBC;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) throws Exception {
        AddressBookMain addressBookMain = new AddressBookMain();
        System.out.println("Welcome to address book program ☺");
        addressBookMain.connection();
    }

    public void connection() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/demo";
        Connection con = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            //creating jdbc connection object
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "Momloverjee@0275");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        AddressBook addressBook = new AddressBook();
        boolean change = true;
        do {
            System.out.println("\n Select the operation you want to perform : ");
            System.out.println(
                    "1.Add To Address Book\n2.Edit Existing Entry\n3.Delete Contact\n4.Display Address book\n11.Exit Address book System");
            switch (scanner.nextInt()) {
                case 1:
                    addressBook.createTable(con);
                    break;
                default:
                    change = false;
                    System.out.println("Exiting Address Book... ");
            }
        } while (change);
    }
}


