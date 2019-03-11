package com.dius.com.dius.tennis.functionality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Match {
	private Map<String, Player> players = new HashMap<>();

	public Match(String player1, String player2) {
		players.put(player1, new Player(player1));
		players.put(player2, new Player(player2));
	}

	public void pointWonBy(String player) {
		players.get(player).addPoint();

	}

	public String score() {
		List<Player> playersList = new ArrayList<>();
		playersList = players.values().stream().map(p -> p)
				.collect(Collectors.toList());
		Collections.reverse(playersList);
		String scoreString = Game.getScore(playersList);
		return scoreString;
	}
}
