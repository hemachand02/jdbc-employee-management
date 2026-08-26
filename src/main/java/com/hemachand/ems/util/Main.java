package com.hemachand.ems.util;

//import com.hemachand.ems.util.DBConnection;

import java.sql.SQLException;
import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
    try(
    Connection connection = DBConnection.getConnection())
    {
        System.out.println("Connection Established Successfully[java<-->MySQL]");
    }
    catch(SQLException e)
    {
        System.err.println(e.getMessage());
        e.printStackTrace();
    }
}
}
