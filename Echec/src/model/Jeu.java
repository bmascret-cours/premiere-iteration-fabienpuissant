package model;
import java.util.LinkedList;
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
		//On vérifie s'il y a bien une pièce à l'emplacement
		Pieces piece = this.getPieceFromCoord(xInit, yInit);
		if(piece != null) {
			//On récupère la pièece est on regarde si le move correspond à ses caractéristiques
			if(piece.isMoveOK(xFinal, yFinal)) {
				//Verifier si le déplacement est possible en fonction des autres pièces
				if(isPieceHere(xFinal, yFinal)) {
					this.capture(xFinal, yFinal);
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		if(this.isMoveOK(xInit, yInit, xFinal, yFinal)) {
			Pieces piece = this.getPieceFromCoord(xInit, yInit);
			piece.setX(xFinal);
			piece.setY(yFinal);
			return true;
		}
		return false;
	}
	
	public void setPossibleCapture() {
		
	}
	
	public boolean capture(int xCatch, int yCatch) {
		Pieces piece = this.getPieceFromCoord(xCatch, yCatch);
		piece.setX(-1);
		piece.setY(-1);
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
		 PieceIHM newPieceIHM = null;
		 List<PieceIHM> list = new LinkedList<PieceIHM>();

		 for (Pieces piece : pieces){
			 boolean existe = false;
			 // si le type de piece existe déjà dans la liste de PieceIHM
			 // ajout des coordonnées de la pièce dans la liste de Coord de ce type
			 // si elle est toujours en jeu (x et y != -1)
			 for ( PieceIHM pieceIHM : list){
				 if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
					 existe = true;
					 if (piece.getX() != -1){
						 pieceIHM.add(new Coord(piece.getX(), piece.getY()));
					 }
					 
				 	}
				 }
			 
				 // sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
				 if (! existe) {
					 if (piece.getX() != -1){
					newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
					piece.getCouleur());
					 newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
					 list.add(newPieceIHM);
					 }
				 }
			 }
		 return list;
	}
	

	public boolean isPawnPromotion(int xFinal, int yFinal) {
		//Verifier coordonnées xFinal et yFinal
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
	
	//Modification par rapport à la doc : on retourne l'indice de la piece trouvée, si il n'y a pas de pièce, on retourne -1
	private Pieces getPieceFromCoord(int x, int y) {
		for (int i = 0; i < this.pieces.size(); i++) {
			if(pieces.get(i).getX() == x && pieces.get(i).getY() == y) {
				return this.pieces.get(i);
			}
		}
		return null;
		
	}
	
	public void setCastling() {
		//Boolean pour activer l'hypothèse d'un roque du roi
	}
	
	public void undoMove() {
		
	}
	
	public void undoCapture() {
		
	}
	
	
	
}
