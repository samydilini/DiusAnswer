package com.dius.com.dius.tennis.functionality;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GameTest {

	@Test
	public void testNormalScoreZeroZero() {
		List<Player> playersList = new ArrayList<>();
		playersList.add(new Player("p1"));
		playersList.add(new Player("p2"));
		assertEquals("0-0, 0-0", Game.getScore(playersList));
	}

	@Test
	public void testNormalScoreOneOne() {
		List<Player> playersList = new ArrayList<>();
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		p1.addPoint();
		p2.addPoint();

		playersList.add(p1);
		playersList.add(p2);
		assertEquals("0-0, 15-15", Game.getScore(playersList));
	}

	@Test
	public void testNormalScoreDuce() {
		List<Player> playersList = new ArrayList<>();
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		p1.addPoint();
		p1.addPoint();
		p1.addPoint();

		p2.addPoint();
		p2.addPoint();
		p2.addPoint();

		playersList.add(p1);
		playersList.add(p2);
		assertEquals("0-0, Deuce", Game.getScore(playersList));
	}

	@Test
	public void testNormalScoreAdvantagePlayer() {
		List<Player> playersList = new ArrayList<>();
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		p1.addPoint();
		p1.addPoint();
		p1.addPoint();

		p2.addPoint();
		p2.addPoint();
		p2.addPoint();
		p2.addPoint();

		playersList.add(p1);
		playersList.add(p2);
		assertEquals("0-0, Advantage p2", Game.getScore(playersList));
	}
	
	@Test
	public void testNormalScoreWinOneGame() {
		List<Player> playersList = new ArrayList<>();
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		p1.addPoint();
		p1.addPoint();
		p1.addPoint();

		p2.addPoint();
		p2.addPoint();
		p2.addPoint();
		p2.addPoint();
		p2.addPoint();

		playersList.add(p1);
		playersList.add(p2);
		assertEquals("1-0", Game.getScore(playersList));
	}

}
