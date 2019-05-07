package main;

import javax.swing.SwingUtilities;
import frame.LoginFrame;
public class manage {
	public static void main(String[] args)
    {
	try {
		   javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  SwingUtilities.invokeLater(new Runnable() {
		     public void run() {
		    	 new LoginFrame();
		     }
		  });
	    
		
    }

}
