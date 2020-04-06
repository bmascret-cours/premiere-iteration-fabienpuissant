package model;

import java.util.ArrayList;
import java.util.List;

public class Tour extends AbstractPiece{
	
	public Tour(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
		this.name = "Tour";
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		if((this.getX() == xFinal && this.getY() != yFinal)
				|| (this.getY() == yFinal && this.getX() != xFinal)) {
			return true;
		}
		return false;
	}
	
	public static List<Coord> getTrajectoire(int xInit, int yInit, int xFinal, int yFinal){
		List<Coord> trajectoire = new ArrayList<Coord>();
		
		if(xInit != xFinal) {
			int miniX = Math.min(xInit, xFinal);
			int maxiX = Math.max(xInit, xFinal);
			for(int i = miniX; i <= maxiX; i++) {
				trajectoire.add(new Coord(i, yFinal));
			}
		}
		else if (yInit != yFinal) {
			int miniY = Math.min(yInit, yFinal);
			int maxiY = Math.max(yInit, yFinal);
			for(int i = miniY; i <= maxiY; i++) {
				trajectoire.add(new Coord(xInit, i));
			}
		}
		return trajectoire;
	}
	
}
