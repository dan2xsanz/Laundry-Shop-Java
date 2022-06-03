
package laundryshop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

public class AddCostmers extends FormDesign implements ActionListener{
    
      Connection myConnection=null;
        Statement myStatement=null;
        ResultSet myResult=null;
    
         JLabel washing = new JLabel();
       
        
    Date date=new Date();
    
    JButton check=new JButton("Check Record");
     
    DateFormat dateFor=new SimpleDateFormat("MMMM dd,yyyy hh:mm a");
     Date da=new Date();
    JLabel curday=new JLabel(dateFor.format(da));
      
    JLabel lblcustNum = new JLabel("Costumer Number: ");
    JTextField txtcustNum = new JTextField();
    JPanel line = new JPanel();
    
    JPanel line1 = new JPanel();
    JLabel lblFname = new JLabel("First Name : ");
    JTextField txtFname = new JTextField();
    
    JPanel line2 = new JPanel();
    JLabel lblLname = new JLabel("Last Name : ");
    JTextField txtLname = new JTextField();
    
    JPanel line3 = new JPanel();
    JLabel address = new JLabel(" Address : ");
    JTextField txtaddress = new JTextField();
  
    JPanel line4 = new JPanel();
    JLabel contact = new JLabel(" Contact No. : ");
    JTextField txtcontact = new JTextField();
    
    JCheckBox checkOwnService=new JCheckBox("Own Service");
    JLabel lblPerKilo = new JLabel("Per Kilo: ");
    JTextField txtPerKilo = new JTextField("20");
    JLabel lblNoOfKilo = new JLabel("How many kilo: ");
    JTextField txtNoOfKilo = new JTextField("0");
    
    JCheckBox checkProvideService=new JCheckBox("Provide Service");
    JLabel provlblPerKilo = new JLabel("Per Kilo: ");
    JTextField provtxtPerKilo = new JTextField("30");
    JLabel provlblNoOfKilo = new JLabel("How many kilo: ");
    JTextField provtxtNoOfKilo = new JTextField("0");
   
    JLabel items = new JLabel("Items");
    
    JLabel shirt = new JLabel("T-Shirt/Shirt");
    JTextField noOfshirt = new JTextField("0");
    
    JLabel jeans = new JLabel("Jeans/Pants");
    JTextField noOfJeans = new JTextField("0");
    
    JLabel sweater = new JLabel("Sweater");
    JTextField noOfSweater = new JTextField("0");
  
    JLabel suit = new JLabel("Suit");
    JTextField noOfSuit = new JTextField("0");
  
    JLabel curtain = new JLabel("Curtain");
    JTextField noOfCurtain = new JTextField("0");
    
    JLabel blanket = new JLabel("Blanket");
    JTextField noOfBlanket = new JTextField("0");
    
    JLabel noOfItems = new JLabel("No. of Items");
    
    
    JLabel items2   = new JLabel("Items");
    
   JLabel noOfItems2 = new JLabel("No. of Items");
    
    JLabel pajama = new JLabel("Pajama");
    JTextField noOfpajama = new JTextField("0");
    
     JLabel blouse = new JLabel("Blouse");
    JTextField noOfblouse = new JTextField("0");
    
     JLabel underwear = new JLabel("Underwear");
    JTextField noOfunderwear = new JTextField("0");
    
     JLabel skirt = new JLabel("Skirt");
    JTextField noOfskirt = new JTextField("0");
    
     JLabel shorts = new JLabel("Shorts");
    JTextField noOfshorts = new JTextField("0");
    
    JLabel socks = new JLabel("Socks(pair)");
    JTextField noOfsocks = new JTextField("0");
    
    JButton viewTotal=new JButton("Calculate Total Payment");
    JLabel lblTotal = new JLabel("Total Payment: ");
    JLabel totalPayment = new JLabel("0000");
    
    JRadioButton checkTender =new JRadioButton("Tender");
    JTextField txtTender = new JTextField("");
    JLabel lblchange = new JLabel(" Change: ");
    JLabel change = new JLabel("0000");
    JButton calculate =new JButton("Calculate");
    
    JRadioButton checkDeposit =new JRadioButton("Deposit");
    JTextField txtDeposit = new JTextField("");
    JLabel lblbalance = new JLabel("Balance : ");
    JLabel balance = new JLabel("0000");
    JButton calculateBalance =new JButton("Calculate Balance");
    
    JButton save=new JButton("Save Records");
    JButton cancel=new JButton("Cancel Records");
    
    public AddCostmers()
    {
        //Form
        setTitle("Add Costumers");
        lblFormTitle.setText("ADD COSTUMERS FORM");
        icon2.setIcon( new ImageIcon(location + "AddCostumers_B.png"));
        
          
       
//        Controls
        curday.setFont(new  Font("Calibri", 1,20));
        curday.setForeground(Color.WHITE);
        curday.setBounds(580, -8, 400, 100);
        curday.setVerticalAlignment(SwingConstants.CENTER);
        curday.setHorizontalAlignment(SwingConstants.LEFT);     
           
        lblcustNum.setFont(new  Font("Calibri", 0, 12));
        lblcustNum.setForeground(Color.WHITE);
        lblcustNum.setBounds(5, 30, 130, 25);
        lblcustNum.setVerticalAlignment(SwingConstants.CENTER);
        lblcustNum.setHorizontalAlignment(SwingConstants.RIGHT);
        
        txtcustNum.setBounds(140, 30, 150, 25);
        txtcustNum.setFont(new  Font("Calibri", 0, 12));
        txtcustNum.setForeground(Color.WHITE);
        txtcustNum.setBorder(null);
        txtcustNum.setOpaque(false);
        txtcustNum.setHorizontalAlignment(SwingConstants.CENTER);
        
        check.setFont(new  Font("Calibri", 0, 12));
         check.setBounds(317, 30, 120, 20);
         check.setVerticalAlignment(SwingConstants.CENTER);
         check.setHorizontalAlignment(SwingConstants.CENTER);
         check.setForeground(Color.WHITE);
         check.setBackground(new Color(0,59,147));
        check.setOpaque(false);
         
        line.setBounds(140, 50, 150, 2);
        line.setOpaque(true);
        line.setBackground(Color.LIGHT_GRAY);
        
        lblFname.setFont(new  Font("Calibri", 0, 12));
        lblFname.setForeground(Color.WHITE);
        lblFname.setBounds(5, 55, 130, 25);
        lblFname.setVerticalAlignment(SwingConstants.CENTER);
        lblFname.setHorizontalAlignment(SwingConstants.RIGHT);
        
        txtFname.setBounds(140, 55, 150, 25);
        txtFname.setFont(new  Font("Calibri", 0, 12));
        txtFname.setForeground(Color.WHITE);
        txtFname.setBorder(null);
        txtFname.setOpaque(false);
        txtFname.setHorizontalAlignment(SwingConstants.CENTER);
        
        line1.setBounds(140, 75, 150, 2);
        line1.setOpaque(true);
        line1.setBackground(Color.LIGHT_GRAY);
        
        lblLname.setFont(new  Font("Calibri", 0, 12));
        lblLname.setForeground(Color.WHITE);
        lblLname.setBounds(5, 83, 130, 25);
        lblLname.setVerticalAlignment(SwingConstants.CENTER);
        lblLname.setHorizontalAlignment(SwingConstants.RIGHT);
        
        txtLname.setBounds(140, 83, 150, 25);
        txtLname.setFont(new  Font("Calibri", 0, 12));
        txtLname.setForeground(Color.WHITE);
        txtLname.setBorder(null);
        txtLname.setOpaque(false);
        txtLname.setHorizontalAlignment(SwingConstants.CENTER);
        
        line2.setBounds(140, 102, 150, 2);
        line2.setOpaque(true);
        line2.setBackground(Color.LIGHT_GRAY);
        
        address.setFont(new  Font("Calibri", 0, 12));
        address.setForeground(Color.WHITE);
        address.setBounds(5, 110, 130, 25);
        address.setVerticalAlignment(SwingConstants.CENTER);
        address.setHorizontalAlignment(SwingConstants.RIGHT);
        
        txtaddress.setBounds(140, 110, 150, 25);
        txtaddress.setFont(new  Font("Calibri", 0, 12));
        txtaddress.setForeground(Color.WHITE);
        txtaddress.setBorder(null);
        txtaddress.setOpaque(false);
        txtaddress.setHorizontalAlignment(SwingConstants.CENTER);
        
        line3.setBounds(140, 129, 150, 2);
        line3.setOpaque(true);
        line3.setBackground(Color.LIGHT_GRAY);
        
        
         contact.setFont(new  Font("Calibri", 0, 12));
        contact.setForeground(Color.WHITE);
        contact.setBounds(5, 140, 130, 25);
        contact.setVerticalAlignment(SwingConstants.CENTER);
        contact.setHorizontalAlignment(SwingConstants.RIGHT);
        
        txtcontact.setBounds(140, 140, 150, 25);
        txtcontact.setFont(new  Font("Calibri", 0, 12));
        txtcontact.setForeground(Color.WHITE);
        txtcontact.setBorder(null);
        txtcontact.setOpaque(false);
        txtcontact.setHorizontalAlignment(SwingConstants.CENTER);
        
        line4.setBounds(140, 159, 150, 2);
        line4.setOpaque(true);
        line4.setBackground(Color.LIGHT_GRAY);
        
        viewTotal.setFont(new  Font("Calibri", 0, 14));
        viewTotal.setBounds(70, 167, 220, 25);
        viewTotal.setVerticalAlignment(SwingConstants.CENTER);
        viewTotal.setHorizontalAlignment(SwingConstants.CENTER);
        viewTotal.setForeground(Color.WHITE);
        viewTotal.setBackground(new Color(13,52,200));
        viewTotal.setOpaque(false);
         
        lblTotal.setFont(new  Font("Calibri", 0, 12));
        lblTotal.setForeground(Color.WHITE);
        lblTotal.setBounds(70, 200, 130, 25);
        lblTotal.setVerticalAlignment(SwingConstants.CENTER);
        lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
        lblTotal.setVisible(false);
        
        totalPayment.setFont(new  Font("Calibri", 0, 12));
        totalPayment.setForeground(Color.WHITE);
        totalPayment.setBounds(110, 200, 130, 25);
        totalPayment.setVerticalAlignment(SwingConstants.CENTER);
        totalPayment.setHorizontalAlignment(SwingConstants.RIGHT);
        totalPayment.setVisible(false);
        
        checkTender.setFont(new  Font("Calibri", 0, 12));
        checkTender.setForeground(Color.WHITE);
        checkTender.setBounds(90, 220, 70, 25);
        checkTender.setBackground(new Color(0,59,147)); 
        checkTender.setOpaque(false);
       
        txtTender.setBounds(160, 220,130, 20);
        txtTender.setFont(new  Font("Calibri", 0, 12));
        txtTender.setForeground(Color.WHITE);
        txtTender.setOpaque(false);
        txtTender.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblchange.setBounds(106, 245,130, 20);
        lblchange.setFont(new  Font("Calibri", 0, 12));
        lblchange.setForeground(Color.WHITE);
        lblchange.setOpaque(false);
        
        change.setFont(new  Font("Calibri", 0, 12));
        change.setForeground(Color.WHITE);
        change.setBounds(110, 245, 130, 25);
        change.setVerticalAlignment(SwingConstants.CENTER);
        change.setHorizontalAlignment(SwingConstants.RIGHT);
        
        calculate.setFont(new  Font("Calibri", 0, 12));
        calculate.setBounds(95, 265, 195, 20);
        calculate.setVerticalAlignment(SwingConstants.CENTER);
        calculate.setHorizontalAlignment(SwingConstants.CENTER);
        calculate.setForeground(Color.WHITE);
        calculate.setBackground(new Color(0,59,147));
        
        checkDeposit.setFont(new  Font("Calibri", 0, 12));
        checkDeposit.setForeground(Color.WHITE);
        checkDeposit.setBounds(90, 290, 70, 25);
        checkDeposit.setBackground(new Color(0,59,147)); 
       
        txtDeposit.setBounds(160, 290,130, 20);
        txtDeposit.setFont(new  Font("Calibri", 0, 12));
        txtDeposit.setForeground(Color.WHITE);
        txtDeposit.setOpaque(false);
        txtDeposit.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblbalance.setBounds(110, 310,130, 20);
        lblbalance.setFont(new  Font("Calibri", 0, 12));
        lblbalance.setForeground(Color.WHITE);
        lblbalance.setOpaque(false);
        
        balance.setFont(new  Font("Calibri", 0, 12));
        balance.setForeground(Color.WHITE);
        balance.setBounds(110, 310, 130, 25);
        balance.setVerticalAlignment(SwingConstants.CENTER);
        balance.setHorizontalAlignment(SwingConstants.RIGHT);
        
        calculateBalance.setFont(new  Font("Calibri", 0, 12));
        calculateBalance.setBounds(95, 330, 195, 20);
        calculateBalance.setVerticalAlignment(SwingConstants.CENTER);
        calculateBalance.setHorizontalAlignment(SwingConstants.CENTER);
        calculateBalance.setForeground(Color.WHITE);
        calculateBalance.setBackground(new Color(0,59,147));
        
        save.setFont(new  Font("Calibri", 0, 14));
        save.setBounds(95, 370, 195, 25);
        save.setVerticalAlignment(SwingConstants.CENTER);
        save.setHorizontalAlignment(SwingConstants.CENTER);
        save.setForeground(Color.WHITE);
        save.setBackground(new Color(13,52,200));
        save.setOpaque(false);
        
        cancel.setFont(new  Font("Calibri", 0, 14));
        cancel.setBounds(95, 395, 195, 25);
        cancel.setVerticalAlignment(SwingConstants.CENTER);
        cancel.setHorizontalAlignment(SwingConstants.CENTER);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(new Color(13,52,200));
        cancel.setOpaque(false);
        
        //Check Own Service Checkbox
        checkOwnService.setFont(new  Font("Calibri", 0, 16));
        checkOwnService.setForeground(Color.WHITE);
        checkOwnService.setBounds(315, 55, 110, 25);
        checkOwnService.setBackground(new Color(0,59,147)); 
         
        lblPerKilo.setFont(new  Font("Calibri", 0, 12));
        lblPerKilo.setForeground(Color.WHITE);
        lblPerKilo.setBounds(450, 55, 50, 25);
        
        txtPerKilo.setBounds(500, 55, 100, 20);
        txtPerKilo.setFont(new  Font("Calibri", 0, 12));
        txtPerKilo.setForeground(Color.WHITE);
        txtPerKilo.setOpaque(false);
        txtPerKilo.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblNoOfKilo.setFont(new  Font("Calibri", 0, 12));
        lblNoOfKilo.setForeground(Color.WHITE);
        lblNoOfKilo.setBounds(610, 55, 100, 25);
        
        txtNoOfKilo.setBounds(700, 55, 100, 20);
        txtNoOfKilo.setFont(new  Font("Calibri", 0, 12));
        txtNoOfKilo.setForeground(Color.WHITE);
        txtNoOfKilo.setOpaque(false);
        txtNoOfKilo.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Check Provide Service Checkbox
        checkProvideService.setFont(new  Font("Calibri", 0, 16));
        checkProvideService.setForeground(Color.WHITE);
        checkProvideService.setBounds(315, 85, 130, 25);
        checkProvideService.setBackground(new Color(0,59,147)); 
                
        provlblPerKilo.setFont(new  Font("Calibri", 0, 12));
        provlblPerKilo.setForeground(Color.WHITE);
        provlblPerKilo.setBounds(450, 85, 50, 25);
        
        provtxtPerKilo.setBounds(500, 85, 100, 20);
        provtxtPerKilo.setFont(new  Font("Calibri", 0, 12));
        provtxtPerKilo.setForeground(Color.WHITE);
        provtxtPerKilo.setOpaque(false);
        provtxtPerKilo.setHorizontalAlignment(SwingConstants.CENTER);
    
        provlblNoOfKilo.setFont(new  Font("Calibri", 0, 12));
        provlblNoOfKilo.setForeground(Color.WHITE);
        provlblNoOfKilo.setBounds(610, 85, 100, 25);
        
        provtxtNoOfKilo.setBounds(700, 85, 100, 20);
        provtxtNoOfKilo.setFont(new  Font("Calibri", 0, 12));
        provtxtNoOfKilo.setForeground(Color.WHITE);
        provtxtNoOfKilo.setOpaque(false);
        provtxtNoOfKilo.setHorizontalAlignment(SwingConstants.CENTER);
  
      items.setFont(new  Font("Calibri", 0, 15));
        items.setForeground(Color.WHITE);
        items.setBounds(450, 145, 60, 25);
       
        noOfItems.setFont(new  Font("Calibri", 0, 15));
        noOfItems.setForeground(Color.WHITE);
        noOfItems.setBounds(522, 145, 100, 25);
        
        items2.setFont(new  Font("Calibri", 0, 15));
        items2.setForeground(Color.WHITE);
        items2.setBounds(650, 145, 100, 25);
        
        shirt.setFont(new  Font("Calibri", 0, 11));
        shirt.setForeground(Color.WHITE);
        shirt.setBounds(450, 180, 60, 25);
        noOfshirt.setBounds(520,180, 80, 20);
        noOfshirt.setFont(new  Font("Calibri", 0, 12));
        noOfshirt.setForeground(Color.WHITE);
        noOfshirt.setOpaque(false);
        noOfshirt.setHorizontalAlignment(SwingConstants.CENTER);
       
         noOfItems2.setFont(new  Font("Calibri", 0, 15));
        noOfItems2.setForeground(Color.WHITE);
        noOfItems2.setBounds(720, 145, 100, 25);
        
         blouse.setFont(new  Font("Calibri", 0, 12));
        blouse.setForeground(Color.WHITE);
        blouse.setBounds(650, 180, 60, 25);
        noOfblouse.setBounds(720,180, 80, 20);
        noOfblouse.setFont(new  Font("Calibri", 0, 12));
        noOfblouse.setForeground(Color.WHITE);
        noOfblouse.setOpaque(false);
        noOfblouse.setHorizontalAlignment(SwingConstants.CENTER);
        
        pajama.setFont(new  Font("Calibri", 0, 12));
        pajama.setForeground(Color.WHITE);
        pajama.setBounds(650, 210, 60, 25);
        noOfpajama.setBounds(720,210, 80, 20);
        noOfpajama.setFont(new  Font("Calibri", 0, 12));
        noOfpajama.setForeground(Color.WHITE);
        noOfpajama.setOpaque(false);
        noOfpajama.setHorizontalAlignment(SwingConstants.CENTER);
        
        underwear.setFont(new  Font("Calibri", 0, 12));
        underwear.setForeground(Color.WHITE);
        underwear.setBounds(650, 240, 60, 25);
        noOfunderwear.setBounds(720,240, 80, 20);
        noOfunderwear.setFont(new  Font("Calibri", 0, 12));
        noOfunderwear.setForeground(Color.WHITE);
        noOfunderwear.setOpaque(false);
        noOfunderwear.setHorizontalAlignment(SwingConstants.CENTER);
        
        skirt.setFont(new  Font("Calibri", 0, 12));
        skirt.setForeground(Color.WHITE);
        skirt.setBounds(650, 270, 60, 25);
        noOfskirt.setBounds(720,270, 80, 20);
        noOfskirt.setFont(new  Font("Calibri", 0, 12));
        noOfskirt.setForeground(Color.WHITE);
        noOfskirt.setOpaque(false);
        noOfskirt.setHorizontalAlignment(SwingConstants.CENTER);
        
        shorts.setFont(new  Font("Calibri", 0, 12));
        shorts.setForeground(Color.WHITE);
        shorts.setBounds(650, 300, 60, 25);
        noOfshorts.setBounds(720,300, 80, 20);
        noOfshorts.setFont(new  Font("Calibri", 0, 12));
        noOfshorts.setForeground(Color.WHITE);
        noOfshorts.setOpaque(false);
        noOfshorts.setHorizontalAlignment(SwingConstants.CENTER);
        
         socks.setFont(new  Font("Calibri", 0, 12));
        socks.setForeground(Color.WHITE);
        socks.setBounds(650, 330, 60, 25);
        noOfsocks.setBounds(720,330, 80, 20);
        noOfsocks.setFont(new  Font("Calibri", 0, 12));
        noOfsocks.setForeground(Color.WHITE);
        noOfsocks.setOpaque(false);
        noOfsocks.setHorizontalAlignment(SwingConstants.CENTER);
        
        jeans.setFont(new  Font("Calibri", 0, 11));
        jeans.setForeground(Color.WHITE);
        jeans.setBounds(450, 210, 60, 25);
        noOfJeans.setBounds(520,210, 80, 20);
        noOfJeans.setFont(new  Font("Calibri", 0, 12));
        noOfJeans.setForeground(Color.WHITE);
        noOfJeans.setOpaque(false);
        noOfJeans.setHorizontalAlignment(SwingConstants.CENTER);
       
        sweater.setFont(new  Font("Calibri", 0, 12));
        sweater.setForeground(Color.WHITE);
        sweater.setBounds(450, 240, 60, 25);
        noOfSweater.setBounds(520,240, 80, 20);
        noOfSweater.setFont(new  Font("Calibri", 0, 12));
        noOfSweater.setForeground(Color.WHITE);
        noOfSweater.setOpaque(false);
        noOfSweater.setHorizontalAlignment(SwingConstants.CENTER);
           
        suit.setFont(new  Font("Calibri", 0, 12));
        suit.setForeground(Color.WHITE);
        suit.setBounds(450, 270, 60, 25);
        noOfSuit.setBounds(520,270, 80, 20);
        noOfSuit.setFont(new  Font("Calibri", 0, 12));
        noOfSuit.setForeground(Color.WHITE);
        noOfSuit.setOpaque(false);
        noOfSuit.setHorizontalAlignment(SwingConstants.CENTER);
         
        curtain.setFont(new  Font("Calibri", 0, 12));
        curtain.setForeground(Color.WHITE);
        curtain.setBounds(450, 300, 60, 25);
        noOfCurtain.setBounds(520,300, 80, 20);
        noOfCurtain.setFont(new  Font("Calibri", 0, 12));
        noOfCurtain.setForeground(Color.WHITE);
        noOfCurtain.setOpaque(false);
        noOfCurtain.setHorizontalAlignment(SwingConstants.CENTER);
        
        blanket.setFont(new  Font("Calibri", 0, 12));
        blanket.setForeground(Color.WHITE);
        blanket.setBounds(450, 330, 60, 25);
        noOfBlanket.setBounds(520,330, 80, 20);
        noOfBlanket.setFont(new  Font("Calibri", 0, 12));
        noOfBlanket.setForeground(Color.WHITE);
        noOfBlanket.setOpaque(false);
        noOfBlanket.setHorizontalAlignment(SwingConstants.CENTER);
        
         
        fullPanel.add(lblcustNum);
        fullPanel.add(txtcustNum);
        fullPanel.add(line);

        fullPanel.add( check);   
        
        fullPanel.add(curday);   
        
        fullPanel.add(lblFname);
        fullPanel.add(txtFname);
        fullPanel.add(line1);
        
        fullPanel.add(lblLname);
        fullPanel.add(txtLname);
        fullPanel.add(line2);
        
        fullPanel.add(address);
        fullPanel.add(txtaddress);
        fullPanel.add(line3);
        
         fullPanel.add(contact);
        fullPanel.add(txtcontact);
        fullPanel.add(line4);
        
        fullPanel.add(viewTotal);
        viewTotal.setVisible(false);
        fullPanel.add(lblTotal);
        fullPanel.add(totalPayment);
        
        fullPanel.add(checkTender);
        fullPanel.add(txtTender);
        fullPanel.add(lblchange);
        fullPanel.add(change);
        fullPanel.add(calculate);
        checkTender.setVisible(false);
        txtTender.setVisible(false);
        lblchange.setVisible(false);
        change.setVisible(false);
        calculate.setVisible(false);
        checkTender.setEnabled(false);
        txtTender.setEnabled(false);
        lblchange.setEnabled(false);
        change.setEnabled(false);
        calculate.setEnabled(false);
        
        fullPanel.add(checkDeposit);
         checkDeposit.setOpaque(false);
        fullPanel.add(txtDeposit);
        fullPanel.add(lblbalance);
        fullPanel.add(balance);
        fullPanel.add(calculateBalance);
        checkDeposit.setVisible(false);
        txtDeposit.setVisible(false);
        lblbalance.setVisible(false);
        balance.setVisible(false);
        calculateBalance.setVisible(false);
         checkDeposit.setEnabled(false);
        txtDeposit.setEnabled(false);
        lblbalance.setEnabled(false);
        balance.setEnabled(false);
        calculateBalance.setEnabled(false);
        fullPanel.add(save);
        fullPanel.add(cancel);
        save.setVisible(false);
        cancel.setVisible(false);
        
        fullPanel.add(checkOwnService);
        checkOwnService.setOpaque(false);
        fullPanel.add(lblPerKilo);
        fullPanel.add(txtPerKilo);
        fullPanel.add(lblNoOfKilo);
        fullPanel.add(txtNoOfKilo);
        lblPerKilo.setEnabled(false);
        txtPerKilo.setEnabled(false);
        lblNoOfKilo.setEnabled(false);
        txtNoOfKilo.setEnabled(false);
        
        fullPanel.add(checkProvideService);
        checkProvideService.setOpaque(false);
        fullPanel.add(provlblPerKilo);
        fullPanel.add(provtxtPerKilo);
        fullPanel.add(provlblNoOfKilo);
        fullPanel.add(provtxtNoOfKilo);
        provlblPerKilo.setEnabled(false);
        provtxtPerKilo.setEnabled(false);
        provlblNoOfKilo.setEnabled(false);
        provtxtNoOfKilo.setEnabled(false);
        
        fullPanel.add(washing);
        fullPanel.add(items);
        fullPanel.add(noOfItems);
        fullPanel.add(items2);
        items.setEnabled(false);
        noOfItems.setEnabled(false);
        items2.setEnabled(false);
        
        fullPanel.add(shirt);
        fullPanel.add(noOfshirt);
        shirt.setEnabled(false);
        noOfshirt.setEnabled(false);
        
        fullPanel.add(jeans);
        fullPanel.add(noOfJeans);
        jeans.setEnabled(false);
        noOfJeans.setEnabled(false);
        
        fullPanel.add(sweater);
        fullPanel.add(noOfSweater);
        sweater.setEnabled(false);
        noOfSweater.setEnabled(false);
        
        fullPanel.add(suit);
        fullPanel.add(noOfSuit);
        suit.setEnabled(false);
        noOfSuit.setEnabled(false);
        
        fullPanel.add(curtain);
        fullPanel.add(noOfCurtain);
        curtain.setEnabled(false);
        noOfCurtain.setEnabled(false);
        
        fullPanel.add(blanket);
        fullPanel.add(noOfBlanket);
        blanket.setEnabled(false);
        noOfBlanket.setEnabled(false);
        
        fullPanel.add(noOfItems2);
         noOfItems2.setEnabled(false);
         
        fullPanel.add(pajama);
        fullPanel.add(noOfpajama);
        pajama.setEnabled(false);
        noOfpajama.setEnabled(false);
        
        fullPanel.add(blouse);
        fullPanel.add(noOfblouse);
        blouse.setEnabled(false);
        noOfblouse.setEnabled(false);
        
         fullPanel.add(underwear);
        fullPanel.add(noOfunderwear);
        underwear.setEnabled(false);
        noOfunderwear.setEnabled(false);
        
         fullPanel.add(skirt);
        fullPanel.add(noOfskirt);
        skirt.setEnabled(false);
        noOfskirt.setEnabled(false);
        
         fullPanel.add(shorts);
        fullPanel.add(noOfshorts);
        shorts.setEnabled(false);
        noOfshorts.setEnabled(false);
        
          fullPanel.add(socks);
        fullPanel.add(noOfsocks);
        socks.setEnabled(false);
        noOfsocks.setEnabled(false);
        
        checkOwnService.addActionListener(this);
        checkProvideService.addActionListener(this);
        viewTotal.addActionListener(this);
        checkTender.addActionListener(this);
        checkDeposit.addActionListener(this);
        calculate.addActionListener(this);
        calculateBalance.addActionListener(this);
        save.addActionListener(this);
         check.addActionListener(this);
        
    }
     public void actionPerformed(ActionEvent e) 
     {
        
         if (checkOwnService.isSelected()) 
         {
             lblPerKilo.setEnabled(true);
             txtPerKilo.setEnabled(true);
             lblNoOfKilo.setEnabled(true);
             txtNoOfKilo.setEnabled(true);
         }
         else
         {
             lblPerKilo.setEnabled(false);
             txtPerKilo.setEnabled(false);
             lblNoOfKilo.setEnabled(false);
             txtNoOfKilo.setEnabled(false);
         }
        
         if (checkProvideService.isSelected()) 
         {
            provlblPerKilo.setEnabled(true);
            provtxtPerKilo.setEnabled(true);
            provlblNoOfKilo.setEnabled(true);
            provtxtNoOfKilo.setEnabled(true);  
            
            
            items.setEnabled(true);
            noOfItems.setEnabled(true);
            
            items2.setEnabled(true);
             noOfItems2.setEnabled(true);
            
            shirt.setEnabled(true);
            noOfshirt.setEnabled(true);
            
             jeans.setEnabled(true);
             noOfJeans.setEnabled(true);
             
            sweater.setEnabled(true);
            noOfSweater.setEnabled(true);
        
            suit.setEnabled(true);
            noOfSuit.setEnabled(true);
        
             curtain.setEnabled(true);
            noOfCurtain.setEnabled(true);
        
           blanket.setEnabled(true);
            noOfBlanket.setEnabled(true);
            
            pajama.setEnabled(true);
            noOfpajama.setEnabled(true);
            
            blouse.setEnabled(true);
            noOfblouse.setEnabled(true);
            
            skirt.setEnabled(true);
            noOfskirt.setEnabled(true);
            
            shorts.setEnabled(true);
            noOfshorts.setEnabled(true);
           
            socks.setEnabled(true);
            noOfsocks.setEnabled(true);
            
            underwear.setEnabled(true);
            noOfunderwear.setEnabled(true);
         }
         else
         {
            provlblPerKilo.setEnabled(false);
            provtxtPerKilo.setEnabled(false);
            provlblNoOfKilo.setEnabled(false);
            provtxtNoOfKilo.setEnabled(false);
       
            
         
             items.setEnabled(false);
             noOfItems.setEnabled(false);
             
             items2.setEnabled(false);
             noOfItems2.setEnabled(false);
             
             shirt.setEnabled(false);
             noOfshirt.setEnabled(false);
             
            jeans.setEnabled(false);
            noOfJeans.setEnabled(false);
         
             sweater.setEnabled(false);
            noOfSweater.setEnabled(false);
            
             suit.setEnabled(false);
             noOfSuit.setEnabled(false);
        
             curtain.setEnabled(false);
            noOfCurtain.setEnabled(false);
        
           blanket.setEnabled(false);
            noOfBlanket.setEnabled(false);
            
              pajama.setEnabled(false);
            noOfpajama.setEnabled(false);
            
            blouse.setEnabled(false);
            noOfblouse.setEnabled(false);
            
            skirt.setEnabled(false);
            noOfskirt.setEnabled(false);
            
            shorts.setEnabled(false);
            noOfshorts.setEnabled(false);
           
            socks.setEnabled(false);
            noOfsocks.setEnabled(false);
            
            underwear.setEnabled(false);
            noOfunderwear.setEnabled(false);
         }
         
         
         if (checkOwnService.isSelected()||checkProvideService.isSelected()) 
         {
             viewTotal.setVisible(true);
       
         }
         else
         {
             viewTotal.setVisible(false);
         }
         if (e.getSource()==viewTotal) 
         {
            
             double total1=0, total2=0;
             if (checkOwnService.isSelected()) 
             {
                 if ((Double.parseDouble(txtNoOfKilo.getText())>=1)&& (Double.parseDouble(txtNoOfKilo.getText())<=3))
                 {
                     
                     total1=Double.parseDouble(txtPerKilo.getText())*Double.parseDouble(txtNoOfKilo.getText());
                 }
                 
                 else if ((Double.parseDouble(txtNoOfKilo.getText())>=4)&& (Double.parseDouble(txtNoOfKilo.getText())<=8))
                 {
                     total1=160;
                 }
                 
                 else
                 {
                     JOptionPane.showMessageDialog(this,"Maximum kilo per transaction is only 8kls.", "Warning", JOptionPane.WARNING_MESSAGE);
                 }
             }
                 
                 
             if (checkProvideService.isSelected()) 
             {
                   
                   
                   if ((Double.parseDouble(provtxtNoOfKilo.getText())>=1)&& (Double.parseDouble(provtxtNoOfKilo.getText())<=3))
                 {
                     
                     total2=Double.parseDouble(provtxtPerKilo.getText())*Double.parseDouble(provtxtNoOfKilo.getText());
                 }
                 
                 else if ((Double.parseDouble(provtxtNoOfKilo.getText())>=4)&& (Double.parseDouble(provtxtNoOfKilo.getText())<=8))
                 {
                     total2=180;
                 }
                 
                 else
                 {
                     JOptionPane.showMessageDialog(this,"Maximum kilo per transaction is only 8kls.", "Warning", JOptionPane.WARNING_MESSAGE);
                 }
             }
               
            
             
             totalPayment.setText(""+(total1+total2));
             lblTotal.setVisible(true);
             totalPayment.setVisible(true);
        
             
       checkTender.setVisible(true);
        checkTender.setEnabled(true);
        txtTender.setVisible(true);
        lblchange.setVisible(true);
        change.setVisible(true);
        calculate.setVisible(true);
        checkDeposit.setVisible(true);
        checkDeposit.setEnabled(true);
        txtDeposit.setVisible(true);
        lblbalance.setVisible(true);
        balance.setVisible(true);
        calculateBalance.setVisible(true);
      
         
         }
         
         if (checkTender.isSelected()) 
         {
        txtDeposit.setText("");
        balance.setText("0000");
        txtTender.setEnabled(true);
        lblchange.setEnabled(true);
        change.setEnabled(true);
        calculate.setEnabled(true);
        txtDeposit.setEnabled(false);
        lblbalance.setEnabled(false);
        balance.setEnabled(false);
        calculateBalance.setEnabled(false);
         }
         
         else if (checkDeposit.isSelected()) 
         {
        txtTender.setText("");
        change.setText("0000");
        txtDeposit.setEnabled(true);
        lblbalance.setEnabled(true);
        balance.setEnabled(true);
        calculateBalance.setEnabled(true);
        txtTender.setEnabled(false);
        lblchange.setEnabled(false);
        change.setEnabled(false);
        calculate.setEnabled(false);
         }
         
         if (e.getSource()==calculate) 
         {
              if (txtTender.getText().equals("")) 
             {
                 JOptionPane.showMessageDialog(this,"Please input Tender","Warning", JOptionPane.WARNING_MESSAGE);
             }
             else
             {
                  if (Double.parseDouble(txtTender.getText())<Double.parseDouble(totalPayment.getText())||txtTender.getText().equals("") )
                  {
                    JOptionPane.showMessageDialog(this,"Tender is not enough", "Warning", JOptionPane.WARNING_MESSAGE);
                  }
             else
             {
             double changee=0;
             changee=Double.parseDouble(txtTender.getText())-Double.parseDouble(totalPayment.getText());
             
             change.setText(changee+"");
             save.setVisible(true);
             cancel.setVisible(true);
            
             }
             }
         }
         if (e.getSource()==calculateBalance) 
         {
             if (txtDeposit.getText().equals("")) 
             {
                 JOptionPane.showMessageDialog(this,"Please input Deposit","Warning", JOptionPane.WARNING_MESSAGE);
             }
             else
             {
             if (Double.parseDouble(txtDeposit.getText())>Double.parseDouble(totalPayment.getText()))
             {
                    JOptionPane.showMessageDialog(this,"Deposited is enough for payment, Try Tender", "Warning", JOptionPane.WARNING_MESSAGE);
             }
             else
             {
             double balanced=0;
             balanced = Double.parseDouble(totalPayment.getText())-Double.parseDouble(txtDeposit.getText());
            
             balance.setText(balanced+"");
             save.setVisible(true);
             cancel.setVisible(true);
             }
             }
         }
         
         if (e.getSource()==save) 
         {
              
             
//              int kilos=Integer.parseInt(txtNoOfKilo.getText())+Integer.parseInt(provtxtNoOfKilo.getText());
//              
//              
//               try 
//                  {
//                
//               String sql ="SELECT COSTUMER_NUMBER,POINT,TOTAL_KILO FROM POINTS WHERE COSTUMER_NUMBER = ?";
//                 
//                      myConnection=DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
//                  
//                       PreparedStatement add =myConnection.prepareStatement(sql);
//                       add.setString(1, txtcustNum.getText());
//                       myResult = add.executeQuery();
//                            if(myResult.next()) 
//                             { 
//                                 String pointss = myResult.getString("POINT");
//                                 String kilo = myResult.getString("TOTAL_KILO");
//                                 if (Integer.parseInt(pointss)>=4) 
//                                 {
//                                  kilos=kilos+Integer.parseInt(kilo);
//                                  int kiloadd=kilos%4;
//                                  int p= Integer.parseInt(pointss)-4;
//                                    JOptionPane.showMessageDialog(this,"Costumer "+txtFname.getText()+"Congratulations you have reach 8 points, You can now avail our Promo.", "Information", JOptionPane.INFORMATION_MESSAGE);
//                                    
//                                    myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
//                                    String updatesql =" update LAUNDRYSHOP.POINTS set POINT = '"+p+"',TOTAL_KILO = '"+kiloadd+"' WHERE COSTUMER_NUMBER ='"+txtcustNum.getText()+"'";
//                                    Statement update=myConnection.createStatement();
//                                    update.executeUpdate(updatesql);
//                                 /////////////////////DISCOUNT CODES HERE!!!!!
//                                 }
//                                 
//                                 else
//                                 {
//                                 kilos=kilos+Integer.parseInt(kilo);
//                                 int pointadd=kilos/4;
//                                 int kiloadd=kilos%4;
//                                 pointadd=pointadd+Integer.parseInt(pointss);
//                                
//                                 myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
//                                 String updatesql =" update LAUNDRYSHOP.POINTS set POINT = '"+pointadd+"',TOTAL_KILO = '"+kiloadd+"' WHERE COSTUMER_NUMBER ='"+txtcustNum.getText()+"'";
//                                 if(pointadd>=1) 
//                                 { 
//                   
//                                    JOptionPane.showMessageDialog(this,"Costumer "+txtFname.getText()+" you have a total "+pointadd+" gained points.", "Information", JOptionPane.INFORMATION_MESSAGE);
//             
//                                 }
//                                 Statement update=myConnection.createStatement();
//                                 update.executeUpdate(updatesql);
//                                 }
//                             }
//                            else
//                            {     int calcpoint=kilos/4;
//                                   int kilo=kilos%4;
//                                   myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
//                                   PreparedStatement addpoint = myConnection.prepareStatement("insert Into LaundryShop.POINTS values(?,?,?)");
//              
//                                   addpoint.setString(1, txtcustNum.getText());
//                                   addpoint.setString(2,String.valueOf(calcpoint));
//                                   addpoint.setString(3,String.valueOf(kilo));
//                                   int rows=addpoint.executeUpdate();
//                                   
//                                     if(kilos>0) 
//                                     { 
//                   
//                                     JOptionPane.showMessageDialog(this,"Costumer "+txtFname.getText()+" you have gain "+calcpoint+" point.", "Information", JOptionPane.INFORMATION_MESSAGE);
//             
//                                     }
//                            }
//                  } catch (SQLException ex) 
//                  {
//                      Logger.getLogger(AddCostmers.class.getName()).log(Level.SEVERE, null, ex);
//                  
//                  }
               
         
         try {
               String dress = noOfshirt.getText();
               String jeanss = noOfJeans.getText();
               String sweaters = noOfSweater.getText();
               String suits = noOfSuit.getText();
               String curtains = noOfCurtain.getText();
               String blankets = noOfBlanket.getText();
               String blouses = noOfblouse.getText();
               String pajamas = noOfpajama.getText();
               String underwears = noOfunderwear.getText();
               String skirts = noOfskirt.getText();
               String shortss = noOfshorts.getText();
               String sockss = noOfsocks.getText();
               
             
               String num = txtcustNum.getText();
               String dates = curday.getText();
               String fname = txtFname.getText();
               String lname = txtLname.getText();
               String addr = txtaddress.getText();
               String contacts = txtcontact.getText();
               String ownservice = txtNoOfKilo.getText();
               String provservice = provtxtNoOfKilo.getText();
               String totalpayment = totalPayment.getText();
               String deposit = txtDeposit.getText();
               String balances = balance.getText();
               
              
               
               myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
               PreparedStatement add = myConnection.prepareStatement("insert Into LaundryShop.INFORMATIONS values(?,?,?,?,?,?,?,?,?,?,?)");
               PreparedStatement additems = myConnection.prepareStatement("insert Into LaundryShop.ITEMS values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
               PreparedStatement ch = myConnection.prepareStatement("insert Into LaundryShop.HISTORY1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
               
                 add.setString(1, num);
                 add.setString(2,dates);
                 add.setString(3, fname);
                 add.setString(4, lname);
                 add.setString(5, addr);
                 add.setString(6, contacts);
                 add.setString(7, ownservice);
                 add.setString(8, provservice);
                 add.setString(9, totalpayment);
                 add.setString(10, deposit);
                 add.setString(11, balances);
                  
                 additems.setString(1, num);
                 additems.setString(2,dress);
                 additems.setString(3, jeanss);
                 additems.setString(4, sweaters);
                 additems.setString(5, suits);
                 additems.setString(6, curtains);
                 additems.setString(7, blankets);
                 additems.setString(8, blouses);
                 additems.setString(9, pajamas);
                 additems.setString(10, underwears);
                 additems.setString(11, skirts);
                 additems.setString(12, shortss);
                 additems.setString(13, sockss);
                 
                 ch.setString(1, num);
                 ch.setString(2,dates);
                 ch.setString(3, fname);
                 ch.setString(4, lname);
                 ch.setString(5, addr);
                 ch.setString(6, contacts);
                 ch.setString(7, ownservice);
                 ch.setString(8, provservice);
                 ch.setString(9, totalpayment);
                 ch.setString(10,dress);
                 ch.setString(11, jeanss);
                 ch.setString(12, sweaters);
                 ch.setString(13, suits);
                 ch.setString(14, curtains);
                 ch.setString(15, blankets);
                 ch.setString(16, blouses);
                 ch.setString(17, pajamas);
                 ch.setString(18, underwears);
                 ch.setString(19, skirts);
                 ch.setString(20, shortss);
                 ch.setString(21, sockss);
                 
                 int row=add.executeUpdate();
                 int rows=additems.executeUpdate();
                 int rowss=ch.executeUpdate();
                JOptionPane.showMessageDialog(this,"Successfully Saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
                 
                noOfshirt.setText("");
                noOfJeans.setText("");
                noOfSweater.setText("");
                noOfSuit.setText("");
                noOfCurtain.setText("");
                noOfBlanket.setText("");
                noOfblouse.setText("");
                noOfpajama.setText("");
                noOfunderwear.setText("");
                noOfskirt.setText("");
                noOfshorts.setText("");
                noOfsocks.setText("");
             
                txtcustNum.setText("");
                txtFname.setText("");
                txtLname.setText("");
                txtaddress.setText("");
                txtcontact.setText("");
                txtNoOfKilo.setText("");
                provtxtNoOfKilo.setText("");
                totalPayment.setText("");
                txtDeposit.setText("");
               txtTender.setText("");
               change.setText("");
                balance.setText("");
                save.setVisible(false);
                cancel.setVisible(false);
                 
             } 
             catch (SQLException ex) 
             {
                 JOptionPane.showMessageDialog(this,"This Costumer has a clothes did not claim. Claim first!", "Warning", JOptionPane.WARNING_MESSAGE);
              
             }
         }
         if(e.getSource()==  check)
         {
              try
             {
         
             String sql ="SELECT COSTUMER_NUMBER,FIRST_NAME,LAST_NAME,ADDRESS,CONTACT_NUMBER"
                     + "  FROM HISTORY1"
                     + "  where COSTUMER_NUMBER = ?";
             
              myConnection=DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
               PreparedStatement add =myConnection.prepareStatement(sql);
               add.setString(1, txtcustNum.getText());
               myResult = add.executeQuery();
                if(myResult.next()) 
                { 
        String fn = myResult.getString("FIRST_NAME");
        txtFname.setText(fn);
        String ln = myResult.getString("LAST_NAME");
        txtLname.setText(ln);
        String ad = myResult.getString("ADDRESS");
        txtaddress.setText(ad);
        String cn = myResult.getString("CONTACT_NUMBER");
        txtcontact.setText(cn);
         }
                
                else
                {
               JOptionPane.showMessageDialog(this,"Costumer not found!", "Warning", JOptionPane.WARNING_MESSAGE);
               
                }
             } catch (SQLException ex) 
             {
                 
                ex.printStackTrace();
                
             }
             
             
             try 
                  {
                
               String sql ="SELECT COUNT(COSTUMER_NUMBER) AS COUNTER FROM HISTORY1 WHERE TOTAL_PAYMENT  >= '160.0' and TOTAL_PAYMENT >  '180.0'  AND COSTUMER_NUMBER = ? ";
                 
                      myConnection=DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
                  
                       PreparedStatement add =myConnection.prepareStatement(sql);
                       add.setString(1, txtcustNum.getText());
                       myResult = add.executeQuery();
                            if(myResult.next()) 
                             { 
                                 String count = myResult.getString("COUNTER");
                                 if (Integer.parseInt(count)>=8) 
                                 {
                                     JOptionPane.showMessageDialog(this,"You have reached 8 points, you can now use this reward this time", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                                
                                 
               myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
               String dsql = "delete from HISTORY1 where COSTUMER_NUMBER = ? ";
               PreparedStatement addd =myConnection.prepareStatement(dsql);
               addd.setString(1,txtcustNum.getText());
               addd.executeUpdate();

         viewTotal.setEnabled(false);
        totalPayment.setText("FREE");
        lblTotal.setVisible(true);
        totalPayment.setVisible(true);
        
        checkTender.setVisible(true);
        checkTender.setEnabled(true);
        txtTender.setVisible(true);
        lblchange.setVisible(true);
        change.setVisible(true);
        calculate.setVisible(true);
        checkDeposit.setVisible(true);
        checkDeposit.setEnabled(true);
        txtDeposit.setVisible(true);
        lblbalance.setVisible(true);
        balance.setVisible(true);
        calculateBalance.setVisible(true);                   
               
         save.setVisible(true);
         cancel.setVisible(true);
                                 }
                                
                            }
                  } catch (SQLException ex) 
                  {
                      Logger.getLogger(AddCostmers.class.getName()).log(Level.SEVERE, null, ex);
                  
                  }
            
         
         }
         if (e.getSource()==cancel) 
         {
               noOfshirt.setText("");
                noOfJeans.setText("");
                noOfSweater.setText("");
                noOfSuit.setText("");
                noOfCurtain.setText("");
                noOfBlanket.setText("");
                noOfblouse.setText("");
                noOfpajama.setText("");
                noOfunderwear.setText("");
                noOfskirt.setText("");
                noOfshorts.setText("");
                noOfsocks.setText("");
             
                txtcustNum.setText("");
                txtFname.setText("");
                txtLname.setText("");
                txtaddress.setText("");
                txtcontact.setText("");
                txtNoOfKilo.setText("");
                provtxtNoOfKilo.setText("");
                totalPayment.setText("");
                txtDeposit.setText("");
               txtTender.setText("");
               change.setText("");
                balance.setText("");
                save.setVisible(false);
                cancel.setVisible(false);
            new Home();
            dispose();
         }
     
    
     }
}

