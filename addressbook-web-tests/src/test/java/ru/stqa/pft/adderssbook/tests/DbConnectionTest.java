package ru.stqa.pft.adderssbook.tests;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionTest {
  @Test
  public void testDbConnection (){
    Connection conn = null;
    try {
      conn =
              DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?" +
                      "user=root&password=greatsqldb");

      // Do something with the Connection

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}
