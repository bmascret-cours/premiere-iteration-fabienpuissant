package model;
import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	private List<Pieces> pieces = null;
	private Couleur couleur;
	
	public Jeu(Couleur couleur) {
		this.pieces = ChessPiecesFactory.newPieces(couleur);
		this.couleur = couleur;
	}
	
	public List<Pieces> getPieces() {
		return this.pieces;
	}
	
	public boolean isPieceHere(int x, int y) {
		for (int i = 0; i < this.pieces.size(); i++) {
			if(pieces.get(i).getX() == x && pieces.get(i).getY() == y) {
				return true;
			}
		}
		return false;
		
	}
	
	public boolean isMoveOK(int xInit, int yInit, int xFinal, int yFinal) {
		//On v�rifie s'il y a bien une pi�ce � l'emplacement
		Pieces piece = this.getPieceFromCoord(xInit, yInit);
		if(piece != null) {
			//On r�cup�re la pi�ece est on regarde si le move correspond � ses caract�ristiques
			if(piece.isMoveOK(xFinal, yFinal)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		if(this.isMoveOK(xInit, yInit, xFinal, yFinal)) {
			Pieces piece = this.getPieceFromCoord(xInit, yInit);;
			piece.setX(xFinal);
			piece.setY(yFinal);
			
			return true;
		}
		return false;
	}
	
	public void setPossibleCapture() {
		
	}
	
	public boolean capture(int xCatch, int yCatch) {
		return true;
	}
	
	public Couleur getPieceColor(int x, int y) {
		return this.getPieceFromCoord(x, y).getCouleur();
	}
	
	public java.lang.String getPieceType(int x, int y) {
		return this.getPieceFromCoord(x, y).getClass().getSimpleName();
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	public java.util.List<PieceIHM> getPiecesIHM() {
		return null;
	}
	

	public boolean isPawnPromotion(int xFinal, int yFinal) {
		if(this.getPieceType(xFinal, yFinal) == "Pion") {
			return true;
		}
		return false;
	}
	
	public boolean pawnPromotion(int xFinal, int yFinal, java.lang.String type) {
		if(this.isPawnPromotion(xFinal, yFinal)) {
			Pieces piece = this.getPieceFromCoord(xFinal, yFinal);
			piece = null;
			//TODO Creer une piece avec le bon type
			return true;
		}
		return false;
	}
	
	public Coord getKingCoord() {
		Coord coord = new Coord(0, 0);
		for(int i = 0; i < this.pieces.size(); i++) {
			if(this.pieces.get(i).getClass().getSimpleName() == "Roi") {
				coord.x = this.pieces.get(i).getX();
				coord.y = this.pieces.get(i).getY();
				
			}
		}
		return coord;
	}
	
	@Override
	public String toString() {
		return this.pieces.toString();
	}
	
	//Modification par rapport � la doc : on retourne l'indice de la piece trouv�e, si il n'y a pas de pi�ce, on retourne -1
	private Pieces getPieceFromCoord(int x, int y) {
		for (int i = 0; i < this.pieces.size(); i++) {
			if(pieces.get(i).getX() == x && pieces.get(i).getY() == y) {
				return this.pieces.get(i);
			}
		}
		return null;
		
	}
	
	public void setCastling() {
		//Boolean pour activer l'hypoth�se d'un roque du roi
	}
	
	public void undoMove() {
		
	}
	
	public void undoCapture() {
		
	}
	
	
	
}
