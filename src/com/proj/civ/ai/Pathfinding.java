package com.proj.civ.ai;

import java.util.List;
import java.util.Map;

import com.proj.civ.datastruct.Hex;

public class Pathfinding {
	AStar ap;
	
	public Pathfinding() {
		ap = new AStar();
	}
	
	public List<Hex> findPath(Map<Integer, Hex> map, Hex from, Hex to) {
		return ap.aStar(map, from, to);	
	}
}
