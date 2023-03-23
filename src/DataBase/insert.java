package DataBase;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class insert extends JDialog{
	private static insert instance = null;
	private static JTextField goodsIDField = null;
	private static JTextField goodsTypeField = null;
	private static JTextField adrressField = null;
	private static JTextField countField = null;
	private static int goodID = 0;
	private static int goodType = 0;
	private static int count = 0;
	private static String address = null;
	
	private static insert getInstance() {
		if(instance == null) {
			instance = new insert();
		}
		return instance;
	}
	public static insert getInsert() {
		return insert.getInstance();
	}
	private insert() {
		super();
		this.setSize(new Dimension(350, 300));
		this.setLayout(new FlowLayout());
		this.setTitle("��Ӷ���");
		goodsIDField = new JTextField();
		goodsIDField.setPreferredSize(new Dimension(150, 40));
		goodsTypeField = new JTextField();
		goodsTypeField.setPreferredSize(new Dimension(150, 40));
		adrressField = new JTextField();
		adrressField.setPreferredSize(new Dimension(150, 40));
		countField = new JTextField();
		countField.setPreferredSize(new Dimension(150, 40));
		
		JPanel goodsIDFieldPanel = new JPanel();
		JLabel goodsIDFieldLabel = new JLabel("��ƷID��");
		goodsIDFieldPanel.setLayout(new GridLayout(1,2));
		goodsIDFieldPanel.add(goodsIDFieldLabel);
		goodsIDFieldPanel.add(goodsIDField);
		
		JPanel goodsTypeFieldPanel = new JPanel();
		JLabel goodsTypeFieldLabel = new JLabel("��Ʒ��ţ�");
		goodsTypeFieldPanel.setLayout(new GridLayout(1,2));
		goodsTypeFieldPanel.add(goodsTypeFieldLabel);
		goodsTypeFieldPanel.add(goodsTypeField);
		
		JPanel adrressFieldPanel = new JPanel();
		JLabel adrressFieldLabel = new JLabel("��ַ��");
		adrressFieldPanel.setLayout(new GridLayout(1,2));
		adrressFieldPanel.add(adrressFieldLabel);
		adrressFieldPanel.add(adrressField);
		
		JPanel countFieldPanel = new JPanel();
		JLabel countFieldLabel = new JLabel("������");
		countFieldPanel.setLayout(new GridLayout(1,2));
		countFieldPanel.add(countFieldLabel);
		countFieldPanel.add(countField);
		
		JButton button = new JButton("��Ӷ���");
		button.setPreferredSize(new Dimension(150,30));
		button.addActionListener(new addListener());
		this.add(goodsIDFieldPanel);
		this.add(goodsTypeFieldPanel);
		this.add(adrressFieldPanel);
		this.add(countFieldPanel);
		this.add(button);
	}
	private static class addListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			goodID = Integer.parseInt(goodsIDField.getText());
			goodType = Integer.parseInt(goodsTypeField.getText());
			count = Integer.parseInt(countField.getText());
			address = adrressField.getText();
			String sql1 = new String("select �۸� from ��Ʒ��� where ��ƷID=" 
			+ goodID + " and ��Ʒ���=" + goodType + ";");
			Center.customize1(sql1);
			float price = 0;
			try {
				while(Center.rs.next()){
					price = Center.rs.getFloat("�۸�");
				}
			} catch (SQLException e1) {
				
			} 
			price = price * count;

			int res = Center.insert("����(��ƷID, ��Ʒ���, �û�ID, ��ַ, ����, ���)", "("+
			goodID + ", " + goodType + ", " + DBUI.userID + ",'" + address + "'," +
			count+"," + price + ")");
			if(res == 0) {JOptionPane.showInternalMessageDialog(null, "��������ʧ�ܣ���治��","��������ʧ��", 
					JOptionPane.INFORMATION_MESSAGE);}
			insert.getInsert().setVisible(false);
			customerPanel.logArea.append("��Ӷ���--��ƷID: "+goodID+" ��Ʒ���: "+goodType+" ����: "+count);
		}
	}
}
