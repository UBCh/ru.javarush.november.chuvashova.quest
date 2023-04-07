package quest.repositories.dispather;

import quest.repositories.contents.ContentQuest;
import quest.controller.DispatherQuest.NameBD;
import quest.repositories.contents.Quest;

import java.sql.SQLException;
import java.util.Map;

public class DispatcherRepository {

       Quest content;




    public DispatcherRepository(NameBD nameBD)  {
	try {
	    content= new ContentQuest(nameBD);
	} catch (SQLException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }




	public String getQuestName(){
	return content.getHeader();
	}

	public String getStartPageContent(){
	return content.getPrologue();
	}

	public String getVictoryPageContent(){
	return content.getVictoryText();
	}

	public Map<Integer, String> getSetsQuestions(){
	return content.getQuestions();
	}

    public Map<Integer, String> getSetsAnsversFail(){
	return content.getAnswersFail();
    }

    public Map<Integer, String> getSetsСorrectAnswers(){
	return content.getRightButton();
    }

    public Map<Integer, String> getSetsWrongAnswers(){
	return content.getButtonWong();
    }

    public void setLevelGaim(int level){
	content.setLevel(level);
    }
    public int getLevelGaim(){
	 return content.getLevel();
    }

    public void plusLevelGaim(){
	content.plusLevel();
    }

    }

