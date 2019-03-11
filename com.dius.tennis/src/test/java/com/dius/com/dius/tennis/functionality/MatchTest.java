package com.dius.com.dius.tennis.functionality;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatchTest {

	@Test
	public void testIncrementOne() {
		Match match = new Match("player 1", "player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");
		assertEquals("0-0, 15-15", match.score());

	}

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

	@Test
	public void testAdvantage() throws Exception {
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

	@Test
	public void testWinaGame() throws Exception {
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

	@Test
	public void testMatchAfterWiningAGame() throws Exception {
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
	// than the opponent.
	@Test
	public void testWinMatch() throws Exception {
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
