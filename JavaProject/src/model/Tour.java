package model;

public class Tour extends AbstractPiece{
	
	public Tour(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
		this.name = "Tour";
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		if(this.getX() == xFinal || this.getY() == yFinal) {
			return true;
		}
		return false;
	}
	
}
