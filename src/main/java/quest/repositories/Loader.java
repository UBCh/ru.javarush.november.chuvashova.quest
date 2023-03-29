package quest.repositories;

import java.sql.*;

public class Loader {

    private static final String url = "jdbc:mysql://localhost:3306/UBCh";
    private static final String user = "app";
    private static final String password = "pass";
    private static final String GET_ALL = "SELECT * FROM `bd_quest`";
    private static int levelMax = 0;
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;



    public static void searchValue() throws SQLException, ClassNotFoundException {
	String qwery = "SELECT * FROM `bd_quest` WHERE ";
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(url, user, password);
	stmt = con.createStatement();
	rs = stmt.executeQuery(qwery + "1");
	rs.next();
	levelMax = rs.getInt(5);
	Content.setHeader(rs.getString(3));
	Content.setPrologue(rs.getString(4));
	Content.setVictoryText(rs.getString(10));
	setContent(1, rs);
	for (int i = 2; i < levelMax + 1; i++) {
	    rs.next();
	    setContent(i, rs);
	}
    }



    public static void setContent(int level, ResultSet rsv) throws SQLException {
	Content.setQuestions(level, rsv.getString(6));
	Content.setAnswersFail(level, rsv.getString(7));
	Content.setRightButton(level, rsv.getString(8));
	Content.setButtonWong(level, rsv.getString(9));
    }
}
