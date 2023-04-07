package quest.repositories.databaseIngector;

import quest.controller.DispatherQuest.NameBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Loader {

    private  final String URL = "jdbc:mysql://localhost:3306/UBCh";
    private  final String USER = "app";
    private  final String PASSWORD = "pass";
   private  int levelMax = 0;
    private  Connection con;
    private  Statement stmt;
    private  ResultSet rs;
    private ArrayList<Map<Integer,String>> resultSets=new ArrayList<>();
    private NameBD nameBD;

    public Loader(NameBD nameBD) throws SQLException, ClassNotFoundException {
	this.nameBD = nameBD;
	searchValue();
    }

    public void searchValue() throws SQLException, ClassNotFoundException {
	String qwery = getStringRequest();
	Map<Integer,String> value=new HashMap<>();
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(URL, USER, PASSWORD);
	stmt = con.createStatement();
	rs = stmt.executeQuery(qwery);
	 while (rs.next())
	 {
          levelMax = rs.getInt(5);
	     resultSets.add(giveСontentOfLine(rs));}
	}



    private String getStringRequest(){
	switch (nameBD){
	    case BD_QUEST -> {
		return "SELECT * FROM `bd_quest`";
	    }
	    case BD_QUEST2 ->{return "SELECT * FROM `bd_quest2`";}
	    case BD_QUEST3 ->{return "SELECT * FROM `bd_quest3`";}
	}
	return null;
    }

    private Map<Integer, String> giveСontentOfLine(ResultSet rs) throws SQLException {
	Map<Integer,String> value=new HashMap<>();
	for (int i = 1; i <11 ; i++) {
	  value.put(i,rs.getString(i)) ;
	}
	return value;
    }

    public ArrayList<Map<Integer, String>> getResultSets() {
	return resultSets;
    }
}
