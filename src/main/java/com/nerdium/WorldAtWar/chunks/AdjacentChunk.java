package com.nerdium.WorldAtWar.chunks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdjacentChunk extends ChunkPosition {
	
	private AdjacentChunk top = null;
	private AdjacentChunk bottom = null;
	private AdjacentChunk left = null;
	private AdjacentChunk right = null;
	
	public AdjacentChunk(ChunkPosition pos) {
		super(pos.x, pos.x, pos.dim);
	}
	
	public ChunkPosition getPos() {
		return (ChunkPosition) this;
	}
	
	void processAdjacentChunks(Set<ChunkPosition> availableChunks, Map<ChunkPosition, AdjacentChunk> processedChunks) {
		ChunkPosition[] adjacentPos = { new ChunkPosition(x, z - 1, dim),
                new ChunkPosition(x, z + 1, dim),
                new ChunkPosition(x - 1, z, dim),
                new ChunkPosition(x + 1, z, dim)
		};

		AdjacentChunk[] adjacentChunks = { null, null, null, null };
		
		for (int index = 0; index < 4; index++) {
			 if (availableChunks.contains(adjacentPos[index])) {
	            	
				 availableChunks.remove(adjacentPos[index]);
	             adjacentChunks[index] = new AdjacentChunk(adjacentPos[index]);
	             processedChunks.put(adjacentPos[index], adjacentChunks[index]);
	             adjacentChunks[index].processAdjacentChunks(availableChunks, processedChunks);
	            
			 } else {
	                adjacentChunks[index] = processedChunks.get(adjacentPos[index]);
	                
	         }
		}

		top = adjacentChunks[0];
	    bottom = adjacentChunks[1];
	    left = adjacentChunks[2];
	    right = adjacentChunks[3];

	}

	List<ChunkEdge> getOpenChunkEdges() {
        List<ChunkEdge> edges = new ArrayList<>();

        if (top == null) {
            edges.add(new ChunkEdge(this, ChunkEdge.Edge.TOP));
        }

        if (bottom == null) {
            edges.add(new ChunkEdge(this, ChunkEdge.Edge.BOTTOM));
        }

        if (left == null) {
            edges.add(new ChunkEdge(this, ChunkEdge.Edge.LEFT));
        }

        if (right == null) {
            edges.add(new ChunkEdge(this, ChunkEdge.Edge.RIGHT));
        }

        return edges;
    }

	
} 
