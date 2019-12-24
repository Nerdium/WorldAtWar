/*package com.nerdium.WorldAtWar;

import java.math.BigDecimal;
import java.util.Optional;

import org.dynmap.markers.AreaMarker;
import org.dynmap.markers.MarkerAPI;
import org.dynmap.markers.MarkerSet;
import org.spongepowered.api.Sponge;
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
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import com.nerdium.WorldAtWar.chunks.Chunk;
import com.nerdium.WorldAtWar.chunks.ChunkPosition;
import com.nerdium.WorldAtWar.economy.AccountManager;

public class SendMessage implements CommandExecutor {

	
	private WorldAtWar  waw;
	
	public SendMessage(WorldAtWar waw) {
		this.waw = waw;
	}

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {

		if(src instanceof Player) {
			
			Player player = (Player) src;
			Optional<UniqueAccount> uOpt = waw.accountManager.getOrCreateAccount(player.getUniqueId());
	        UniqueAccount acc = uOpt.get();
	        BigDecimal balance = acc.getBalance(waw.accountManager.getDefaultCurrency());
			player.sendMessage(Text.of(TextColors.AQUA, TextStyles.BOLD, "Hello, " + player.getName() + ": " + balance));
			Location<World> location = player.getLocation();
			player.sendMessage(Text.of(location.getBlockX() + ", " + location.getBlockZ()));
			player.sendMessage(Text.of((location.getBlockX() >> 4) + ", " + (location.getBlockZ() >> 4)));
			Chunk claimedChunk = new Chunk(location.getBlockX() >> 4, location.getBlockZ() >> 4, 0);
			waw.claimedChunks.put(location.getBlockX() + ", " + location.getBlockZ(), claimedChunk);
			waw.claimChunk(location.getBlockX() + ", " + location.getBlockZ());
			
		} else {
			src.sendMessage(Text.of(TextColors.RED, "Only the player can enter this command..."));
		}
		
		
		return CommandResult.success();
	}

}
*/