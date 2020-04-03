package model;

import java.util.LinkedList;
import java.util.List;

public class Echiquier implements BoardGames {
	
	private String message;
	
	private Jeu JeuBlanc;
	
	private Jeu JeuNoir;
	
	private Jeu JeuCourant;
	
	public Echiquier() {
		this.JeuBlanc = new Jeu(Couleur.BLANC);
		this.JeuNoir = new Jeu(Couleur.NOIR);
		this.JeuCourant = this.JeuNoir;
	}
	
	public void switchJoueur() {
		if(this.JeuCourant == this.JeuBlanc) {
			this.JeuCourant = this.JeuNoir;
		}
		else {
			this.JeuCourant = this.JeuBlanc;
		}
	}
	
	public java.util.List<PieceIHM> getPiecesIHM(){
		List<PieceIHM> list = new LinkedList<PieceIHM>();
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
		return this.JeuCourant.isMoveOK(xInit, yInit, xFinal, yFinal);
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		return this.JeuCourant.move(xInit, yInit, xFinal, yFinal);
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
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
	
	public static void main(String[] args){
		
		Echiquier echiquier = new Echiquier();
		
		echiquier.switchJoueur();
		echiquier.move(3, 6, 3, 5);
		System.out.println(echiquier.toString());
		
		System.out.println(echiquier.getPiecesIHM());
	}


}


	
	
