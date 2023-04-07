package quest.repositories;

import org.junit.jupiter.api.Test;
import quest.controller.DispatherQuest.DisperserQuest;
import quest.controller.DispatherQuest.NameBD;
import quest.repositories.contents.Quest;
import quest.repositories.dispather.DispatcherRepository;

import java.sql.SQLException;

class DispatcherRepositoryTest {


    @Test
    void name() throws SQLException, ClassNotFoundException {
      var tmp=new DisperserQuest().PAGE_CONTENT_by_LEVEL;
        var tmp1=tmp.get(0).get(3);
        tmp1=tmp1+1;
         tmp.get(0).set(3, String.valueOf(tmp1));
         int tmp2= Integer.parseInt(tmp.get(0).get(3));


    }

}