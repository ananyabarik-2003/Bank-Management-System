package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    String pinNo;

    JButton back,change;
    JTextField newField,changeField;

    PinChange(String pinNo){
        this.pinNo=pinNo;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/ATM.jpg"));
        Image i2= i1.getImage().getScaledInstance(1080,1050,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel l2=new JLabel("CHANGE YOUR PIN");
        l2.setBounds(350,180,600,40);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l2.setForeground(Color.white);
        label.add(l2);

        JLabel l3=new JLabel("NEW PIN : ");
        l3.setBounds(250,230,600,40);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l3.setForeground(Color.white);
        label.add(l3);

        newField=new JTextField();
        newField.setBounds(470,230,200,30);
        newField.setFont(new Font("Arial",Font.BOLD,20));
        newField.setForeground(Color.black);
        label.add(newField);

        JLabel l4=new JLabel("RE-ENTER NEW PIN : ");
        l4.setBounds(250,270,600,40);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        l4.setForeground(Color.white);
        label.add(l4);

        changeField=new JTextField();
        changeField.setBounds(470,270,200,30);
        changeField.setFont(new Font("Arial",Font.BOLD,20));
        changeField.setForeground(Color.black);
        label.add(changeField);


        change=new JButton("CHANGE");
        change.setBounds(500,380,200,40);
        change.setFont(new Font("Arial",Font.BOLD,18));
        change.setBackground(Color.black);
        change.setForeground(Color.WHITE);
        change.addActionListener(this);
        label.add(change);

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
        } else if (ae.getSource()==change) {
            try {
                String npin= newField.getText();
                String rpin=changeField.getText();

                if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Re-Entered pin is not same.");
                    return;
                }

                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter new pin");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null,"Re-Enter new pin");
                    return;
                }

                Conn conn=new Conn();
                String query1="update bank set PIN='"+rpin+"' where PIN='"+pinNo+"'";
                String query2="update login set PIN='"+rpin+"' where PIN='"+pinNo+"'";
                String query3="update signup3 set PIN='"+rpin+"' where PIN='"+pinNo+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed Successfully");

                setVisible(false);
                new Transaction2(rpin).setVisible(true);


            }catch (Exception e){
                System.out.println(e);
            }

        }
    }

    public static void main(String[] args) {

        new PinChange("");

    }
}
