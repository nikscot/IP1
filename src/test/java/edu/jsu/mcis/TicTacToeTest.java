package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	private TicTacToe model;
	
	@Before
    public void setUp() {
        model = new TicTacToe();
    }
	
	@Test
	public void testInitialBoardIsEmpty() {
		for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
				//Mark m = model.getMark(row, col);
                assertEquals(TicTacToe.Mark.EMPTY, model.getMarkAt(row, col));
            }
        }
		//assertTrue(false);
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		model.setMarkAt(0, 2);
        assertEquals(TicTacToe.Mark.X, model.getMarkAt(0, 2));
		//assertTrue(false);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		model.setMarkAt(0, 2);
        model.setMarkAt(2, 0);
        assertEquals(TicTacToe.Mark.O, model.getMarkAt(2, 0));
		//assertTrue(false);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		model.setMarkAt(0, 2);
        assertEquals(TicTacToe.Mark.X, model.getMarkAt(0, 2));
        model.setMarkAt(0, 2);
        assertEquals(TicTacToe.Mark.X, model.getMarkAt(0, 2));
        model.setMarkAt(2, 0);
        assertEquals(TicTacToe.Mark.O, model.getMarkAt(2, 0));
		//assertTrue(false);
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		model.setMarkAt(0, 2);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
		//assertTrue(false);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		model.setMarkAt(0, 0);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMarkAt(1, 1);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMarkAt(0, 1);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMarkAt(1, 0);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMarkAt(0, 2);
        assertEquals(TicTacToe.Result.XWINS, model.getResult());
		//assertTrue(false);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		model.setMarkAt(0, 0);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMarkAt(0, 1);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMarkAt(0, 2);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMarkAt(2, 0);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMarkAt(2, 1);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMarkAt(2, 2);
        model.setMarkAt(1, 0);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMarkAt(1, 1);
        assertEquals(TicTacToe.Result.NONE, model.getResult());
        model.setMarkAt(1, 2);
        assertEquals(TicTacToe.Result.TIE, model.getResult());
		//assertTrue(false);
	}	
}
