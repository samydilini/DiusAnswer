package com.dius.com.dius.tennis.functionality;

/**
 * The Class Player.
 */
public class Player {
	
	/** The point. */
	private int point;

	/** The game count. */
	private int gameCount;
	
	/** The name. */
	private String name;

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the point.
	 *
	 * @param point the new point
	 */
	public void setPoint(int point) {
		this.point = point;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Instantiates a new player.
	 *
	 * @param name the name
	 */
	public Player(String name) {
		this.name = name;
	}

	/**
	 * Adds the point.
	 */
	public void addPoint() {
		point++;
	}

	/**
	 * Gets the point.
	 *
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * Gets the game count.
	 *
	 * @return the game count
	 */
	public int getGameCount() {
		return gameCount;
	}

	/**
	 * Incremet game count.
	 */
	public void incremetGameCount() {
		gameCount++;

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [point=" + point + ", gameCount=" + gameCount
				+ ", name=" + name + "]";
	}
	
}
