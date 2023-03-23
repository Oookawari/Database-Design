package DataBase;

import java.sql.DriverManager;
import java.sql.SQLException;

public class main {
	public static void main(String[] args) {
		Center.getCenter();
		DBUI UI = DBUI.getDBUI();
		UI.setVisible(true);
	}
}
