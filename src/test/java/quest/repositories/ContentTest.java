package quest.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContentTest {


    Content content;

    @BeforeEach
    void setUp() {

	content = new Content();
    }

    @Test
    @DisplayName("should return the level of the game")
    void shouldGetLevel() {
	int expected = Content.level;
	int actual = Content.getLevel();
	assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("should set the correct level")
    @ValueSource(ints = {1, 2, 3})
    void shouldSetLevel(int argument) {
	Content.setLevel(argument);
	int expected = argument;
	int actual = Content.level;
	assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("should level up by 1")
    @ValueSource(ints = {1, 2, 3})
    void shouldPlusLevel(int argument) {
	Content.setLevel(0);
	for (int i = 0; i < argument; i++) {
	    Content.plusLevel();
	}
	int expected = argument;
	int actual = Content.level;
	assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should return the texts of the winning message")
    void shouldGetVictoryText() {
	String expected = Content.victoryText;
	String actual = Content.getVictoryText();
	assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should return the texts of the header of game")
    void shouldGetHeader() {
	String expected = Content.header;
	String actual = Content.getHeader();
	assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should return the texts of the prologue of game")
    void shouldGetPrologue() {
	String expected = Content.prologue;
	String actual = Content.getPrologue();
	assertEquals(expected, actual);
    }


    @ParameterizedTest
    @DisplayName("should return the texts of game pages")
    @ValueSource(ints = {1, 2, 3, 4})
    void shouldGetQuestions(int argument) {
	Map<Integer, String> expected = (Map<Integer, String>) argsProviderFactory(argument)[0];
	Map<Integer, String> actual = (Map<Integer, String>) argsProviderFactory(argument)[1];
	int expected1 = expected.size();
	int actual1 = actual.size();
	assertEquals(expected1, actual1);
	for (int i = 1; i <= expected1; i++) {
	    String expected2 = expected.get(i);
	    String actual2 = actual.get(i);
	    assertEquals(expected2, actual2);
	}
    }

    private Object[] argsProviderFactory(int tmp) {
	Object[] test = new Object[2];
	switch (tmp) {
	    case 1: {
		test[0] = Content.questions;
		test[1] = Content.getQuestions();
		return test;
	    }
	    case 2: {
		test[0] = Content.answersFail;
		test[1] = Content.getAnswersFail();
		return test;
	    }
	    case 3: {
		test[0] = Content.buttonWong;
		test[1] = Content.getButtonWong();
		return test;
	    }
	    case 4: {
		test[0] = Content.rightButton;
		test[1] = Content.getRightButton();
		return test;
	    }
	}
	return null;
    }

}