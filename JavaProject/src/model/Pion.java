package model;

import java.util.ArrayList;
import java.util.List;

public class Pion extends AbstractPiece{

	private int xInit = this.getX();
	private int yInit = this.getY();
	
	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Pion"; 
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		//TODO G�rer le premier d�placement (2cases possibles) et le fait de manger des pi�ces (deplacement diagonal)
		//D�placement rectiligne
		if(this.getX() == this.xInit && this.getY() == this.yInit) {
			if(this.getCouleur() == Couleur.BLANC && yFinal - this.getY() == -1
					|| this.getCouleur() == Couleur.BLANC && yFinal - this.getY() == -2) {
				return true;
			}
			else if (this.getCouleur() == Couleur.NOIR && yFinal - this.getY() == 1
					|| this.getCouleur() == Couleur.NOIR && yFinal - this.getY() == 2) {
				return true;
			}
			
		}
		
		//D�placement diagonal actif si jamais il y a un pion � manger
		else if(this.getCouleur() == Couleur.BLANC && yFinal - this.getY() ==  -1 && Math.abs(xFinal - this.getX()) == 1 ) {
			return true;
		}
		else if (this.getCouleur() == Couleur.NOIR && yFinal - this.getY() == 1 && Math.abs(xFinal - this.getX()) == 1) {
			return true;
		}
	
		else if(this.getCouleur() == Couleur.BLANC && yFinal - this.getY() ==  -1) {
			return true;
		}
		else if (this.getCouleur() == Couleur.NOIR && yFinal - this.getY() == 1) {
			return true;
		}
	
		return false;
		
		
	}
	
	public static boolean moveCapture(int xInit, int yInit,int xFinal, int yFinal, Couleur couleur) {
		//D�placement diagonal actif si jamais il y a un pion � manger
		if(couleur == Couleur.BLANC && yFinal - yInit ==  -1 && Math.abs(xFinal - xInit) == 1 ) {
			return true;
		}
		else if (couleur == Couleur.NOIR && yFinal - yInit == 1 && Math.abs(xFinal - xInit) == 1) {
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
