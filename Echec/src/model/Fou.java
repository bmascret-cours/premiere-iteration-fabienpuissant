package model;

import java.util.ArrayList;
import java.util.List;

public class Fou extends AbstractPiece{

	public Fou(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Fou";
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		if(Math.abs(this.getX()-xFinal) == Math.abs(this.getY()-yFinal)) {
			return true;
		}
		return false;
	}
	
	public static List<Coord> getTrajectoire(int xInit, int yInit, int xFinal, int yFinal){
		List<Coord> trajectoire = new ArrayList<Coord>();

		if(xFinal > xInit && yFinal < yInit) {
			for(int i = 1; i <= Math.abs(xInit - xFinal); i++) {
				trajectoire.add(new Coord(xInit + i, yInit - i));
			}
		}
		//Déplacement diagonale bas droit
		else if(xFinal > xInit && yFinal > yInit) {
			for(int i = 1; i <= Math.abs(xInit - xFinal); i++) {
				trajectoire.add(new Coord(xInit + i, yInit + i));
			}
		}
		//Déplacement diagonale haut gauche
		else if(xFinal < xInit && yFinal < yInit) {
			for(int i = 1; i <= Math.abs(xInit - xFinal); i++) {
				trajectoire.add(new Coord(xInit - i, yInit - i));
			}
		}
		//Déplacement diagonale bas gauche
		else if(xFinal < xInit && yFinal > yInit) {
			for(int i = 1; i <= Math.abs(xInit - xFinal); i++) {
				trajectoire.add(new Coord(xInit - i, yInit + i));
			}
		}
	
		return trajectoire;
	}

}
