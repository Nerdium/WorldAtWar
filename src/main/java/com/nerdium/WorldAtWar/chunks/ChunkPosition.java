package com.nerdium.WorldAtWar.chunks;

public class ChunkPosition {
	public final int x;
	public final int z;
	public final int dim;
	
	public ChunkPosition(int x, int z, int dim){
		this.x = x;
		this.z = z;
		this.dim = dim;
	}
	
	/**
     * @return Return the real X position of the chunk in blocks
     */
	
	public int getRealX() {
		return (this.x << 4);
	}
	
	/**
     * @return Return the real Z position of the chunk in blocks
     */
	
	public int getRealZ() {
		return (this.z << 4);
	}
	
	/**
     * Compares the object to this object
     * @param obj The object to compare this object too
     * @return Returns true if the object is the same type and the contents match.
     */

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } else {
            return obj instanceof ChunkPosition && this.equals((ChunkPosition) obj);
        }
    }

    /**
     * Compares another ChunkPosition with this one.
     * @param pos The other ChunkPosition to compare against
     * @return Returns true if the Chunk is in the same position and dimension.
     */

    private boolean equals(ChunkPosition pos) {
        if (pos == null) {
            return false;
        } else {
            return x == pos.x && z == pos.z && dim == pos.dim;
        }
    }

	
}
