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

public class delete extends JDialog{
	private static delete instance = null;
	private static JTextField goodsIDField = null;
	private static JTextField goodsTypeField = null;
	private static JTextField adrressField = null;
	private static JTextField countField = null;
	private static String name = null;
	
	private static delete getInstance() {
		if(instance == null) {
			instance = new delete();
		}
		return instance;
	}
	public static delete getDelete() {
		return delete.getInstance();
	}
	private delete() {
		super();
		this.setSize(new Dimension(350, 300));
		this.setLayout(new FlowLayout());
		this.setTitle("删除收藏");
		goodsIDField = new JTextField();
		goodsIDField.setPreferredSize(new Dimension(150, 40));
		goodsTypeField = new JTextField();
		goodsTypeField.setPreferredSize(new Dimension(150, 40));
		adrressField = new JTextField();
		adrressField.setPreferredSize(new Dimension(150, 40));
		countField = new JTextField();
		countField.setPreferredSize(new Dimension(150, 40));
		
		JLabel tipLabel = new JLabel("请输入需要删除的商品名称：");
		
		JPanel goodsIDFieldPanel = new JPanel();
		JLabel goodsIDFieldLabel = new JLabel("商品名称：");
		goodsIDFieldPanel.setLayout(new GridLayout(1,2));
		goodsIDFieldPanel.add(goodsIDFieldLabel);
		goodsIDFieldPanel.add(goodsIDField);
		
		JButton button = new JButton("删除收藏");
		button.setPreferredSize(new Dimension(150,30));
		button.addActionListener(new addListener());
		this.add(tipLabel);
		this.add(goodsIDFieldPanel);
		this.add(button);
	}
	private static class addListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//DELETE FROM 收藏 WHERE 商品ID IN (SELECT 商品ID FROM 商品 WHERE 名称 = '%+  +%';);
			
			name = goodsIDField.getText();
			String sql1 = new String("BEGIN;");
			String sql2 = new String("DELETE FROM 收藏 WHERE 用户ID = " + 
					DBUI.userID + " AND 商品ID IN (SELECT 商品ID FROM 商品 WHERE 名称 LIKE '%"+ 
					name +"%');");

			Center.customize2(sql1);
			Center.customize2(sql2);

			int res = JOptionPane.showConfirmDialog(null, "确认删除这些数据吗？","确认", JOptionPane.OK_CANCEL_OPTION);
			if(res ==JOptionPane.OK_OPTION) {
				Center.customize2("COMMIT;");
			}
			else {
				Center.customize2("ROLLBACK;");
			}
			delete.getInstance().setVisible(false);
			customerPanel.logArea.append("删除订单 含有字符串：" + name);

		}
	}
}
