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

	public Player pointWonBy(String player) {
		Player currentPlayer = players.get(player);
		currentPlayer.addPoint();
		score();
		Player winner = null;
		winner = getWinner(currentPlayer);
		return winner;
	}

	private Player getWinner(Player currentPlayer) {
		if (currentPlayer.getGameCount() >= 6) {
			List<Player> playersList = players.values().stream().map(p -> p)
					.collect(Collectors.toList());
			int gameCountDiff = Math.abs(playersList.get(0).getGameCount()
					- playersList.get(1).getGameCount());
			if (gameCountDiff >= 2) {
				return currentPlayer;
			}
		}
		return null;
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
