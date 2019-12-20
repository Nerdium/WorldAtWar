package com.nerdium.WorldAtWar.economy;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.spongepowered.api.service.context.ContextCalculator;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.EconomyService;
import org.spongepowered.api.service.economy.account.Account;
import org.spongepowered.api.service.economy.account.UniqueAccount;

import com.nerdium.WorldAtWar.WorldAtWar;

public class AccountManager implements EconomyService {

	WorldAtWar waw;
	
	public AccountManager(WorldAtWar waw) {
		this.waw = waw;
	}
	
	@Override
	public void registerContextCalculator(ContextCalculator<Account> calculator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Currency getDefaultCurrency() {
		return waw.getPowerCurrency();
	}

	@Override
	public Set<Currency> getCurrencies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasAccount(UUID uuid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasAccount(String identifier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<UniqueAccount> getOrCreateAccount(UUID uuid) {
		WawAccount acc = new WawAccount();
		return Optional.of(acc);
	}

	@Override
	public Optional<Account> getOrCreateAccount(String identifier) {
		// TODO Auto-generated method stub
		return null;
	}

}
