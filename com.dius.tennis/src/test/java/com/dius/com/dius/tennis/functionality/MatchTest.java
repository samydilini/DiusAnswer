package com.dius.com.dius.tennis.functionality;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class MatchTest. This class has covered all the interface scenarios given
 * in the test and additionl information on the description
 */
public class MatchTest {

	/**
	 * Test increment one.
	 */
	@Test
	public void testIncrementOne() {
		Match match = new Match("player 1", "player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");
		assertEquals("0-0, 15-15", match.score());

	}

	/**
	 * Test three one.
	 */
	@Test
	public void testThreeOne() {
		Match match = new Match("player 1", "player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");

		match.pointWonBy("player 1");
		match.pointWonBy("player 1");
		// this will return "0-0, 40-15"
		assertEquals("0-0, 40-15", match.score());
	}

	/**
	 * Test duce.
	 */
	@Test
	public void testDuce() {
		Match match = new Match("player 1", "player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");

		match.pointWonBy("player 1");
		match.pointWonBy("player 1");
		match.score();

		match.pointWonBy("player 2");
		match.pointWonBy("player 2");
		// this will return "0-0, Deuce"
		assertEquals("0-0, Deuce", match.score());
	}

	/**
	 * Test advantage.
	 */
	@Test
	public void testAdvantage() {
		Match match = new Match("player 1", "player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");

		match.pointWonBy("player 1");
		match.pointWonBy("player 1");

		match.pointWonBy("player 2");
		match.pointWonBy("player 2");

		match.pointWonBy("player 1");
		// this will return "0-0, Advantage player 1"
		assertEquals("0-0, Advantage player 1", match.score());
	}

	/**
	 * Test wina game.
	 */
	@Test
	public void testWinaGame() {
		Match match = new Match("player 1", "player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");
		match.pointWonBy("player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 1");
		// this will return "1-0"
		assertEquals("1-0", match.score());

	}

	/**
	 * Test match after wining A game.
	 */
	@Test
	public void testMatchAfterWiningAGame() {
		Match match = new Match("player 1", "player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");
		match.pointWonBy("player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 1");
		// this will return "1-0"
		assertEquals("1-0", match.score());
		match.pointWonBy("player 1");
		assertEquals("1-0, 15-0", match.score());
	}

	// A player wins a set by winning at least 6 games and at least 2 games more
	/**
	 * Test win match.
	 */
	// than the opponent.
	@Test
	public void testWinMatch() {
		Match match = new Match("player 1", "player 2");
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");
		match.pointWonBy("player 2");

		assertNull(match.pointWonBy("player 1"));
		Player winner = match.pointWonBy("player 1");
		assertEquals("player 1", winner.getName());
	}

	// If one player has won six games and the opponent five, an additional game
	// is played. If the leading player wins that game, the player wins the set
	/**
	 * Test win match after six and five.
	 */
	// 7–5. If the trailing player wins the game, a tie-break is played.
	@Test
	public void testWinMatchAfterSixAndFive() {
		Match match = new Match("player 1", "player 2");
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);

		match = player2WinGame(match);
		match = player2WinGame(match);
		match = player2WinGame(match);
		match = player2WinGame(match);
		match = player2WinGame(match);

		match = player1WinGame(match);

		match.pointWonBy("player 1");
		match.pointWonBy("player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");
		match.pointWonBy("player 2");

		assertNull(match.pointWonBy("player 1"));
		Player winner = match.pointWonBy("player 1");
		assertEquals("player 1", winner.getName());
	}

	/**
	 * Test set tie break.
	 */
	@Test
	public void testSetTieBreak() {
		Match match = new Match("player 1", "player 2");
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);

		match = player2WinGame(match);
		match = player2WinGame(match);
		match = player2WinGame(match);
		match = player2WinGame(match);
		match = player2WinGame(match);

		match = player1WinGame(match);
		match = player2WinGame(match);
		match = player1WinGame(match);
		assertTrue(match.isTieBreaker());

	}

	/**
	 * Test tie break scoring.
	 */
	@Test
	public void testTieBreakScoring() {
		Match match = new Match("player 1", "player 2");
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);

		match = player2WinGame(match);
		match = player2WinGame(match);
		match = player2WinGame(match);
		match = player2WinGame(match);
		match = player2WinGame(match);

		match = player1WinGame(match);
		match = player2WinGame(match);
		match = player1WinGame(match);
		assertTrue(match.isTieBreaker());
		match.pointWonBy("player 1");
		assertEquals("7-6, 1-0", match.score());
	}

	/**
	 * Test tie break wining.
	 */
	@Test
	public void testTieBreakWining() {
		Match match = new Match("player 1", "player 2");
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);
		match = player1WinGame(match);

		match = player2WinGame(match);
		match = player2WinGame(match);
		match = player2WinGame(match);
		match = player2WinGame(match);
		match = player2WinGame(match);

		match = player1WinGame(match);
		match = player2WinGame(match);
		match = player1WinGame(match);
		assertTrue(match.isTieBreaker());
		assertNull(match.pointWonBy("player 1"));
		Player winner = match.pointWonBy("player 1");
		assertEquals("player 1", winner.getName());
	}

	/**
	 * Player 2 win game.
	 *
	 * @param match
	 *            the match
	 * @return the match
	 */
	private Match player2WinGame(Match match) {
		for (int i = 0; i <= 2; i++) {
			match.pointWonBy("player 2");
			match.pointWonBy("player 1");
		}
		match.pointWonBy("player 2");
		match.pointWonBy("player 2");
		match.score();
		return match;
	}

	/**
	 * Player 1 win game.
	 *
	 * @param match
	 *            the match
	 * @return the match
	 */
	private Match player1WinGame(Match match) {
		for (int i = 0; i <= 2; i++) {
			match.pointWonBy("player 1");
			match.pointWonBy("player 2");
		}
		match.pointWonBy("player 1");
		match.pointWonBy("player 1");
		match.score();
		return match;
	}
}
