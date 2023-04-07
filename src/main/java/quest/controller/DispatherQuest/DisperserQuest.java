package quest.controller.DispatherQuest;

import quest.repositories.dispather.DispatcherRepository;

import java.util.ArrayList;
import java.util.Map;

public class DisperserQuest {


    public static Map<Integer, ArrayList<String>> PAGE_CONTENT_by_LEVEL = new RegisterContents(new DispatcherRepository(NameBD.BD_QUEST)).getPageContent();

}