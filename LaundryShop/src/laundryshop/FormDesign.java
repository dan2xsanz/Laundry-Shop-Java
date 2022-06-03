
package laundryshop;


import laundryshop.Home;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;

public class FormDesign extends JFrame implements MouseListener {

    public static String location = "C:\\Users\\Sanz\\Desktop\\LaundryShop\\";


    JLabel fullPanel = new JLabel();
    JLabel botPanel = new JLabel();
    JPanel bottomPanel = new JPanel();
    JPanel topPanel = new JPanel();


    JLabel icon1 = new JLabel();
    JLabel icon2 = new JLabel();
    JLabel icon3 = new JLabel();
    JLabel icon4 = new JLabel();
    JLabel icon5 = new JLabel();
    JLabel icon6 = new JLabel();
    JLabel icon7 = new JLabel();
    JLabel icon8 = new JLabel();

    JLabel lblFormTitle = new JLabel("Laundry Shop");
    JLabel lblClose = new JLabel("X");

    public FormDesign()
    {
        setSize(900, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(51, 51, 51));
        setFont(new  Font("Calibri", 0, 10)); // NOI18N
        setForeground(new Color(255, 255, 255));
        setUndecorated(true);
        setVisible(true);


        icon1.setBounds(150, 2, 40, 40);
        icon1.setIcon( new ImageIcon(location + "Home_A.png"));
        icon1.setToolTipText("Home");

        icon2.setBounds(260,2, 40, 40);
        icon2.setIcon( new ImageIcon(location + "AddCostumers_A.png"));
        icon2.setToolTipText("Add Costumers");

        icon3.setBounds(375, 2, 40, 40);
        icon3.setIcon( new ImageIcon(location + "ViewData_A.png"));
        icon3.setToolTipText("View Costumers");

        icon4.setBounds(490, 2, 40, 40);
        icon4.setIcon( new ImageIcon(location + "Update_A.png"));
        icon4.setToolTipText("Update Logs");

        icon5.setBounds(600, 2, 40, 40);
        icon5.setIcon( new ImageIcon(location + "Reports_A.png"));
        icon5.setToolTipText("View Report");

        icon6.setBounds(700, 2, 40, 40);
        icon6.setIcon( new ImageIcon(location + "SignOut_A.png"));
        icon6.setToolTipText("Sign Out Application");

//        icon7.setBounds(750, 10, 30, 30);
//        icon7.setIcon( new ImageIcon(location + "Transaction_B.png"));
//        icon7.setToolTipText("Fines Transactions");

        lblFormTitle.setBounds(7, 3, 500, 25);
        lblFormTitle.setFont(new  Font("Calibri", 1, 14));
        lblFormTitle.setForeground(Color.WHITE);
        lblFormTitle.setVerticalAlignment(SwingConstants.CENTER);
        lblFormTitle.setHorizontalAlignment(SwingConstants.LEADING);

        lblClose.setBounds(840, 3, 50, 25);
        lblClose.setFont(new  Font("Calibri", 1, 14));
        lblClose.setForeground(Color.WHITE);
        lblClose.setVerticalAlignment(SwingConstants.CENTER);
        lblClose.setHorizontalAlignment(SwingConstants.RIGHT);

         fullPanel.setIcon( new ImageIcon(location + "addcust.jpg"));
        fullPanel.setBackground(new Color(0,59,147));
        fullPanel.setBounds(0, 0, 900, 500);
        fullPanel.setLayout(null);
        fullPanel.add(botPanel);
        fullPanel.add(topPanel);
        fullPanel.add(bottomPanel);


        topPanel.setBackground(new Color(0,0,102));
        topPanel.setBounds(0, 0, 900, 23);
        topPanel.setLayout(null);
        topPanel.add(lblFormTitle);
        topPanel.add(lblClose);

botPanel.setIcon( new ImageIcon(location + "addcust.jpg"));
        botPanel.setBackground(new Color(13,52,200));
        botPanel.setPreferredSize(new Dimension(75, 448));
        botPanel.setBounds(0, 425, 900, 43);
        botPanel.setLayout(null);
        botPanel.add(icon1);
        botPanel.add(icon2);
        botPanel.add(icon3);
        botPanel.add(icon4);
        botPanel.add(icon5);
        botPanel.add(icon6);
        botPanel.add(icon7);

        bottomPanel.setBackground(new Color(0,0,102));
        bottomPanel.setBounds(0, 475, 1000, 30);
        bottomPanel.setLayout(null);

        add(fullPanel);

        icon1.addMouseListener(this);
        icon2.addMouseListener(this);
        icon3.addMouseListener(this);
        icon4.addMouseListener(this);
        icon5.addMouseListener(this);
        icon6.addMouseListener(this);
        icon7.addMouseListener(this);

        lblClose.addMouseListener(this);

    }


    @Override
    public void mouseClicked(MouseEvent me) {

        if(me.getSource() == icon1)
        {
            new Home();
            dispose();
            
        }
        if(me.getSource() == icon2)
        {
            new AddCostmers();
            dispose();
        }
        if(me.getSource() == icon3)
        {
            new ViewCostumers();
            dispose();
        }
        if(me.getSource() == icon4)
        {
            new UpdateData();
            dispose();
        }
       
        if(me.getSource() == icon5)
        {
            new Reports();
            dispose();
        }
         if(me.getSource() == icon6)
        {
           
            icon6.setIcon( new ImageIcon(location + "SignOut_B.png"));
            new LogInForm();
           dispose();
        }
       
        if(me.getSource() == lblClose)
        {
           
           dispose();
        }

    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(me.getSource() == lblClose)
        {
            lblClose.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if(me.getSource() == lblClose)
        {
            lblClose.setForeground(Color.BLUE);
        }
        
       
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if(me.getSource() == lblClose)
        {
            lblClose.setForeground(Color.WHITE);
        }
    }

}
