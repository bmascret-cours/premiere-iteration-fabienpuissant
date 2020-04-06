package model;

import java.util.ArrayList;
import java.util.List;

public class Roi extends AbstractPiece {

	public Roi(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Roi";
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		if(Math.abs(this.getX() - xFinal) <= 1 &&
				Math.abs(this.getY() - yFinal) <= 1) {
			return true;
		}
		return false;
	}
	
	public static List<Coord> getTrajectoire(int xInit, int yInit, int xFinal, int yFinal){
		List<Coord> trajectoire = new ArrayList<Coord>();
		trajectoire.add(new Coord(xFinal, yFinal));
		return trajectoire;
	}

}
