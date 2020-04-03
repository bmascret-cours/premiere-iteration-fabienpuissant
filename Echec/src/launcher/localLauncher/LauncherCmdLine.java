package launcher.localLauncher;

import java.util.Observer;

import model.observable.ChessGame;
import vue.ChessGameCmdLine;
import controller.controlerLocal.ChessGameController;


/**
 * @author francoise.perrin
 * Lance l'exécution d'un jeu d'échec en mode console.
 */
public class LauncherCmdLine {
	
	public static void main(String[] args) {		
		
		ChessGame model;
		ChessGameController controller;	
		ChessGameCmdLine vue;
		
		model = new ChessGame();	
		controller = new ChessGameController(model);
		
		new ChessGameCmdLine(controller);	
		
		vue = new ChessGameCmdLine(controller);
		model.addObserver((Observer) vue);
		vue.go();
	}

}
