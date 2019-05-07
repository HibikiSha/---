package frame;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import util.AccountInfor;
import frame.MainFrame;
//登陆界面框架
public class LoginFrame extends AccountInfor//从AccountInfor中继承账号信息
{
	//组件
	private JFrame f;
	private JButton but;
	private JPasswordField pf;
	private JTextField tf1;
	private JLabel lab1;
	private JLabel lab2;
	//构造函数引用
	public LoginFrame()
	{
		init();
	}
	public void init()//定义登陆界面的框架
	{
		f= new JFrame ("登录");
		f.setBounds(300,200,800,800);
		f.setLayout(null);//无框架模式
		ImageIcon image = new ImageIcon("src//backgroundLogin.jpg");
		JLabel lbBg = new JLabel(image);
		lbBg.setBounds(0, 0, 800, 800);
		ImageIcon loginbutton = new ImageIcon("src//buttonlogin.jpg");
		//添加组件
		tf1 = new JTextField(15);
		but = new JButton(loginbutton);
		pf = new JPasswordField(15);
		lab1= new JLabel("<html><font color=black size=4 face=\"verdana\">登录账号：</font></html>");
		lab2= new JLabel("<html><font color=black size=4 face=\"verdana\">登录密码：</font></html>");
		//设置组件位置
		tf1.setBounds(300,300,200,50);
		but.setBounds(300,500,150,40);
		pf.setBounds(300,400,200,50);
		lab1.setBounds(220,300,200,40);
		lab2.setBounds(220,400,200,40);
		f.add (tf1);
		f.add (but);
		f.add (pf);
		f.add (lab1);
		f.add (lab2);
		f.add (lbBg);
		myEvent();//利用监听事件完成账号核对和登录操作
		f.setVisible(true);

	}
	private void myEvent()//通过事件监听关闭窗口
	{   
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		//button按钮实现
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				String Name = new String();
				String Pwd= new String();
			    String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
			    String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=S_C";//注意更换自己的数据库端口和名称
				Pwd=String.valueOf(pf.getPassword());
				Name=tf1.getText();//从文本框中获取账号密码并存储
				account1.setAccount(Name);
				account1.setPassword(Pwd);
				   try{
					   Class.forName(driverName);
					   Connection conn=DriverManager.getConnection(dbURL,Name,Pwd);
					   System.out.println("数据库连接成功");
					   new MainFrame();
					   f.dispose();
					   } catch(Exception e1){
					   e1.printStackTrace();
					      System.out.println("连接失败");
					      }			}
		});
	}

}

