package com.dius.com.dius.tennis.functionality;

import java.util.List;

public class Game {
	static int[] normalGameScore = { 0, 15, 30, 40 };

	public static String getScore(List<Player> playersList) {
		Player player1 = playersList.get(0);
		Player player2 = playersList.get(1);
		int player1GameCount = player1.getGameCount();
		int player2GameCount = player2.getGameCount();

		int player1Points = player1.getPoint();
		int player2Points = player2.getPoint();

		String scoreString = "";
		if (player1Points >= 3 && player2Points >= 3
				&& (player1Points == player2Points)) {
			scoreString = "Deuce";
		} else {
			scoreString = normalGameScore[player1Points] + "-"
					+ normalGameScore[player2Points];
		}
		return player1GameCount + "-" + player2GameCount + ", " + scoreString;
	}
}
