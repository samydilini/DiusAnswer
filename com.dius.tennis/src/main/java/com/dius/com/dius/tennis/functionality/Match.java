package com.dius.com.dius.tennis.functionality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The Class Match. This will hold information about players and tiebreaker
 * state
 */
public class Match {

	/** The players. */
	private Map<String, Player> players = new HashMap<>();

	/** The tie breaker. */
	private boolean tieBreaker = false;

	/**
	 * Instantiates a new match.
	 *
	 * @param player1
	 *            the player 1
	 * @param player2
	 *            the player 2
	 */
	public Match(String player1, String player2) {
		players.put(player1, new Player(player1));
		players.put(player2, new Player(player2));
	}

	/**
	 * This will increment the points of a given player
	 *
	 * @param player
	 *            the player
	 * @return the player
	 */
	public Player pointWonBy(String player) {
		Player currentPlayer = players.get(player);
		currentPlayer.addPoint();
		score();
		Player winner = null;
		winner = !tieBreaker ? getWinner(currentPlayer)
				: getTieBreakerWinner(currentPlayer);
		return winner;
	}

	/**
	 * calculate the winner of a tieBreak
	 *
	 * @param currentPlayer
	 *            the current player
	 * @return the tie breaker winner
	 */
	private Player getTieBreakerWinner(Player currentPlayer) {
		return getPointDifference() >= 2 ? currentPlayer : null;
	}

	/**
	 * Gets the players points difference.
	 *
	 * @return the point count difference
	 */
	private int getPointDifference() {
		int diff = 0;
		List<Player> playersList = players.values().stream().map(p -> p)
				.collect(Collectors.toList());
		diff = Math.abs(playersList.get(0).getPoint()
				- playersList.get(1).getPoint());
		return diff;
	}

	/**
	 * Gets the winner in a non tie breaker match.
	 *
	 * @param currentPlayer
	 *            the current player
	 * @return the winner
	 */
	private Player getWinner(Player currentPlayer) {
		if (currentPlayer.getGameCount() >= 6) {

			int gameCountDiff = getGameCountDifference();

			if (gameCountDiff >= 2) {
				return currentPlayer;
			}
			if (currentPlayer.getGameCount() > 6 && gameCountDiff == 1) {
				tieBreaker = true;
			}
		}
		return null;
	}

	/**
	 * Gets the difference of game counts won by players.
	 *
	 * @return the game count difference
	 */
	private int getGameCountDifference() {
		int diff = 0;
		List<Player> playersList = players.values().stream().map(p -> p)
				.collect(Collectors.toList());
		diff = Math.abs(playersList.get(0).getGameCount()
				- playersList.get(1).getGameCount());
		return diff;
	}

	/**
	 * get score.
	 *
	 * @return the string
	 */
	public String score() {
		List<Player> playersList = new ArrayList<>();
		playersList = players.values().stream().map(p -> p)
				.collect(Collectors.toList());
		Collections.reverse(playersList);
		String scoreString = !tieBreaker ? Game.getScore(playersList) : Game
				.getTieBreakerScore(playersList);
		return scoreString;
	}

	/**
	 * Checks if is tie breaker.
	 *
	 * @return true, if is tie breaker
	 */
	public boolean isTieBreaker() {
		return tieBreaker;
	}
}
