package com.nerdium.WorldAtWar.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import com.nerdium.WorldAtWar.WorldAtWar;
import com.nerdium.WorldAtWar.chunks.Chunk;

public class ClaimCommand implements CommandExecutor {
	
	public Chunk claimedChunk = null;
	private WorldAtWar instance;
	
	public ClaimCommand(WorldAtWar waw) {
		instance = waw;
	}
	
	public CommandSpec base() {
		return CommandSpec.builder().permission("waw.command.base").executor(this).build();
	}

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		
		
if(src instanceof Player) {
			
			Player player = (Player) src;
			player.sendMessage(Text.of(TextColors.AQUA, TextStyles.BOLD, "Hello, " + player.getName()));
			Location<World> location = player.getLocation();
			player.sendMessage(Text.of(location.getBlockX() + ", " + location.getBlockZ()));
			player.sendMessage(Text.of((location.getBlockX()) + ", " + (location.getBlockZ())));
			player.sendMessage(Text.of((location.getBlockX() + 16) + ", " + (location.getBlockZ() + 16)));
			claimedChunk = new Chunk(location.getBlockX() >> 4, location.getBlockZ() >> 4, 0);
			instance.claimChunk();
			
		} else {
			src.sendMessage(Text.of(TextColors.RED, "Only the player can enter this command..."));
		}
		
		return CommandResult.success();
	}
}
