package com.nerdium.WorldAtWar.economy;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.account.Account;
import org.spongepowered.api.service.economy.account.VirtualAccount;
import org.spongepowered.api.service.economy.transaction.TransactionResult;
import org.spongepowered.api.service.economy.transaction.TransferResult;
import org.spongepowered.api.text.Text;

import com.nerdium.WorldAtWar.WorldAtWar;

public class FactionPowerAccount implements VirtualAccount {

	private WorldAtWar waw;
	private AccountManager accountManager;
	private String identifier;
	
	public FactionPowerAccount(WorldAtWar waw, AccountManager accountManager, String identifier) {
		this.waw = waw;
		this.accountManager = accountManager;
		this.identifier = identifier;
	}
	
	@Override
	public Text getDisplayName() {
		return Text.of(identifier);
	}

	@Override
	public BigDecimal getDefaultBalance(Currency currency) {
		return ((Power) currency).getStartingBalance();
	}

	@Override
	public boolean hasBalance(Currency currency, Set<Context> contexts) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BigDecimal getBalance(Currency currency, Set<Context> contexts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Currency, BigDecimal> getBalances(Set<Context> contexts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionResult setBalance(Currency currency, BigDecimal amount, Cause cause, Set<Context> contexts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Currency, TransactionResult> resetBalances(Cause cause, Set<Context> contexts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionResult resetBalance(Currency currency, Cause cause, Set<Context> contexts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionResult deposit(Currency currency, BigDecimal amount, Cause cause, Set<Context> contexts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionResult withdraw(Currency currency, BigDecimal amount, Cause cause, Set<Context> contexts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferResult transfer(Account to, Currency currency, BigDecimal amount, Cause cause,
			Set<Context> contexts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public Set<Context> getActiveContexts() {
		// TODO Auto-generated method stub
		return null;
	}

}
