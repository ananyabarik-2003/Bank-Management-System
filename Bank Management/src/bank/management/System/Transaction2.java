package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction2 extends JFrame implements ActionListener {

    String pinNo;

    JButton deposit,fastcash,pinchange,cashWithdrawl,ministatement,balanceenq,exit;

    Transaction2(String pinNo){

        this.pinNo=pinNo;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/ATM.jpg"));
        Image i2= i1.getImage().getScaledInstance(1080,1050,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel l2=new JLabel("Please select your Transaction");
        l2.setBounds(270,180,600,40);
        l2.setFont(new Font("Arial",Font.BOLD,24));
        l2.setForeground(Color.white);
        label.add(l2);

        deposit=new JButton(" DEPOSIT ");
        deposit.setBounds(200,280,200,40);
        deposit.setFont(new Font("Arial",Font.BOLD,18));
        deposit.setBackground(Color.black);
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        label.add(deposit);

        fastcash=new JButton(" FAST CASH ");
        fastcash.setBounds(200,330,200,40);
        fastcash.setFont(new Font("Arial",Font.BOLD,18));
        fastcash.setBackground(Color.black);
        fastcash.setForeground(Color.WHITE);
        fastcash.addActionListener(this);
        label.add(fastcash);

        pinchange=new JButton(" PIN CHANGE ");
        pinchange.setBounds(200,380,200,40);
        pinchange.setFont(new Font("Arial",Font.BOLD,18));
        pinchange.setBackground(Color.black);
        pinchange.setForeground(Color.WHITE);
        pinchange.addActionListener(this);
        label.add(pinchange);

        cashWithdrawl=new JButton(" CASH WITHDRAWL ");
        cashWithdrawl.setBounds(500,280,200,40);
        cashWithdrawl.setFont(new Font("Arial",Font.BOLD,16));
        cashWithdrawl.setBackground(Color.black);
        cashWithdrawl.setForeground(Color.WHITE);
        cashWithdrawl.addActionListener(this);
        label.add(cashWithdrawl);

        ministatement=new JButton(" MINI STATEMENT ");
        ministatement.setBounds(500,330,200,40);
        ministatement.setFont(new Font("Arial",Font.BOLD,16));
        ministatement.setBackground(Color.black);
        ministatement.setForeground(Color.WHITE);
        ministatement.addActionListener(this);
        label.add(ministatement);

        balanceenq=new JButton(" BALANCE ENQUIRY ");
        balanceenq.setBounds(500,380,200,40);
        balanceenq.setFont(new Font("Arial",Font.BOLD,16));
        balanceenq.setBackground(Color.black);
        balanceenq.setForeground(Color.WHITE);
        balanceenq.addActionListener(this);
        label.add(balanceenq);

        exit=new JButton(" EXIT ");
        exit.setBounds(500,430,200,40);
        exit.setFont(new Font("Arial",Font.BOLD,18));
        exit.setBackground(Color.black);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        label.add(exit);

        setUndecorated(true);
        setSize(900,900);
        setLocation(350,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
            System.exit(0);
        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinNo).setVisible(true);
        } else if (ae.getSource()==cashWithdrawl) {
            setVisible(false);
            new Withdrawl(pinNo).setVisible(true);
        } else if (ae.getSource()==fastcash) {
            setVisible(false);
            new FastCash(pinNo).setVisible(true);
        } else if (ae.getSource()==pinchange) {
            setVisible(false);
            new PinChange(pinNo).setVisible(true);
        } else if (ae.getSource()==balanceenq) {
            setVisible(false);
            new BalanceEnquiry(pinNo).setVisible(true);
        } else if (ae.getSource()==ministatement) {
            setVisible(false);
            new MiniStatement(pinNo).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transaction2("");
    }
}
