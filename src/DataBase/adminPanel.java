package DataBase;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class adminPanel extends JPanel{
	protected static String UserName = null;
	protected static String UserType = "admin";
	protected static float UserAccount = 0;
	protected static adminPanel instance = null;
	protected static JPanel leftPanel = null;
	protected static JPanel rightPanel = null;
	protected static JPanel centerPanel = null;
	protected static JPanel infPanel = null;
	protected static JPanel operationBtns = null;
	protected static JButton OpBtn1 = null;//�����û�
	protected static JButton OpBtn2 = null;//�����̻�
	protected static JButton OpBtn3= null;//��������
	protected static JButton OpBtn4= null;//��������
	protected static JButton OpBtn5 = null;//������Ʒ
	protected static JButton OpBtn6 = null;//��������
	protected static JButton OpBtn7 = null;//������Ʒ���
	protected static JButton OpBtn8 = null;//�����ղ�
	protected static JPanel optBtns = null;
	protected static JButton newBtn = null;//�½�
	protected static JButton queryBtn = null;//��ѯ
	protected static JButton modifyBtn = null;//�޸�
	protected static JButton deleteBtn = null;//ɾ��
	protected static JScrollPane jSPane = null;
	protected static JTextArea logArea = null;//��־
	private static adminPanel getInstance() {
		if(instance == null) {
			instance = new adminPanel();
		}
		return instance;
	}
	public static adminPanel getAdminPanell() {
		return adminPanel.getInstance();
	}
	private adminPanel() {
		super();
		this.UserName = DBUI.userName;
		this.UserAccount = DBUI.userAccount;
		this.setLayout(new BorderLayout());
		this.add(getLeftPanel(),BorderLayout.WEST);
		this.add(getRightPanel(),BorderLayout.EAST);
	}
	
	private static JPanel getLeftPanel() {
		if(leftPanel == null) {
			leftPanel = new JPanel();
			leftPanel.setPreferredSize(new Dimension(180, 900));
			leftPanel.add(getInfPanel());
			leftPanel.add(getOperationBtns());
		}
		return leftPanel;
	}
	
	private static JPanel getRightPanel() {
		if(rightPanel == null) {
			rightPanel = new JPanel();
			rightPanel.setPreferredSize(new Dimension(180, 900));
			rightPanel.add(getOptBtns());
			rightPanel.add(getJSPane());
		}
		return rightPanel;
	}
	
	private static JPanel getInfPanel() {
		if(infPanel == null) {
			infPanel = new JPanel();
			infPanel.setLayout(new GridLayout(3,1));
			JLabel UserNameLabel = new JLabel();
			UserNameLabel.setPreferredSize(new Dimension(140,30));
			String nameStr = "�û����� " + UserName;
			UserNameLabel.setText(nameStr);
			
			JLabel UserTypeLabel = new JLabel();
			String typeStr = "�û����ͣ� " + UserType;
			UserTypeLabel.setPreferredSize(new Dimension(140,30));
			UserTypeLabel.setText(typeStr);
			/*
			JLabel UserAccountLabel = new JLabel();
			String accountStr = "�û��� " + UserAccount;
			UserAccountLabel.setPreferredSize(new Dimension(90,30));
			UserAccountLabel.setText(accountStr);
			*/
			infPanel.add(UserNameLabel);
			infPanel.add(UserTypeLabel);
			//infPanel.add(UserAccountLabel);
		}
		return infPanel;
	}
	
	private static JPanel getOperationBtns() {
		if(operationBtns == null) {
			operationBtns = new JPanel();
			operationBtns.setLayout(new FlowLayout());

			operationBtns.setPreferredSize(new Dimension(150,450));

			operationBtns.setBorder(BorderFactory.createTitledBorder(""));
			operationBtns.add(getOpBtn1());
			operationBtns.add(getOpBtn2());
			operationBtns.add(getOpBtn3());
			operationBtns.add(getOpBtn4());			
			operationBtns.add(getOpBtn5());
			operationBtns.add(getOpBtn6());
			operationBtns.add(getOpBtn7());
			operationBtns.add(getOpBtn8());
		}
		return operationBtns;
	}
	
	
	
	private static JButton getOpBtn1() {
		if(OpBtn1 == null) {
			OpBtn1 = new JButton("�����û�");
			OpBtn1.setPreferredSize(new Dimension(140,50));
			OpBtn1.addActionListener(new OpBtn1Listener());
		}
		return OpBtn1;
	}
	
	private static JButton getOpBtn2() {
		if(OpBtn2 == null) {
			OpBtn2 = new JButton("�����̻�");
			OpBtn2.setPreferredSize(new Dimension(140,50));
			OpBtn2.addActionListener(new OpBtn2Listener());
		}
		return OpBtn2;
	}
	
	private static JButton getOpBtn3() {
		if(OpBtn3 == null) {
			OpBtn3 = new JButton("��������");
			OpBtn3.setPreferredSize(new Dimension(140,50));
			OpBtn3.addActionListener(new OpBtn3Listener());
		}
		return OpBtn3;
	}
	
	private static JButton getOpBtn4() {
		if(OpBtn4 == null) {
			OpBtn4 = new JButton("��������");
			OpBtn4.setPreferredSize(new Dimension(140,50));
			OpBtn4.addActionListener(new OpBtn4Listener());
		}
		return OpBtn4;
	}
	
	private static JButton getOpBtn5() {
		if(OpBtn5 == null) {
			OpBtn5 = new JButton("������Ʒ");
			OpBtn5.setPreferredSize(new Dimension(140,50));
			OpBtn5.addActionListener(new OpBtn5Listener());
		}
		return OpBtn5;
	}
	
	private static JButton getOpBtn6() {
		if(OpBtn6 == null) {
			OpBtn6 = new JButton("��������");
			OpBtn6.setPreferredSize(new Dimension(140,50));
			OpBtn6.addActionListener(new OpBtn6Listener());
		}
		return OpBtn6;
	}
	
	private static JButton getOpBtn7() {
		if(OpBtn7 == null) {
			OpBtn7 = new JButton("������Ʒ���");
			OpBtn7.setPreferredSize(new Dimension(140,50));
			OpBtn7.addActionListener(new OpBtn7Listener());
		}
		return OpBtn7;
	}
	
	private static JButton getOpBtn8() {
		if(OpBtn8 == null) {
			OpBtn8 = new JButton("�����ղ�");
			OpBtn8.setPreferredSize(new Dimension(140,50));
			OpBtn8.addActionListener(new OpBtn8Listener());
		}
		return OpBtn8;
	}
	
	private static JPanel getOptBtns() {
		if(optBtns == null) {
			optBtns = new JPanel();
			optBtns.setLayout(new FlowLayout());
			optBtns.setPreferredSize(new Dimension(150,290));
			optBtns.setBorder(BorderFactory.createTitledBorder("ѡ�������"));
			optBtns.add(getNewBtn());
			optBtns.add(getQueryBtn());
			optBtns.add(getModifyBtn());
			optBtns.add(getDeleteBtn());
		}
		return optBtns;
	}
	
	private static JButton getNewBtn() {
		if(newBtn == null) {
			newBtn = new JButton("�½�");
			newBtn.setPreferredSize(new Dimension(140,60));
		}
		return newBtn;
	}
	
	private static JButton getQueryBtn() {
		if(queryBtn == null) {
			queryBtn = new JButton("��ѯ");
			queryBtn.setPreferredSize(new Dimension(140,60));
		}
		return queryBtn;
	}
	
	private static JButton getModifyBtn() {
		if(modifyBtn == null) {
			modifyBtn = new JButton("�޸�");
			modifyBtn.setPreferredSize(new Dimension(140,60));
		}
		return modifyBtn;
	}
	
	private static JButton getDeleteBtn() {
		if(deleteBtn == null) {
			deleteBtn = new JButton("ɾ��");
			deleteBtn.setPreferredSize(new Dimension(140,60));
		}
		return deleteBtn;
	}
	
	private static JScrollPane getJSPane() {
		if(jSPane == null){
			jSPane = new JScrollPane(getLogArea());
			jSPane.setPreferredSize(new Dimension(160,250));
		}
		return jSPane;
	}
	
	private static JTextArea getLogArea() {
		if(logArea == null) {
			logArea = new JTextArea();
			logArea.setPreferredSize(new Dimension(160,250));
			logArea.setEditable(false);			
			logArea.setBorder(BorderFactory.createTitledBorder("������־��"));

		}
		return logArea;
	}
	
	private static class OpBtn1Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			btn.setEnabled(false);
			getOpBtn2().setEnabled(true);
			getOpBtn3().setEnabled(true);
			getOpBtn4().setEnabled(true);
			getOpBtn5().setEnabled(true);
			getOpBtn6().setEnabled(true);
			getOpBtn7().setEnabled(true);
			getOpBtn8().setEnabled(true);
		}
	}
	private static class OpBtn2Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			btn.setEnabled(false);
			getOpBtn1().setEnabled(true);
			getOpBtn3().setEnabled(true);
			getOpBtn4().setEnabled(true);
			getOpBtn5().setEnabled(true);
			getOpBtn6().setEnabled(true);
			getOpBtn7().setEnabled(true);
			getOpBtn8().setEnabled(true);
			
		}
	}
	private static class OpBtn3Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			btn.setEnabled(false);
			getOpBtn1().setEnabled(true);
			getOpBtn2().setEnabled(true);
			getOpBtn4().setEnabled(true);
			getOpBtn5().setEnabled(true);
			getOpBtn6().setEnabled(true);
			getOpBtn7().setEnabled(true);
			getOpBtn8().setEnabled(true);
			
		}
	}
	private static class OpBtn4Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			btn.setEnabled(false);
			getOpBtn1().setEnabled(true);
			getOpBtn2().setEnabled(true);
			getOpBtn3().setEnabled(true);
			getOpBtn5().setEnabled(true);
			getOpBtn6().setEnabled(true);
			getOpBtn7().setEnabled(true);
			getOpBtn8().setEnabled(true);
			
		}
	}
	private static class OpBtn5Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			btn.setEnabled(false);
			getOpBtn1().setEnabled(true);
			getOpBtn2().setEnabled(true);
			getOpBtn3().setEnabled(true);
			getOpBtn4().setEnabled(true);
			getOpBtn6().setEnabled(true);
			getOpBtn7().setEnabled(true);
			getOpBtn8().setEnabled(true);
			
		}
	}
	private static class OpBtn6Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			btn.setEnabled(false);
			getOpBtn1().setEnabled(true);
			getOpBtn2().setEnabled(true);
			getOpBtn3().setEnabled(true);
			getOpBtn4().setEnabled(true);
			getOpBtn5().setEnabled(true);
			getOpBtn7().setEnabled(true);
			getOpBtn8().setEnabled(true);
			
		}
	}
	private static class OpBtn7Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			btn.setEnabled(false);
			getOpBtn1().setEnabled(true);
			getOpBtn2().setEnabled(true);
			getOpBtn3().setEnabled(true);
			getOpBtn4().setEnabled(true);
			getOpBtn5().setEnabled(true);
			getOpBtn6().setEnabled(true);
			getOpBtn8().setEnabled(true);
			
		}
	}
	private static class OpBtn8Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			btn.setEnabled(false);
			getOpBtn1().setEnabled(true);
			getOpBtn2().setEnabled(true);
			getOpBtn3().setEnabled(true);
			getOpBtn4().setEnabled(true);
			getOpBtn5().setEnabled(true);
			getOpBtn6().setEnabled(true);
			getOpBtn7().setEnabled(true);
			
		}
	}
}
