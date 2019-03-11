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

}
