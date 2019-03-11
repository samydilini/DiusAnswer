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
		players.put(player1, new Player());
		players.put(player2, new Player());
	}

	public void pointWonBy(String player) {
		players.get(player).addPoint();

	}
	
	public String score() {
		String scoreString="";
		return scoreString;
	}
}
