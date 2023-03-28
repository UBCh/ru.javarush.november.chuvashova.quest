package quest.repositories;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoaderBDContentTest {

    public LoaderBDContentTest() throws SQLException, ClassNotFoundException {
        searchValue();

    }
    private static final String url = "jdbc:mysql://localhost:3306/UBCh";
    private static final String user = "app";
    private static final String password = "pass";
    private static int levelMax=0;

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static final String GET_ALL = "SELECT * FROM `bd_quest`";

    public static Map<Integer, String> questionsTest = new HashMap<>();
    public static Map<Integer, String> answersFailTest = new HashMap<>();
    public static Map<Integer, String> rightButtonTest = new HashMap<>();
    public static Map<Integer, String> buttonWongTest = new HashMap<>();
    public static String victoryTextTest ="";
    public static String headerTest ="";
    public static String prologueTest ="";


    //доступ к бд

    public static void searchValue() throws SQLException, ClassNotFoundException {
        String qwery="SELECT * FROM `bd_quest` WHERE ";   //  позволяет выбрать конкретную строку
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, password);
        stmt = con.createStatement( );
        rs = stmt.executeQuery(qwery+"1");
        rs.next();
        levelMax=rs.getInt(5);
        headerTest=(rs.getString(3));
        prologueTest=(rs.getString(4));
        victoryTextTest=(rs.getString(10));
        setContent(1,rs);
        for (int i = 2; i < levelMax+1; i++) {
           rs.next();
            setContent(i,rs);
        }
    }



    // формирование данных Content из БД
    public static void setContent(int level, ResultSet rsv) throws SQLException {
        questionsTest.put(level,rsv.getString(6));
       answersFailTest.put(level,rsv.getString(7));
       rightButtonTest.put(level,rsv.getString(8));
        buttonWongTest.put(level,rsv.getString(9));
    }

    public static int getLevelMax() {
        return levelMax;
    }

    public static Map<Integer, String> getQuestionsTest() {
        return questionsTest;
    }

    public static Map<Integer, String> getAnswersFailTest() {
        return answersFailTest;
    }

    public static Map<Integer, String> getRightButtonTest() {
        return rightButtonTest;
    }

    public static Map<Integer, String> getButtonWongTest() {
        return buttonWongTest;
    }

    public static String getVictoryTextTest() {
        return victoryTextTest;
    }

    public static String getHeaderTest() {
        return headerTest;
    }

    public static String getPrologueTest() {
        return prologueTest;
    }


}