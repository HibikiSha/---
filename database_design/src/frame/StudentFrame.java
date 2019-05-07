package frame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.AccountInfor;
public class StudentFrame extends AccountInfor {
	private JFrame f;
	private JTextField tfSearchSno;
	private JTextField tfSearchSname;
	private JTextField tfSearchSsex;
	private JTextField tfSearchSageMin;
	private JTextField tfSearchSageMax;
	private JTextField tfSearchSdept;
	private JTextField tfSno;
	private JTextField tfSname;
	private JTextField tfSsex;
	private JTextField tfSage;
	private JTextField tfSdept;
	private JButton butSearch;
	private JButton butInsert;
	private JButton butDelete;
	private JLabel labSearch;
	private JLabel labSname1;
	private JLabel labSno1;
	private JLabel labSsex1;
	private JLabel labSname2;
	private JLabel labSno2;
	private JLabel labSsex2;
	private JLabel labSage1;
	private JLabel labSage2;
	private JLabel labInsert;
	private JLabel labSdept1;
	private JLabel labSdept2;
	private JLabel labWave;
	private JTextArea ep;

	public StudentFrame()
	{
		init();
	}
	
	public void init()//定义登陆界面的框架
	{
		f= new JFrame ("课程信息数据库");
		butSearch = new JButton("开始查询");
		butInsert = new JButton("插入信息");
		butDelete = new JButton("删除");
		labSearch= new JLabel("<html><font color=black size=4 face=\"verdana\">查询区</font></html>");
		labInsert= new JLabel("<html><font color=black size=4 face=\"verdana\">添加/删除</font></html>");
		labSno1= new JLabel("<html><font color=black size=4 face=\"verdana\">学号(Sno)：</font></html>");
		labSno2= new JLabel("<html><font color=black size=4 face=\"verdana\">学号(Sno)：</font></html>");
		labSsex1= new JLabel("<html><font color=black size=4 face=\"verdana\">性别(Ssex)：</font></html>");
		labSsex2= new JLabel("<html><font color=black size=4 face=\"verdana\">性别(Ssex)：</font></html>");
		labSname1= new JLabel("<html><font color=black size=4 face=\"verdana\">姓名(Sname)：</font></html>");
		labSname2= new JLabel("<html><font color=black size=4 face=\"verdana\">姓名(Sname)：</font></html>");
		labSage1= new JLabel("<html><font color=black size=4 face=\"verdana\">年龄(Sage)：</font></html>");
		labSage2= new JLabel("<html><font color=black size=4 face=\"verdana\">年龄(Sage)：</font></html>");
		labSdept1= new JLabel("<html><font color=black size=4 face=\"verdana\">专业(Sdept)：</font></html>");
		labSdept2= new JLabel("<html><font color=black size=4 face=\"verdana\">专业(Sdept)：</font></html>");
		labWave= new JLabel("<html><font color=black size=4 face=\"verdana\">~</font></html>");
		ep = new JTextArea();
		ep.setLineWrap(true);
		Font x = new Font("Serif",0,20); 
		ep.setFont(x);
		tfSearchSname = new JTextField(15);
		tfSearchSno = new JTextField(15);
		tfSearchSsex = new JTextField(15);
		tfSearchSageMin = new JTextField(15);
		tfSearchSageMax = new JTextField(15);
		tfSearchSdept = new JTextField(15);
		tfSno = new JTextField(15);
		tfSname = new JTextField(15);
		tfSsex = new JTextField(15);
		tfSage = new JTextField(15);
		tfSdept = new JTextField(15);
		f.setBounds(300,200,1920,960);
		f.setLayout(null);//无框架模式
		
		//添加组件
		//设置组件位置
		labSearch.setBounds(100,100,80,50);
		labSno1.setBounds(100,200,80,50);
		labSname1.setBounds(100,300,80,50);
		labSsex1.setBounds(100,400,80,50);
		labSage1.setBounds(100,500,80,50);
		labSage2.setBounds(580, 500, 80, 50);
		labInsert.setBounds(580,100,80,50);
		labSno2.setBounds(580,200,80,50);
		labSname2.setBounds(580,300,80,50);
		labSsex2.setBounds(580,400,80,50);
		labSdept1.setBounds(100,600,80,50);
		labSdept2.setBounds(580,600,80,50);
		labWave.setBounds(320,500,20,50);
		butInsert.setBounds(400,700,200,70);
		butSearch.setBounds(120,700,200,70);
		butDelete.setBounds(650,700,200,70);
		tfSearchSno.setBounds(200,200,100,50);
		tfSearchSname.setBounds(200,300,100,50);
		tfSearchSsex.setBounds(200,400,100,50);
		tfSearchSageMin.setBounds(200,500,100,50);
		tfSearchSageMax.setBounds(360,500,100,50);
		tfSearchSdept.setBounds(200, 600, 100, 50);
		tfSno.setBounds(680,200,100,50);
		tfSname.setBounds(680,300,100,50);
		tfSsex.setBounds(680,400,100,50);
		tfSage.setBounds(680,500,100,50);
		tfSdept.setBounds(680, 600, 100, 50);
		ep.setBounds(960,100,800,700);
		f.add(labSno1);
		f.add(labSno2);
		f.add(labSname1);
		f.add(labSname2);
		f.add(labInsert);
		f.add(labSsex1);
		f.add(labSearch);
		f.add(labSsex2);
		f.add(labSage1);
		f.add(labSage2);
		f.add(labSdept1);
		f.add(labSdept2);
		f.add(labWave);
		f.add (butSearch);
		f.add (butInsert);
		f.add (butDelete);
		f.add (tfSearchSname);
		f.add (tfSearchSno);
		f.add (tfSearchSsex);
		f.add (tfSearchSageMin);
		f.add (tfSearchSageMax);
		f.add (tfSearchSdept);
		f.add (tfSname);
		f.add (tfSno);
		f.add (tfSsex);
		f.add (tfSage);
		f.add (tfSdept);
		f.add (ep);
		myEvent();
		f.setVisible(true);
	}
	private void myEvent()//通过事件监听关闭窗口
	{   
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				   f.dispose();
			}
		});
		//button按钮实现
		butSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
		        PreparedStatement ps=null;
		        Connection ct=null;
		        ResultSet rs=null;
		        try {
		            //1.加载驱动
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            //2.得到链接 127.0.0.1:1433
		            ct=DriverManager.getConnection
		                    ("jdbc:sqlserver://127.0.0.1:1433;databaseName=S_C",account1.getAccount(),account1.getPassword());
		            String SnoCon = " Sno is not null ";
		            String SnameCon = " Sname is not null ";
		            String SsexCon = " Ssex is not null ";
		            String SageCon = " Sage is not null ";
		            String SdeptCon = " Sdept is not null ";
		            if(tfSearchSno.getText().length()!=0) { SnoCon = " Sno = " + tfSearchSno.getText();}
		            if(tfSearchSname.getText().length()!=0) {SnameCon = " Sname like '%" + tfSearchSname.getText() + "%'";}
		            if(tfSearchSsex.getText().length()!=0) {SsexCon = " Ssex = '" + tfSearchSsex.getText() + "'";}
		            if(tfSearchSageMin.getText().length()!=0&&tfSearchSageMax.getText().length()!=0) 
		            {SageCon = " Sage between " + tfSearchSageMin.getText() + " and " + tfSearchSageMax.getText();}
		            if(tfSearchSdept.getText().length()!=0) {SdeptCon = " Sdept = '" + tfSearchSdept.getText() + "'";}
		            ps=ct.prepareStatement("select * from Student where " + SnoCon +" and "+ SnameCon +" and "+ SsexCon + " and " + SageCon + " and " + SdeptCon);
		            rs=ps.executeQuery();
	                System.out.println('\n');
	            	ep.setText("");
		            while(rs.next()) {
		                String sno=rs.getString(1);
		                String sname=rs.getString(2);
		                String ssex=rs.getString(3);
		                String sage=rs.getString(4);
		                String sdept=rs.getString(5);
		                System.out.println("学号： " + sno + " 姓名： " + sname + " 性别： " + ssex + " 年龄： " + sage + " 专业： " + sdept);
		                ep.append("学号： " + sno + " 姓名： " + sname + " 性别： " + ssex + " 年龄： " + sage + " 专业： " + sdept +"\n");
		            }
		        }catch(Exception e1) {
		            e1.printStackTrace();
		        }finally {
		            try {
		                if(rs != null)rs.close();
		                if(ps != null)ps.close();
		                if(ct != null)ct.close();
		            }catch(Exception e1) {
		                e1.printStackTrace();
		            }
		        }

			}
		});
		butInsert.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
		        PreparedStatement ps=null;
		        Connection ct=null;
		        ResultSet rs=null;
		        try {
		            //1.加载驱动
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            //2.得到链接 127.0.0.1:1433
		            ct=DriverManager.getConnection
		                    ("jdbc:sqlserver://127.0.0.1:1433;databaseName=S_C",account1.getAccount(),account1.getPassword());

		            ps=ct.prepareStatement("INSERT into Student (Sno, Sname, Ssex, Sage, Sdept) VALUES (?,?,?,?,?) ");
		            ps.setString(1,tfSno.getText());
		            ps.setString(2,tfSname.getText());
		            ps.setString(3,tfSsex.getText());
		            ps.setString(4,tfSage.getText());
		            ps.setString(5,tfSdept.getText());
		            ps.executeQuery();
	                System.out.println("添加成功");
	                ep.setText("添加成功");

		        }catch(Exception e1) {
		            e1.printStackTrace();
		        }finally {
		            try {
		                if(rs != null)rs.close();
		                if(ps != null)ps.close();
		                if(ct != null)ct.close();
		            }catch(Exception e1) {
		                e1.printStackTrace();
		            }		        }

			}
		});
		butDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
		        PreparedStatement ps=null;
		        Connection ct=null;
		        ResultSet rs=null;
		        try {
		            //1.加载驱动
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            //2.得到链接 127.0.0.1:1433
		            ct=DriverManager.getConnection
		                    ("jdbc:sqlserver://127.0.0.1:1433;databaseName=S_C",account1.getAccount(),account1.getPassword());
		            String SnoCon = " Sno is not null ";
		            String SnameCon = " Sname is not null ";
		            String SsexCon = " Ssex is not null ";
		            String SageCon = " Sage is not null ";
		            String SdeptCon = " Sdept is not null ";
		            if(tfSno.getText().length()!=0) { SnoCon = " Sno = " + tfSno.getText();}
		            if(tfSname.getText().length()!=0) {SnameCon = " Sname = '" + tfSname.getText() + "'";}
		            if(tfSearchSsex.getText().length()!=0) {SsexCon = " Ssex = '" + tfSsex.getText() + "'";}
		            if(tfSage.getText().length()!=0) {SageCon = " Sage = " + tfSage.getText();}
		            if(tfSearchSdept.getText().length()!=0) {SdeptCon = " Sdept = '" + tfSearchSdept.getText() + "'";}
		            
		            ps=ct.prepareStatement("delete from Student where " + SnoCon +" and "+ SnameCon +" and "+ SsexCon + " and " + SageCon + " and " + SdeptCon);
		            System.out.println("delete from Student where " + SnoCon +" and "+ SnameCon +" and "+ SsexCon + " and " + SageCon + " and " + SdeptCon);
		            ps.executeUpdate();
	                ep.setText("删除成功");
		        }catch(Exception e1) {
		            e1.printStackTrace();
		        }finally {
		            try {
		                if(rs != null)rs.close();
		                if(ps != null)ps.close();
		                if(ct != null)ct.close();
		            }catch(Exception e1) {
		                e1.printStackTrace();
		            }
		        }


			}
		});


	}


}
