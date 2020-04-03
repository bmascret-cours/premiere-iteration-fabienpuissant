package model;

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

}
