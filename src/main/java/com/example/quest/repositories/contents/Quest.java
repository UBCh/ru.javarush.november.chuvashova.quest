package com.example.quest.repositories.contents;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public abstract class Quest {

    public  String prologue;
    public Map<Integer, String> questions;
    public Map<Integer, String> answersFail;
    public Map<Integer, String> rightButton;
    public Map<Integer, String> buttonWong;
    public String victoryText;
    public String header;
    public volatile int level;
    private ArrayList<ResultSet> resultSets;

    public abstract void plusLevel();


    public abstract String getPrologue();

    public abstract Map<Integer, String> getQuestions();

    public abstract Map<Integer, String> getAnswersFail();

    public abstract Map<Integer, String> getRightButton();

    public abstract Map<Integer, String> getButtonWong();

    public abstract String getVictoryText();


    public abstract String getHeader();


    public abstract int getLevel();

    public abstract void setLevel(int level);
}
