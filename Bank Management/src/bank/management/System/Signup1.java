package bank.management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class Signup1 extends JFrame implements ActionListener {

    long random;
    JTextField nameText,fatherText,emailText,addrText,cityText,pinText,stateText;
    JButton next;
    JRadioButton sexM,sexF,other,single,married,widow;
    JDateChooser dobchooser;
    Signup1(){
        setLayout(null);
        getContentPane().setBackground(Color.lightGray);

        Random rnd=new Random();
        random=(Math.abs(rnd.nextLong() % 9000L) + 1000L);


        JLabel formNo=new JLabel("APPLICATION FORM NO : "+random);
        formNo.setFont(new Font("Onwards",Font.BOLD,30));
        formNo.setBounds(150,40,500,40);
        add(formNo);

        JLabel personalDetails=new JLabel("Page : 1 : PERSONAL DETAILS");
        personalDetails.setFont(new Font("Onwards",Font.BOLD,20));
        personalDetails.setBounds(230,80,500,40);
        add(personalDetails);

        JLabel name=new JLabel("NAME : ");
        name.setFont(new Font("Onwards",Font.BOLD,18));
        name.setBounds(80,150,500,30);
        add(name);

        nameText=new JTextField();
        nameText.setBounds(300,150,400,30);
        nameText.setFont(new Font("Arial",Font.BOLD,14));
        add(nameText);

        JLabel fathername=new JLabel("FATHER'S NAME : ");
        fathername.setFont(new Font("Onwards",Font.BOLD,18));
        fathername.setBounds(80,200,500,30);
        add(fathername);

        fatherText=new JTextField();
        fatherText.setBounds(300,200,400,30);
        fatherText.setFont(new Font("Arial",Font.BOLD,14));
        add(fatherText);

        JLabel dob=new JLabel("DATE OF BIRTH : ");
        dob.setFont(new Font("Onwards",Font.BOLD,18));
        dob.setBounds(80,250,500,30);
        add(dob);

        dobchooser=new JDateChooser();
        dobchooser.setBounds(300,250,400,30);
        dobchooser.setFont(new Font("Arial",Font.BOLD,14));
        add(dobchooser);

        JLabel gender=new JLabel("SEX : ");
        gender.setFont(new Font("Onwards",Font.BOLD,18));
        gender.setBounds(80,300,500,30);
        add(gender);

        sexM=new JRadioButton("Male");
        sexM.setBounds(300,300,90,30);
        sexM.setBackground(Color.lightGray);
        add(sexM);

        sexF=new JRadioButton("Female");
        sexF.setBounds(400,300,90,30);
        sexF.setBackground(Color.lightGray);
        add(sexF);

        other=new JRadioButton("Others");
        other.setBounds(500,300,90,30);
        other.setBackground(Color.lightGray);
        add(other);

        ButtonGroup sexgrp=new ButtonGroup();
        sexgrp.add(sexM);
        sexgrp.add(sexF);
        sexgrp.add(other);

        JLabel email=new JLabel("E-MAIL ADDRESS : ");
        email.setFont(new Font("Onwards",Font.BOLD,18));
        email.setBounds(80,350,500,30);
        add(email);

        emailText=new JTextField();
        emailText.setBounds(300,350,400,30);
        emailText.setFont(new Font("Arial",Font.BOLD,14));
        add(emailText);

        JLabel maritalsts=new JLabel("MARITAL STATUS : ");
        maritalsts.setFont(new Font("Onwards",Font.BOLD,18));
        maritalsts.setBounds(80,400,500,30);
        add(maritalsts);

        single=new JRadioButton("Single");
        single.setBounds(300,400,90,30);
        single.setBackground(Color.lightGray);
        add(single);

        married=new JRadioButton("Married");
        married.setBounds(400,400,90,30);
        married.setBackground(Color.lightGray);
        add(married);

        widow=new JRadioButton("Widow");
        widow.setBounds(500,400,90,30);
        widow.setBackground(Color.lightGray);
        add(widow);

        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(single);
        maritalgroup.add(married);
        maritalgroup.add(widow);

        JLabel addr=new JLabel("ADDRESS : ");
        addr.setFont(new Font("Onwards",Font.BOLD,18));
        addr.setBounds(80,450,500,30);
        add(addr);

        addrText=new JTextField();
        addrText.setBounds(300,450,400,30);
        addrText.setFont(new Font("Arial",Font.BOLD,14));
        add(addrText);

        JLabel city=new JLabel("CITY : ");
        city.setFont(new Font("Onwards",Font.BOLD,18));
        city.setBounds(80,500,500,30);
        add(city);

        cityText=new JTextField();
        cityText.setBounds(300,500,400,30);
        cityText.setFont(new Font("Arial",Font.BOLD,14));
        add(cityText);

        JLabel state=new JLabel("STATE : ");
        state.setFont(new Font("Onwards",Font.BOLD,18));
        state.setBounds(80,550,500,30);
        add(state);

        stateText=new JTextField();
        stateText.setBounds(300,550,400,30);
        stateText.setFont(new Font("Arial",Font.BOLD,14));
        add(stateText);

        JLabel pin=new JLabel("PIN CODE : ");
        pin.setFont(new Font("Onwards",Font.BOLD,18));
        pin.setBounds(80,600,500,30);
        add(pin);

        pinText=new JTextField();
        pinText.setBounds(300,600,400,30);
        pinText.setFont(new Font("Arial",Font.BOLD,14));
        add(pinText);

        next=new JButton("Next");
        next.setBounds(600,700,100,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);



        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){


        String formno = " "+random;
        String name=nameText.getText();
        String fname= fatherText.getText();
        String dob= ((JTextField)dobchooser.getDateEditor().getUiComponent()).getText();

        String gender=null;
        if (sexM.isSelected()){
            gender="Male";
        } else if (sexF.isSelected()) {
            gender="Female";
        } else if (other.isSelected()) {
            gender="Others";
        }

        String email=emailText.getText();

        String marital=null;
        if (single.isSelected()){
            marital="Single";
        } else if (married.isSelected()) {
            marital="Married";
        } else if (widow.isSelected()) {
            marital="Widow";
        }

        String addrs=addrText.getText();
        String city=cityText.getText();
        String pin=pinText.getText();
        String state=stateText.getText();


        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"*Name is Required");
            }


            else if (fname.equals("")){
                JOptionPane.showMessageDialog(null,"*Father`s Name is Required");
            }

            else if (dob.equals("")){
                JOptionPane.showMessageDialog(null,"Enter your Date of Birth");
            }


            else if (email.equals("")){
                JOptionPane.showMessageDialog(null,"* E-Mail required");
            }

            else if (city.equals("")){
                JOptionPane.showMessageDialog(null,"Enter your city");
            }

            else if (state.equals("")){
                JOptionPane.showMessageDialog(null,"Enter your State");
            }

            else if (addrs.equals("")){
                JOptionPane.showMessageDialog(null,"Address is required");
            }

            else if (pin.equals("")){
                JOptionPane.showMessageDialog(null,"*PIN code Required");
            }

//            else if (gender.equals("")){
//               JOptionPane.showMessageDialog(null,"Enter your Gender");
//            }
//
//            else if (marital.equals("")){
//                JOptionPane.showMessageDialog(null,"Enter your Marital Status");
//            }

            else {
                Conn c=new Conn();
                String query= "insert into signup1 values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+addrs+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signup2(formno).setVisible(true);
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        new Signup1();

    }
}
