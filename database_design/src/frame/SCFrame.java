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
public class SCFrame extends AccountInfor{
	private JFrame f;
	private JTextField tfSearchSno;
	private JTextField tfSearchCno;
	private JTextField tfSearchGradeMax;
	private JTextField tfSearchGradeMin;
	private JTextField tfSno;
	private JTextField tfCno;
	private JTextField tfGrade;
	private JButton butSearch;
	private JButton butInsert;
	private JButton butDelete;
	private JButton butUpdate;
	private JLabel labSearch;
	private JLabel labSno1;
	private JLabel labCno1;
	private JLabel labGrade1;
	private JLabel labSno2;
	private JLabel labCno2;
	private JLabel labGrade2;
	private JLabel labInsert;
	private JLabel labWave;
	private JTextArea ep;

	public SCFrame()
	{
		init();
	}
	public void init()//定义登陆界面的框架
	{
		f= new JFrame ("选课信息数据库");
		butSearch = new JButton("开始查询");
		butInsert = new JButton("插入信息");
		butDelete = new JButton("删除");
		butUpdate = new JButton("修改");
		labSearch= new JLabel("<html><font color=black size=4 face=\"verdana\">查询区</font></html>");
		labInsert= new JLabel("<html><font color=black size=4 face=\"verdana\">添加/删除</font></html>");
		labSno1= new JLabel("<html><font color=black size=4 face=\"verdana\">学号(Sno)：</font></html>");
		labSno2= new JLabel("<html><font color=black size=4 face=\"verdana\">学号(Sno)：</font></html>");
		labCno1= new JLabel("<html><font color=black size=4 face=\"verdana\">课程号(Cno)：</font></html>");
		labCno2= new JLabel("<html><font color=black size=4 face=\"verdana\">课程号(Cno)：</font></html>");
		labGrade1= new JLabel("<html><font color=black size=4 face=\"verdana\">成绩(Grade)：</font></html>");
		labGrade2= new JLabel("<html><font color=black size=4 face=\"verdana\">成绩(Grade)：</font></html>");
		labWave= new JLabel("<html><font color=black size=4 face=\"verdana\">~</font></html>");

		tfSearchSno = new JTextField(15);
		tfSearchCno = new JTextField(15);
		tfSearchGradeMax = new JTextField(15);
		tfSearchGradeMin = new JTextField(15);
		tfSno = new JTextField(15);
		tfCno = new JTextField(15);
		tfGrade = new JTextField(15);

		f.setBounds(300,200,1920,960);
		f.setLayout(null);//无框架模式
		ep = new JTextArea();
		ep.setLineWrap(true);
		Font x = new Font("Serif",0,20); 
		ep.setFont(x);
		//添加组件
		//设置组件位置
		labSearch.setBounds(100,100,80,50);
		labSno1.setBounds(100,200,80,50);
		labCno1.setBounds(100,300,80,50);
		labGrade1.setBounds(100,400,80,50);
		labInsert.setBounds(580,100,80,50);
		labSno2.setBounds(580,200,80,50);
		labCno2.setBounds(580,300,80,50);
		labGrade2.setBounds(580,400,80,50);
		labWave.setBounds(320,400,20,50);
		butInsert.setBounds(400,700,200,70);
		butSearch.setBounds(120,700,200,70);
		butDelete.setBounds(650,700,200,70);
		butUpdate.setBounds(400,800,200,70);
		tfSearchCno.setBounds(200,300,100,50);
		tfSearchSno.setBounds(200,200,100,50);
		tfSearchGradeMax.setBounds(360,400,100,50);
		tfSearchGradeMin.setBounds(200,400,100,50);
		tfSno.setBounds(680,200,100,50);
		tfCno.setBounds(680,300,100,50);
		tfGrade.setBounds(680,400,100,50);
		ep.setBounds(960,100,800,700);

		f.add(labCno1);
		f.add(labCno2);
		f.add(labGrade1);
		f.add(labGrade2);
		f.add(labInsert);
		f.add(labSno1);
		f.add(labSearch);
		f.add(labSno2);
		f.add(labWave);
		f.add (butSearch);
		f.add (butInsert);
		f.add (butDelete);
		f.add (butUpdate);
		f.add (tfSearchSno);
		f.add (tfSearchCno);
		f.add (tfSearchGradeMax);
		f.add (tfSearchGradeMin);
		f.add (tfSno);
		f.add (tfCno);
		f.add (tfGrade);
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
		            String CnoCon = " Cno is not null ";
		            String GradeCon = " Grade between 0 and 100 ";
		            if(tfSearchSno.getText().length()!=0) { SnoCon = " Sno = " + tfSearchSno.getText();}
		            if(tfSearchCno.getText().length()!=0) {CnoCon = " Cno = " + tfSearchCno.getText();}
		            if(tfSearchGradeMin.getText().length()!=0&&tfSearchGradeMax.getText().length()!=0)
		            	{GradeCon = " Grade  between " + tfSearchGradeMin.getText() + " and " + tfSearchGradeMax.getText();}
		            ps=ct.prepareStatement("select * from SC where " + SnoCon +" and "+ CnoCon +" and "+ GradeCon);
		            rs=ps.executeQuery();
	                System.out.println('\n');
	            	ep.setText("");
		            while(rs.next()) {
		                String sno=rs.getString(1);
		                String cno=rs.getString(2);
		                String grade=rs.getString(3);
		                System.out.println("学号： "+sno+" 课程号： "+cno+" 成绩： "+grade);
		                ep.append("学号： "+sno+" 课程号： "+cno+" 成绩： "+grade +"\n");

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

		            ps=ct.prepareStatement("INSERT into SC (Sno, Cno, Grade) VALUES (?,?,?) ");
		            ps.setString(1,tfSno.getText());
		            ps.setString(2,tfCno.getText());
		            ps.setString(3,tfGrade.getText());
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
		            String SnoCon = " Sno is null ";
		            String CnoCon = " Cno is null ";
		            String GradeCon = " Grade is not null ";
		            if(tfSno.getText().length()!=0) { SnoCon = " Sno = " + tfSno.getText();}
		            if(tfCno.getText().length()!=0) {CnoCon = " Cno = " + tfCno.getText();}
		            if(tfGrade.getText().length()!=0)
		            	{GradeCon = " Grade  = " + tfGrade.getText();}
		            System.out.println("delete from SC where " + SnoCon +" and "+ CnoCon +" and "+ GradeCon);
		            ps=ct.prepareStatement("delete from SC where " + SnoCon +" and "+ CnoCon +" and "+ GradeCon);
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
		butUpdate.addActionListener(new ActionListener()
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
		            ps=ct.prepareStatement("update SC set Grade = ? where Sno = ? and Cno = ?");
		            ps.setString(2,tfSearchSno.getText());
		            ps.setString(3,tfSearchCno.getText());
		            ps.setString(1,tfGrade.getText());
		            ps.executeUpdate();
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
