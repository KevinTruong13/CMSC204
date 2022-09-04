import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	private GradeBook book1 = null, book2 = null;

	@BeforeEach
	void setUp() throws Exception {
		book1 = new GradeBook(10);
		book2 = new GradeBook(99);
		
		book1.addScore(-99);
		book1.addScore(999);
		
		for (int i = 0; i < 5; i++) {
			book2.addScore(i);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		book1 = book2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(book1.toString().equals("-99.0 999.0 "));
		assertEquals(2, book1.getScoreSize());
		
		assertTrue(book2.toString().equals("0.0 1.0 2.0 3.0 4.0 "));
		assertEquals(5, book2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(900, book1.sum());
		assertEquals(10, book2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(-99, book1.minimum());
		assertEquals(0, book2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(999, book1.finalScore());
		assertEquals(10, book2.finalScore());
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2, book1.getScoreSize());
		assertEquals(5, book2.getScoreSize());
	}

	@Test
	void testToString() {
		assertTrue(book1.toString().equals("-99.0 999.0 "));
		assertTrue(book2.toString().equals("0.0 1.0 2.0 3.0 4.0 "));
	}

}
