package com.nerdium.WorldAtWar.economy;

import java.math.BigDecimal;

import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.text.Text;

public class Power implements Currency {
	
	private Text singular;
    private Text plural;
    private Text symbol;
    private int numFractionDigits;
    private boolean isDefault;
    private boolean prefixSymbol;
    private boolean isTransferable;
    private BigDecimal startingBalance;
	
    public Power() {
        singular = Text.of("Power");
        plural = Text.of("Power");
        symbol = Text.of("¤");
        prefixSymbol = true;
        isDefault = false;
        numFractionDigits = 1;
        isTransferable = false;
        startingBalance = BigDecimal.ZERO;
    }
    
	@Override
	public String getId() {
		return "worldatwar:" + singular.toPlain().toLowerCase();
	}

	@Override
	public String getName() {
		return singular.toPlain();
	}

	@Override
	public Text getDisplayName() {
		return singular;
	}

	@Override
	public Text getPluralDisplayName() {
		return plural;
	}

	@Override
	public Text getSymbol() {
		return symbol;
	}

	@Override
	public Text format(BigDecimal amount, int numFractionDigits) {
		if(prefixSymbol) {
			return Text.of(symbol, amount.setScale(numFractionDigits, BigDecimal.ROUND_HALF_UP));
		} else {
			return Text.of(amount.setScale(numFractionDigits, BigDecimal.ROUND_HALF_UP), symbol);
		}
	}

	@Override
	public int getDefaultFractionDigits() {
		return numFractionDigits;
	}

	@Override
	public boolean isDefault() {
		return isDefault;
	}

	public boolean isTransferable() {
		return isTransferable;
	}

	public BigDecimal getStartingBalance() {
		return startingBalance;
	}

}
