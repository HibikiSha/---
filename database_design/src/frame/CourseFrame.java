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

public class CourseFrame extends AccountInfor{
	private JFrame f;
	private JTextField tfSearchCno;
	private JTextField tfSearchCname;
	private JTextField tfSearchCpno;
	private JTextField tfSearchCcredit;
	private JTextField tfCno;
	private JTextField tfCname;
	private JTextField tfCpno;
	private JTextField tfCcredit;
	private JButton butSearch;
	private JButton butInsert;
	private JButton butDelete;
	private JLabel labSearch;
	private JLabel labCname1;
	private JLabel labCno1;
	private JLabel labCpno1;
	private JLabel labCname2;
	private JLabel labCno2;
	private JLabel labCpno2;
	private JLabel labCcredit1;
	private JLabel labCcredit2;
	private JLabel labInsert;
	private JTextArea ep;

	public CourseFrame()
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
		labCno1= new JLabel("<html><font color=black size=4 face=\"verdana\">课程号(Cno)：</font></html>");
		labCno2= new JLabel("<html><font color=black size=4 face=\"verdana\">课程号(Cno)：</font></html>");
		labCpno1= new JLabel("<html><font color=black size=4 face=\"verdana\">先修课程号(Cpno)：</font></html>");
		labCpno2= new JLabel("<html><font color=black size=4 face=\"verdana\">先修课程号(Cpno)：</font></html>");
		labCname1= new JLabel("<html><font color=black size=4 face=\"verdana\">课程名(Cname)：</font></html>");
		labCname2= new JLabel("<html><font color=black size=4 face=\"verdana\">课程名(Cname)：</font></html>");
		labCcredit1= new JLabel("<html><font color=black size=4 face=\"verdana\">课程学分(Cname)：</font></html>");
		labCcredit2= new JLabel("<html><font color=black size=4 face=\"verdana\">课程学分(Cname)：</font></html>");

		tfSearchCname = new JTextField(15);
		tfSearchCno = new JTextField(15);
		tfSearchCpno = new JTextField(15);
		tfSearchCcredit = new JTextField(15);
		tfCno = new JTextField(15);
		tfCname = new JTextField(15);
		tfCpno = new JTextField(15);
		tfCcredit = new JTextField(15);
		f.setBounds(300,200,1920,960);
		f.setLayout(null);//无框架模式
		ep = new JTextArea();
		ep.setLineWrap(true);
		Font x = new Font("Serif",0,20); 
		ep.setFont(x);

		//添加组件
		//设置组件位置
		labSearch.setBounds(100,100,80,50);
		labCno1.setBounds(100,200,80,50);
		labCname1.setBounds(100,300,80,50);
		labCpno1.setBounds(100,400,80,50);
		labCcredit1.setBounds(100,500,80,50);
		labCcredit2.setBounds(580, 500, 80, 50);
		labInsert.setBounds(580,100,80,50);
		labCno2.setBounds(580,200,80,50);
		labCname2.setBounds(580,300,80,50);
		labCpno2.setBounds(580,400,80,50);
		butInsert.setBounds(400,700,200,70);
		butSearch.setBounds(120,700,200,70);
		butDelete.setBounds(650,700,200,70);
		tfSearchCno.setBounds(200,200,100,50);
		tfSearchCname.setBounds(200,300,100,50);
		tfSearchCpno.setBounds(200,400,100,50);
		tfSearchCcredit.setBounds(200,500,100,50);
		tfCno.setBounds(680,200,100,50);
		tfCname.setBounds(680,300,100,50);
		tfCpno.setBounds(680,400,100,50);
		tfCcredit.setBounds(680,500,100,50);
		ep.setBounds(960,100,800,700);

		f.add(labCno1);
		f.add(labCno2);
		f.add(labCname1);
		f.add(labCname2);
		f.add(labInsert);
		f.add(labCpno1);
		f.add(labSearch);
		f.add(labCpno2);
		f.add(labCcredit1);
		f.add(labCcredit2);
		f.add (butSearch);
		f.add (butInsert);
		f.add (butDelete);
		f.add (tfSearchCname);
		f.add (tfSearchCno);
		f.add (tfSearchCpno);
		f.add (tfSearchCcredit);
		f.add (tfCname);
		f.add (tfCno);
		f.add (tfCpno);
		f.add (tfCcredit);
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
		            String CnoCon = " Cno is not null ";
		            String CnameCon = " Cname is not null ";
		            String CpnoCon = " (Cpno is not null or Cpno is null)  ";
		            String CcreditCon = " Ccredit is not null ";
		            if(tfSearchCno.getText().length()!=0) { CnoCon = " Cno = " + tfSearchCno.getText();}
		            if(tfSearchCname.getText().length()!=0) {CnameCon = " Cname like '%" + tfSearchCname.getText() + "%'";}
		            if(tfSearchCpno.getText().length()!=0) {CpnoCon = " Cpno = " + tfSearchCpno.getText();}
		            if(tfSearchCcredit.getText().length()!=0) {CcreditCon = " Ccredit = " + tfSearchCcredit.getText();}
		            ps=ct.prepareStatement("select * from Course where " + CnoCon +" and "+ CnameCon +" and "+ CpnoCon + " and " + CcreditCon);
		            System.out.println("select * from Course where " + CnoCon +" and "+ CnameCon +" and "+ CpnoCon + " and " + CcreditCon);
		            rs=ps.executeQuery();
	                System.out.println('\n');
	            	ep.setText("");
		            while(rs.next()) {
		                String cno=rs.getString(1);
		                String cname=rs.getString(2);
		                String cpno=rs.getString(3);
		                String ccredit=rs.getString(4);
		                System.out.println("课程号： " + cno + " 课程名： " + cname + " 先修课程号： " + cpno + " 课程学分： " + ccredit);
		                ep.append("课程号： " + cno + " 课程名： " + cname + " 先修课程号： " + cpno + " 课程学分： " + ccredit +"\n");

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

		            ps=ct.prepareStatement("INSERT into Course (Cno, Cname, Cpno, Ccredit) VALUES (?,?,?,?) ");
		            ps.setString(1,tfCno.getText());
		            ps.setString(2,tfCname.getText());
		            if(tfCpno.getText().length()==0) {ps.setString(3, null);}
		            else{ps.setString(3,tfCpno.getText());}
		            ps.setString(4,tfCcredit.getText());
		            ps.executeUpdate();
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
		            String CnoCon = " Cno is not null ";
		            String CnameCon = " Cno is not null ";
		            String CpnoCon = " Cpno is null ";
		            String CcreditCon = " Ccredit is not null ";
		            if(tfCno.getText().length()!=0) { CnoCon = " Cno = " + tfCno.getText();}
		            if(tfCname.getText().length()!=0) {CnameCon = " Cname = '" + tfCname.getText() + "' ";}
		            if(tfCpno.getText().length()!=0) {CpnoCon = " Cpno = " + tfCpno.getText();}
		            if(tfCcredit.getText().length()!=0) {CcreditCon = " Ccredit = " + tfCcredit.getText();}
		           // System.out.println("delete from SC where " + SnoCon +" and "+ CnoCon +" and "+ GradeCon);
		            ps=ct.prepareStatement("delete from Course where " + CnoCon +" and "+ CnameCon +" and "+ CpnoCon + " and " + CcreditCon);
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
