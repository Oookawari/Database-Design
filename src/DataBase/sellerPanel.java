package DataBase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class sellerPanel extends JPanel {
	protected static String UserName = null;
	protected static String UserType = "seller";
	protected static float UserAccount = 0;
	protected static sellerPanel instance = null;
	protected static JPanel leftPanel = null;
	protected static JPanel rightPanel = null;
	protected static JPanel centerPanel = null;
	protected static JPanel infPanel = null;
	protected static JPanel operationBtns = null;
	protected static JButton OpBtn1 = null;//��Ʒ�б�
	protected static JButton OpBtn2 = null;//��Ʒ���
	protected static JButton OpBtn3= null;//����
	protected static JButton OpBtn4 = null;//����
	protected static JButton OpBtn5 = null;//�������
	protected static JButton OpBtn6 = null;//������Ϣ
	protected static JPanel optBtns = null;
	protected static JButton newBtn = null;//�½�
	protected static JButton queryBtn = null;//��ѯ
	protected static JButton modifyBtn = null;//�޸�
	protected static JButton deleteBtn = null;//ɾ��
	protected static JScrollPane jSPane = null;
	protected static JTextArea logArea = null;//��־
	private static sellerPanel getInstance() {
		if(instance == null) {
			instance = new sellerPanel();
		}
		return instance;
	}
	public static sellerPanel getSellerPanel() {
		return sellerPanel.getInstance();
	}
	private sellerPanel() {
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
			
			JLabel UserAccountLabel = new JLabel();
			String accountStr = "�û��� " + UserAccount;
			UserAccountLabel.setPreferredSize(new Dimension(140,30));
			UserAccountLabel.setText(accountStr);
			
			infPanel.add(UserNameLabel);
			infPanel.add(UserTypeLabel);
			infPanel.add(UserAccountLabel);
		}
		return infPanel;
	}
	
	private static JPanel getOperationBtns() {
		if(operationBtns == null) {
			operationBtns = new JPanel();
			operationBtns.setLayout(new FlowLayout());

			operationBtns.setPreferredSize(new Dimension(150,400));

			operationBtns.setBorder(BorderFactory.createTitledBorder(""));
			operationBtns.add(getOpBtn1());
			operationBtns.add(getOpBtn2());
			operationBtns.add(getOpBtn3());
			operationBtns.add(getOpBtn4());			
			operationBtns.add(getOpBtn5());	
			operationBtns.add(getOpBtn6());
		}
		return operationBtns;
	}
	
	
	
	private static JButton getOpBtn1() {
		if(OpBtn1 == null) {
			OpBtn1 = new JButton("������Ʒ");
			OpBtn1.setPreferredSize(new Dimension(140,60));
			OpBtn1.addActionListener(new OpBtn1Listener());
			getNewBtn().setEnabled(false);
			getModifyBtn().setEnabled(false);
			getDeleteBtn().setEnabled(false);
			getQueryBtn().setEnabled(true);
		}
		return OpBtn1;
	}
	
	private static JButton getOpBtn2() {
		if(OpBtn2 == null) {
			OpBtn2 = new JButton("������Ʒ�����");
			OpBtn2.setPreferredSize(new Dimension(140,60));
			OpBtn2.addActionListener(new OpBtn2Listener());

			getNewBtn().setEnabled(false);
			getModifyBtn().setEnabled(false);
			getDeleteBtn().setEnabled(false);
			getQueryBtn().setEnabled(true);
		}
		return OpBtn2;
	}
	
	private static JButton getOpBtn3() {
		if(OpBtn3 == null) {
			OpBtn3 = new JButton("��������");
			OpBtn3.setPreferredSize(new Dimension(140,60));						
			OpBtn3.addActionListener(new OpBtn3Listener());

			getNewBtn().setEnabled(false);
			getModifyBtn().setEnabled(false);
			getDeleteBtn().setEnabled(false);
			getQueryBtn().setEnabled(true);
		}
		return OpBtn3;
	}
	
	private static JButton getOpBtn4() {
		if(OpBtn4 == null) {
			OpBtn4 = new JButton("������");
			OpBtn4.setPreferredSize(new Dimension(140,60));
			OpBtn4.addActionListener(new OpBtn4Listener());

			getNewBtn().setEnabled(false);
			getModifyBtn().setEnabled(false);
			getDeleteBtn().setEnabled(false);
			getQueryBtn().setEnabled(true);
		}
		return OpBtn4;
	}
	
	private static JButton getOpBtn5() {
		if(OpBtn5 == null) {
			OpBtn5 = new JButton("�������");
			OpBtn5.setPreferredSize(new Dimension(140,60));
			OpBtn5.addActionListener(new OpBtn5Listener());

			getNewBtn().setEnabled(false);
			getModifyBtn().setEnabled(false);
			getDeleteBtn().setEnabled(false);
			getQueryBtn().setEnabled(true);
		}
		return OpBtn5;
	}
	
	private static JButton getOpBtn6() {
		if(OpBtn6 == null) {
			OpBtn6 = new JButton("������Ϣ");
			OpBtn6.setPreferredSize(new Dimension(140,60));
			OpBtn6.addActionListener(new OpBtn6Listener());

			getNewBtn().setEnabled(false);
			getModifyBtn().setEnabled(false);
			getDeleteBtn().setEnabled(false);
			getQueryBtn().setEnabled(true);
		}
		return OpBtn6;
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
			logArea.setBorder(BorderFactory.createTitledBorder("������־��"));
			logArea.setPreferredSize(new Dimension(160,250));
			logArea.setEditable(false);
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
			
		}
	}
}
