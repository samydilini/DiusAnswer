package com.dius.com.dius.tennis.functionality;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * The Class GameTest. Will test if the score strings are properly added.
 */
public class GameTest {

	/**
	 * Test normal score zero zero.
	 */
	@Test
	public void testNormalScoreZeroZero() {
		List<Player> playersList = new ArrayList<>();
		playersList.add(new Player("p1"));
		playersList.add(new Player("p2"));
		assertEquals("0-0", Game.getScore(playersList));
	}

	/**
	 * Test normal score one one.
	 */
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

	/**
	 * Test normal score duce.
	 */
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

	/**
	 * Test normal score advantage player.
	 */
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

	/**
	 * Test normal score win one game.
	 */
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
		assertEquals("0-1", Game.getScore(playersList));
	}
	
	/**
	 * Test tie breaker score.
	 */
	@Test
	public void testTieBreakerScore() {
		List<Player> playersList = new ArrayList<>();
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		p1.addPoint();
		p2.addPoint();

		playersList.add(p1);
		playersList.add(p2);
		assertEquals("0-0, 1-1", Game.getTieBreakerScore(playersList));
	}

	
}
