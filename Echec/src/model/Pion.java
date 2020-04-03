package model;

public class Pion extends AbstractPiece{

	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.name = "Pion";
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		//TODO G�rer le premier d�placement (2cases possibles) et le fait de manger des pi�ces (deplacement diagonal)
		if(Math.abs(yFinal - this.getY()) == 1 ) {
			return true;
		}
		return false;
	}
}
