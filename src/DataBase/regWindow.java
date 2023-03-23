package DataBase;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class regWindow extends JDialog{
	protected static regWindow instance = null;
	protected static JLabel titleLabel = null;
	protected static JTextField userName = null;
	protected static JTextField passWord = null;
	protected static JPanel logInPanel = null;
	protected static JPanel userNamePanel = null;
	protected static JPanel passWordPanel = null;
	protected static JPanel BtnPanel = null;
	protected static JPanel BtnPanel2 = null;
	protected static JButton FinishBtn = null;
	protected static JLabel state = null;
	protected static JButton SellerBtn = null;
	protected static JButton CustomerBtn = null;
	protected static String UserType = "customer";
	private static regWindow getInstance() {
		if(instance == null) {
			instance = new regWindow();
		}
		return instance;
	}
	public static regWindow getRegWindow() {
		return regWindow.getInstance();
	}
	private regWindow() {
		super();
		this.setLayout(new FlowLayout());
		this.setTitle("ע��");
		this.setSize(new Dimension(350, 500));
		this.setResizable(false);
		this.add(getTitleLabel());
		this.add(getUserNamePanel());
		this.add(getPassWordPanel());
		this.add(getBtnPanel2());
		this.add(getBtnPanel());
	}
	
	private static JLabel getTitleLabel() {
		if(titleLabel == null) {
			titleLabel = new JLabel("ע   ��", JLabel.CENTER);
			Font font = new Font("�����п�", Font.BOLD, 50);
			titleLabel.setBorder(BorderFactory.createTitledBorder(""));
			titleLabel.setFont(font);
			titleLabel.setPreferredSize(new Dimension(300,150));
		}
		return titleLabel;
	}
	
	private static JPanel getUserNamePanel() {
		if(userNamePanel == null) {
			userNamePanel = new JPanel();
			userNamePanel.setLayout(new FlowLayout());
			JLabel temp1 = new JLabel("�û���:      ");
			userNamePanel.setPreferredSize(new Dimension(300,40));
			userNamePanel.add(temp1);
			userNamePanel.add(getUserName());
		}
		return userNamePanel;
	}
	
	private static JPanel getPassWordPanel() {
		if(passWordPanel == null) {
			passWordPanel = new JPanel();
			passWordPanel.setLayout(new FlowLayout());
			JLabel temp2 = new JLabel("��   ��:       ");
			passWordPanel.setPreferredSize(new Dimension(300,40));
			passWordPanel.add(temp2);
			passWordPanel.add(getPassWord());
		}
		return passWordPanel;
	}
	
	private static JPanel getBtnPanel() {
		if(BtnPanel == null) {
			BtnPanel = new JPanel();
			BtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			state = new JLabel("");
			state.setText("����Ҫ������ �˿��˻�");
			state.setPreferredSize(new Dimension(300, 50));
			BtnPanel.setPreferredSize(new Dimension(300,130));
			BtnPanel.add(state);
			BtnPanel.add(getFinishBtn());
		}
		return BtnPanel;
	}
	
	private static JPanel getBtnPanel2() {
		if(BtnPanel2 == null) {
			BtnPanel2 = new JPanel();
			BtnPanel2.setLayout(new FlowLayout());
			BtnPanel2.setPreferredSize(new Dimension(300,70));
			BtnPanel2.setBorder(BorderFactory.createTitledBorder("ѡ���û����ͣ�"));
			BtnPanel2.add(getCustomerBtn());
			BtnPanel2.add(getSellerBtn());
		}
		return BtnPanel2;
	}
	
	private static JTextField getUserName() {
		if(userName == null) {
			userName = new JTextField();
			userName.setPreferredSize(new Dimension(180,35));
			
		}
		return userName;
	}
	
	private static JTextField getPassWord() {
		if(passWord == null) {
			passWord = new JTextField();
			passWord.setPreferredSize(new Dimension(180,35));
			
		}
		return passWord;
	}

	private static JButton getFinishBtn() {
		if(FinishBtn == null) {
			FinishBtn = new JButton("�����û�");
			FinishBtn.setPreferredSize(new Dimension(150, 40));
			FinishBtn.addActionListener(new LogInListener());
		}
		return FinishBtn;
	}
	
	private static JButton getCustomerBtn() {
		if(CustomerBtn == null) {
			CustomerBtn = new JButton("��  ��");
			CustomerBtn.setPreferredSize(new Dimension(100, 30));
			CustomerBtn.addActionListener(new CustomListener());
			CustomerBtn.setEnabled(false);
			
		}
		return CustomerBtn;
	}
	
	private static JButton getSellerBtn() {
		if(SellerBtn == null) {
			SellerBtn = new JButton("��  ��");
			SellerBtn.setPreferredSize(new Dimension(100, 30));
			SellerBtn.addActionListener(new SellerListener());
		}
		return SellerBtn;
	}
	
	private static class LogInListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String userStr = getUserName().getText();
			String userPwd = getPassWord().getText();
			DBUI.userType = UserType;
			int userId = -1;
			//JOptionPane.showInternalMessageDialog(null, "����ʧ��","����ʧ�ܣ��û����ظ�", JOptionPane.INFORMATION_MESSAGE);
			
			//SELECT MAX(�û�ID) FROM �û�;
			int number = 0;
			try {
				String temp1 = new String("SELECT MAX(�û�ID) FROM �û�");
				Center.customize1(temp1);
				while(Center.rs.next()){
					number = Center.rs.getInt("MAX(�û�ID)");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			number++;
			String temp = new String("(" + number + ", '" + userStr + "', '" + UserType + "', '" + userPwd + "')");
			//INSERT �û�(�û�ID, �ǳ�, �û�����, ����) VALUES (number, userID, type, userPwd);
			
			int res = Center.insert("�û�(�û�ID, �ǳ�, �û�����, ����)", temp);
			if(res == 1) {
				JOptionPane.showInternalMessageDialog(null, "�����ɹ�,����ID�ǣ�" + number, "�����ɹ�", JOptionPane.INFORMATION_MESSAGE);
				getRegWindow().setVisible(false);
				getRegWindow().setEnabled(false);
				return;
			}
			else {
				JOptionPane.showInternalMessageDialog(null, "����ʧ��","����ʧ�ܣ�", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}
	}

	private static class SellerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			state.setText("����Ҫ������ �̼��˻�");
			JButton btn = (JButton) e.getSource();
			btn.setEnabled(false);
			getRegWindow().UserType = "seller";
			getCustomerBtn().setEnabled(true);
		}
	}
	
	private static class CustomListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			state.setText("����Ҫ������ �˿��˻�");
			JButton btn = (JButton) e.getSource();
			btn.setEnabled(false);
			getRegWindow().UserType = "customer";
			getSellerBtn().setEnabled(true);
		}
	}
}