package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    JButton next,back;
    JTextField panText,aadharText;
    JRadioButton citizenshipY,citizenshipN,existingaccountY,existingaccountN;
    String formno;
    JComboBox <String> name,category,inc,qualify,occ;

    Signup2(String formno){

        this.formno=formno;

        setLayout(null);
        getContentPane().setBackground(Color.lightGray);

        JLabel additionallDetails=new JLabel("Page : 2 : ADDITIONAL DETAILS");
        additionallDetails.setFont(new Font("Onwards",Font.BOLD,28));
        additionallDetails.setBounds(200,50,500,40);
        add(additionallDetails);

        JLabel religion=new JLabel("RELIGION : ");
        religion.setFont(new Font("Onwards",Font.BOLD,18));
        religion.setBounds(80,150,500,30);
        add(religion);

        String[] valname = {"","Hindu", "Muslim", "Sikh"};
        name=new JComboBox<>(valname);
        name.setBounds(300,150,400,30);
        add(name);

        JLabel caste=new JLabel("CATEGORY : ");
        caste.setFont(new Font("Onwards",Font.BOLD,18));
        caste.setBounds(80,200,500,30);
        add(caste);

        String[] valcategory= {"","SC", "ST", "OBC","GEN"};
        category=new JComboBox<>(valcategory);
        category.setBounds(300,200,400,30);
        add(category);

        JLabel income=new JLabel("INCOME : ");
        income.setFont(new Font("Onwards",Font.BOLD,18));
        income.setBounds(80,250,500,30);
        add(income);

        String[] valinc = {"","<1000","<15000","<50000"};
        inc=new JComboBox<>(valinc);
        inc.setBounds(300,250,400,30);
        add(inc);

        JLabel qualification=new JLabel("QUALIFICATION : ");
        qualification.setFont(new Font("Onwards",Font.BOLD,18));
        qualification.setBounds(80,300,500,30);
        add(qualification);

        String[] valqualify = {"","Illiterate","10th","+2"};
        qualify=new JComboBox<>(valqualify);
        qualify.setBounds(300,300,400,30);
        add(qualify);

        JLabel occupation=new JLabel("OCCUPATION : ");
        occupation.setFont(new Font("Onwards",Font.BOLD,18));
        occupation.setBounds(80,350,500,30);
        add(occupation);

        String[] valocc = {"","House wife","Farmer","CA"};
        occ=new JComboBox<>(valocc);
        occ.setBounds(300,350,400,30);
        add(occ);

        JLabel pan=new JLabel("PAN NO : ");
        pan.setFont(new Font("Onwards",Font.BOLD,18));
        pan.setBounds(80,400,500,30);
        add(pan);

        panText=new JTextField();
        panText.setBounds(300,400,400,30);
        panText.setFont(new Font("Onwards",Font.BOLD,18));
        add(panText);

        JLabel aadhar=new JLabel("AADHAR NO : ");
        aadhar.setFont(new Font("Onwards",Font.BOLD,18));
        aadhar.setBounds(80,450,500,30);
        add(aadhar);

        aadharText=new JTextField();
        aadharText.setBounds(300,450,400,30);
        aadharText.setFont(new Font("Arial",Font.BOLD,14));
        add(aadharText);

        JLabel citizen=new JLabel("SENIOR CITIZEN : ");
        citizen.setFont(new Font("Onwards",Font.BOLD,18));
        citizen.setBounds(80,500,500,30);
        add(citizen);

        citizenshipY=new JRadioButton("YES");
        citizenshipY.setBounds(300,500,100,30);
        citizenshipY.setBackground(Color.lightGray);
        add(citizenshipY);

        citizenshipN=new JRadioButton("NO");
        citizenshipN.setBounds(400,500,100,30);
        citizenshipN.setBackground(Color.lightGray);
        add(citizenshipN);

        ButtonGroup citygrp=new ButtonGroup();
        citygrp.add(citizenshipY);
        citygrp.add(citizenshipN);

        JLabel account=new JLabel("EXISTING ACCOUNT : ");
        account.setFont(new Font("Onwards",Font.BOLD,18));
        account.setBounds(80,550,500,30);
        add(account);

        existingaccountY=new JRadioButton("YES");
        existingaccountY.setBounds(300,550,100,30);
        existingaccountY.setBackground(Color.lightGray);
        add(existingaccountY);

        existingaccountN=new JRadioButton("NO");
        existingaccountN.setBounds(400,550,100,30);
        existingaccountN.setBackground(Color.lightGray);
        add(existingaccountN);

        ButtonGroup existgrp=new ButtonGroup();
        existgrp.add(existingaccountY);
        existgrp.add(existingaccountN);


        next=new JButton("Next");
        next.setBounds(600,700,100,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        back=new JButton("Back");
        back.setBounds(80,700,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource()==back){
            setVisible(false);
            new Signup1().setVisible(true);
        }

        String sreligion = (String) name.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) inc.getSelectedItem();
        String squalification = (String) qualify.getSelectedItem();
        String soccupation = (String) occ.getSelectedItem();

        String citizenship = null;
        if (citizenshipY.isSelected()) {
            citizenship = "YES";
        } else if (citizenshipN.isSelected()) {
            citizenship = "NO";
        }


        String existingacc = null;
        if (existingaccountY.isSelected()) {
            existingacc = "YES";
        } else if (existingaccountN.isSelected()) {
            existingacc = "NO";
        }

        String sPan = panText.getText();
        String sAadhar = aadharText.getText();


        try {
            if (sreligion.equals("")) {
                JOptionPane.showMessageDialog(null, "*Religion is Required");
            } else if (scategory.equals("")) {
                JOptionPane.showMessageDialog(null, "*Category Name is Required");
            } else if (sincome.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter your Income Details");
            } else if (squalification.equals("")) {
                JOptionPane.showMessageDialog(null, "* Qualification is required");
            } else if (soccupation.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter your Occupation");
            } else if (sPan.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter your Pan no");
            } else if (sAadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Aadhar no is required");
            }


//            else if (gender.equals("")){
//               JOptionPane.showMessageDialog(null,"Enter your Gender");
//            }
//
//            else if (marital.equals("")){
//                JOptionPane.showMessageDialog(null,"Enter your Marital Status");
//            }

            else {
                Conn c = new Conn();
                String query = "insert into signup2 values('" + formno + "','"+ sreligion + "','" + scategory + "','" + sincome + "','" + squalification + "','" + soccupation + "','" + sPan + "','" + sAadhar + "','" + citizenship + "','" + existingacc + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signup3(formno).setVisible(true);

            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
