package is.aadoj.TicTacToe;

import static org.junit.Assert.*;
import org.junit.Test;

public class TicTacToeTest
{
	public static void main(String args[])
	{
		org.junit.runner.JUnitCore.main("is.aadoj.TicTacToe.TicTacToeTest");
	}

	@Test
	public void insertCharTest()
	{
		TicTacToe game = new TicTacToe();
		char[] result = new char[9];
		char[] expected = new char[9];
		for (int i = 0; i < 9; i++)
		{
			expected[i] = ' ';
		}

		result = game.insertChar(1);
		expected[1] = 'X';
		assertArrayEquals(expected, result);

		result = game.insertChar(4);
		expected[4] = 'O';
		assertArrayEquals(expected, result);

		result = game.insertChar(2);
		expected[2] = 'X';
		assertArrayEquals(expected, result);

		result = game.insertChar(0);
		expected[0] = 'O';
		assertArrayEquals(expected, result);

		result = game.insertChar(8);
		expected[8] = 'X';
		assertArrayEquals(expected, result);

		result = game.insertChar(5);
		expected[5] = 'O';
		assertArrayEquals(expected, result);

		result = game.insertChar(3);
		expected[3] = 'X';
		assertArrayEquals(expected, result);

		result = game.insertChar(7);
		expected[7] = 'O';
		assertArrayEquals(expected, result);

		result = game.insertChar(6);
		expected[6] = 'X';
		assertArrayEquals(expected, result);
	}

	@Test
	public void playerOneWon()
	{			
<<<<<<< HEAD
		TicTackToe game = new TickTackToe();
		game.insertChar(0);
		game.insertChar(2);
		game.insertChar(4);
		game.insertChar(3);
		game.insertChar(8);
		assertEquals(1, game.whoWon());
=======
		assertEquals(1, TicTacToe.whoWon(true,false));
	}

	@Test
	public void gameFinishedShouldReturnFalse()
	{
		TicTacToe game = new TicTacToe();
		assertEquals(false, game.gameFinished());
<<<<<<< HEAD
>>>>>>> develop
>>>>>>> 86097312cc567981c36f087ab0278ced7874f19e
=======
>>>>>>> f2174e24e2c428c297cbee2db9347b3f0540d699
	}
}
