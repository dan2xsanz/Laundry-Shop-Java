/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryshop;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static laundryshop.FormDesign.location;


/**
 *
 * @author USER
 */
public class LogInForm extends JFrame implements  ActionListener
{       JPanel topPanel = new JPanel();
    JLabel picture = new JLabel();
    JLabel icon1 = new JLabel();
    JPanel bottomPanel = new JPanel();
    JButton viewTotal=new JButton("Log In");
    JButton cancel =new JButton("Exit");
        JLabel fullPanel = new JLabel();
         JLabel lblCredits = new JLabel("MF Oraño, JE Mamolo,DL Sanz");
         JLabel lblCredits2 = new JLabel("All Rights Reserved 2019 - BS Information Technology 2A");
  JLabel lblTitle = new JLabel("Laundry Shop");
    JLabel lblClose = new JLabel("X");
    
    JLabel password = new JLabel("Password: ");
    JPasswordField txtpassword = new JPasswordField("");
   public LogInForm()
    {
        setSize(700, 240);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setFont(new  Font("Calibri", 0, 10)); // NOI18N
        setForeground(new Color(255, 255, 255));
        setUndecorated(true);
        setVisible(true);

        fullPanel.setIcon( new ImageIcon(location + "addcust.jpg"));
        fullPanel.setBackground(new Color(0,59,147));
        fullPanel.setBounds(-200, 0, 900, 500);
        fullPanel.setLayout(null);
        add(fullPanel);
        
        picture.setBounds(790, 20, 150,150);
        picture.setIcon( new ImageIcon(location + "washing.png"));
        
//            icon1.setBounds(470, 230, 40, 40);
//        icon1.setIcon( new ImageIcon(location + "Unlock.png"));
//     
//      
        
        txtpassword.setBounds(490, 170, 200, 25);
        txtpassword.setFont(new  Font("Calibri", 0, 15));
        txtpassword.setForeground(Color.WHITE);
        txtpassword.setOpaque(false);
        txtpassword.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        lblTitle.setFont(new  Font("Calibri", 1, 50));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(390, 30, 400, 100);
        lblTitle.setVerticalAlignment(SwingConstants.CENTER);
        lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
        
        lblCredits.setFont(new  Font("Calibri", 0, 12));
        lblCredits.setForeground(Color.WHITE);
        lblCredits.setBounds(388, 65, 400, 100);
        lblCredits.setVerticalAlignment(SwingConstants.CENTER);
        lblCredits.setHorizontalAlignment(SwingConstants.RIGHT);
        
        lblCredits2.setFont(new  Font("Calibri", 0, 12));
        lblCredits2.setForeground(Color.WHITE);
        lblCredits2.setBounds(390,80, 400, 100);
        lblCredits2.setVerticalAlignment(SwingConstants.CENTER);
        lblCredits2.setHorizontalAlignment(SwingConstants.RIGHT);
        
        topPanel.setBackground(new Color(0,0,102));
        topPanel.setBounds(0, 0, 900, 20);
        topPanel.setLayout(null);
  
        topPanel.add(lblClose);
   
     bottomPanel.setBackground(new Color(0,0,102));
        bottomPanel.setBounds(0, 220, 1000, 30);
        bottomPanel.setLayout(null);
        
         viewTotal.setFont(new  Font("Calibri", 0, 14));
        viewTotal.setBounds(700, 170, 90, 25);
        viewTotal.setVerticalAlignment(SwingConstants.CENTER);
        viewTotal.setHorizontalAlignment(SwingConstants.CENTER);
        viewTotal.setForeground(Color.WHITE);
        viewTotal.setBackground(new Color(13,52,200));
        viewTotal.setOpaque(false);
        
         cancel.setFont(new  Font("Calibri", 0, 14));
        cancel.setBounds(795, 170, 90, 25);
        cancel.setVerticalAlignment(SwingConstants.CENTER);
        cancel.setHorizontalAlignment(SwingConstants.CENTER);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(new Color(13,52,200));
        cancel.setOpaque(false);
        
        fullPanel.add(cancel);
        fullPanel.add(icon1);
             fullPanel.add(viewTotal);
        fullPanel.add(lblCredits);
        fullPanel.add(picture);
        fullPanel.add(topPanel);
        fullPanel.add(lblTitle);
        fullPanel.add(lblCredits2);
         fullPanel.add(bottomPanel);
         fullPanel.add(txtpassword);
         fullPanel.add(password);
         
   viewTotal.addActionListener(this);
   txtpassword.addActionListener(this);
   cancel.addActionListener(this);
    } 
    
      public void actionPerformed(ActionEvent e) 
     {
         if (e.getSource()==txtpassword) 
         {
             
         }
         if (e.getSource()==viewTotal)
         {
             if (txtpassword.getText().equals("password")) 
             {
                 new Home();
                 dispose();
                 JOptionPane.showMessageDialog(this,"Successfully Log In", "Log In", JOptionPane.INFORMATION_MESSAGE);
      
              
             }
             else
             {
                   JOptionPane.showMessageDialog(this,"Invalid Input", "Wrong Password", JOptionPane.WARNING_MESSAGE);
                txtpassword.setText("");
             }
         }
         
         
         if (e.getSource()==cancel) 
         {
             
              dispose();
         }
     } 
  
    
}
