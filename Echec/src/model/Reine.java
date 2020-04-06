package model;

import java.util.ArrayList;
import java.util.List;

public class Reine extends AbstractPiece {

	public Reine(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Reine";
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		if(Math.abs(this.getX()-xFinal) == Math.abs(this.getY()-yFinal) ||
			this.getX() == xFinal ||
			this.getY() ==yFinal) {
			return true;
		}
		return false;
	}
	
	
	
	public static List<Coord> getTrajectoire(int xInit, int yInit, int xFinal, int yFinal){
		List<Coord> trajectoire = new ArrayList<Coord>();
		//Déplacement ligne horizontal
		if(xInit != xFinal && yFinal == yInit) {
			int miniX = Math.min(xInit, xFinal);
			int maxiX = Math.max(xInit, xFinal);
			for(int i = miniX; i <= maxiX; i++) {
				trajectoire.add(new Coord(i, yFinal));
			}
		}
		//Déplacement ligne vertical
		else if (yInit != yFinal && xFinal == xInit) {
			int miniY = Math.min(yInit, yFinal);
			int maxiY = Math.max(yInit, yFinal);
			for(int i = miniY; i <= maxiY; i++) {
				trajectoire.add(new Coord(xInit, i));
			}
		}
		//Déplacement en diagonale
		else if (xInit != xFinal && yFinal != yInit) {
			//Déplacement diagonale haut droit
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
		}
		return trajectoire;
	}

}
