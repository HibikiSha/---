package frame;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import util.AccountInfor;
import frame.MainFrame;
//��½������
public class LoginFrame extends AccountInfor//��AccountInfor�м̳��˺���Ϣ
{
	//���
	private JFrame f;
	private JButton but;
	private JPasswordField pf;
	private JTextField tf1;
	private JLabel lab1;
	private JLabel lab2;
	//���캯������
	public LoginFrame()
	{
		init();
	}
	public void init()//�����½����Ŀ��
	{
		f= new JFrame ("��¼");
		f.setBounds(300,200,800,800);
		f.setLayout(null);//�޿��ģʽ
		ImageIcon image = new ImageIcon("src//backgroundLogin.jpg");
		JLabel lbBg = new JLabel(image);
		lbBg.setBounds(0, 0, 800, 800);
		ImageIcon loginbutton = new ImageIcon("src//buttonlogin.jpg");
		//������
		tf1 = new JTextField(15);
		but = new JButton(loginbutton);
		pf = new JPasswordField(15);
		lab1= new JLabel("<html><font color=black size=4 face=\"verdana\">��¼�˺ţ�</font></html>");
		lab2= new JLabel("<html><font color=black size=4 face=\"verdana\">��¼���룺</font></html>");
		//�������λ��
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
		myEvent();//���ü����¼�����˺ź˶Ժ͵�¼����
		f.setVisible(true);

	}
	private void myEvent()//ͨ���¼������رմ���
	{   
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		//button��ťʵ��
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				String Name = new String();
				String Pwd= new String();
			    String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL���ݿ�����
			    String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=S_C";//ע������Լ������ݿ�˿ں�����
				Pwd=String.valueOf(pf.getPassword());
				Name=tf1.getText();//���ı����л�ȡ�˺����벢�洢
				account1.setAccount(Name);
				account1.setPassword(Pwd);
				   try{
					   Class.forName(driverName);
					   Connection conn=DriverManager.getConnection(dbURL,Name,Pwd);
					   System.out.println("���ݿ����ӳɹ�");
					   new MainFrame();
					   f.dispose();
					   } catch(Exception e1){
					   e1.printStackTrace();
					      System.out.println("����ʧ��");
					      }			}
		});
	}

}

