package model;

public class Cavalier extends AbstractPiece{

	public Cavalier(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Cavalier";
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int  yFinal) {
		if(Math.abs(xFinal - this.getX()) == 1 && Math.abs(yFinal - this.getY()) == 2 ||
				Math.abs(xFinal - this.getX()) == 2 && Math.abs(yFinal - this.getY()) == 1) {
			return true;
		}
		return false;
	}

}
