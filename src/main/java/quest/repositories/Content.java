package quest.repositories;

import java.util.HashMap;
import java.util.Map;


public class Content {

    public static Map<Integer, String> questions = new HashMap<>();
    public static Map<Integer, String> answersFail = new HashMap<>();
    public static Map<Integer, String> rightButton = new HashMap<>();
    public static Map<Integer, String> buttonWong = new HashMap<>();
    public static String victoryText = "";
    public static String header = "";
    public static String prologue = "";
    static volatile int level = 0;


    public static Map<Integer, String> getRightButton() {
	return rightButton;
    }

    public static Map<Integer, String> getButtonWong() {
	return buttonWong;
    }

    public static Map<Integer, String> getQuestions() {
	return questions;
    }

    public static Map<Integer, String> getAnswersFail() {
	return answersFail;
    }

    public static int getLevel() {
	return level;
  }

    public static void setLevel(int lev) {
	level = lev;
    }

    public static String getVictoryText() {
	return victoryText;
    }

    public static String getHeader() {
	return header;
    }

    public static String getPrologue() {
	return prologue;
    }


    public synchronized static void plusLevel() {
	level = level + 1;
    }

    public static void setQuestions(int i, String text) {
	questions.put(i,text);
    }

    public static void setAnswersFail(int i, String text) {
	answersFail.put(i,text);
    }

    public static void setRightButton(int i, String text) {
	rightButton.put(i,text);

    }

    public static void setButtonWong(int i, String text) {
	buttonWong.put(i,text);
    }

    public static void setVictoryText(String victoryText) {
	Content.victoryText = victoryText;
    }

    public static void setHeader(String header) {
	Content.header = header;
    }

    public static void setPrologue(String prologue) {
	Content.prologue = prologue;
    }
}
