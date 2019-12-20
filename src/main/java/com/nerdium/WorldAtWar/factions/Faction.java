package com.nerdium.WorldAtWar.factions;

import java.util.ArrayList;
import java.util.UUID;

import com.nerdium.WorldAtWar.WorldAtWar;
import com.nerdium.WorldAtWar.economy.AccountManager;
import com.nerdium.WorldAtWar.economy.FactionPowerAccount;

public class Faction {
	private ArrayList<UUID> players;
	private String name;
	private FactionPowerAccount factionPower;
	
	public Faction(String name, WorldAtWar waw, AccountManager accountManager) {
		this.name = name;
		players = new ArrayList<UUID>();
		factionPower = new FactionPowerAccount(waw, accountManager, name);
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
