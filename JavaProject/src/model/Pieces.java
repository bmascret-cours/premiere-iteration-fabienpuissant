package model;

public interface Pieces {
	
	int getX();
	int getY();
	
	void setX(int x);
	void setY(int y);
	
	Couleur getCouleur();
	
	boolean isMoveOK(int xFinal, int yFinal);
	
	boolean move(int xFinal, int yFinal);
	
	boolean capture();

}
