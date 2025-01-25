package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {

    String pinNo;

    JButton b1,b2,b3,b4,b5,b6,back;

    FastCash(String pinNo){

        this.pinNo=pinNo;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/ATM.jpg"));
        Image i2= i1.getImage().getScaledInstance(1080,1050,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel l2=new JLabel("SELECT WITHDRAWL AMOUNT");
        l2.setBounds(300,180,600,40);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l2.setForeground(Color.white);
        label.add(l2);


        b1=new JButton("Rs 100");
        b1.setBounds(200,280,200,40);
        b1.setFont(new Font("Arial",Font.BOLD,18));
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        label.add(b1);

        b2=new JButton("Rs 500");
        b2.setBounds(500,280,200,40);
        b2.setFont(new Font("Arial",Font.BOLD,18));
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        label.add(b2);

        b3=new JButton("Rs 1000");
        b3.setBounds(200,330,200,40);
        b3.setFont(new Font("Arial",Font.BOLD,18));
        b3.setBackground(Color.black);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        label.add(b3);

        b4=new JButton("Rs 2000");
        b4.setBounds(500,330,200,40);
        b4.setFont(new Font("Arial",Font.BOLD,18));
        b4.setBackground(Color.black);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        label.add(b4);

        b5=new JButton("Rs 5000");
        b5.setBounds(200,380,200,40);
        b5.setFont(new Font("Arial",Font.BOLD,18));
        b5.setBackground(Color.black);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        label.add(b5);

        b6=new JButton("Rs 10000");
        b6.setBounds(500,380,200,40);
        b6.setFont(new Font("Arial",Font.BOLD,18));
        b6.setBackground(Color.black);
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        label.add(b6);

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

    public void actionPerformed(ActionEvent ae ){

        if (ae.getSource()==back){
            setVisible(false);
            new Transaction2(pinNo).setVisible(true);
        } else  {
            String amount= ((JButton)ae.getSource()).getText().substring(3);
            Conn conn=new Conn();
            try {
                ResultSet rs=conn.s.executeQuery("select * from bank where PIN='"+ pinNo +"'");
                int balance=0;
                while (rs.next()){
                    if (rs.getString("Type").equals("Deposit")){
                        balance +=Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -=Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient amount");
                    return;
                }

                Date date=new Date();
                String query="insert into bank values('"+ pinNo +"', '"+date+"', 'Withdraw', '"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs " + amount +" Debited Successfully");

                setVisible(false);
                new Transaction2(pinNo).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
