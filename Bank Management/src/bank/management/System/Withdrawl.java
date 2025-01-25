package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    String pinNo;

    JTextField t1;
    JButton withdraw,back;

    Withdrawl(String pinNo){

        this.pinNo=pinNo;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/ATM.jpg"));
        Image i2= i1.getImage().getScaledInstance(1080,1050,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel l2=new JLabel("MAXIMUM WITHDRAWL IS 10000");
        l2.setBounds(280,180,600,40);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l2.setForeground(Color.white);
        label.add(l2);

        JLabel l3=new JLabel("PLEASE ENTER YOUR AMOUNT YOU WANT TO WITHDRAW");
        l3.setBounds(180,220,600,40);
        l3.setFont(new Font("Arial",Font.BOLD,18));
        l3.setForeground(Color.white);
        label.add(l3);

        t1=new JTextField();
        t1.setBounds(240,280,400,30);
        t1.setFont(new Font("Arial",Font.BOLD,20));
        t1.setForeground(Color.black);
        label.add(t1);

        withdraw=new JButton(" WITHDRAW ");
        withdraw.setBounds(500,380,200,40);
        withdraw.setFont(new Font("Arial",Font.BOLD,18));
        withdraw.setBackground(Color.black);
        withdraw.setForeground(Color.WHITE);
        withdraw.addActionListener(this);
        label.add(withdraw);

        back=new JButton(" < BACK ");
        back.setBounds(500,430,200,40);
        back.setFont(new Font("Arial",Font.BOLD,18));
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        label.add(back);

        setUndecorated(true);
        setSize(900,900);
        setLocation(350,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource()==back){
            setVisible(false);
            new Transaction2(pinNo).setVisible(true);
        } else if (ae.getSource()==withdraw) {
            String amount=t1.getText();
            Date date= new Date();
            if (amount.equals("")){
                JOptionPane.showMessageDialog(null,"Enter amount");
            }
            else {
                try {
                    Conn conn=new Conn();
                    String query="insert into bank values('"+ pinNo +"', '"+date+"', 'Withdraw', '"+amount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs " + amount +" Transaction Successful");
                    setVisible(false);
                    new Transaction2(pinNo).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }

            }

        }

    }

    public static void main(String[] args) {
        new Withdrawl("");

    }
}
