package DataBase;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class customerPanel extends JPanel{
	protected static String UserName = null;
	protected static String UserType = "customer";
	protected static int UserID1 = 0;
	protected static float UserAccount = 0;
	protected static customerPanel instance = null;
	protected static JPanel leftPanel = null;
	protected static JPanel rightPanel = null;
	protected static JPanel centerPanel = null;
	protected static JPanel infPanel = null;
	protected static JPanel operationBtns = null;
	protected static JTable DataTable = null;
	protected static JButton OpBtn1 = null;
	protected static JButton OpBtn2 = null;
	protected static JButton OpBtn3= null;
	protected static JButton OpBtn4 = null;
	protected static JButton OpBtn5 = null;
	protected static JButton OpBtn6 = null;
	protected static JButton OpBtn7 = null;
	protected static JPanel optBtns = null;
	protected static JButton newBtn = null;//�½�
	protected static JButton queryBtn = null;//��ѯ
	protected static JButton modifyBtn = null;//�޸�
	protected static JButton deleteBtn = null;//ɾ��
	protected static JScrollPane jSPane = null;
	protected static JScrollPane jSPane2 = null;
	protected static JTextArea logArea = null;//��־
	protected static DefaultTableModel model;
	protected static int selected = 0;
	private static customerPanel getInstance() {
		if(instance == null) {
			instance = new customerPanel();
		}
		return instance;
	}
	public static customerPanel getCustomerPanel() {
		return customerPanel.getInstance();
	}
	private customerPanel() {
		super();
		this.UserName = DBUI.userName;
		this.UserAccount = DBUI.userAccount;
		this.UserID1 = DBUI.userID;
		this.setLayout(new BorderLayout());
		this.add(getLeftPanel(),BorderLayout.WEST);
		this.add(getRightPanel(),BorderLayout.EAST);
		this.add(getCenterPanel(),BorderLayout.CENTER);
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
	
	private static JPanel getCenterPanel() {
		if(centerPanel == null) {
			centerPanel = new JPanel();
			centerPanel.add(getJSPane2());
		}
		return centerPanel;
	}
	
	private static JScrollPane getJSPane2() {
		if(jSPane2 == null){
			jSPane2 = new JScrollPane(getDataTable());

			jSPane2.setPreferredSize(new Dimension(600, 500));
		}
		return jSPane2;
	}
	
	private static JTable getDataTable() {
		if(DataTable == null) {
			DataTable = new JTable();
		}
		return DataTable;
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

			operationBtns.setPreferredSize(new Dimension(150,460));

			operationBtns.setBorder(BorderFactory.createTitledBorder(""));
			operationBtns.add(getOpBtn1());
			operationBtns.add(getOpBtn2());
			operationBtns.add(getOpBtn3());
			operationBtns.add(getOpBtn4());			
			operationBtns.add(getOpBtn5());	
			operationBtns.add(getOpBtn6());
			operationBtns.add(getOpBtn7());
		}
		return operationBtns;
	}
	
	
	
	private static JButton getOpBtn1() {
		if(OpBtn1 == null) {
			OpBtn1 = new JButton("�鿴��Ʒ");
			OpBtn1.setPreferredSize(new Dimension(140,60));
			OpBtn1.addActionListener(new OpBtn1Listener());
		}
		return OpBtn1;
	}
	
	private static JButton getOpBtn2() {
		if(OpBtn2 == null) {
			OpBtn2 = new JButton("������Ʒ");
			OpBtn2.setPreferredSize(new Dimension(140,60));
			OpBtn2.addActionListener(new OpBtn2Listener());
		}
		return OpBtn2;
	}
	
	private static JButton getOpBtn3() {
		if(OpBtn3 == null) {
			OpBtn3 = new JButton("����");
			OpBtn3.setPreferredSize(new Dimension(140,60));
			OpBtn3.addActionListener(new OpBtn3Listener());
		}
		return OpBtn3;
	}
	
	private static JButton getOpBtn4() {
		if(OpBtn4 == null) {
			OpBtn4 = new JButton("�鿴����");
			OpBtn4.setPreferredSize(new Dimension(140,60));
			OpBtn4.addActionListener(new OpBtn4Listener());
		}
		return OpBtn4;
	}
	
	private static JButton getOpBtn5() {
		if(OpBtn5 == null) {
			OpBtn5 = new JButton("�鿴����");
			OpBtn5.setPreferredSize(new Dimension(140,60));
			OpBtn5.addActionListener(new OpBtn5Listener());
		}
		return OpBtn5;
	}
	
	private static JButton getOpBtn6() {
		if(OpBtn6 == null) {
			OpBtn6 = new JButton("�鿴�ղ�");
			OpBtn6.setPreferredSize(new Dimension(140,60));
			OpBtn6.addActionListener(new OpBtn6Listener());
		}
		return OpBtn6;
	}
	
	private static JButton getOpBtn7() {
		if(OpBtn7 == null) {
			OpBtn7 = new JButton("������Ϣ");
			OpBtn7.setPreferredSize(new Dimension(140,60));
			OpBtn7.addActionListener(new OpBtn7Listener());
		}
		return OpBtn7;
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
			newBtn = new JButton("�½�����");
			newBtn.setPreferredSize(new Dimension(140,60));
			newBtn.addActionListener(new InsertListener());
		}
		return newBtn;
	}
	
	private static JButton getQueryBtn() {
		if(queryBtn == null) {
			queryBtn = new JButton("��������");
			queryBtn.setPreferredSize(new Dimension(140,60));
			queryBtn.addActionListener(new QueryListener());
		}
		return queryBtn;
	}
	
	private static JButton getModifyBtn() {
		if(modifyBtn == null) {
			modifyBtn = new JButton("�޸Ķ���");
			modifyBtn.setPreferredSize(new Dimension(140,60));
			modifyBtn.addActionListener(new UpdateListener());
		}
		return modifyBtn;
	}
	
	private static JButton getDeleteBtn() {
		if(deleteBtn == null) {
			deleteBtn = new JButton("ɾ���ղ�");
			deleteBtn.setPreferredSize(new Dimension(140,60));
			deleteBtn.addActionListener(new DeleteListener());
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
			logArea.setEditable(false);
		}
		return logArea;
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
			String sql = "SELECT * FROM ��Ʒ���;";
			Center.customize1(sql);
			String[] Title = {"��ƷID","��Ʒ���","�۸�","�ͺ�","���"};
			Object [][]cellData={};
			model=new DefaultTableModel(cellData,Title){
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return false;
				}
			};
			String []data=new String [5];
		    try {
				while (Center.rs.next()) {
					int temp1 = Center.rs.getInt(Title[0]);
				    data[0] = Integer.toString(temp1);
					int temp2 = Center.rs.getInt(Title[1]);
				    data[1] = Integer.toString(temp2);
				    float temp3 = Center.rs.getFloat(Title[2]);
				    data[2] = Float.toString(temp3);
				    data[3] = Center.rs.getString(Title[3]);
				    int temp4 = Center.rs.getInt(Title[4]);
				    data[4] = Integer.toString(temp4);
				   model.addRow(data);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    DataTable.setModel(model);
		    getLogArea().append("��ѯ:��Ʒ���\n");
		}
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
			String sql = "SELECT * FROM ��Ʒ;";
			Center.customize1(sql);
			String[] Title = {"��ƷID","����ID","����","���","������","��ַ"};
			Object [][]cellData={};
			model=new DefaultTableModel(cellData,Title){
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return false;
				}
			};
			String []data=new String [7];
		    try {
				while (Center.rs.next()) {
					int temp1 = Center.rs.getInt(Title[0]);
				    data[0] = Integer.toString(temp1);
					int temp2 = Center.rs.getInt(Title[1]);
				    data[1] = Integer.toString(temp2);
				    data[2] = Center.rs.getString(Title[2]);
				    data[3] = Center.rs.getString(Title[3]);
				    data[4] = Center.rs.getString(Title[4]);
				    data[5] = Center.rs.getString(Title[5]);
				   model.addRow(data);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    DataTable.setModel(model);
		    getLogArea().append("��ѯ:��Ʒ��Ϣ\n");
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
			String sql = "SELECT * FROM ���� WHERE �û�ID=" + UserID1 + ";";
			Center.customize1(sql);
			String[] Title = {"��ƷID","���","�û�ID","ʱ��","����","�ȼ�"};
			Object [][]cellData={};
			model=new DefaultTableModel(cellData,Title){
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return false;
				}
			};
			String []data=new String [6];
		    try {
				while (Center.rs.next()) {
					int temp1 = Center.rs.getInt(Title[0]);
				    data[0] = Integer.toString(temp1);
					int temp2 = Center.rs.getInt(Title[1]);
				    data[1] = Integer.toString(temp2);
				    int temp3 = Center.rs.getInt(Title[2]);
				    data[2] = Integer.toString(temp3);
				    data[3] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Center.rs.getTimestamp(Title[3]));
				    data[4] = Center.rs.getString(Title[4]);
				    int temp4 = Center.rs.getInt(Title[5]);
				    data[5] = Integer.toString(temp4);
				   model.addRow(data);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    DataTable.setModel(model);
		    getLogArea().append("��ѯ:����\n");
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
			String sql = "SELECT * FROM ���� WHERE �û�ID=" + UserID1 + ";";
			Center.customize1(sql);
			String[] Title = {"��ƷID", "��Ʒ���", "�û�ID","��ַ","����","���"};
			Object [][]cellData={};
			model=new DefaultTableModel(cellData,Title){
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return false;
				}
			};
			String []data=new String [6];
		    try {
				while (Center.rs.next()) {
					int temp1 = Center.rs.getInt(Title[0]);
				    data[0] = Integer.toString(temp1);
				    int temp2 = Center.rs.getInt(Title[1]);
				    data[1] = Integer.toString(temp2);
				    int temp3 = Center.rs.getInt(Title[2]);
				    data[2] = Integer.toString(temp3);
				    data[3] = Center.rs.getString(Title[3]);
				    int temp4 = Center.rs.getInt(Title[4]);
				    data[4] = Integer.toString(temp4);
				    float temp5 = Center.rs.getFloat(Title[5]);
				    data[5] = Float.toString(temp5);
				    model.addRow(data);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    DataTable.setModel(model);
		    getLogArea().append("��ѯ:" + UserID1 + " ����\n");
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
			getOpBtn6().setEnabled(true);
			getOpBtn5().setEnabled(true);
			String sql = "SELECT * FROM �û� WHERE �û�ID=" + UserID1 + ";";
			Center.customize1(sql);
			String[] Title = {"�û�ID", "�绰", "�ǳ�","���֤", "���"};
			Object [][]cellData={};
			model=new DefaultTableModel(cellData,Title){
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return false;
				}
			};
			String []data=new String [6];
		    try {
				while (Center.rs.next()) {
					int temp1 = Center.rs.getInt(Title[0]);
				    data[0] = Integer.toString(temp1);
				    data[1] = Center.rs.getString(Title[1]);
				    data[2] = Center.rs.getString(Title[2]);
				    data[3] = Center.rs.getString(Title[3]);
				    float temp5 = Center.rs.getFloat(Title[4]);
				    data[4] = Float.toString(temp5);
				    model.addRow(data);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    DataTable.setModel(model);
		    getLogArea().append("��ѯ:" + UserID1 + " ������Ϣ\n");
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
			String sql = "SELECT * FROM ����;";
			Center.customize1(sql);
			String[] Title = {"����ID", "�û�ID", "Ʒ��", "����", "����" };
			Object [][]cellData={};
			model=new DefaultTableModel(cellData,Title){
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return false;
				}
			};
			String []data=new String [5];
		    try {
				while (Center.rs.next()) {
					int temp1 = Center.rs.getInt(Title[0]);
				    data[0] = Integer.toString(temp1);
					int temp2 = Center.rs.getInt(Title[1]);
				    data[1] = Integer.toString(temp2);
				    data[2] = Center.rs.getString(Title[2]);
				    data[3] = Center.rs.getString(Title[3]);
				    data[4] = Center.rs.getString(Title[4]);
				   model.addRow(data);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    DataTable.setModel(model);
		    getLogArea().append("��ѯ:����\n");
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
			String sql = "SELECT * FROM �ղ� WHERE �û�ID=" + UserID1 + ";";
			Center.customize1(sql);
			String[] Title = {"�û�ID", "��ƷID", "��Ʒ���", "����", "ʱ��", "�۸�"};
			Object [][]cellData={};
			model=new DefaultTableModel(cellData,Title){
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return false;
				}
			};
			String []data=new String [6];
		    try {
				while (Center.rs.next()) {
					int temp1 = Center.rs.getInt(Title[0]);
				    data[0] = Integer.toString(temp1);
					int temp2 = Center.rs.getInt(Title[1]);
				    data[1] = Integer.toString(temp2);
				    int temp3 = Center.rs.getInt(Title[2]);
				    data[2] = Integer.toString(temp3);
				    int temp4 = Center.rs.getInt(Title[3]);
				    data[3] = Integer.toString(temp4);				    
				    data[4] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Center.rs.getTimestamp(Title[4]));
				    float temp5 = Center.rs.getFloat(Title[5]);
				    data[5] = Float.toString(temp5);
				    model.addRow(data);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    DataTable.setModel(model);
		    getLogArea().append("��ѯ:" + UserID1 + " �ղ�\n");
		}
	}
	private static class InsertListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			insert.getInsert().setVisible(true);
			
		}
	}
	
	private static class DeleteListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			delete.getDelete().setVisible(true);
			
		}
	}
	
	private static class QueryListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			select.getSelect().setVisible(true);
			
		}
	}
	
	private static class UpdateListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			update.getUpdate().setVisible(true);
			
		}
	}
}
