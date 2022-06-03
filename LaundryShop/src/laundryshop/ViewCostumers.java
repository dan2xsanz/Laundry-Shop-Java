
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

public class ViewCostumers extends FormDesign implements ActionListener{
    
      Connection myConnection=null;
        Statement myStatement=null;
        ResultSet myResult=null;
        
       
    private JTable logtable=new JTable();
    private JLabel tablePanel=new JLabel();
    
    JLabel mi = new JLabel("MONTHLY INCOME : ");
    JLabel mon = new JLabel("0000.00");
    JButton save = new JButton("Save");
    private Object noOfSuit;
     double tot=0;
     String runner="0";
     JLabel or = new JLabel("OR");
     
     JLabel costumer_id = new JLabel("COSTUMER_ID: ");
    JTextField costumer_idtxt = new JTextField("");
    
     JLabel last_name = new JLabel("LAST NAME: ");
    JTextField txtlast_name = new JTextField("");
    
    JLabel first_name = new JLabel("FIRST NAME: ");
    JTextField txtfirst_name = new JTextField("");
    
      JButton view=new JButton("View History");
      JButton viewitems=new JButton("View Items");
      
    
    public ViewCostumers()
    {
        //Form
        setTitle("View Costumers");
        lblFormTitle.setText("VIEW COSTUMERS TRANSACTION HISTORY FORM");
        icon3.setIcon( new ImageIcon(location + "ViewData_B.png"));

      
      //  
        last_name.setFont(new  Font("Calibri", 0, 12));
        last_name.setForeground(Color.WHITE);
        last_name.setBounds(70, 40, 130, 25);
        
        txtlast_name.setBounds(140, 40, 150, 20);
        txtlast_name.setFont(new  Font("Calibri", 0, 12));
        txtlast_name.setForeground(Color.WHITE);
        txtlast_name.setOpaque(false);
        txtlast_name.setHorizontalAlignment(SwingConstants.CENTER);
      //  
        first_name.setFont(new  Font("Calibri", 0, 12));
        first_name.setForeground(Color.WHITE);
        first_name.setBounds(310, 40, 130, 25);
        
        txtfirst_name.setBounds(380, 40, 150, 20);
        txtfirst_name.setFont(new  Font("Calibri", 0, 12));
        txtfirst_name.setForeground(Color.WHITE);
        txtfirst_name.setOpaque(false);
        txtfirst_name.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        or.setFont(new  Font("Calibri", 0, 12));
        or.setForeground(Color.WHITE);
        or.setBounds(560, 40, 130, 25);
        
       //
        costumer_id.setFont(new  Font("Calibri", 0, 12));
        costumer_id.setForeground(Color.WHITE);
        costumer_id.setBounds(590, 40, 130, 25);
      
        costumer_idtxt.setBounds(680, 40, 150, 20);
        costumer_idtxt.setFont(new  Font("Calibri", 0, 12));
        costumer_idtxt.setForeground(Color.WHITE);
        costumer_idtxt.setOpaque(false);
        costumer_idtxt.setHorizontalAlignment(SwingConstants.CENTER);
        
        view.setFont(new  Font("Calibri", 0, 14));
        view.setBounds(70, 75,350, 25);
        view.setVerticalAlignment(SwingConstants.CENTER);
        view.setHorizontalAlignment(SwingConstants.CENTER);
        view.setForeground(Color.WHITE);
        view.setBackground(new Color(13,52,200));
        view.setOpaque(false);
        
        viewitems.setFont(new  Font("Calibri", 0, 14));
        viewitems.setBounds(480, 75, 350, 25);
        viewitems.setVerticalAlignment(SwingConstants.CENTER);
        viewitems.setHorizontalAlignment(SwingConstants.CENTER);
        viewitems.setForeground(Color.WHITE);
        viewitems.setBackground(new Color(13,52,200));
        viewitems.setOpaque(false);
        
        
tablePanel.setIcon( new ImageIcon(location + "addcust.jpg"));
        tablePanel.setBounds(10, 115,880, 300);
        tablePanel.setBorder(new LineBorder(new Color(0,59,147),1,true));
        tablePanel.setOpaque(false);
        JScrollPane scrollTable=new JScrollPane(logtable);
        tablePanel.add(scrollTable);
        
     
      
      logtable.setPreferredScrollableViewportSize(new Dimension(880,300));
      logtable.setFillsViewportHeight(true);
      logtable.setRowSelectionAllowed(true);
      logtable.removeEditor();
      logtable.setOpaque(false);
      logtable.setRowMargin(3);
      logtable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      logtable.setRowHeight(17);
      logtable.getTableHeader().setReorderingAllowed(false);
      logtable.getTableHeader().setReorderingAllowed(false);
      logtable.setBorder(new LineBorder(new Color(0,0,153),0,true));
      logtable.setFont(new Font("Calibri",0,15));
      logtable.setVisible(false);
     
      

     
      fullPanel.add(tablePanel);
      fullPanel.add(or);
      fullPanel.add(last_name);
      fullPanel.add(txtlast_name);
      fullPanel.add(first_name);
      fullPanel.add(txtfirst_name);
      fullPanel.add(view);
      fullPanel.add(viewitems);
      fullPanel.add(costumer_id);
      fullPanel.add(costumer_idtxt);
      

      view.addActionListener(this);
viewitems.addActionListener(this);
      
        
       }
     public void actionPerformed(ActionEvent e) 
     {
        
         
          if(e.getSource()==view)
         {
             logtable.setVisible(true);
              try
              {
              
                     myConnection=DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
                     myStatement=myConnection.createStatement();
                     myResult=myStatement.executeQuery("Select COSTUMER_NUMBER ,DATE,FIRST_NAME,LAST_NAME,TOTAL_PAYMENT from LAUNDRYSHOP.HISTORY1 "
                                                       + "where LAST_NAME ='"+txtlast_name.getText()+"' AND FIRST_NAME ='"+txtfirst_name.getText()+ "' OR COSTUMER_NUMBER ='"+costumer_idtxt.getText()+"'");
                     logtable.setModel(DbUtils.resultSetToTableModel(myResult));
              }
              catch(SQLException ex)
              {
              ex.printStackTrace();
              }
         }
          
           if(e.getSource()==viewitems)
         {
            
              logtable.setVisible(true);
              try
              {
              
                     myConnection=DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
                     myStatement=myConnection.createStatement();
                     myResult=myStatement.executeQuery("Select DATE,SHIRT,JEANS,SWEATER,SUIT,CURTAIN,BLANKET,BLOUSE,PAJAMA,UNDERWEAR,SKIRT,SHORTS,SOCKS from LAUNDRYSHOP.HISTORY1 "
                                                       + "where LAST_NAME ='"+txtlast_name.getText()+"' AND FIRST_NAME ='"+txtfirst_name.getText()+ "' OR COSTUMER_NUMBER ='"+costumer_idtxt.getText()+"'");
                     logtable.setModel(DbUtils.resultSetToTableModel(myResult));
              }
              catch(SQLException ex)
              {
              ex.printStackTrace();
              }
         }
     }
}

