package DataBase;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class select extends JDialog{
	private static select instance = null;
	private static JTextField goodsIDField = null;
	private static String name = null;
	
	private static select getInstance() {
		if(instance == null) {
			instance = new select();
		}
		return instance;
	}
	public static select getSelect() {
		return select.getInstance();
	}
	private select() {
		super();
		this.setSize(new Dimension(350, 300));
		this.setLayout(new FlowLayout());
		this.setTitle("查询评论");
		goodsIDField = new JTextField();
		goodsIDField.setPreferredSize(new Dimension(150, 40));
		
		JLabel tipLabel = new JLabel("请输入需要查询的商品名称：");
		
		JPanel goodsIDFieldPanel = new JPanel();
		JLabel goodsIDFieldLabel = new JLabel("商品名称：");
		goodsIDFieldPanel.setLayout(new GridLayout(1,2));
		goodsIDFieldPanel.add(goodsIDFieldLabel);
		goodsIDFieldPanel.add(goodsIDField);
		
		JButton button = new JButton("查询评论");
		button.setPreferredSize(new Dimension(150,30));
		button.addActionListener(new addListener());
		this.add(tipLabel);
		this.add(goodsIDFieldPanel);
		this.add(button);
	}
	private static class addListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			name = goodsIDField.getText();
			String sql1 = new String("DROP VIEW view_commit;");
			String sql2 = new String("CREATE VIEW view_commit AS SELECT 商品.名称,商品.商品ID,评论.内容,评论.等级,评论.时间 FROM 商品,评论 WHERE 商品.商品ID = 评论.商品ID");
			String sql3 = new String("SELECT * FROM view_commit WHERE 名称 LIKE '%" +
					name + "%' ORDER BY 等级 DESC;");
			Center.customize2(sql1);
			Center.customize2(sql2);
			Center.customize1(sql3);
			
			String[] Title = {"名称","商品ID","内容","等级","时间"};
			Object [][]cellData={};
			customerPanel.model=new DefaultTableModel(cellData,Title){
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return false;
				}
			};
			String []data=new String [7];
		    try {
				while (Center.rs.next()) {
					data[0] = Center.rs.getString(Title[0]);
					int temp2 = Center.rs.getInt(Title[1]);
				    data[1] = Integer.toString(temp2);
				    data[2] = Center.rs.getString(Title[2]);
				    int temp3 = Center.rs.getInt(Title[3]);
				    data[3] = Center.rs.getString(Title[3]);
				    data[4] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Center.rs.getTimestamp(Title[4]));
				    customerPanel.model.addRow(data);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    customerPanel.DataTable.setModel(customerPanel.model);
			
			select.getInstance().setVisible(false);
			customerPanel.logArea.append("查询评论 含有字符串：" + name + "的商品");
			
		}
	}
}