package com.nerdium.WorldAtWar.economy;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.account.UniqueAccount;
import org.spongepowered.api.service.economy.transaction.TransactionResult;
import org.spongepowered.api.service.economy.transaction.TransferResult;
import org.spongepowered.api.text.Text;

public class WawAccount implements UniqueAccount {

	public WawAccount() {
		
	}
	
	@Override
	public Text getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getDefaultBalance(Currency currency) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasBalance(Currency currency, Set<Context> contexts) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BigDecimal getBalance(Currency currency, Set<Context> contexts) {
		return BigDecimal.TEN;
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
	public TransferResult transfer(org.spongepowered.api.service.economy.account.Account to, Currency currency,
			BigDecimal amount, Cause cause, Set<Context> contexts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Context> getActiveContexts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getUniqueId() {
		// TODO Auto-generated method stub
		return null;
	}

}
