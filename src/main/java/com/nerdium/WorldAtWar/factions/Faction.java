package com.nerdium.WorldAtWar.factions;

import java.util.ArrayList;
import java.util.UUID;

public class Faction {
	private ArrayList<UUID> players;
	private String name;
	
	public Faction(String name) {
		this.name = name;
		players = new ArrayList<UUID>();
	}
	
	public void addPlayer(UUID playerID) {
		players.add(playerID);
	}
	
	public boolean removePlayer(UUID playerID) {
		return players.remove(playerID);
	}
	
	public String getName() {
		return name;
	}
	
	public void rename(String name) {
		this.name = name;
	}
	
	public boolean containsPlayer(UUID playerID) {
		return players.contains(playerID);
	}
}
