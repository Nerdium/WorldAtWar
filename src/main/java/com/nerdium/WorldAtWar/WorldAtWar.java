package com.nerdium.WorldAtWar;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.EconomyService;
import org.spongepowered.api.service.economy.account.UniqueAccount;

import com.google.inject.Inject;
import com.nerdium.WorldAtWar.economy.AccountManager;
import com.nerdium.WorldAtWar.economy.Power;

@Plugin(id = "worldatwar", name = "World At War", authors = "Nerdium")
public class WorldAtWar {

	private AccountManager accountManager;
	private Power power;
	public static WorldAtWar instance;
	
	@Inject
	Logger logger;
	
	@Listener
	public void onGameInit(GameInitializationEvent event) {
		
		instance = this;
	
		accountManager = new AccountManager(this);
		
		logger.info("GameInit for this plugin has started");
		
		CommandSpec command = CommandSpec.builder()
			.permission("worldatwar.command.base")
			.description(Text.of("This command is the base command"))
			.executor(new SendMessage(accountManager))
			.build();
		
		Sponge.getCommandManager().register(instance, command, "waw");
		
	}
	
	@Listener
    public void onPlayerJoin(ClientConnectionEvent.Join event) {
        Player player = event.getTargetEntity();
        Optional<UniqueAccount> uOpt = accountManager.getOrCreateAccount(player.getUniqueId());
        UniqueAccount acc = uOpt.get();
        BigDecimal balance = acc.getBalance(accountManager.getDefaultCurrency());
    }

	public Currency getPowerCurrency() {
		return power;
	}
}
