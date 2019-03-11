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

}
