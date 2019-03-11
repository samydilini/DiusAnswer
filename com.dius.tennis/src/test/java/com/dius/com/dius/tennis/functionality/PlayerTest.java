package com.dius.com.dius.tennis.functionality;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testAddPoint() {
		Player player = new Player();
		assertEquals(0, player.getPoint());
		player.addPoint();
		assertEquals(1, player.getPoint());
	}
	

}
