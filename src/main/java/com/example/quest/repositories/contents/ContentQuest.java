package com.example.quest.repositories.contents;

import com.example.quest.repositories.databaseIngector.Loader;
import com.example.quest.controller.DispatherQuest.NameBD;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ContentQuest extends Quest{

   private ArrayList<Map<Integer, String>> resultSets;

    public  Map<Integer, String> questions = new HashMap<>();
    public  Map<Integer, String> answersFail = new HashMap<>();
    public  Map<Integer, String> rightButton = new HashMap<>();
    public  Map<Integer, String> buttonWong = new HashMap<>();
    public  String victoryText = "";
    public  String header = "";
    public  String prologue = "";
    public volatile int level = 0;

    public ContentQuest(NameBD nameBD) throws SQLException, ClassNotFoundException {
	Loader loader=new Loader(nameBD);
	this.resultSets =loader.getResultSets();
	downloadContent();
    }

    private void downloadContent() throws SQLException {
	int maxLevel=resultSets.size();
	Map<Integer,String> value= resultSets.get(0);
	header=value.get(3);
	prologue=value.get(4);
	victoryText=value.get(10);
         setContent(1,value);
	for (int i = 1; i < maxLevel; i++) {
	  value=resultSets.get(i);
	     setContent(i+1, value);
	}

    }

    public  void setContent(int level, Map<Integer,String> value) throws SQLException {
	questions.put(level, value.get(6));
	answersFail.put(level, value.get(7));
	rightButton.put(level, value.get(8));
	buttonWong.put(level, value.get(9));
    }


    public  Map<Integer, String> getRightButton() {
	return rightButton;
    }

    public  Map<Integer, String> getButtonWong() {
	return buttonWong;
    }

    public  Map<Integer, String> getQuestions() {
	return questions;
    }

    public  Map<Integer, String> getAnswersFail() {
	return answersFail;
    }

    public  int getLevel() {
	return level;
  }

    public  void setLevel(int lev) {
	level = lev;
    }

    public  String getVictoryText() {
	return victoryText;
    }

    public  String getHeader() {
	return header;
    }

    public  String getPrologue() {
	return prologue;
    }


    public synchronized  void plusLevel() {
	level = level + 1;
    }


}
