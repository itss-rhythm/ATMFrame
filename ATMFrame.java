import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import javax.swing.ImageIcon;
public class ATMFrame extends JFrame implements ActionListener
{
  private JButton jBt7 = new JButton();
  private JButton jBt4 = new JButton();
  private JButton jBt1 = new JButton();
  private JButton jBt0 = new JButton();
  private JButton jBtDec = new JButton();
  private JButton jBt2 = new JButton();
  private JButton jBt5 = new JButton();
  private JButton jBt8 = new JButton();
  private JButton jBCancel = new JButton();
  private JButton jBt3 = new JButton();
  private JButton jBt6 = new JButton();
  private JButton jBt9 = new JButton();
  private JButton withdrawBt = new JButton();
  private JButton depositBt = new JButton();
  private JButton transferBt = new JButton();
  private JButton balanceBt = new JButton();
  private JButton savingBt = new JButton();
  private JButton currentBt = new JButton();
  private JButton enterBt = new JButton();
  private JButton pinChangeBt = new JButton();
  private JLabel logoLbl = new JLabel();
  private JTextField jtf = new JTextField();
  private JLabel msgLbl = new JLabel();
  private JPasswordField jPwdField = new JPasswordField();
  private String pinNo,accNo,trType,otherAccNo,accType;
  private Connection con;
  private Statement stmt;
  private ResultSet rs;
  private boolean flagAccPwd,flagTran;
  private long amt;
  private int times;
  public ATMFrame()
  {
    try
    {
      jbInit();
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=ATMDataBase.mdb";
  con = DriverManager.getConnection(url);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception
  {
 this.getContentPane().setLayout(null);
    this.setBounds(200,200,551,217);
    this.setTitle("ATM");
    this.setResizable(false);
    this.getContentPane().setBackground(new Color(236, 236, 131));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jBt7.setText("7");
    jBt7.setForeground(Color.red);
    jBt7.setFocusPainted(false);
    jBt7.setBounds(new Rectangle(15, 90, 40, 35));
    jBt7.setMargin(new Insets(0, 0, 0, 0));
    jBt4.setText("4");
    jBt4.setForeground(Color.red);
    jBt4.setFocusPainted(false);
    jBt4.setBounds(new Rectangle(15, 50, 40, 35));
    jBt4.setMargin(new Insets(0, 0, 0, 0));
    jBt1.setText("1");
    jBt1.setForeground(Color.red);
    jBt1.setFocusPainted(false);
    jBt1.setBounds(new Rectangle(15, 10, 40, 35));
    jBt1.setMargin(new Insets(0, 0, 0, 0));
    jBt0.setText("0");
    jBt0.setForeground(Color.red);
    jBt0.setFocusPainted(false);
    jBt0.setBounds(new Rectangle(15, 130, 40, 35));
    jBt0.setMargin(new Insets(0, 0, 0, 0));
    jBtDec.setText("C");
    jBtDec.setForeground(Color.red);
    jBtDec.setFocusPainted(false);
    jBtDec.setBounds(new Rectangle(60, 130, 40, 35));
    jBtDec.setMargin(new Insets(0, 0, 0, 0));
    jBt2.setText("2");
    jBt2.setForeground(Color.red);
    jBt2.setFocusPainted(false);
    jBt2.setBounds(new Rectangle(60, 10, 40, 35));
    jBt2.setMargin(new Insets(0, 0, 0, 0));
    jBt5.setText("5");
    jBt5.setForeground(Color.red);
    jBt5.setFocusPainted(false);
    jBt5.setBounds(new Rectangle(60, 50, 40, 35));
    jBt5.setMargin(new Insets(0, 0, 0, 0));
    jBt8.setText("8");
    jBt8.setForeground(Color.red);
    jBt8.setFocusPainted(false);
    jBt8.setBounds(new Rectangle(60, 90, 40, 35));
    jBt8.setMargin(new Insets(0, 0, 0, 0));
    jBCancel.setText("CE");
    jBCancel.setForeground(Color.red);
    jBCancel.setFocusPainted(false);
    jBCancel.setBounds(new Rectangle(105, 130, 40, 35));
    jBCancel.setMargin(new Insets(0, 0, 0, 0));
    jBt3.setText("3");
    jBt3.setForeground(Color.red);
    jBt3.setFocusPainted(false);
    jBt3.setBounds(new Rectangle(105, 10, 40, 35));
    jBt3.setMargin(new Insets(0, 0, 0, 0));
    jBt6.setText("6");
    jBt6.setForeground(Color.red);
    jBt6.setFocusPainted(false);
    jBt6.setBounds(new Rectangle(105, 50, 40, 35));
    jBt6.setMargin(new Insets(0, 0, 0, 0));
    jBt9.setText("9");
    jBt9.setForeground(Color.red);
    jBt9.setFocusPainted(false);
    jBt9.setBounds(new Rectangle(105, 90, 40, 35));
    jBt9.setMargin(new Insets(0, 0, 0, 0));
    withdrawBt.setText("Withdraw");
    withdrawBt.setForeground(Color.red);
    withdrawBt.setFocusPainted(false);
    withdrawBt.setBounds(new Rectangle(440, 15, 85, 30));
    withdrawBt.setMargin(new Insets(0, 0, 0, 0));
    depositBt.setText("Deposit");
    depositBt.setForeground(Color.red);
    depositBt.setFocusPainted(false);
    depositBt.setBounds(new Rectangle(350, 15, 85, 30));
    transferBt.setText("Transfer");
    transferBt.setForeground(Color.red);
    transferBt.setFocusPainted(false);
    transferBt.setBounds(new Rectangle(440, 55, 85, 30));
    balanceBt.setText("Balance");
    balanceBt.setForeground(Color.red);
    balanceBt.setFocusPainted(false);
    balanceBt.setBounds(new Rectangle(350, 55, 85, 30));
    savingBt.setText("Saving");
    savingBt.setForeground(Color.red);
    savingBt.setFocusPainted(false);
    savingBt.setBounds(new Rectangle(440, 95, 85, 30));
    currentBt.setText("Current");
    currentBt.setForeground(Color.red);
    currentBt.setFocusPainted(false);
    currentBt.setBounds(new Rectangle(350, 95, 85, 30));
    enterBt.setText("Enter");
    enterBt.setForeground(Color.red);
    enterBt.setFocusPainted(false);
    enterBt.setBounds(new Rectangle(350, 135, 85, 30));
    pinChangeBt.setText("PinChange");
    pinChangeBt.setForeground(Color.red);
    pinChangeBt.setFocusPainted(false);
    pinChangeBt.setBounds(new Rectangle(440, 135, 85, 30));
    pinChangeBt.setMargin(new Insets(0, 0, 0, 0));
    logoLbl.setText("ICICI Bank ATM");
// logoLbl.setIcon(new ImageIcon("logo.GIF"));
    logoLbl.setBounds(new Rectangle(155, 10, 175, 30));
    logoLbl.setHorizontalAlignment(JLabel.CENTER);
    logoLbl.setFont(new Font("Tahoma", 1, 11));
    logoLbl.setForeground(new Color(13, 22, 247));
    jtf.setBounds(new Rectangle(160, 135, 170, 30));
    jtf.setFont(new Font("Tahoma", 1, 11));
    jtf.setForeground(new Color(13, 22, 247));
    msgLbl.setText("Enter AccNo");
    msgLbl.setBounds(new Rectangle(155, 65, 180, 50));
    msgLbl.setHorizontalAlignment(JLabel.CENTER);
    msgLbl.setFont(new Font("Tahoma", 1, 11));
    msgLbl.setForeground(new Color(13, 22, 247));
    jPwdField.setBounds(new Rectangle(160, 135, 170, 30));
    jPwdField.setForeground(new Color(13, 22, 247));
    jPwdField.setFont(new Font("Tahoma", 1, 11));
    this.getContentPane().add(jPwdField, null);
    this.getContentPane().add(msgLbl, null);
    this.getContentPane().add(jtf, null);
    this.getContentPane().add(logoLbl, null);
    this.getContentPane().add(pinChangeBt, null);
    this.getContentPane().add(enterBt, null);
    this.getContentPane().add(currentBt, null);
    this.getContentPane().add(savingBt, null);
    this.getContentPane().add(balanceBt, null);
    this.getContentPane().add(transferBt, null);
    this.getContentPane().add(depositBt, null);
    this.getContentPane().add(withdrawBt, null);
    this.getContentPane().add(jBt9, null);
    this.getContentPane().add(jBt6, null);
    this.getContentPane().add(jBt3, null);
    this.getContentPane().add(jBCancel, null);
    this.getContentPane().add(jBt8, null);
    this.getContentPane().add(jBt5, null);
    this.getContentPane().add(jBt2, null);
    this.getContentPane().add(jBtDec, null);
    this.getContentPane().add(jBt0, null);
    this.getContentPane().add(jBt1, null);
    this.getContentPane().add(jBt4, null);
    this.getContentPane().add(jBt7, null);
    jBt1.addActionListener(this);
    jBt2.addActionListener(this);
    jBt3.addActionListener(this);
    jBt4.addActionListener(this);
    jBt5.addActionListener(this);
    jBt6.addActionListener(this);
    jBt7.addActionListener(this);
    jBt8.addActionListener(this);
    jBt9.addActionListener(this);
    jBt0.addActionListener(this);
    jBtDec.addActionListener(this);
    jBCancel.addActionListener(this);
    currentBt.addActionListener(this);
    savingBt.addActionListener(this);
    depositBt.addActionListener(this);
    withdrawBt.addActionListener(this);
    pinChangeBt.addActionListener(this);
    enterBt.addActionListener(this);
    balanceBt.addActionListener(this);
    transferBt.addActionListener(this);
    jPwdField.setVisible(false);
    jtf.setVisible(true);
    jPwdField.setEnabled(false);
    jtf.setEnabled(false);
    depositBt.setEnabled(false);
    withdrawBt.setEnabled(false);
    currentBt.setEnabled(false);
    savingBt.setEnabled(false);
    balanceBt.setEnabled(false);
    transferBt.setEnabled(false);
    pinChangeBt.setEnabled(false);
  }
  public void actionPerformed(ActionEvent ae)
  {
    String str=ae.getActionCommand();
 if(str.equals("Enter"))
    {
  String msg=msgLbl.getText();
  if(msg.equals("Enter AccNo"))
  {
   accNo=jtf.getText();
   if(accNo.equals(""))
   {
    JOptionPane.showMessageDialog(this,"AccNo can't be blank","Error",JOptionPane.ERROR_MESSAGE);
    return;
   }
   msgLbl.setText("Enter PinNo");
   jPwdField.setVisible(true);
   jPwdField.setText("");
   jtf.setVisible(false);
   flagAccPwd=true;
  }
  else if(msg.equals("Enter PinNo"))
  {
   pinNo=jPwdField.getText();
   if(pinNo.equals(""))
   {
    JOptionPane.showMessageDialog(this,"PinNo can't be blank","Error",JOptionPane.ERROR_MESSAGE);
    return;
   }
   jPwdField.setVisible(false);
   jtf.setVisible(false);
   enterBt.setEnabled(false);
   try
   {
    stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=stmt.executeQuery("select * from AccDetails where AccNo='"+accNo+"' and PinNo='"+pinNo+"'");
    if(rs.first())
    {
     msgLbl.setText("Enter Account Type");
     logoLbl.setText(rs.getString("Name"));
     depositBt.setEnabled(false);
     withdrawBt.setEnabled(false);
     currentBt.setEnabled(true);
     savingBt.setEnabled(true);
     balanceBt.setEnabled(false);
     transferBt.setEnabled(false);
     pinChangeBt.setEnabled(false);
    }
    else
    {
     JOptionPane.showMessageDialog(this,"You Entered Wrong PinNo.","Error",JOptionPane.ERROR_MESSAGE);
     msgLbl.setText("Enter AccNo");
     jPwdField.setVisible(false);
     jtf.setVisible(true);
     jtf.setText("");
     enterBt.setEnabled(true);
     accNo=pinNo=null;
     flagAccPwd=false;
    }
    rs.close();
    stmt.close();
   }
   catch(SQLException sql)
   {
    sql.printStackTrace();
   }
  }
  else if(msg.equals("Enter Other's AccNo"))
  {
   otherAccNo=jtf.getText();
   msgLbl.setText("Enter Amount");
   jtf.setText("");
   jPwdField.setVisible(false);
   jtf.setVisible(true);
   enterBt.setEnabled(true);
   flagAccPwd=false;
  }
  else if(msg.equals("Enter Amount"))
  {
   try
   {
    if(jtf.getText()==null || jtf.getText().equals(""))
    {
     JOptionPane.showMessageDialog(this,"Amount can't be left blank","Error",JOptionPane.ERROR_MESSAGE);
     return;
    }
    amt=Long.parseLong(jtf.getText());
    if(amt%100!=0)
    {
     JOptionPane.showMessageDialog(this,"Enter correct amount \n multiples of 100 only","Error",JOptionPane.ERROR_MESSAGE);
     return;
    }
    stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=stmt.executeQuery("select * from AccDetails where AccNo='"+accNo+"'");
    if(rs.next())
    {
     long bal=rs.getInt("Balance");
     if(bal-amt<5000 && (trType.equals("Withdraw") || trType.equals("Transfer")))
     {
      JOptionPane.showMessageDialog(this,"You are exceeding minimum balance","Error",JOptionPane.ERROR_MESSAGE);
      return;
     }
     if(trType.equals("Withdraw") || trType.equals("Transfer"))
     {
      Date date=Calendar.getInstance().getTime();
      String dateStr=DateFormat.getDateInstance(DateFormat.SHORT).format(date);
      rs=stmt.executeQuery("select sum(Amount) from Transactions where AccNo='"+accNo+"' and TrDate=DateValue('"+dateStr+"') and (TrType='Withdraw' or TrType='Transfer');");
      if(rs.next())
      {
       long totTranAmt=rs.getInt(1);
       if(totTranAmt==20000)
       {
        JOptionPane.showMessageDialog(this,"Today you have already done transaction of \nRs.20,000 One day withdrawl/transfer limit","Error",JOptionPane.ERROR_MESSAGE);
        return;
       }
       else if((totTranAmt+amt)>20000)
       {
        JOptionPane.showMessageDialog(this,"You are exceeding transaction limit per day\n Today you can "+trType+" a maximum of Rs."+(20000-totTranAmt),"Error",JOptionPane.ERROR_MESSAGE);
        return;
       }
      }
     }
     if(trType.equals("Withdraw"))
     {
      stmt.execute("update AccDetails set Balance="+(bal-amt)+" where AccNo='"+accNo+"'");
      int res=stmt.getUpdateCount();
      if(res==-1)
       JOptionPane.showMessageDialog(this,"Error occured while withdrawing try again","Error",JOptionPane.ERROR_MESSAGE);
      else
       JOptionPane.showMessageDialog(this,"Withdraw Successful","Message",JOptionPane.INFORMATION_MESSAGE);
      if(res!=-1)
      {
       Date date=Calendar.getInstance().getTime();
       String dateStr=DateFormat.getDateInstance(DateFormat.SHORT).format(date);
       stmt.execute("insert into Transactions(TrDate,AccNo,AccType,TrType,OtherAccNo,Amount) values('"+dateStr+"','"+accNo+"','"+accType+"','"+trType+"','"+accNo+"',"+amt+")");
      }
      trType="";
      jtf.setText("");
      msgLbl.setText("Enter Transaction Choice");
      jPwdField.setVisible(false);
      jtf.setVisible(false);
      enterBt.setEnabled(false);
      currentBt.setEnabled(false);
      savingBt.setEnabled(false);
      depositBt.setEnabled(true);
      withdrawBt.setEnabled(true);
      balanceBt.setEnabled(true);
      transferBt.setEnabled(true);
      pinChangeBt.setEnabled(true);
      flagAccPwd=false;
     }
     else if(trType.equals("Deposit"))
     {
      stmt.execute("update AccDetails set Balance="+(bal+amt)+" where AccNo='"+accNo+"'");
      int res=stmt.getUpdateCount();
      if(res==-1)
       JOptionPane.showMessageDialog(this,"Error occured while depositing try again","Error",JOptionPane.ERROR_MESSAGE);
      else
       JOptionPane.showMessageDialog(this,"Deposited Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
      if(res!=-1)
      {
       Date date=Calendar.getInstance().getTime();
       String dateStr=DateFormat.getDateInstance(DateFormat.SHORT).format(date);
       stmt.execute("insert into Transactions(TrDate,AccNo,AccType,TrType,OtherAccNo,Amount) values('"+dateStr+"','"+accNo+"','"+accType+"','"+trType+"','"+accNo+"',"+amt+")");
      }
      trType="";
      jtf.setText("");
      msgLbl.setText("Enter Transaction Choice");
      jPwdField.setVisible(false);
      jtf.setVisible(false);
      enterBt.setEnabled(false);
      currentBt.setEnabled(false);
      savingBt.setEnabled(false);
      depositBt.setEnabled(true);
      withdrawBt.setEnabled(true);
      balanceBt.setEnabled(true);
      transferBt.setEnabled(true);
      pinChangeBt.setEnabled(true);
      flagAccPwd=false;
     }
     else if(trType.equals("Transfer"))
     {
      flagTran=true;
      int res;
      one:
      {
       stmt.execute("update AccDetails set Balance="+(bal-amt)+" where AccNo='"+accNo+"'");
       res=stmt.getUpdateCount();
       if(res==-1)
       {
        flagTran=false;
        break one;
       }
       rs=stmt.executeQuery("select * from AccDetails where AccNo='"+otherAccNo+"'");
       if(!rs.first())
       {
        flagTran=false;
        break one;
       }
       stmt.execute("update AccDetails set Balance="+(rs.getInt("Balance")+amt)+" where AccNo='"+otherAccNo+"'");
       res=stmt.getUpdateCount();
       if(res==-1)
       {
        flagTran=false;
        break one;
       }
      }
      if(flagTran)
      {
       JOptionPane.showMessageDialog(this,"Transfer Successful","Message",JOptionPane.INFORMATION_MESSAGE);
       Date date=Calendar.getInstance().getTime();
       String dateStr=DateFormat.getDateInstance(DateFormat.SHORT).format(date);
       stmt.execute("insert into Transactions(TrDate,AccNo,AccType,TrType,OtherAccNo,Amount) values('"+dateStr+"','"+accNo+"','"+accType+"','Transfer','"+otherAccNo+"',"+amt+")");
       stmt.execute("insert into Transactions(TrDate,AccNo,AccType,TrType,OtherAccNo,Amount) values('"+dateStr+"','"+otherAccNo+"','"+accType+"','Deposit','"+accNo+"',"+amt+")");
      }
      else
       JOptionPane.showMessageDialog(this,"Error occured while transfering","Error",JOptionPane.ERROR_MESSAGE);
      stmt.close();
      otherAccNo=null;
      trType="";
      jtf.setText("");
      msgLbl.setText("Enter Transaction Choice");
      jPwdField.setVisible(false);
      jtf.setVisible(false);
      enterBt.setEnabled(false);
      currentBt.setEnabled(false);
      savingBt.setEnabled(false);
      depositBt.setEnabled(true);
      withdrawBt.setEnabled(true);
      balanceBt.setEnabled(true);
      transferBt.setEnabled(true);
      pinChangeBt.setEnabled(true);
      flagAccPwd=false;
     }
    }
    else
    {
     JOptionPane.showMessageDialog(this,"Error occured while processing try again","Error",JOptionPane.ERROR_MESSAGE);
    }
   }
   catch(SQLException sql)
   {
    sql.printStackTrace();
   }
  }
  else if(msg.equals("Enter New Pin No."))
  {
   try
   {
    stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    stmt.execute("update AccDetails set PinNo='"+jPwdField.getText()+"' where AccNo='"+accNo+"' and PinNo='"+pinNo+"'");
    int res=stmt.getUpdateCount();
    if(res==-1)
     JOptionPane.showMessageDialog(this,"Error occured while changing PinNo","Error",JOptionPane.ERROR_MESSAGE);
    else
     JOptionPane.showMessageDialog(this,"Your PinNo has been changed","Message",JOptionPane.INFORMATION_MESSAGE);
    msgLbl.setText("Enter AccNo");
    logoLbl.setText("ICICI Bank ATM");
    jPwdField.setVisible(false);
    jPwdField.setText("");
    jtf.setText("");
    jtf.setVisible(true);
    enterBt.setEnabled(true);
    pinNo=accNo=trType=otherAccNo=accType=null;
    currentBt.setEnabled(false);
    savingBt.setEnabled(false);
    depositBt.setEnabled(false);
    withdrawBt.setEnabled(false);
    balanceBt.setEnabled(false);
    transferBt.setEnabled(false);
    pinChangeBt.setEnabled(false);
    flagAccPwd=false;
   }
   catch(SQLException sql)
   {
    sql.printStackTrace();
   }
  }
    }
    else if(str.equals("Saving"))
    {
  accType="Saving";
  msgLbl.setText("Enter Transaction Choice");
  jPwdField.setVisible(false);
  jtf.setVisible(false);
  enterBt.setEnabled(false);
  currentBt.setEnabled(false);
  savingBt.setEnabled(false);
  depositBt.setEnabled(true);
  withdrawBt.setEnabled(true);
  balanceBt.setEnabled(true);
  transferBt.setEnabled(true);
  pinChangeBt.setEnabled(true);
 }
    else if(str.equals("Current"))
    {
  accType="Current";
  msgLbl.setText("Enter Transaction Choice");
  jPwdField.setVisible(false);
  jtf.setVisible(false);
  enterBt.setEnabled(false);
  currentBt.setEnabled(false);
  savingBt.setEnabled(false);
  depositBt.setEnabled(true);
  withdrawBt.setEnabled(true);
  balanceBt.setEnabled(true);
  transferBt.setEnabled(true);
  pinChangeBt.setEnabled(true);
 }
 else if(str.equals("Withdraw"))
 {
  trType="Withdraw";
  jPwdField.setVisible(false);
  jtf.setVisible(true);
  jtf.setText("");
  enterBt.setEnabled(true);
  currentBt.setEnabled(false);
  savingBt.setEnabled(false);
  depositBt.setEnabled(false);
  withdrawBt.setEnabled(false);
  balanceBt.setEnabled(false);
  transferBt.setEnabled(false);
  pinChangeBt.setEnabled(false);
  msgLbl.setText("Enter Amount");
  flagAccPwd=false;
 }
 else if(str.equals("Deposit"))
 {
  trType="Deposit";
  jPwdField.setVisible(false);
  jtf.setVisible(true);
  jtf.setText("");
  enterBt.setEnabled(true);
  currentBt.setEnabled(false);
  savingBt.setEnabled(false);
  depositBt.setEnabled(false);
  withdrawBt.setEnabled(false);
  balanceBt.setEnabled(false);
  transferBt.setEnabled(false);
  pinChangeBt.setEnabled(false);
  msgLbl.setText("Enter Amount");
  flagAccPwd=false;
 }
 else if(str.equals("PinChange"))
 {
  trType="PinChange";
  msgLbl.setText("Enter New Pin No.");
  jPwdField.setVisible(true);
  jtf.setVisible(false);
  jPwdField.setText("");
  enterBt.setEnabled(true);
  currentBt.setEnabled(false);
  savingBt.setEnabled(false);
  depositBt.setEnabled(false);
  withdrawBt.setEnabled(false);
  balanceBt.setEnabled(false);
  transferBt.setEnabled(false);
  pinChangeBt.setEnabled(false);
  flagAccPwd=true;
 }
 else if(str.equals("Balance"))
 {
  try
  {
   trType="Balance";
   stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
   rs=stmt.executeQuery("select * from AccDetails where AccNo='"+accNo+"'");
   if(rs.first())
   {
    Date date=Calendar.getInstance().getTime();
    String dateStr=DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
    String balStr="<html><body><font color='blue'>Balance Statement</font>\nAccNo. : "+accNo+"\nDate : "+dateStr+"\nBalance : Rs."+rs.getString("Balance");//+"</body></html>";
    JOptionPane.showMessageDialog(this,balStr,"Balance",JOptionPane.INFORMATION_MESSAGE);
   }
   else
    JOptionPane.showMessageDialog(this,"Error occured while retrieveing","Error",JOptionPane.ERROR_MESSAGE);
   msgLbl.setText("Enter Transaction Choice");
   jPwdField.setVisible(false);
   jtf.setVisible(false);
   enterBt.setEnabled(false);
   currentBt.setEnabled(false);
   savingBt.setEnabled(false);
   depositBt.setEnabled(true);
   withdrawBt.setEnabled(true);
   balanceBt.setEnabled(true);
   transferBt.setEnabled(true);
   pinChangeBt.setEnabled(true);
   rs.close();
   stmt.close();
  }
  catch(SQLException sql)
  {
   sql.printStackTrace();
  }
 }
 else if(str.equals("Transfer"))
 {
  trType="Transfer";
  msgLbl.setText("Enter Other's AccNo");
  jtf.setText("");
  jPwdField.setVisible(false);
  jtf.setVisible(true);
  enterBt.setEnabled(true);
  currentBt.setEnabled(false);
  savingBt.setEnabled(false);
  depositBt.setEnabled(false);
  withdrawBt.setEnabled(false);
  balanceBt.setEnabled(false);
  transferBt.setEnabled(false);
  pinChangeBt.setEnabled(false);
  flagAccPwd=false;
 }
 else if(str.equals("CE"))
 {
  msgLbl.setText("Enter AccNo");
  jtf.setText("");
  jPwdField.setText("");
  enterBt.setEnabled(true);
  jPwdField.setVisible(false);
  jtf.setVisible(true);
  depositBt.setEnabled(false);
  withdrawBt.setEnabled(false);
  currentBt.setEnabled(false);
  savingBt.setEnabled(false);
  balanceBt.setEnabled(false);
  transferBt.setEnabled(false);
  pinChangeBt.setEnabled(false);
  logoLbl.setText("ICICI Bank ATM");
  pinNo=accNo=trType=otherAccNo=accType=null;
  flagAccPwd=false;
 }
    else if(flagAccPwd)
    {
  if(str.equals("1"))
    jPwdField.setText(jPwdField.getText()+str);
  else if(str.equals("2"))
    jPwdField.setText(jPwdField.getText()+str);
  else if(str.equals("3"))
    jPwdField.setText(jPwdField.getText()+str);
  else if(str.equals("4"))
    jPwdField.setText(jPwdField.getText()+str);
  else if(str.equals("5"))
    jPwdField.setText(jPwdField.getText()+str);
  else if(str.equals("6"))
    jPwdField.setText(jPwdField.getText()+str);
  else if(str.equals("7"))
    jPwdField.setText(jPwdField.getText()+str);
  else if(str.equals("8"))
    jPwdField.setText(jPwdField.getText()+str);
  else if(str.equals("9"))
    jPwdField.setText(jPwdField.getText()+str);
  else if(str.equals("0"))
    jPwdField.setText(jPwdField.getText()+str);
  else if(str.equals("."))
    jPwdField.setText(jPwdField.getText()+str);
  else if(str.equals("C"))
  {
    char pwd[]=jPwdField.getPassword();
    if(pwd!=null && pwd.length>0)
    {
   String newPin=String.copyValueOf(pwd,0,pwd.length-1);
   jPwdField.setText(newPin);
    }
    }
 }
 else if(!flagAccPwd)
 {
  if(str.equals("1"))
    jtf.setText(jtf.getText()+str);
  else if(str.equals("2"))
    jtf.setText(jtf.getText()+str);
  else if(str.equals("3"))
    jtf.setText(jtf.getText()+str);
  else if(str.equals("4"))
    jtf.setText(jtf.getText()+str);
  else if(str.equals("5"))
    jtf.setText(jtf.getText()+str);
  else if(str.equals("6"))
    jtf.setText(jtf.getText()+str);
  else if(str.equals("7"))
    jtf.setText(jtf.getText()+str);
  else if(str.equals("8"))
    jtf.setText(jtf.getText()+str);
  else if(str.equals("9"))
    jtf.setText(jtf.getText()+str);
  else if(str.equals("0"))
    jtf.setText(jtf.getText()+str);
  else if(str.equals("."))
    jtf.setText(jtf.getText()+str);
  else if(str.equals("C"))
  {
    String s=jtf.getText();
    if(s!=null && s.length()>0)
    {
   String newAcc=s.substring(0,s.length()-1);
   jtf.setText(newAcc);
    }
    }
   }
  }
  public static void main(String args[])
  {
   JFrame.setDefaultLookAndFeelDecorated(true);
   new ATMFrame().setVisible(true);
  }
} 

