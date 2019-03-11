package com.dius.com.dius.tennis.functionality;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class PlayerTest. User functionalities adding a point, getting the game
 * count and incrementing the game count is tested here
 */
public class PlayerTest {

	/**
	 * Test add point.
	 */
	@Test
	public void testAddPoint() {
		Player player = new Player("p1");
		assertEquals(0, player.getPoint());
		player.addPoint();
		assertEquals(1, player.getPoint());
	}

	/**
	 * Test game count.
	 */
	@Test
	public void testGameCount() {
		Player player = new Player("p2");
		assertEquals(0, player.getGameCount());
	}

	/**
	 * Test increment game count.
	 */
	@Test
	public void testIncrementGameCount() {
		Player player = new Player("p2");
		player.incremetGameCount();
		assertEquals(1, player.getGameCount());
	}
}
