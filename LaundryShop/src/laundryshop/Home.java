package laundryshop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*; 

public class Home extends FormDesign implements ActionListener
{

     
     
    JLabel picture = new JLabel();
    JLabel design = new JLabel();
    JLabel lblCredits = new JLabel("MF Oraño, JE Mamolo,DL Sanz");
    JLabel lblCredits2 = new JLabel("All Rights Reserved 2019 - BS Information Technology 2A");
    JLabel lblTime = new JLabel("10:00 AM");
    JLabel lblDate = new JLabel("Tuesday, December 20, 2019");
    JLabel lblTitle = new JLabel("Laundry Shop");

    public Home()
    {
        
       
        
        // Form
        
        setTitle("Laundry Shop");
        lblFormTitle.setText("Home");
        icon1.setIcon( new ImageIcon(location + "Home_B.png"));
         
        picture.setBounds(790, 48, 150,150);
        picture.setIcon( new ImageIcon(location + "washing.png"));
        
        design.setBounds(580, 150, 350,300);
        design.setIcon( new ImageIcon(location + "step2_v2.gif"));
      
        
        
        lblTitle.setFont(new  Font("Calibri", 1, 70));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(390, 50, 400, 100);
        lblTitle.setVerticalAlignment(SwingConstants.CENTER);
        lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
        
        lblCredits.setFont(new  Font("Calibri", 0, 12));
        lblCredits.setForeground(Color.WHITE);
        lblCredits.setBounds(390, 95, 400, 100);
        lblCredits.setVerticalAlignment(SwingConstants.CENTER);
        lblCredits.setHorizontalAlignment(SwingConstants.RIGHT);
        
        lblCredits2.setFont(new  Font("Calibri", 0, 12));
        lblCredits2.setForeground(Color.WHITE);
        lblCredits2.setBounds(390,110, 400, 100);
        lblCredits2.setVerticalAlignment(SwingConstants.CENTER);
        lblCredits2.setHorizontalAlignment(SwingConstants.RIGHT);
        
       
        fullPanel.add(picture);
         fullPanel.add(design);
        fullPanel.add(lblCredits);
        fullPanel.add(lblTime);
        fullPanel.add(lblDate);
        fullPanel.add(lblTitle);
        fullPanel.add(lblCredits2);
              
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }

        
        
    
    
    
}
