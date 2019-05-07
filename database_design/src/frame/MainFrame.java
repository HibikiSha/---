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
	public void init()//�����½����Ŀ��
	{
		f= new JFrame ("��ѡ����Ҫ���������ݿ�");
		butStudent = new JButton("ѧ����Ϣ���ݿ�");
		butCourse = new JButton("�γ���Ϣ���ݿ�");
		butSC = new JButton("ѡ����Ϣ���ݿ�");
		f.setBounds(300,200,800,800);
		f.setLayout(null);//�޿��ģʽ
		ImageIcon image = new ImageIcon("src//backgroundLogin.jpg");
		JLabel lbBg = new JLabel(image);
		lbBg.setBounds(0, 0, 800, 800);
		//������
		//�������λ��
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
