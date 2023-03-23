package DataBase;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Taskbar.State;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class logIn extends JDialog{
	protected static logIn instance;
	protected static JLabel titleLabel = null;
	protected static JTextField userName = null;
	protected static JTextField passWord = null;
	protected static JPanel logInPanel = null;
	protected static JPanel userNamePanel = null;
	protected static JPanel passWordPanel = null;
	protected static JPanel BtnPanel = null;
	protected static JPanel BtnPanel2 = null;
	protected static JButton logInBtn = null;
	protected static JLabel state = null;
	protected static JButton regBtn = null;
	protected static JButton adminBtn = null;
	private static logIn getInstance() {
		if(instance == null) {
			instance = new logIn();
		}
		return instance;
	}
	public static logIn getlogIn() {
		return logIn.getInstance();
	}
	private logIn() {
		super();
		this.setSize(new Dimension(350, 500));
		this.setResizable(false);
		this.setTitle("欢迎使用数据库系统");
		this.setLayout(new FlowLayout());
		this.add(getLogInPanel());
		this.setVisible(true);
	}
	
	private static JPanel getLogInPanel() {
		if(logInPanel == null) {
			logInPanel = new JPanel();
			logInPanel.setLayout(new FlowLayout());
			logInPanel.setPreferredSize(new Dimension(350, 500));
			logInPanel.add(getTitleLabel());
			logInPanel.add(getUserNamePanel());
			logInPanel.add(getPassWordPanel());
			logInPanel.add(getBtnPanel());
			logInPanel.add(getBtnPanel2());
		}
		return logInPanel;
	}
	
	private static JLabel getTitleLabel() {
		if(titleLabel == null) {
			titleLabel = new JLabel("登   录", JLabel.CENTER);
			Font font = new Font("华文行楷", Font.BOLD, 50);
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
			JLabel temp1 = new JLabel("用户名:      ");
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
			JLabel temp2 = new JLabel("密   码:       ");
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
			state.setPreferredSize(new Dimension(300, 50));
			BtnPanel.setPreferredSize(new Dimension(300,130));
			BtnPanel.add(state);
			BtnPanel.add(getLogInBtn());
		}
		return BtnPanel;
	}
	
	private static JPanel getBtnPanel2() {
		if(BtnPanel2 == null) {
			BtnPanel2 = new JPanel();
			BtnPanel2.setLayout(new FlowLayout());
			BtnPanel2.setPreferredSize(new Dimension(300,70));
			BtnPanel2.setBorder(BorderFactory.createTitledBorder("其他选项："));
			BtnPanel2.add(getRegBtn());
			BtnPanel2.add(getAdminBtn());
		}
		return BtnPanel2;
	}
	
	private static JTextField getUserName() {
		if(userName == null) {
			userName = new JTextField();
			userName.setPreferredSize(new Dimension(180,35));
			userName.addKeyListener(new KeyAdapter(){
		    	public void keyTyped(KeyEvent event){
		    		char ch=event.getKeyChar();
		            if(ch<'0'||ch>'9')
		            	event.consume();
		            }
		     });
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

	private static JButton getLogInBtn() {
		if(logInBtn == null) {
			logInBtn = new JButton("登	录");
			logInBtn.setPreferredSize(new Dimension(150, 40));
			logInBtn.addActionListener(new LogInListener());
		}
		return logInBtn;
	}
	
	private static JButton getRegBtn() {
		if(regBtn == null) {
			regBtn = new JButton("用户注册");
			regBtn.setPreferredSize(new Dimension(100, 30));
			regBtn.addActionListener(new RegListener());
		}
		return regBtn;
	}
	
	private static JButton getAdminBtn() {
		if(adminBtn == null) {
			adminBtn = new JButton("管理者入口");
			adminBtn.setPreferredSize(new Dimension(100, 30));
			adminBtn.addActionListener(new AdminListener());
		}
		return adminBtn;
	}
	
	private static class LogInListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//连接函数
			String temp = getUserName().getText();
			if(temp.equals("")) {
				state.setText("请输入用户id");
				return;}
			int userID = Integer.parseInt(temp);
			String userPwd = getPassWord().getText();
			if(userPwd.equals("")) {
				state.setText("请输入密码");
				return;}
			//SELECT 昵称, 余额 FROM 用户 WHERE 用户.用户ID = 1 AND 用户.`密码` = '2012516';
			String str = new String("用户.用户ID = " + userID + " AND 用户.`密码` = '" + userPwd +"'");
			Center.select("昵称, 余额, 用户类型", "用户", str);
			String name = null;
			float account = 0;
			String type = null;
			try {
				while(Center.rs.next()){
					name = Center.rs.getString("昵称");
					account = Center.rs.getFloat("余额");
					type = Center.rs.getString("用户类型");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			if(type == null) {
				state.setText("用户名或密码错误！");
				return;
			}
			else {
				DBUI.userName = name;
				DBUI.userAccount = account;
				DBUI.userType = type;
				DBUI.userID = userID;
				logIn.getlogIn().setVisible(false);
				logIn.getlogIn().setEnabled(false);;
			}
		}
	}

	private static class RegListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			regWindow.getRegWindow().setVisible(true);
			regWindow.getRegWindow().setModal(true);
		}
	}
	
	private static class AdminListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String temp = getUserName().getText();
			String userPwd = getPassWord().getText();
			if(!temp.equals("2012516")) {
				state.setText("该用户不是管理用户");
				return;}
			if(!userPwd.equals("2012516")) {
				state.setText("该用户不是管理用户");
				return;}
			else {
				DBUI.userName = "root";
				DBUI.userAccount = 0;
				DBUI.userType = "admin";
				logIn.getlogIn().setVisible(false);
				logIn.getlogIn().setEnabled(false);
			}
		}
	}
}
