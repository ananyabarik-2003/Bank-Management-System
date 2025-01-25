package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Transaction1 extends JFrame implements ActionListener {
    String pinNo;
    JButton b1;

    Transaction1(String pinNo){

        this.pinNo=pinNo;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/ATM.jpg"));
        Image i2= i1.getImage().getScaledInstance(1080,1050,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel l1=new JLabel("Hii...");
        l1.setBounds(400,280,600,40);
        l1.setFont(new Font("Arial",Font.BOLD,34));
        l1.setForeground(Color.white);
        label.add(l1);

        JLabel l2=new JLabel("Please CLICK the switch to start your Transaction");
        l2.setBounds(220,320,600,40);
        l2.setFont(new Font("Arial",Font.BOLD,18));
        l2.setForeground(Color.white);
        label.add(l2);

        b1=new JButton("START");
        b1.setBounds(430,102,68,20);
        b1.setFont(new Font("Arial",Font.BOLD,9));
        b1.setBackground(Color.GRAY);
        b1.addActionListener(this);
        label.add(b1);


        setUndecorated(true);
        setSize(900,900);
        setLocation(350,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == b1){
            setVisible(false);
            new Transaction2(pinNo).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Transaction1("").setVisible(true);
    }
}
