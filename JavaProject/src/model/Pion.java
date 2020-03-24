package model;

public class Pion extends AbstractPiece{

	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Pion";
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		//TODO Gérer le premier déplacement (2cases possibles) et le fait de manger des piéces (deplacement diagonal)
		if(xFinal == this.getX() + 1  || yFinal == this.getY() + 1 ) {
			return true;
		}
		return false;
	}
}
