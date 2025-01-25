package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    JButton back;

    String pinNo;

    MiniStatement(String pinNo){

        this.pinNo=pinNo;

        setTitle("MINI STATEMENT");

        setLayout(null);

        JLabel l1=new JLabel("BANK OF GITA");
        l1.setFont(new Font("Arial",Font.BOLD,16));
        l1.setBounds(155,30,200,30);
        add(l1);

        JLabel card=new JLabel();
        card.setBounds(40,80,300,20);
        card.setFont(new Font("Arial",Font.BOLD,16));
        add(card);

        JLabel mini=new JLabel();
        mini.setBounds(40,130,400,200);
        add(mini);

        try {
            Conn conn=new Conn();
            ResultSet rs= conn.s.executeQuery("select * from login where PIN='"+  pinNo+"'");
            while (rs.next()){

                card.setText("Card No : "+ rs.getString("Cardno").substring(0,5)+ "XXXXXXXX"+rs.getString("Cardno").substring(12));

            }

        }catch (Exception e){
            System.out.println(e);
        }

        try {
            Conn conn=new Conn();
            ResultSet rs= conn.s.executeQuery("select * from bank where PIN='"+  pinNo+"'");
            while (rs.next()){

                mini.setText(mini.getText()+"<html>"+rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("Amount")+"<br><br><br><html>");

            }
        }catch (Exception e){
            System.out.println(e);
        }

        back=new JButton("<BACK");
        back.setBounds(25,600,100,40);
        back.setFont(new Font("Arial",Font.BOLD,18));
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //setUndecorated(true);
        setSize(450,700);
        setLocation(20,20);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back){
            setVisible(false);
            new Transaction2(pinNo).setVisible(true);
        }
    }

    public static void main(String[] args) {

        new MiniStatement("");

    }
}
