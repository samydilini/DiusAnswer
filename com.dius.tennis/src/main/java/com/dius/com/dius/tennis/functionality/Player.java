package com.dius.com.dius.tennis.functionality;

public class Player {
	private int point;

	private int gameCount;
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	public String getName() {
		return name;
	}

	public Player(String name) {
		this.name = name;
	}

	public void addPoint() {
		point++;
	}

	public int getPoint() {
		return point;
	}

	public int getGameCount() {
		return gameCount;
	}

	public void incremetGameCount() {
		gameCount++;

	}
}
