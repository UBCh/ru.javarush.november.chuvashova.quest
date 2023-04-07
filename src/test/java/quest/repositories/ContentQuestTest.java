//package quest.repositories;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class ContentQuestTest {
//
//
//    ContentQuest content;
//
//    @BeforeEach
//    void setUp() {
//
//	content = new ContentQuest();
//    }
//
//    @Test
//    @DisplayName("should return the level of the game")
//    void shouldGetLevel() {
//	int expected = ContentQuest.level;
//	int actual = ContentQuest.getLevel();
//	assertEquals(expected, actual);
//    }
//
//    @ParameterizedTest
//    @DisplayName("should set the correct level")
//    @ValueSource(ints = {1, 2, 3})
//    void shouldSetLevel(int argument) {
//	ContentQuest.setLevel(argument);
//	int expected = argument;
//	int actual = ContentQuest.level;
//	assertEquals(expected, actual);
//    }
//
//    @ParameterizedTest
//    @DisplayName("should level up by 1")
//    @ValueSource(ints = {1, 2, 3})
//    void shouldPlusLevel(int argument) {
//	ContentQuest.setLevel(0);
//	for (int i = 0; i < argument; i++) {
//	    ContentQuest.plusLevel();
//	}
//	int expected = argument;
//	int actual = ContentQuest.level;
//	assertEquals(expected, actual);
//    }
//
//
//    @Test
//    @DisplayName("should return the texts of the winning message")
//    void shouldGetVictoryText() {
//	String expected = ContentQuest.victoryText;
//	String actual = ContentQuest.getVictoryText();
//	assertEquals(expected, actual);
//    }
//
//    @Test
//    @DisplayName("should return the texts of the header of game")
//    void shouldGetHeader() {
//	String expected = ContentQuest.header;
//	String actual = ContentQuest.getHeader();
//	assertEquals(expected, actual);
//    }
//
//    @Test
//    @DisplayName("should return the texts of the prologue of game")
//    void shouldGetPrologue() {
//	String expected = ContentQuest.prologue;
//	String actual = ContentQuest.getPrologue();
//	assertEquals(expected, actual);
//    }
//
//
//    @ParameterizedTest
//    @DisplayName("should return the texts of game pages")
//    @ValueSource(ints = {1, 2, 3, 4})
//    void shouldGetQuestions(int argument) {
//	Map<Integer, String> expected = (Map<Integer, String>) argsProviderFactory(argument)[0];
//	Map<Integer, String> actual = (Map<Integer, String>) argsProviderFactory(argument)[1];
//	int expected1 = expected.size();
//	int actual1 = actual.size();
//	assertEquals(expected1, actual1);
//	for (int i = 1; i <= expected1; i++) {
//	    String expected2 = expected.get(i);
//	    String actual2 = actual.get(i);
//	    assertEquals(expected2, actual2);
//	}
//    }
//
//    private Object[] argsProviderFactory(int tmp) {
//	Object[] test = new Object[2];
//	switch (tmp) {
//	    case 1: {
//		test[0] = ContentQuest.questions;
//		test[1] = ContentQuest.getQuestions();
//		return test;
//	    }
//	    case 2: {
//		test[0] = ContentQuest.answersFail;
//		test[1] = ContentQuest.getAnswersFail();
//		return test;
//	    }
//	    case 3: {
//		test[0] = ContentQuest.buttonWong;
//		test[1] = ContentQuest.getButtonWong();
//		return test;
//	    }
//	    case 4: {
//		test[0] = ContentQuest.rightButton;
//		test[1] = ContentQuest.getRightButton();
//		return test;
//	    }
//	}
//	return null;
//    }
//
//}