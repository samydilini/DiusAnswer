package com.dius.com.dius.tennis.functionality;

import java.util.List;

public class Game {
	static int[] normalGameScore = { 0, 15, 30, 40 };

	public static String getScore(List<Player> playersList) {
		Player player1 = playersList.get(0);
		Player player2 = playersList.get(1);
		int player1GameCount = player1.getGameCount();
		int player2GameCount = player2.getGameCount();
		return player1GameCount + "-" + player2GameCount + ", "
				+ normalGameScore[player1.getPoint()] + "-"
				+ normalGameScore[player2.getPoint()];
	}
}
