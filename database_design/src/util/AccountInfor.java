package util;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class AccountInfor//����һ�����ŵõ����˻���Ϣ
{	public static AccountInfor account1 = new AccountInfor();
	private String account;//�˺���Ϣ���ӵ�¼�������
	private String password;//������Ϣ
	private int currentDB;//1Ϊѧ����Ϣ��2Ϊ�γ���Ϣ��3Ϊѡ����Ϣ
	public void setCurrentDB(int i)
	{
		this.currentDB = i;
	}
	public void setAccount(String account)
	{
		this.account=account;

	}
	public String getAccount(){
		return account;
	}
	public void setPassword(String password)
	{
		this.password=password;

	}
	public String getPassword(){
		return password;
	}
}

