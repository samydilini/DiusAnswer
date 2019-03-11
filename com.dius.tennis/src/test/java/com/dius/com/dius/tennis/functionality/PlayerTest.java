package com.dius.com.dius.tennis.functionality;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testAddPoint() {
		Player player = new Player("p1");
		assertEquals(0, player.getPoint());
		player.addPoint();
		assertEquals(1, player.getPoint());
	}

	@Test
	public void testGameCount() throws Exception {
		Player player = new Player("p2");
		assertEquals(0, player.getGameCount());
	}
}
