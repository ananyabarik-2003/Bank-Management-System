package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public  class Signup3 extends JFrame implements ActionListener {
    String formno;

    JRadioButton r1,r2,r3,r4;

    JCheckBox c1,c2,c3,c4,c5,c6,declaration;

    JButton submit,cancel;

    Signup3(String formno){
        this.formno=formno;

        setLayout(null);
      //  getContentPane().setBackground(Color.);

        JLabel accountDetails=new JLabel("Page : 3 : ACCOUNT DETAILS");
        accountDetails.setFont(new Font("Onwards",Font.BOLD,28));
        accountDetails.setBounds(200,40,500,40);
        add(accountDetails);

        JLabel accounttype=new JLabel("ACCOUNT TYPE :");
        accounttype.setFont(new Font("Onwards",Font.BOLD,20));
        accounttype.setBounds(80,140,500,30);
        add(accounttype);

        r1=new JRadioButton("Saving Account");
        r1.setBounds(90,180,250,30);
        //r1.setBackground(Color.lightGray);
        r1.setFont(new Font("Arial",Font.BOLD,16));
        add(r1);

        r2=new JRadioButton("Deposit Account");
        r2.setBounds(350,180,300,30);
        //r2.setBackground(Color.lightGray);
        r2.setFont(new Font("Arial",Font.BOLD,16));
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setBounds(90,230,250,30);
       // r3.setBackground(Color.lightGray);
        r3.setFont(new Font("Arial",Font.BOLD,16));
        add(r3);

        r4=new JRadioButton("Reccuring deposit Account");
        r4.setBounds(350,230,300,30);
       // r4.setBackground(Color.lightGray);
        r4.setFont(new Font("Arial",Font.BOLD,16));
        add(r4);

        ButtonGroup buttons=new ButtonGroup();
        buttons.add(r1);
        buttons.add(r2);
        buttons.add(r3);
        buttons.add(r4);

        JLabel cardno=new JLabel("CARD NO :");
        cardno.setFont(new Font("Onwards",Font.BOLD,20));
        cardno.setBounds(80,300,500,30);
        add(cardno);

        JLabel l1=new JLabel("(Your 16-digit Card No)");
        l1.setFont(new Font("Onwards",Font.BOLD,12));
        l1.setBounds(80,330,500,30);
        add(l1);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-4764");
        number.setFont(new Font("Railway",Font.BOLD,18));
        number.setBounds(350,300,500,30);
        add(number);

        JLabel l2=new JLabel("It would appear on the ATM Card/cheque book and statements");
        l2.setFont(new Font("Onwards",Font.BOLD,12));
        l2.setBounds(350,330,500,30);
        add(l2);

        JLabel pin=new JLabel("PIN : ");
        pin.setFont(new Font("Onwards",Font.BOLD,20));
        pin.setBounds(80,400,500,30);
        add(pin);

        JLabel p1=new JLabel("(Your 4-digit Password)");
        p1.setFont(new Font("Onwards",Font.BOLD,12));
        p1.setBounds(80,430,500,30);
        add(p1);

        JLabel pno=new JLabel("XXXX");
        pno.setFont(new Font("Railway",Font.BOLD,18));
        pno.setBounds(350,400,500,30);
        add(pno);

        JLabel services=new JLabel("SERVICES REQUIRED :");
        services.setFont(new Font("Onwards",Font.BOLD,20));
        services.setBounds(80,500,500,30);
        add(services);

        c1=new JCheckBox("ATM CARD");
        c1.setBounds(100,540,250,30);
        c1.setFont(new Font("Arial",Font.BOLD,16));
        //c1.setBackground(Color.lightGray);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBounds(350,540,300,30);
        c2.setFont(new Font("Arial",Font.BOLD,16));
       // c2.setBackground(Color.lightGray);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBounds(100,590,250,30);
        c3.setFont(new Font("Arial",Font.BOLD,16));
       // c3.setBackground(Color.lightGray);
        add(c3);

        c4=new JCheckBox("E-MAIL Alerts");
        c4.setBounds(350,590,300,30);
        c4.setFont(new Font("Arial",Font.BOLD,16));
        //c4.setBackground(Color.lightGray);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBounds(100,640,250,30);
        c5.setFont(new Font("Arial",Font.BOLD,16));
       // c5.setBackground(Color.lightGray);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBounds(350,640,300,30);
        c6.setFont(new Font("Arial",Font.BOLD,16));
        //c6.setBackground(Color.lightGray);
        add(c6);

        declaration=new JCheckBox("I Hereby declare that the above entered details are correct as my best knowledge",true);
        declaration.setBounds(100,720,500,30);
        declaration.setFont(new Font("Arial",Font.BOLD,12));
        //declaration.setBackground(Color.lightGray);
        add(declaration);

        cancel=new JButton("Cancel");
        cancel.setBounds(250,750,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        submit=new JButton("Submit");
        submit.setBounds(400,750,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);



        setSize(850,850);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){

            String accountType=null;
            if (r1.isSelected()){
                accountType="Saving Account";
            } else if (r2.isSelected()) {
                accountType="Deposit Account";
            }else if (r3.isSelected()){
                accountType="Current Account";
            } else if (r4.isSelected()) {
                accountType="Recurring deposit Account";
            }

            Random rnd=new Random();
            String cardNo=" " + Math.abs((rnd.nextLong() % 90000000L)+ 5040396000000000L);
            String pinNo=" " +Math.abs((rnd.nextLong() % 9000L) + 1000L);

            String facility="";
            if (c1.isSelected()){
                facility= facility +"ATM CARD";
            } else if (c2.isSelected()) {
                facility=facility +"Internet Banking";
            } else if (c3.isSelected()) {
                facility=facility +"Mobile Banking";
            } else if (c4.isSelected()) {
                facility=facility +"E-MAIL Alerts";
            } else if (c5.isSelected()) {
                facility=facility +"Cheque Book";
            } else if (c6.isSelected()) {
                facility=facility +"E-Statement";
            }

            try {
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter Account type");
                }
                else {
                    Conn c = new Conn();
                    String query1 = "insert into signup3 values('" + formno + "','" + accountType + "','"+ cardNo + "','" + pinNo + "','" + facility + "')";
                    String query2= "insert into login values('" + formno + "','" + cardNo + "','" + pinNo + "')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card no : "+ cardNo + "\n PIN : "+ pinNo +" ");

                    setVisible(false);
                    new Deposit(pinNo).setVisible(true);
                }

            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()==cancel) {

        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
