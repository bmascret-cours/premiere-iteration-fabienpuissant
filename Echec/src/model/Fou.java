package model;

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

}
