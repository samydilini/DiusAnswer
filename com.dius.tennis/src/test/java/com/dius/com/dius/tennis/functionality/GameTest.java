package com.dius.com.dius.tennis.functionality;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GameTest {

	@Test
	public void testNormalScoreZeroZero() {
		List<Player> playersList = new ArrayList<>();
		playersList.add(new Player());
		playersList.add(new Player());
		assertEquals("0-0, 0-0", Game.getScore(playersList));
	}
	
	@Test
	public void testNormalScoreOneOne() {
		List<Player> playersList = new ArrayList<>();
		Player p1 = new Player();
		Player p2 = new Player();
		p1.addPoint();
		p2.addPoint();

		playersList.add(p1);
		playersList.add(p2);
		assertEquals("0-0, 15-15", Game.getScore(playersList));
	}
	
	public void testNormalScoreDuce() {
		List<Player> playersList = new ArrayList<>();
		Player p1 = new Player();
		Player p2 = new Player();
		p1.addPoint();
		p1.addPoint();
		p1.addPoint();
		
		p2.addPoint();
		p2.addPoint();
		p2.addPoint();

		playersList.add(p1);
		playersList.add(p2);
		assertEquals("0-0, Duce", Game.getScore(playersList));
	}

}
