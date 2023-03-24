package quest.repositories;

import java.util.HashMap;
import java.util.Map;


public class Content {

    public  static Map <Integer, String> questions= new HashMap<>();

    static {
	questions.put(1,"На стене справа выбиты символы древнего языка, они требуют поклониться погребенному здесь богу.");
	questions.put(2,"Ты Поклонился!!!. И спокойно проходишь внутрь. Ты достаёшь факел из заплечного мешка. Ты зажигаешь его. Неровный, колеблющийся свет освещает коридор, пол покрыт пылью. Ты идёшь вперёд довольно долгое время, пока не натыкаешься на развилку, вправо и влево, два пути. Что выберешь?");
	questions.put(3," Ты пошел налево!!! и спокойно проходишь.Ты долго петляешь по коридорам, избегаешь ловушек (давно сломанных, впрочем), перепрыгиваешь через дыры в полу. Так доходишь до тронного зала. Ты видишь трон вдалеке, на нём полуразложившийся труп восседает, единственное сокровище — богато украшенный скипетр в его руке. Ты доходишь до трона. Ты смотришь на скипетр.");
    }

    public  static Map <Integer, String> answersFail= new HashMap<>();

    static {
	answersFail.put(1,"Ты вошел без уважения и стены раздавливают тебя.");
	answersFail.put(2,"Ты пошел направо и натыкаешься на ловушку. Стрелы из стен пронзают тебя.");
	answersFail.put(3,"Пытаешься вырвать скипетр. Труп пробуждается и убивает тебя.Ибо воровать не хорошо!!!");
    }

    public  static Map <Integer, String>  rightButton= new HashMap<>();

    static {
	rightButton.put(1,"Поклониться");
	rightButton.put(2,"Налево");
	rightButton.put(3,"Просто уходи");
    }

    public  static Map <Integer, String> buttonWong= new HashMap<>();

    static {
	buttonWong.put(1,"К черту суеверия");
	buttonWong.put(2,"Герои идут направо");
	buttonWong.put(3,"Хватай добычу");
    }

    static int level=0;

    public static Map<Integer, String> getRightButton() {
	return rightButton;
    }

    public static Map<Integer, String> getButtonWong() {
	return buttonWong;
    }

    public static void setLevel(int lev) {
	level = lev;
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

   public static String victoryText="У самурая нет цели, есть только путь. Ты спокойно уходишь. Победа.";

    public static String getVictoryText() {
	return victoryText;
    }
    public static String header="ВЕЛИКАЯ ПИРАМИДА САГИ";

 public static String prologue="СТОЙ ИСКАТЕЛЬ ПРИКЛЮЧЕНИЙ!!!!\nТы достиг своей цели после долгого пути, пройдя через леса и горы, и руины старых городов, в поисках\n" +
	 "            сокровищ. Теперь ты стоишь перед огромной пирамидой. Вход — прямоугольная дыра в стене — прямо перед тобой.\n" +
	 "            Вокруг безлюдная пустыня. Сфинкс позади нависает над тобой, его тень от солнца закрывает. Ты идёшь вперёд,\n" +
	 "            ноги увязают в песке, горячий ветер треплет одежду. Ты у входа, тьма впереди закрывает взор...";

    public static String getHeader() {
	return header;
    }

    public static String getPrologue() {
	return prologue;
    }


    public static void plusLevel() {
	level=level+1;
    }
}