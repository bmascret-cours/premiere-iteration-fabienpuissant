package model;

public class Pion extends AbstractPiece{

	private int xInit = this.getX();
	private int yInit = this.getY();
	
	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Pion";
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		//TODO Gérer le premier déplacement (2cases possibles) et le fait de manger des piéces (deplacement diagonal)
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
		else {
			if(this.getCouleur() == Couleur.BLANC && yFinal - this.getY() ==  -1) {
				return true;
			}
			else if (this.getCouleur() == Couleur.NOIR && yFinal - this.getY() == 1) {
				return true;
			}
		}
		return false;
	}
}
