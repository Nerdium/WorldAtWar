package com.nerdium.WorldAtWar.chunks;

public class ChunkEdge {
	
	public enum Edge {
		TOP, BOTTOM, LEFT, RIGHT
	}
	
	private static final int CHUNK_SIZE = 16;
	private Edge type;
	private Point p1 = new Point();
	private Point p2 = new Point();
	
	public ChunkEdge(AdjacentChunk chunk, Edge edge) {
		if(chunk != null & edge != null) {
			int xPos = chunk.getRealX();
			int zPos = chunk.getRealZ();
			type = edge;
			
			switch(edge) {
			case TOP:
				p1.setPos(xPos, zPos);
				p2.setPos(xPos + CHUNK_SIZE, zPos);
				break;
				
			case BOTTOM:
				p1.setPos(xPos + CHUNK_SIZE, zPos + CHUNK_SIZE);
				p2.setPos(xPos, zPos + CHUNK_SIZE);
				break;
				
			case LEFT:
				p1.setPos(xPos, zPos + CHUNK_SIZE);
				p2.setPos(xPos, zPos);
				break;
				
			case RIGHT:
				p1.setPos(xPos + CHUNK_SIZE, zPos);
				p2.setPos(xPos + CHUNK_SIZE, zPos + CHUNK_SIZE);
				break;
			}
		}
	}
	
	public Edge edgeType() {
		return type;
	}
	
	public Point point1() {
		return p1;
	}
	
	public Point point2() {
		return p2;
	}
	
}
