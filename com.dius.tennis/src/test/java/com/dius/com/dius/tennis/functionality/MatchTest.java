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
}
