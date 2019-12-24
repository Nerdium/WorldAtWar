package com.nerdium.WorldAtWar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.dynmap.DynmapCommonAPI;
import org.dynmap.DynmapCommonAPIListener;
import org.dynmap.markers.AreaMarker;
import org.dynmap.markers.MarkerAPI;
import org.dynmap.markers.MarkerSet;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

import com.google.inject.Inject;
import com.nerdium.WorldAtWar.chunks.Chunk;
import com.nerdium.WorldAtWar.commands.ClaimCommand;
import com.nerdium.WorldAtWar.economy.AccountManager;

@Plugin(id = "worldatwar", name = "World At War", authors = "Nerdium", dependencies = {@Dependency(id = "dynmap")})
public class WorldAtWar {
	
	private DynmapCommonAPI m_DynmapApi = null;
    private MarkerAPI m_DynmapMarkerApi = null;
    private MarkerSet m_DynmapMarkerSet = null;
    public AccountManager accountManager = null;
    private ClaimCommand command = new ClaimCommand(this);
    private ArrayList<AreaMarker> claims = new ArrayList<AreaMarker>();
    @Inject Logger logger;

    private class DynmapAPIListener extends DynmapCommonAPIListener {
        @Override
        public void apiEnabled(DynmapCommonAPI api) {
            if (api != null)
            {
                m_DynmapApi = api;
                m_DynmapMarkerApi = m_DynmapApi.getMarkerAPI();

                createDynmapClaimMarkerLayer();
            }
        }
    }

    
	@Listener
	public void onGameInit(GameInitializationEvent event) {
		DynmapCommonAPIListener.register(new DynmapAPIListener());
		logger.info("Plugin init");
		accountManager = new AccountManager(this);
			
			Sponge.getCommandManager().register(this, command.base(), "waw");
	}


	public void createDynmapClaimMarkerLayer() {
		m_DynmapMarkerSet = m_DynmapMarkerApi.getMarkerSet("worldatwar.claims.markerset");
		
        if(m_DynmapMarkerSet == null)
            m_DynmapMarkerSet = m_DynmapMarkerApi.createMarkerSet("worldatwar.claims.markerset", "Claims", null, false);
        else
            m_DynmapMarkerSet.setMarkerSetLabel("test");
		
	}
	
	public void claimChunk() {
		claims.add(m_DynmapMarkerSet.createAreaMarker("worldatwarmarker" + claims.size(), "TestMarker" + claims.size(), true, Sponge.getServer().getDefaultWorldName(), new double[1000], new double[1000], false));
		int i = claims.size() - 1;
		logger.info(claims.get(i).getBottomY() + ", test");
		Chunk chunk = command.claimedChunk;
		double[] d1 = {chunk.getRealX(), chunk.getRealZ()};
        double[] d2 = {chunk.getRealX() + 16, chunk.getRealZ() + 16};
        claims.get(i).setCornerLocations(d1, d2);
        claims.get(i).setLabel("" + claims.size());
        claims.get(i).setDescription("" + claims.size());
	}
	
}