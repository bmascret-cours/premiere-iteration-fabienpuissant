package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Echiquier implements BoardGames {
	
	private String message;
	
	private Jeu JeuBlanc;
	
	private Jeu JeuNoir;
	
	private Jeu JeuCourant;
	
	private Jeu JeuNonCourant;
	
	public Echiquier() {
		this.JeuBlanc = new Jeu(Couleur.BLANC);
		this.JeuNoir = new Jeu(Couleur.NOIR);
		this.JeuCourant = this.JeuNoir;
		this.JeuNonCourant = this.JeuNoir;
	}
	
	public void switchJoueur() {
		if(this.JeuCourant == this.JeuBlanc) {
			this.JeuCourant = this.JeuNoir;
			this.JeuNonCourant = this.JeuBlanc;
		}
		else {
			this.JeuCourant = this.JeuBlanc;
			this.JeuNonCourant = this.JeuNoir;
		}
	}
	
	public java.util.List<PieceIHM> getPiecesIHM(){
		List<PieceIHM> list = new ArrayList<PieceIHM>();
		List<PieceIHM> blacklist  = this.JeuBlanc.getPiecesIHM();
		List<PieceIHM> whitelist = this.JeuNoir.getPiecesIHM();
		
		for(PieceIHM piece : blacklist) {
			list.add(piece);
		}
		
		for(PieceIHM piece: whitelist) {
			if(!list.contains(piece)) {
				list.add(piece);
			}
		}
		
		return list;
	}
	
	public boolean isMoveOK(int xInit, int yInit, int xFinal, int yFinal) {
		//Test s'il y a bien une pièce au coordonnées initiales
		if(!this.isPieceHere(xInit, yInit)) {
			return false;
		}
		//test si les coordonnées finales sont valides

		if(xFinal == xInit && yFinal == yInit) {
			return false;
		}

		//Test s'il n'y a pas une pièce sur la trajectoire
		if(this.getPieceType(xInit, yInit).equals("Pion")) {
			if(!checkPion(xInit, yInit, xFinal, yFinal)) {
				return false;
			}
		}
		else {
			List<Coord> pieces = this.getTrajectoire(this.getPieceType(xInit, yInit), xInit, yInit, xFinal, yFinal);
			if(!this.checkTrajectoire(pieces, xInit, yInit)) {
				//Si il a rencontré une pièce sur son chemin, on vérifie si la piece est de son jeu
				return this.checkCapture(pieces, xInit, yInit);
			}
		}
		return this.JeuCourant.isMoveOK(xInit, yInit, xFinal, yFinal);
	}


	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		return this.JeuCourant.move(xInit, yInit, xFinal, yFinal);
	}

	@Override
	public boolean isEnd() {
		Coord kingCoord = this.JeuNonCourant.getKingCoord();
		System.out.println(kingCoord.toString());
		for (Pieces piece: this.JeuCourant.getPieces()) {
			if(piece.isMoveOK(kingCoord.x, kingCoord.y)) {
				System.out.println(piece.toString());
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}
	
	private void setMessage(String message) {
		this.message = message;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return this.JeuCourant.getCouleur();
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		return this.JeuCourant.getPieceColor(x, y);
	}
	
	@Override
	public String toString() {
		return "Jeu 1 : " + this.JeuBlanc.toString() + "\nJeu 2 : " + this.JeuNoir.toString();
	}
	
	private boolean isPieceHere(int x, int y) {
		return this.JeuCourant.isPieceHere(x, y);
	}
	
	private String getPieceType(int x, int y) {
		return this.JeuCourant.getPieceType(x, y);
	}
	
	private boolean checkTrajectoire(List<Coord> pieces, int xInit, int yInit) {
		for(Coord piece: pieces) {
			if(this.JeuBlanc.isPieceHere(piece.x, piece.y) || this.JeuNoir.isPieceHere(piece.x, piece.y)) {
				if(!(piece.x == xInit && piece.y == yInit)) {
					return false;
				}
				
			}
		}
		return true;
	}
	
	
	private boolean checkPion(int xInit, int yInit, int xFinal, int yFinal) {
		//Gestion de la capture
		if(Pion.moveCapture(xInit, yInit, xFinal, yFinal, this.JeuCourant.getCouleur())) {
			if(this.JeuNonCourant.isPieceHere(xFinal, yFinal)) {
					this.JeuNonCourant.capture(xFinal, yFinal);
					return true;
			}
			return false;
		}
		//Si il n'y a pas de pièce devant lui il peut bouger
		else if (this.JeuBlanc.getPieceFromCoord(xFinal, yFinal) != null
				|| this.JeuNoir.getPieceFromCoord(xFinal, yFinal) != null) {
			return false;
		}
		
		return true;
	}
	
	//Vérifie la trajectoire renvoie false si jamais il y a un pion dans la trajectoire
	private List<Coord> getTrajectoire(String pieceType, int xInit, int yInit, int xFinal, int yFinal) {
		List<Coord> pieces = new ArrayList<Coord>();
		if(pieceType.equals("Tour")) {
			pieces = Tour.getTrajectoire(xInit, yInit, xFinal, yFinal);
		}
		else if(pieceType.equals("Roi")) {
			pieces = Roi.getTrajectoire(xInit, yInit, xFinal, yFinal);
		}
		else if(pieceType.equals("Reine")) {
			pieces = Reine.getTrajectoire(xInit, yInit, xFinal, yFinal);
		}
		else if(pieceType.equals("Fou")) {
			pieces = Fou.getTrajectoire(xInit, yInit, xFinal, yFinal);
		}
		else if(pieceType.equals("Cavalier")) {
			pieces = Cavalier.getTrajectoire(xInit, yInit, xFinal, yFinal);
		}

	

		return pieces;
	}
	
	private boolean checkCapture(List<Coord> pieces, int xInit, int yInit) {
		Coord pieceFound = null;
		for(Coord piece: pieces) {
			if(!(piece.x == xInit && piece.y == yInit)) {
	
				//Si c'est sa pièce on ne fait rien
				if(this.JeuCourant.isPieceHere(piece.x, piece.y)) {
					return false;
				}
				//Si c'est la pièce de quelqu'un d'autre on capture
				if(this.JeuNonCourant.isPieceHere(piece.x, piece.y)) {
					return this.JeuNonCourant.capture(piece.x, piece.y);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		
		Echiquier echiquier = new Echiquier();
		
		echiquier.switchJoueur();
		echiquier.move(3, 6, 3, 5);
		System.out.println(echiquier.toString());
		
		System.out.println(echiquier.getPiecesIHM());
	}


}


	
	
