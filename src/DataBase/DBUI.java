package DataBase;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class DBUI extends JFrame{
	protected static String userType = null;
	protected static String userName = null;
	protected static int userID = 0;
	protected static float userAccount = 0;
	protected static DBUI instance = null;
	private static DBUI getInstance() {
		if(instance == null) {
			instance = new DBUI();
		}
		return instance;
	}
	public static DBUI getDBUI() {
		return DBUI.getInstance();
	}
	private DBUI() {
		super();
		this.setSize(new Dimension(1000, 600));
		this.setVisible(true);
		this.setTitle("π∫ŒÔπ‹¿Ì");;
		logIn.getlogIn();
		logIn.getlogIn().setModal(true);
		while(this.userName == null) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(userType == null){
			//System.exit(EXIT_ON_CLOSE);
		}
		else if(userType.equals("seller")) {
			this.add(sellerPanel.getSellerPanel());
		} 
		else if(userType.equals("customer")) {
			this.add(customerPanel.getCustomerPanel());
		}
		else if(userType.equals("admin")) {
			this.add(adminPanel.getAdminPanell());
		}
		this.addWindowListener(new closed());
	}
	private class closed extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			Center.destroy();
			System.exit(0);
			super.windowClosing(e);
			
		}
	}
}
