package laundryshop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JFrame;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class Reports extends FormDesign implements ActionListener{
    
    public Connection myConnection=null;
    public Statement myStatement=null;
    public ResultSet myResult=null;
    private JTable logtable=new JTable();
    private JLabel tablePanel=new JLabel();
    
    private Object noOfSuit;
     double tot=0;
     String runner="0";
     
      JRadioButton checkmonth =new JRadioButton("By Month");
      JRadioButton checkyear=new JRadioButton("By Year");
   
     
     JLabel months = new JLabel("MONTH : ");
    JTextField txtmonths = new JTextField("");
    
    JLabel year = new JLabel("YEAR : ");
    JTextField txtyear = new JTextField("");
    
      JButton view=new JButton("View Report");
   
      
    JLabel mi = new JLabel("MONTHLY INCOME : ");
    JLabel mon = new JLabel("0000.00");
    
     JLabel exp = new JLabel("EXPENCES: ");
    JTextField txtexp = new JTextField("");
   
    
    JButton calculate = new JButton("Calculate Total Income");
    
     JLabel total = new JLabel("TOTAL INCOME : ");
    JLabel lbltotal = new JLabel("0000.00");
    
    
    JButton save = new JButton("Save");
  
    public Reports()
    {
        setTitle("Reports Form");
        lblFormTitle.setText("REPORTS FORM");
        icon5.setIcon( new ImageIcon(location + "Reports_B.png"));
        
        
tablePanel.setIcon( new ImageIcon(location + "addcust.jpg"));   
      tablePanel.setBounds(10, 30,580, 380);
      tablePanel.setBorder(new LineBorder(new Color(0,59,147),1,true));
      tablePanel.setOpaque(false);
      JScrollPane scrollTable=new JScrollPane(logtable);
      tablePanel.add(scrollTable);
       
        checkmonth.setFont(new  Font("Calibri", 0, 17));
        checkmonth.setForeground(Color.WHITE);
        checkmonth.setBounds(640, 25, 115, 25);
        checkmonth.setBackground(new Color(0,59,147)); 
         checkmonth.setOpaque(false);
       
        checkyear.setFont(new  Font("Calibri", 0, 17));
        checkyear.setForeground(Color.WHITE);
        checkyear.setBounds(750, 25, 120, 25);
        checkyear.setBackground(new Color(0,59,147)); 
       checkyear.setOpaque(false);
        
        months.setFont(new  Font("Calibri", 0, 12));
        months.setForeground(Color.WHITE);
        months.setBounds(590, 70, 130, 25);
        
        txtmonths.setBounds(640, 70, 100, 20);
        txtmonths.setFont(new  Font("Calibri", 0, 12));
        txtmonths.setForeground(Color.WHITE);
        txtmonths.setOpaque(false);
        txtmonths.setHorizontalAlignment(SwingConstants.CENTER);
        
        year.setFont(new  Font("Calibri", 0, 12));
        year.setForeground(Color.WHITE);
        year.setBounds(745, 70, 130, 25);
        
        txtyear.setBounds(785, 70, 100, 20);
        txtyear.setFont(new  Font("Calibri", 0, 12));
        txtyear.setForeground(Color.WHITE);
        txtyear.setOpaque(false);
        txtyear.setHorizontalAlignment(SwingConstants.CENTER);
      
        
        view.setFont(new  Font("Calibri", 0, 14));
        view.setBounds(590, 100, 295, 25);
        view.setVerticalAlignment(SwingConstants.CENTER);
        view.setHorizontalAlignment(SwingConstants.CENTER);
        view.setForeground(Color.WHITE);
        view.setBackground(new Color(13,52,200));
        view.setOpaque(false);
//     DateFormat dateFor=new SimpleDateFormat("MMMM dd,yyyy");
//     Date da=new Date();
     
     
//    JLabel curday=new JLabel(dateFor.format(da));
//    
//        curday.setFont(new  Font("Calibri", 1,30));
//        curday.setForeground(Color.WHITE);
//        curday.setBounds(160, 290,500, 40);
//        curday.setVerticalAlignment(SwingConstants.CENTER);
//        curday.setHorizontalAlignment(SwingConstants.LEFT);
//      
        mi.setFont(new  Font("Calibri", 0, 15));
        mi.setForeground(Color.WHITE);
        mi.setBounds(590, 200, 150, 50);
        
        mon.setFont(new  Font("Calibri", 0, 15));
        mon.setForeground(Color.WHITE);
        mon.setBounds(780, 215, 60, 25);
        
        exp.setFont(new  Font("Calibri", 0, 15));
        exp.setForeground(Color.WHITE);
        exp.setBounds(645, 230, 150, 50);
        
       txtexp.setBounds(730, 245, 155, 20);
        txtexp.setFont(new  Font("Calibri", 0, 12));
        txtexp.setForeground(Color.WHITE);
        txtexp.setOpaque(false);
        txtexp.setHorizontalAlignment(SwingConstants.CENTER);
      
         calculate.setFont(new  Font("Calibri", 0, 14));
        calculate.setBounds(590, 270, 295, 25);
        calculate.setVerticalAlignment(SwingConstants.CENTER);
        calculate.setHorizontalAlignment(SwingConstants.CENTER);
        calculate.setForeground(Color.WHITE);
        calculate.setBackground(new Color(13,52,200));
        calculate.setOpaque(false);
        
        
         total.setFont(new  Font("Calibri", 0, 15));
        total.setForeground(Color.WHITE);
        total.setBounds(615, 300, 150, 50);
        
        lbltotal.setFont(new  Font("Calibri", 0, 15));
        lbltotal.setForeground(Color.WHITE);
        lbltotal.setBounds(780, 315, 60, 25);
       
        
        save.setFont(new  Font("Calibri", 0, 20));
        save.setBounds(590, 355, 295, 50);
        save.setVerticalAlignment(SwingConstants.CENTER);
        save.setHorizontalAlignment(SwingConstants.CENTER);
        save.setForeground(Color.WHITE);
        save.setBackground(new Color(13,52,200));
        save.setOpaque(false);
        save.setToolTipText("Save Monthly Income");
      
     
      
      
       
   
//       
     
      logtable.setPreferredScrollableViewportSize(new Dimension(550,400));
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
      logtable.setFont(new Font("Calibri",0,12));
     logtable.setVisible(false);
     
      

     fullPanel.add(checkmonth);
      fullPanel.add(checkyear);
      fullPanel.add(tablePanel);
      fullPanel.add(months);
      fullPanel.add(txtmonths);
      fullPanel.add(year);
      fullPanel.add(txtyear);
      fullPanel.add(view);
      
      fullPanel.add(mi);
      fullPanel.add(mon);
      fullPanel.add(exp);
      fullPanel.add(txtexp);
      fullPanel.add(calculate);
      fullPanel.add(total);
      fullPanel.add(lbltotal);
      fullPanel.add(save);
      
      txtmonths.setEnabled(false);
      txtyear.setEnabled(false);
      view.setEnabled(false);
      
      mi.setVisible(false);
       mon.setVisible(false);
        exp.setVisible(false);
         txtexp.setVisible(false);
          calculate.setVisible(false);
          total.setVisible(false);
          lbltotal.setVisible(false);
          save.setVisible(false);
      calculate.addActionListener(this);
      save.addActionListener(this);
      view.addActionListener(this);
      checkyear.addActionListener(this);
      checkmonth.addActionListener(this);
    }
     public void actionPerformed(ActionEvent e) 
     {
         if(e.getSource()==view)
         {
             logtable.setVisible(true);
             if (view.getText().equals("View Monthly Report")) 
             {
                     mi.setVisible(true);
       mon.setVisible(true);
        exp.setVisible(true);
         txtexp.setVisible(true);
          calculate.setVisible(true);
          total.setVisible(true);
          lbltotal.setVisible(true);
          save.setVisible(true);
             
              try
              {
               
                     myConnection=DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
                     myStatement=myConnection.createStatement();
                     myResult=myStatement.executeQuery("Select * from LAUNDRYSHOP.REPORT1 "
                                                       + "where DATE LIKE '"+txtmonths.getText()+"%' AND DATE LIKE '%"+txtyear.getText()+"%' AND TOTAL_PAYMENT != 'FREE'");
                     logtable.setModel(DbUtils.resultSetToTableModel(myResult));
              }
              catch(SQLException ex)
              {
              ex.printStackTrace();
              }
               sum();
             }
             if (view.getText().equals("View Yearly Report")) 
             {
                  try
              {
               
                     myConnection=DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
                     myStatement=myConnection.createStatement();
                     myResult=myStatement.executeQuery("Select YEARS,JANUARYS AS JAN,FEBRUARYS AS FEB,MARCHS AS MAR,APRILS AS APR,MAYS AS MAYS, JUNES AS JUN,JULYS AS JUL,AUGUSTS AS AUG,SEPTEMBERS AS SEPT,OCTOBERS AS OCT, NOVEMBERS AS NOV, DECEMBERS AS DES from LAUNDRYSHOP.YEARLY ");
                     logtable.setModel(DbUtils.resultSetToTableModel(myResult));
              }
              catch(SQLException ex)
              {
              ex.printStackTrace();
              }
             }
         }
          if(e.getSource()==calculate)
         {
           double total=0;
           total=Double.parseDouble(mon.getText())-Double.parseDouble(txtexp.getText());
           lbltotal.setText(""+total);
           
         }
            if(e.getSource()==save)
         {
            
             try 
              {
                 
               myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
               PreparedStatement add = myConnection.prepareStatement("insert Into LaundryShop.YEARLY values(?,?,?)");
               
                 add.setString(1,txtyear.getText());
                  if ("January".equals(txtmonths.getText())) 
                  {
                      add.setString(2,lbltotal.getText());
                  }
                  else
                  {
                      add.setString(2,"0000");
                  }
                  if ("February".equals(txtmonths.getText())) 
                  {
                      add.setString(3,lbltotal.getText());
                  }
                  else
                  {
                      add.setString(3,"0000");
                  }
                   if ("March".equals(txtmonths.getText())) 
                  {
                      add.setString(4,lbltotal.getText());
                  }
                  else
                  {
                      add.setString(4,"0000");
                  }
                    if ("April".equals(txtmonths.getText())) 
                  {
                      add.setString(5,lbltotal.getText());
                  }
                  else
                  {
                      add.setString(5,"0000");
                  }
                    if ("May".equals(txtmonths.getText())) 
                  {
                      add.setString(6,lbltotal.getText());
                  }
                  else
                  {
                      add.setString(6,"0000");
                  }
                     if ("June".equals(txtmonths.getText())) 
                  {
                      add.setString(7,lbltotal.getText());
                  }
                  else
                  {
                      add.setString(7,"0000");
                  }
                        if ("July".equals(txtmonths.getText())) 
                  {
                      add.setString(8,lbltotal.getText());
                  }
                  else
                  {
                      add.setString(8,"0000");
                  }
                          if ("August".equals(txtmonths.getText())) 
                  {
                      add.setString(9,lbltotal.getText());
                  }
                  else
                  {
                      add.setString(9,"0000");
                  }
                     if ("September".equals(txtmonths.getText())) 
                  {
                      add.setString(10,lbltotal.getText());
                  }
                  else
                  {
                      add.setString(10,"0000");
                  }
                      if ("October".equals(txtmonths.getText())) 
                  {
                      add.setString(11,lbltotal.getText());
                  }
                  else
                  {
                      add.setString(11,"0000");
                  }
                        if ("November".equals(txtmonths.getText())) 
                  {
                      add.setString(12,lbltotal.getText());
                  }
                  else
                  {
                      add.setString(12,"0000");
                  }
                          if ("December".equals(txtmonths.getText())) 
                  {
                      add.setString(13,lbltotal.getText());
                  }
                  else
                  {
                      add.setString(13,"0000");
                  }
               
                  int row=add.executeUpdate();
                  JOptionPane.showMessageDialog(this,"Successfully Saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
                   
                  myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
               String dsql = "delete from LAUNDRYSHOP.REPORT1 "
                            + "where DATE LIKE '"+txtmonths.getText()+"%' AND DATE LIKE '%"+txtyear.getText()+"%'";
                PreparedStatement addd =myConnection.prepareStatement(dsql);
               addd.executeUpdate();
               
               
                 
              } catch (SQLException ex) 
              {
                  String up=txtmonths.getText();
                 try {
                     myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/LaundryShop","laundryshop","laundryshop");
                 
               String sql =" update LAUNDRYSHOP.YEARLY set "+up+"S = "+" '"+lbltotal.getText()+"' WHERE YEARS ='"+txtyear.getText()+"'";
              Statement update=myConnection.createStatement();
              
                update.executeUpdate(sql);
                JOptionPane.showMessageDialog(this,"Successfully Saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex1) {
                     Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex1);
                 }
              }
           
         }
            
            if (e.getSource()==checkmonth)
            {
              txtmonths.setEnabled(true);
              txtyear.setEnabled(true);
              view.setEnabled(true);
              view.setText("View Monthly Report");
            
            }
            else
            {
             txtmonths.setEnabled(false);
             txtyear.setEnabled(false);
             view.setEnabled(false);
          
            }
             if (e.getSource()==checkyear)
            {
             view.setEnabled(true);
             view.setText("View Yearly Report");
               mi.setVisible(false);
       mon.setVisible(false);
        exp.setVisible(false);
         txtexp.setVisible(false);
          calculate.setVisible(false);
          total.setVisible(false);
          lbltotal.setVisible(false);
          save.setVisible(false);
            }
           
             
             
             
             
             
             
             
             
     }

  
    public void sum()
       {
           double t=0;
           for(int i = 0;i<logtable.getRowCount();i++)
           {
               t=t+Double.parseDouble(logtable.getValueAt(i, 5).toString());
           }
                   mon.setText(Double.toString(t));
                    if (Double.parseDouble(mon.getText())<=0) 
                    {
                        mi.setVisible(false);
               mon.setVisible(false);
        exp.setVisible(false);
         txtexp.setVisible(false);
          calculate.setVisible(false);
          total.setVisible(false);
          lbltotal.setVisible(false);
          save.setVisible(false);
                    }
               
           }
       }

