
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
import static laundryshop.FormDesign.location;
import net.proteanit.sql.DbUtils;

public class UpdateData extends FormDesign implements ActionListener{
    
      Connection myConnection=null;
        Statement myStatement=null;
        ResultSet myResult=null;
    
        
    Date date=new Date();
    DateFormat dateFor=new SimpleDateFormat("MMMM dd,yyyy HH:mm a");
     Date da=new Date();
    JLabel curday=new JLabel(dateFor.format(da));
      
    JButton search=new JButton("Search");
    
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
    JLabel address = new JLabel(" Adress : ");
    JTextField txtaddress = new JTextField();
  
    JPanel line4 = new JPanel();
    JLabel contact = new JLabel(" Contact No. : ");
    JTextField txtcontact = new JTextField();
    
    JCheckBox checkOwnService=new JCheckBox("Own Service");
    JLabel lblPerKilo = new JLabel("Per Kilo: ");
    JTextField txtPerKilo = new JTextField("20");
    JLabel lblNoOfKilo = new JLabel("How many kilo: ");
    JTextField txtNoOfKilo = new JTextField("0");
    JTextField prevtxtNoOfKilo = new JTextField("0");
    
    JCheckBox checkProvideService=new JCheckBox("Provide Service");
    JLabel provlblPerKilo = new JLabel("Per Kilo: ");
    JTextField provtxtPerKilo = new JTextField("30");
    JLabel provlblNoOfKilo = new JLabel("How many kilo: ");
    JTextField provtxtNoOfKilo = new JTextField("0");
    JTextField prevprovtxtNoOfKilo = new JTextField("0");
   
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
    JLabel totalPayment = new JLabel("0000.00");
    
    JRadioButton checkTender =new JRadioButton("Tender");
    JTextField txtTender = new JTextField("");
    JLabel lblchange = new JLabel(" Change: ");
    JLabel change = new JLabel("0000.00");
    JButton calculate =new JButton("Calculate Change");
    
    JRadioButton checkDeposit =new JRadioButton("Deposit");
    JTextField txtDeposit = new JTextField("");
    JLabel lblbalance = new JLabel("Balance : ");
    JLabel balance = new JLabel("0000.00");
    JButton calculateBalance =new JButton("Calculate Balance");
    
    JLabel lblprevtp = new JLabel("Previous Payment: ");
    JLabel prevtp = new JLabel("0000");
    JLabel lblprevdeposit = new JLabel("Previous Deposit: ");
    JLabel prevdeposit = new JLabel("0000");
    JLabel lblprevbalance = new JLabel("Previous Balance: ");
    JLabel prevbalance = new JLabel("0000");
    
    JButton save=new JButton("Save Records");
    JButton cancel=new JButton("Cancel Records");
    JButton claim=new JButton("Claim Clothes");
     JButton decline=new JButton("Decline");
    
    public UpdateData()
    {
        //Form
        setTitle("Update Form");
        lblFormTitle.setText("UPDATE COSTUMERS");
        icon4.setIcon( new ImageIcon(location + "Update_B.png"));
        
        
        
         
//        Controls
        
        curday.setFont(new  Font("Calibri", 1,20));
        curday.setForeground(Color.WHITE);
        curday.setBounds(580, -8, 400, 100);
        curday.setVerticalAlignment(SwingConstants.CENTER);
        curday.setHorizontalAlignment(SwingConstants.LEFT);     
          
        lblcustNum.setFont(new  Font("Calibri", 0, 12));
        lblcustNum.setForeground(Color.WHITE);
        lblcustNum.setBounds(15, 30, 120, 25);
        lblcustNum.setVerticalAlignment(SwingConstants.CENTER);
        lblcustNum.setHorizontalAlignment(SwingConstants.RIGHT);
        
        search.setFont(new  Font("Calibri", 0, 12));
        search.setBounds(317, 30, 120, 20);
        search.setVerticalAlignment(SwingConstants.CENTER);
        search.setHorizontalAlignment(SwingConstants.CENTER);
        search.setForeground(Color.WHITE);
        search.setBackground(new Color(0,59,147));
        
        txtcustNum.setBounds(140, 30, 150, 25);
        txtcustNum.setFont(new  Font("Calibri", 0, 12));
        txtcustNum.setForeground(Color.WHITE);
        txtcustNum.setBorder(null);
        txtcustNum.setOpaque(false);
        txtcustNum.setHorizontalAlignment(SwingConstants.CENTER);
        
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
 
        
        totalPayment.setFont(new  Font("Calibri", 0, 12));
        totalPayment.setForeground(Color.WHITE);
        totalPayment.setBounds(110, 200, 130, 25);
        totalPayment.setVerticalAlignment(SwingConstants.CENTER);
        totalPayment.setHorizontalAlignment(SwingConstants.RIGHT);
    
       
        lblprevtp.setFont(new  Font("Calibri", 0, 12));
        lblprevtp.setForeground(Color.WHITE);
        lblprevtp.setBounds(270, 200, 130, 25);
        lblprevtp.setVerticalAlignment(SwingConstants.CENTER);
        lblprevtp.setHorizontalAlignment(SwingConstants.RIGHT);
    
        
        prevtp.setFont(new  Font("Calibri", 0, 12));
        prevtp.setForeground(Color.WHITE);
        prevtp.setBounds(300, 200, 130, 25);
        prevtp.setVerticalAlignment(SwingConstants.CENTER);
        prevtp.setHorizontalAlignment(SwingConstants.RIGHT);
    
        
        checkTender.setFont(new  Font("Calibri", 0, 12));
        checkTender.setForeground(Color.WHITE);
        checkTender.setBounds(90, 220, 70, 25);
        checkTender.setBackground(new Color(0,59,147)); 
       
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
        
        lblprevbalance.setFont(new  Font("Calibri", 0, 12));
        lblprevbalance.setForeground(Color.WHITE);
        lblprevbalance.setBounds(270, 310, 130, 25);
        lblprevbalance.setVerticalAlignment(SwingConstants.CENTER);
        lblprevbalance.setHorizontalAlignment(SwingConstants.RIGHT);
        
        lblprevdeposit.setFont(new  Font("Calibri", 0, 12));
        lblprevdeposit.setForeground(Color.WHITE);
        lblprevdeposit.setBounds(268, 290, 130, 25);
        lblprevdeposit.setVerticalAlignment(SwingConstants.CENTER);
        lblprevdeposit.setHorizontalAlignment(SwingConstants.RIGHT);
        
        prevdeposit.setFont(new  Font("Calibri", 0, 12));
        prevdeposit.setForeground(Color.WHITE);
        prevdeposit.setBounds(300, 290, 130, 25);
        prevdeposit.setVerticalAlignment(SwingConstants.CENTER);
        prevdeposit.setHorizontalAlignment(SwingConstants.RIGHT);
        
        lblbalance.setBounds(110, 310,130, 20);
        lblbalance.setFont(new  Font("Calibri", 0, 12));
        lblbalance.setForeground(Color.WHITE);
        lblbalance.setOpaque(false);
        
        balance.setFont(new  Font("Calibri", 0, 12));
        balance.setForeground(Color.WHITE);
        balance.setBounds(110, 310, 130, 25);
        balance.setVerticalAlignment(SwingConstants.CENTER);
        balance.setHorizontalAlignment(SwingConstants.RIGHT);
        
        lblprevbalance.setFont(new  Font("Calibri", 0, 12));
        lblprevbalance.setForeground(Color.WHITE);
        lblprevbalance.setBounds(270, 310, 130, 25);
        lblprevbalance.setVerticalAlignment(SwingConstants.CENTER);
        lblprevbalance.setHorizontalAlignment(SwingConstants.RIGHT);
        
        prevbalance.setFont(new  Font("Calibri", 0, 12));
        prevbalance.setForeground(Color.WHITE);
        prevbalance.setBounds(300, 310, 130, 25);
        prevbalance.setVerticalAlignment(SwingConstants.CENTER);
        prevbalance.setHorizontalAlignment(SwingConstants.RIGHT);
        
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
        save.setVisible(false);
        
        cancel.setFont(new  Font("Calibri", 0, 14));
        cancel.setBounds(95, 395, 195, 25);
        cancel.setVerticalAlignment(SwingConstants.CENTER);
        cancel.setHorizontalAlignment(SwingConstants.CENTER);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(new Color(13,52,200));
        cancel.setOpaque(false);
        cancel.setVisible(false);
        
        
        claim.setFont(new  Font("Calibri", 0, 16));
        claim.setBounds(450, 360, 350, 25);
        claim.setVerticalAlignment(SwingConstants.CENTER);
        claim.setHorizontalAlignment(SwingConstants.CENTER);
        claim.setForeground(Color.WHITE);
        claim.setBackground(new Color(13,52,200));
        claim.setOpaque(false);
        claim.setVisible(false);
        
        decline.setFont(new  Font("Calibri", 0, 16));
        decline.setBounds(450, 390, 350, 25);
        decline.setVerticalAlignment(SwingConstants.CENTER);
        decline.setHorizontalAlignment(SwingConstants.CENTER);
        decline.setForeground(Color.WHITE);
        decline.setBackground(new Color(13,52,200));
        decline.setOpaque(false);
        decline.setVisible(false);
        
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
        
        prevtxtNoOfKilo.setBounds(805, 55, 20, 20);
        prevtxtNoOfKilo.setFont(new  Font("Calibri", 0, 12));
        prevtxtNoOfKilo.setForeground(Color.WHITE);
        prevtxtNoOfKilo.setOpaque(false);
        prevtxtNoOfKilo.setHorizontalAlignment(SwingConstants.CENTER);
        
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
        
        prevprovtxtNoOfKilo.setBounds(805, 85, 20, 20);
        prevprovtxtNoOfKilo.setFont(new  Font("Calibri", 0, 12));
        prevprovtxtNoOfKilo.setForeground(Color.WHITE);
        prevprovtxtNoOfKilo.setOpaque(false);
        prevprovtxtNoOfKilo.setHorizontalAlignment(SwingConstants.CENTER);

          
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

        fullPanel.add(curday);   
        
        fullPanel.add(search);   
        
         search.setOpaque(false);
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
        
        fullPanel.add(lblprevtp);
         fullPanel.add(prevtp);
        
        fullPanel.add(checkTender);
       
         checkTender.setOpaque(false);
        txtTender.setEnabled(false);
        lblchange.setEnabled(false);
        change.setEnabled(false);
        calculate.setEnabled(false);
        fullPanel.add(txtTender);
        fullPanel.add(lblchange);
        fullPanel.add(change);
        fullPanel.add(calculate);
        
       
        fullPanel.add(checkDeposit);
        
         checkDeposit.setOpaque(false);
        fullPanel.add(txtDeposit);
        fullPanel.add(lblbalance);
        fullPanel.add(balance);
        fullPanel.add(lblprevdeposit);
        fullPanel.add(prevdeposit);
        fullPanel.add(lblprevbalance);
        fullPanel.add(prevbalance);
        fullPanel.add(calculateBalance);
         
        txtDeposit.setEnabled(false);
        lblbalance.setEnabled(false);
        balance.setEnabled(false);
        calculateBalance.setEnabled(false);
        fullPanel.add(save);
        fullPanel.add(cancel);
        fullPanel.add(claim);
        fullPanel.add(decline);
        fullPanel.add(checkOwnService);
        
         checkOwnService.setOpaque(false);
        fullPanel.add(lblPerKilo);
        fullPanel.add(txtPerKilo);
        fullPanel.add(prevtxtNoOfKilo);
        prevtxtNoOfKilo.setEnabled(false);
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
        fullPanel.add(prevprovtxtNoOfKilo);
         prevprovtxtNoOfKilo.setEnabled(false);
        fullPanel.add(provlblNoOfKilo);
        fullPanel.add(provtxtNoOfKilo);
        provlblPerKilo.setEnabled(false);
        provtxtPerKilo.setEnabled(false);
        provlblNoOfKilo.setEnabled(false);
        provtxtNoOfKilo.setEnabled(false);
        
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
        
         fullPanel.add(save);
          fullPanel.add(cancel);
        
        checkOwnService.addActionListener(this);
        checkProvideService.addActionListener(this);
        viewTotal.addActionListener(this);
        checkTender.addActionListener(this);
        checkDeposit.addActionListener(this);
        calculate.addActionListener(this);
        calculateBalance.addActionListener(this);
        save.addActionListener(this);
        search.addActionListener(this);
        decline.addActionListener(this);
        claim.addActionListener(this);
    }
     public void actionPerformed(ActionEvent e) 
     {
         String ps ="";
         String os="";
         if (checkOwnService.isSelected()) 
         {
             lblPerKilo.setEnabled(true);
             txtPerKilo.setEnabled(true);
             lblNoOfKilo.setEnabled(true);
             txtNoOfKilo.setEnabled(true);
             prevtxtNoOfKilo.setEnabled(false);
         }
         else
         {
             lblPerKilo.setEnabled(false);
             txtPerKilo.setEnabled(false);
             lblNoOfKilo.setEnabled(false);
             txtNoOfKilo.setEnabled(false);
             prevprovtxtNoOfKilo.setEnabled(false);
             
         }
        
         if (checkProvideService.isSelected()) 
         {
            provlblPerKilo.setEnabled(true);
            provtxtPerKilo.setEnabled(true);
            provlblNoOfKilo.setEnabled(true);
            provtxtNoOfKilo.setEnabled(true); 
            prevprovtxtNoOfKilo.setEnabled(false);
            
            
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
            prevtxtNoOfKilo.setEnabled(false);
       
            
         
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
            
//             double totalown=0;
//             double totalpro=0;
//             double total=0;
             
             
//             totalown=(Double.parseDouble(txtPerKilo.getText())*Double.parseDouble(txtNoOfKilo.getText()));
//             totalpro=Double.parseDouble(provtxtPerKilo.getText())*Double.parseDouble(provtxtNoOfKilo.getText());
//             total=totalpro+totalown;
//             total=total-Double.parseDouble(prevtp.getText());
//             total=total+Double.parseDouble(totalPayment.getText());
//           
//             totalPayment.setText(""+total);
//             lblTotal.setVisible(true);
//             totalPayment.setVisible(true);
             
             
             
              double total1=0, total2=0;
             if (checkOwnService.isSelected()) 
             {
                 
                 double parkilo = Double.parseDouble(txtNoOfKilo.getText())+ Double.parseDouble(prevtxtNoOfKilo.getText());
                 prevtxtNoOfKilo.setText(""+parkilo);
                 
                 if ((parkilo>=1)&& (parkilo<=3))
                 {
                     total1=parkilo*Double.parseDouble(txtPerKilo.getText());
                 }
                 
                 else if ((Double.parseDouble(txtNoOfKilo.getText())==0))
                 {
                     total1=0; 
                 }
                 
                 else if ((parkilo>=4) && (parkilo <=8))
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
                 double parkilo = Double.parseDouble(provtxtNoOfKilo.getText())+ Double.parseDouble(prevprovtxtNoOfKilo.getText());
                 prevprovtxtNoOfKilo.setText(""+parkilo);
                   
                   
                   if ((parkilo>=1)&& (parkilo<=3))
                 {
                     total2=parkilo*Double.parseDouble(provtxtPerKilo.getText());
                 }
                 
                 else if ((Double.parseDouble(provtxtNoOfKilo.getText())==0))
                 {
                     total2=0; 
                 }
                 
                 else if ((parkilo>=4) && (parkilo <=8))
                 {
                     total2=180;
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(this,"Maximum kilo per transaction is only 8 kls.", "Warning", JOptionPane.WARNING_MESSAGE);
                 }
             }
               
            
             
            
             double total3 = total1 + total2;
            double totalown = Double.parseDouble(prevdeposit.getText());
            double totalown1 = Double.parseDouble(prevbalance.getText());
            
             
             totalPayment.setText(""+((totalown + total3) + totalown1 - totalown));
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
        txtDeposit.setText("0000.00");
        balance.setText("0000.00");
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
        change.setText("0000.00");
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
                 JOptionPane.showMessageDialog(this,"Please input Tender!","Warning", JOptionPane.WARNING_MESSAGE);
             }
             else
             {
            if (Double.parseDouble(txtTender.getText())<Double.parseDouble(totalPayment.getText())||txtTender.getText().equals("") )
             {
                    JOptionPane.showMessageDialog(this,"Tender is not enough!", "Warning", JOptionPane.WARNING_MESSAGE);
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
                 JOptionPane.showMessageDialog(this,"Please input Deposit!","Warning", JOptionPane.WARNING_MESSAGE);
             }
             else
             {
             if (Double.parseDouble(txtDeposit.getText())>Double.parseDouble(totalPayment.getText()))
             {
                    JOptionPane.showMessageDialog(this,"Deposited is enough for payment, Try Tender!", "Warning", JOptionPane.WARNING_MESSAGE);
             }
             else
             {
             double balanced=0;
             balanced=Double.parseDouble(totalPayment.getText())-Double.parseDouble(txtDeposit.getText());
            
             balance.setText(""+balanced);
             prevbalance.setText(""+balanced);
             save.setVisible(true);
             cancel.setVisible(true);
             }
             }
         }
         
         if (e.getSource()==search) 
         {
               
         try 
         {
             String sql ="SELECT COSTUMER_NUMBER,DATE,FIRST_NAME,LAST_NAME,ADDRESS,CONTACT_NUMBER,OWN_SERVICE_KILO,PROV_SERVICE_KILO, TOTAL_PAYMENT,DEPOSIT, BALANCE, SHIRT, JEANS, SWEATER, SUIT, CURTAIN, BLANKET,BLOUSE,PAJAMA,UNDERWEAR,SKIRT,SHORTS,SOCKS "
                     + "  FROM INFORMATIONS JOIN ITEMS USING(COSTUMER_NUMBER) "
                     + "  where COSTUMER_NUMBER = ?";
              myConnection=DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
               PreparedStatement add =myConnection.prepareStatement(sql);
               add.setString(1, txtcustNum.getText());
               myResult = add.executeQuery();
                if(myResult.next()) 
                { 
        String d = myResult.getString("DATE");
        curday.setText(d);
        String fn = myResult.getString("FIRST_NAME");
        txtFname.setText(fn);
        String ln = myResult.getString("LAST_NAME");
        txtLname.setText(ln);
        String ad = myResult.getString("ADDRESS");
        txtaddress.setText(ad);
        
        String cn = myResult.getString("CONTACT_NUMBER");
        txtcontact.setText(cn);
        
         os = myResult.getString("OWN_SERVICE_KILO");
        prevtxtNoOfKilo.setText(os);
        txtNoOfKilo.setText(os);
        ps = myResult.getString("PROV_SERVICE_KILO");
        provtxtNoOfKilo.setText(ps);
        prevprovtxtNoOfKilo.setText(ps);
        String tp = myResult.getString("TOTAL_PAYMENT");
        prevtp.setText(tp);
        String dpst = myResult.getString("DEPOSIT");
                    if ("".equals(dpst)) 
                    {
                        prevdeposit.setText("0000");
                    }
                    else
                    {
                         prevdeposit.setText(dpst);
                    }
        String blnce = myResult.getString("BALANCE");
        prevbalance.setText(blnce);
       totalPayment.setText(blnce);
                    if (Double.parseDouble(blnce)<=0) 
                    {
                     claim.setVisible(true);
                     decline.setVisible(true);
                    }
        
        String drs = myResult.getString("SHIRT"); 
        noOfshirt.setText(drs);
        String jns = myResult.getString("JEANS");
        noOfJeans.setText(jns);
        String swtr = myResult.getString("SWEATER");
        noOfSweater.setText(swtr);
        String st = myResult.getString("SUIT");
        noOfSuit.setText(st);
        String crtn = myResult.getString("CURTAIN");
        noOfCurtain.setText(crtn);
        String blnkt = myResult.getString("BLANKET");
        noOfBlanket.setText(blnkt);
         String blous = myResult.getString("BLOUSE");
        noOfblouse.setText(blous);
        String paja = myResult.getString("PAJAMA");
        noOfpajama.setText(paja);
         String uw = myResult.getString("UNDERWEAR");
        noOfunderwear.setText(uw);
         String skir = myResult.getString("SKIRT");
        noOfskirt.setText(skir);
         String shortss = myResult.getString("SHORTS");
        noOfpajama.setText(shortss);
        String sock = myResult.getString("SOCKS");
        noOfsocks.setText(sock);
        
        
        
                }
               else
                {
               JOptionPane.showMessageDialog(this,"Costumer not found!", "Warning", JOptionPane.WARNING_MESSAGE);
               
                }
             } catch (SQLException ex) 
             {
                 
                ex.printStackTrace();
                
             }
         }
         
         
          if(e.getSource()== save)
             {
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
               String ownservice = prevtxtNoOfKilo.getText();
               String provservice = prevprovtxtNoOfKilo.getText();
               double tp=0;
               tp=Double.parseDouble(totalPayment.getText())+Double.parseDouble(prevtp.getText());
               tp=tp-Double.parseDouble(prevbalance.getText());
               String totalpayment=String.valueOf(tp);
                   if (checkTender.isSelected()) 
                   {
                   prevbalance.setText("0000");
                   prevdeposit.setText("0000");
                   }
               double dep=Double.parseDouble(txtDeposit.getText())+Double.parseDouble(prevdeposit.getText());
               String deposit = String.valueOf(dep);
               double bal=Double.parseDouble(balance.getText())+Double.parseDouble(prevbalance.getText());
               String balances = String.valueOf(bal);
                myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
               String sql =" update LAUNDRYSHOP.INFORMATIONS set DATE = '"+dates+"', FIRST_NAME = '"+fname+"',LAST_NAME = '"+lname+"',ADDRESS = '"+addr+"',CONATCT_NUMBER = '"+contacts+"', OWN_SERVICE_KILO = '"+ownservice+"', PROV_SERVICE_KILO = '"+provservice+"', TOTAL_PAYMENT = '"+totalpayment+"', DEPOSIT = '"+deposit+"', BALANCE = '"+balance.getText()+"' WHERE COSTUMER_NUMBER ='"+num+"'";
               String sqlitems =" update LAUNDRYSHOP.ITEMS set SHIRT = '"+dress+"', JEANS = '"+jeanss+"',SWEATER = '"+sweaters+"',SUIT = '"+suits+"',CURTAIN = '"+curtains+"', BLANKET = '"+blankets+"', BLOUSE = '"+blouses+"', PAJAMA = '"+pajamas+"', UNDERWEAR = '"+underwears+"', SKIRT = '"+skirts+"', SHORTS = '"+shortss+"', SOCKS = '"+sockss+"' WHERE COSTUMER_NUMBER ='"+num+"'";
               String sqlhistory =" update LAUNDRYSHOP.HISTORY1 set COSTUMER_NUMBER = '"+num+"',DATE = '"+dates+"', FIRST_NAME = '"+fname+"',LAST_NAME = '"+lname+"',ADDRESS = '"+addr+"',CONTACT_NUMBER = '"+contacts+"', OWN_SERVICE_KILO = '"+ownservice+"', PROVIDE_SERVICE_KILO = '"+provservice+"', TOTAL_PAYMENT = '"+totalpayment+"'," +
               "SHIRT = '"+dress+"', JEANS = '"+jeanss+"',SWEATER = '"+sweaters+"',SUIT = '"+suits+"',CURTAIN = '"+curtains+"', BLANKET = '"+blankets+"', BLOUSE = '"+blouses+"', PAJAMA = '"+pajamas+"', UNDERWEAR = '"+underwears+"', SKIRT = '"+skirts+"', SHORTS = '"+shortss+"', SOCKS = '"+sockss+"' WHERE COSTUMER_NUMBER ='"+num+"' AND DATE = '"+curday.getText()+"'";
            
               Statement update=myConnection.createStatement();
              
                update.executeUpdate(sql);
                update.executeUpdate(sqlitems);
                update.executeUpdate(sqlhistory);
                JOptionPane.showMessageDialog(this,"Successfully Updated!", "Updated", JOptionPane.INFORMATION_MESSAGE);
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
                 prevtxtNoOfKilo.setText("");
               prevprovtxtNoOfKilo.setText("");
                save.setVisible(false);
                cancel.setVisible(false);
                  }
              catch (SQLException EX) 
             {
              EX.printStackTrace();;
             }
     
             }
          if (e.getSource()==cancel) 
          {
               prevtxtNoOfKilo.setText("");
               prevprovtxtNoOfKilo.setText("");
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
          if (e.getSource()==decline) 
          {
             decline.setVisible(false);
             claim.setVisible(false);
          }
     
           if (e.getSource()==claim) 
          {
            
               
              
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
                                     JOptionPane.showMessageDialog(this,"You have reached 8 points, you can now use this reward next time.", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                                
                                 
                                 }
                                 else 
                                 {   
                                     
                                     JOptionPane.showMessageDialog(this,"You already have "+count+" point/s, keep it up until you have reach the maximun 8 points.", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                                
                                 }
                            }
                  } catch (SQLException ex) 
                  {
                      Logger.getLogger(AddCostmers.class.getName()).log(Level.SEVERE, null, ex);
                  
                  }
               
              
              
            try 
            {
               String date = curday.getText();
               String fname = txtFname.getText();
               String lname = txtLname.getText();
               String totalpayment = prevtp.getText();
               String Costumer_number = txtcustNum.getText();
               String status = "CLAIMED";
               
               String isql = "insert Into LaundryShop.REPORT1 values(?,?,?,?,?,?)";
               myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
               PreparedStatement rt = myConnection.prepareStatement(isql);
               rt.setString(1,Costumer_number);
               rt.setString(2,date);
               rt.setString(3,fname);
               rt.setString(4,lname);
               rt.setString(5,status);
                rt.setString(6,totalpayment);
               int row = rt.executeUpdate();
            
                JOptionPane.showMessageDialog(this,"Clothes Claimed...", "Claim", JOptionPane.INFORMATION_MESSAGE);
               decline.setVisible(false);
               claim.setVisible(false);
            
               myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
               String dsql = "delete from INFORMATIONS where COSTUMER_NUMBER = ?";
               String delsql = "delete from ITEMS where COSTUMER_NUMBER = ?";
               PreparedStatement add =myConnection.prepareStatement(dsql);
               add.setString(1,txtcustNum.getText());
               add.executeUpdate();
               
               PreparedStatement deldd =myConnection.prepareStatement(delsql);
               deldd.setString(1,txtcustNum.getText());
               deldd.executeUpdate();
              
               txtcustNum.setText("");
               curday.setText("");
               txtFname.setText("");
               txtLname.setText("");
               txtaddress.setText("");
               txtcontact.setText("");
               txtNoOfKilo.setText("");
               provtxtNoOfKilo.setText("");
               totalPayment.setText("");
               txtDeposit.setText("");
               balance.setText("");
               
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
               
               
        } 
               catch (SQLException ex) 
        {
                 Logger.getLogger(UpdateData.class.getName()).log(Level.SEVERE, null, ex);
        }
             
            
        }
          
     
     
     
     }
    
}

