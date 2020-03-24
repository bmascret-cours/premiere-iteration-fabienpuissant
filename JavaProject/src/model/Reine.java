package model;

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

}
