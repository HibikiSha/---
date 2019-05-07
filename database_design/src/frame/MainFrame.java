package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import util.AccountInfor;

public class MainFrame extends AccountInfor{
	private JFrame f;
	private JButton butStudent;
	private JButton butCourse;
	private JButton butSC;
	public MainFrame()
	{
		init();
	}
	public void init()//定义登陆界面的框架
	{
		f= new JFrame ("请选择您要操作的数据库");
		butStudent = new JButton("学生信息数据库");
		butCourse = new JButton("课程信息数据库");
		butSC = new JButton("选课信息数据库");
		f.setBounds(300,200,800,800);
		f.setLayout(null);//无框架模式
		ImageIcon image = new ImageIcon("src//backgroundLogin.jpg");
		JLabel lbBg = new JLabel(image);
		lbBg.setBounds(0, 0, 800, 800);
		//添加组件
		//设置组件位置
		butStudent.setBounds(300,100,200,50);
		butCourse.setBounds(300,300,200,50);
		butSC.setBounds(300,500,200,50);
		f.add (butStudent);
		f.add (butCourse);
		f.add (butSC);
		f.add (lbBg);
		myEvent();
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
		butStudent.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				account1.setCurrentDB(1);
				new StudentFrame();
			}
		});
		butCourse.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				account1.setCurrentDB(1);
				new CourseFrame();
			}
		});
		butSC.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				account1.setCurrentDB(1);
				new SCFrame();
			}
		});


	}


}
