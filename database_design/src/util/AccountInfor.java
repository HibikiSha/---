package util;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class AccountInfor//创建一个类存放得到的账户信息
{	public static AccountInfor account1 = new AccountInfor();
	private String account;//账号信息，从登录界面而来
	private String password;//密码信息
	private int currentDB;//1为学生信息，2为课程信息，3为选课信息
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

