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
	protected static JButton newBtn = null;//新建
	protected static JButton queryBtn = null;//查询
	protected static JButton modifyBtn = null;//修改
	protected static JButton deleteBtn = null;//删除
	protected static JScrollPane jSPane = null;
	protected static JScrollPane jSPane2 = null;
	protected static JTextArea logArea = null;//日志
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
			String nameStr = "用户名： " + UserName;
			UserNameLabel.setText(nameStr);
			
			JLabel UserTypeLabel = new JLabel();
			String typeStr = "用户类型： " + UserType;
			UserTypeLabel.setPreferredSize(new Dimension(140,30));
			UserTypeLabel.setText(typeStr);
			
			JLabel UserAccountLabel = new JLabel();
			String accountStr = "用户余额： " + UserAccount;
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
			OpBtn1 = new JButton("查看商品");
			OpBtn1.setPreferredSize(new Dimension(140,60));
			OpBtn1.addActionListener(new OpBtn1Listener());
		}
		return OpBtn1;
	}
	
	private static JButton getOpBtn2() {
		if(OpBtn2 == null) {
			OpBtn2 = new JButton("购买商品");
			OpBtn2.setPreferredSize(new Dimension(140,60));
			OpBtn2.addActionListener(new OpBtn2Listener());
		}
		return OpBtn2;
	}
	
	private static JButton getOpBtn3() {
		if(OpBtn3 == null) {
			OpBtn3 = new JButton("评论");
			OpBtn3.setPreferredSize(new Dimension(140,60));
			OpBtn3.addActionListener(new OpBtn3Listener());
		}
		return OpBtn3;
	}
	
	private static JButton getOpBtn4() {
		if(OpBtn4 == null) {
			OpBtn4 = new JButton("查看订单");
			OpBtn4.setPreferredSize(new Dimension(140,60));
			OpBtn4.addActionListener(new OpBtn4Listener());
		}
		return OpBtn4;
	}
	
	private static JButton getOpBtn5() {
		if(OpBtn5 == null) {
			OpBtn5 = new JButton("查看店铺");
			OpBtn5.setPreferredSize(new Dimension(140,60));
			OpBtn5.addActionListener(new OpBtn5Listener());
		}
		return OpBtn5;
	}
	
	private static JButton getOpBtn6() {
		if(OpBtn6 == null) {
			OpBtn6 = new JButton("查看收藏");
			OpBtn6.setPreferredSize(new Dimension(140,60));
			OpBtn6.addActionListener(new OpBtn6Listener());
		}
		return OpBtn6;
	}
	
	private static JButton getOpBtn7() {
		if(OpBtn7 == null) {
			OpBtn7 = new JButton("个人信息");
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
			optBtns.setBorder(BorderFactory.createTitledBorder("选择操作："));
			optBtns.add(getNewBtn());
			optBtns.add(getQueryBtn());
			optBtns.add(getModifyBtn());
			optBtns.add(getDeleteBtn());
		}
		return optBtns;
	}
	
	private static JButton getNewBtn() {
		if(newBtn == null) {
			newBtn = new JButton("新建订单");
			newBtn.setPreferredSize(new Dimension(140,60));
			newBtn.addActionListener(new InsertListener());
		}
		return newBtn;
	}
	
	private static JButton getQueryBtn() {
		if(queryBtn == null) {
			queryBtn = new JButton("搜索评价");
			queryBtn.setPreferredSize(new Dimension(140,60));
			queryBtn.addActionListener(new QueryListener());
		}
		return queryBtn;
	}
	
	private static JButton getModifyBtn() {
		if(modifyBtn == null) {
			modifyBtn = new JButton("修改订单");
			modifyBtn.setPreferredSize(new Dimension(140,60));
			modifyBtn.addActionListener(new UpdateListener());
		}
		return modifyBtn;
	}
	
	private static JButton getDeleteBtn() {
		if(deleteBtn == null) {
			deleteBtn = new JButton("删除收藏");
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
			logArea.setBorder(BorderFactory.createTitledBorder("操作日志："));
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
			String sql = "SELECT * FROM 商品规格;";
			Center.customize1(sql);
			String[] Title = {"商品ID","商品编号","价格","型号","库存"};
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
		    getLogArea().append("查询:商品规格\n");
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
			String sql = "SELECT * FROM 商品;";
			Center.customize1(sql);
			String[] Title = {"商品ID","店铺ID","名称","简介","生产商","地址"};
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
		    getLogArea().append("查询:商品信息\n");
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
			String sql = "SELECT * FROM 评论 WHERE 用户ID=" + UserID1 + ";";
			Center.customize1(sql);
			String[] Title = {"商品ID","编号","用户ID","时间","内容","等级"};
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
		    getLogArea().append("查询:评论\n");
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
			String sql = "SELECT * FROM 订货 WHERE 用户ID=" + UserID1 + ";";
			Center.customize1(sql);
			String[] Title = {"商品ID", "商品编号", "用户ID","地址","数量","金额"};
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
		    getLogArea().append("查询:" + UserID1 + " 订单\n");
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
			String sql = "SELECT * FROM 用户 WHERE 用户ID=" + UserID1 + ";";
			Center.customize1(sql);
			String[] Title = {"用户ID", "电话", "昵称","身份证", "余额"};
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
		    getLogArea().append("查询:" + UserID1 + " 个人信息\n");
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
			String sql = "SELECT * FROM 店铺;";
			Center.customize1(sql);
			String[] Title = {"店铺ID", "用户ID", "品牌", "介绍", "名称" };
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
		    getLogArea().append("查询:店铺\n");
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
			String sql = "SELECT * FROM 收藏 WHERE 用户ID=" + UserID1 + ";";
			Center.customize1(sql);
			String[] Title = {"用户ID", "商品ID", "商品编号", "数量", "时间", "价格"};
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
		    getLogArea().append("查询:" + UserID1 + " 收藏\n");
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
