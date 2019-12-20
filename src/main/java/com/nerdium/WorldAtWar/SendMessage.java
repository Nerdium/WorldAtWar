package com.nerdium.WorldAtWar;

import java.math.BigDecimal;
import java.util.Optional;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.economy.account.UniqueAccount;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import com.nerdium.WorldAtWar.economy.AccountManager;

public class SendMessage implements CommandExecutor {

	AccountManager accountManager;
	
	public SendMessage(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {

		if(src instanceof Player) {
			
			Player player = (Player) src;
			Optional<UniqueAccount> uOpt = accountManager.getOrCreateAccount(player.getUniqueId());
	        UniqueAccount acc = uOpt.get();
	        BigDecimal balance = acc.getBalance(accountManager.getDefaultCurrency());
			player.sendMessage(Text.of(TextColors.AQUA, TextStyles.BOLD, "Hello, " + player.getName() + ": " + balance));
			
		} else {
			src.sendMessage(Text.of(TextColors.RED, "Only the player can enter this command..."));
		}
		
		
		return CommandResult.success();
	}

}
