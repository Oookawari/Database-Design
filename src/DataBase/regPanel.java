package DataBase;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class regPanel extends JPanel{
	protected static regPanel instance = null;
	private static regPanel getInstance() {
		if(instance == null) {
			instance = new regPanel();
		}
		return instance;
	}
	public static regPanel getRegPanel() {
		return regPanel.getInstance();
	}
	private regPanel() {
		super();
		this.setLayout(new BorderLayout());
	}
}
