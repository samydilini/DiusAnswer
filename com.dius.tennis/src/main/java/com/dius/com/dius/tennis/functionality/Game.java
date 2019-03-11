package com.dius.com.dius.tennis.functionality;

import java.util.List;

/**
 * The Class Game.
 */
public class Game {
	
	/** The normal game score. */
	static int[] normalGameScore = { 0, 15, 30, 40 };

	/**
	 * Gets the score.
	 *
	 * @param playersList the players list
	 * @return the score
	 */
	public static String getScore(List<Player> playersList) {
		Player player1 = playersList.get(0);
		Player player2 = playersList.get(1);

		String playingScoreString = scorePlayingAGame(player1, player2);
		return playingScoreString;
	}

	/**
	 * Score playing A normal game.
	 *
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @return the string
	 */
	private static String scorePlayingAGame(Player player1, Player player2) {
		int player1Points = player1.getPoint();
		int player2Points = player2.getPoint();

		String scoreString = "";
		if (player1Points >= 3 && player2Points >= 3) {
			scoreString = validateDeuceState(player1, player2, player1Points,
					player2Points);
		} else {
			scoreString += (player1Points == 0 && player2Points == 0) ? ""
					: ", " + normalGameScore[player1Points] + "-"
							+ normalGameScore[player2Points];
		}
		String gameCountString = player1.getGameCount() + "-"
				+ player2.getGameCount();
		return gameCountString + scoreString;
	}

	/**
	 * Validate Deuce state.
	 *
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @param player1Points the player 1 points
	 * @param player2Points the player 2 points
	 * @return the string
	 */
	private static String validateDeuceState(Player player1, Player player2,
			int player1Points, int player2Points) {
		String scoreString = ", ";
		if (player1Points != player2Points) {
			int diff = Math.abs(player1Points - player2Points);
			Player playerWithHighScore = ((player1Points > player2Points) ? player1
					: player2);
			if (diff == 1) {
				scoreString += "Advantage " + playerWithHighScore.getName();
			} else {
				scoreString = "";
				playerWithHighScore.incremetGameCount();
				player1.setPoint(0);
				player2.setPoint(0);
			}
		} else {
			scoreString += "Deuce";
		}
		return scoreString;
	}

	/**
	 * Gets the tie breaker score.
	 *
	 * @param playersList the players list
	 * @return the tie breaker score
	 */
	public static String getTieBreakerScore(List<Player> playersList) {
		Player player1 = playersList.get(0);
		Player player2 = playersList.get(1);

		String gameCountString = player1.getGameCount() + "-"
				+ player2.getGameCount();
		String scoreString = ", " + player1.getPoint() + "-"
				+ player2.getPoint();
		return gameCountString + scoreString;
	}
}
