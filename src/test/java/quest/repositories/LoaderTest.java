package quest.repositories;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LoaderTest {


    @Test
    void name() throws SQLException, ClassNotFoundException {
	Loader loader=new Loader();
	loader.searchValue();
	String expected="ВЕЛИКАЯ ПИРАМИДА САГИ";
	String actual= Content.answersFail.get(3);
	assertEquals(expected,actual);
    }
}