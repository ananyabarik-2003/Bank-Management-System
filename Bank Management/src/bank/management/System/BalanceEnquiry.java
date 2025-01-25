package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinNo;
    JButton back;
    BalanceEnquiry(String pinNo){
        this.pinNo=pinNo;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/ATM.jpg"));
        Image i2= i1.getImage().getScaledInstance(1080,1050,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);

        back=new JButton(" < BACK ");
        back.setBounds(500,430,200,40);
        back.setFont(new Font("Arial",Font.BOLD,18));
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        label.add(back);

        Conn conn=new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where PIN='" + pinNo + "'");
            while (rs.next()) {
                if (rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text=new JLabel("YOUR CURRENT BALANCE IS : " + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(300,180,600,40);
        text.setFont(new Font("Arial",Font.BOLD,20));
        label.add(text);

        setUndecorated(true);
        setSize(900,900);
        setLocation(350,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back){
            setVisible(false);
            new Transaction2(pinNo).setVisible(true);
        }
    }

    public static void main(String[] args) {

        new BalanceEnquiry("");

    }
}
