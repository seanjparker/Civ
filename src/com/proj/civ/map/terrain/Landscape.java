package com.proj.civ.map.terrain;

import java.awt.Color;

/**
 * Enum that contains the data on the base yields for the landscape
 * Parameters:
 * FOOD - PRODUCTION - SCIENCE - GOLD
 */
public enum Landscape {
	COAST (1, 0, 0, 1, new Color(90, 123, 168), "Coast"),
	DESERT (0, 0, 0, 0, new Color(239, 239, 155), "Desert"),
	GRASSLAND (2, 0, 0, 0, new Color(152, 196, 64), "Grassland"),
	LAKE (1, 0, 0, 1, new Color(131, 197, 219), "Lake"),
	OCEAN (1, 0, 0, 0, new Color(36, 36, 127), "Ocean"),
	PLAINS (1, 1, 0, 0, new Color(226, 217, 131), "Plains"),
	TUNDRA (1, 0, 0, 0, new Color(128, 128, 128), "Tundra"),
	SNOW (0, 0, 0, 0, new Color(242, 242, 234), "Snow");
	
	private final int food;
	private final int production;
	private final int science;
	private final int gold;
	private final Color colour;
	private final String name;
	
	Landscape(int food, int production, int science, int gold, Color colour, String name) {
		this.food = food;
		this.production = production;
		this.science = science;
		this.gold = gold;
		this.colour = colour;
		this.name = name;
	}
	
	public int getFoodYield() {
		return this.food;
	}
	public int getProductionYield() {
		return this.production;		
	}
	public int getScienceYield() {
		return this.science;		
	}
	public int getGoldYield() {
		return this.gold;		
	}
	public Color getColour() {		
		return this.colour;
	}
	public String getName() {
		return this.name;
	}
}
