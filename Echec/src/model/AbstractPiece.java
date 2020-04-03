package model;

public class AbstractPiece implements Pieces {

	protected String name;
	private Couleur couleur;
	private Coord coord;
	
	public AbstractPiece(Couleur couleur, Coord coord) {
		this.couleur = couleur;
		this.coord = coord;
	}
	
	public void setX(int x) {
		this.coord.x = x;
	}
	
	public void setY(int y) {
		this.coord.y = y;
	}
	
	public int getX() {
		return this.coord.x;
	}
	
	public int getY() {
		return this.coord.y;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	public boolean move(int x, int y) {
		if(this.isMoveOK(x, y)) {
			
			return true;
		}
		return false;
		
	}
	
	public boolean capture() {
		return true;
	}
	
	
	public String toString() {
		return this.name + " X : " + this.getX() + " Y : " + this.getY();
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public static void main(String[] args){
		
		Roi roi = new Roi(Couleur.BLANC, new Coord(4,4));
		//System.out.println(roi.isMoveOK(4, 3));
		
		Jeu jeu = new Jeu(Couleur.BLANC);
		System.out.println(jeu.getPieces());
		System.out.println(jeu.move(0, 7, 0, 5));
	
		
	}

	
	
}
