package bank.management.System;

import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try {
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement", "root", "Ananta");
            s=c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
