package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controller.ChessGameControllers;
import controller.controlerLocal.ChessGameController;
import model.Coord;
import model.Couleur;
import model.PieceIHM;
import model.observable.ChessGame;
import tools.ChessImageProvider;
import tools.ChessPiecePos;

public class ChessGameGUI extends javax.swing.JFrame implements java.awt.event.MouseMotionListener, java.awt.event.MouseListener, java.util.Observer{

	private JPanel chessBoard = new JPanel();
	private ChessGameControllers chessGameController;
	private int rows = 8;
	private int column = 8;
	
	
	
	public ChessGameGUI(java.lang.String name, ChessGameControllers chessGameController, java.awt.Dimension boardSize) {
	
		this.chessGameController = chessGameController;
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);
		  
		layeredPane.add(this.chessBoard, JLayeredPane.DEFAULT_LAYER);
		this.chessBoard.setLayout( new GridLayout(8, 8) );
		this.chessBoard.setPreferredSize( boardSize );
		this.chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		
		for (int i = 0; i < this.rows * this.column; i++) {
		  JPanel square = new JPanel( new BorderLayout() );
		  chessBoard.add( square );
		 
		  int row = (i / this.column) % 2;
		  if (row == 0)
		  square.setBackground( i % 2 == 0 ? Color.black : Color.white );
		  else
		  square.setBackground( i % 2 == 0 ? Color.white :  Color.black );
		}
		
		
		String pieceName;
		Coord pieceCoord;
		Couleur pieceColor;
		for (int i = 0; i < ChessPiecePos.values().length; i++) {
			pieceName = ChessPiecePos.values()[i].nom;
			pieceColor = ChessPiecePos.values()[i].couleur;
			for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
				pieceCoord = ChessPiecePos.values()[i].coords[j];
				this.displayPiece(pieceName, pieceColor, pieceCoord);
			}
			
		}
	
	}
	
	private void displayPiece(String pieceImage, Couleur color, Coord coord) {
		String pathImg = ChessImageProvider.getImageFile(pieceImage, color);
		JLabel piece = new JLabel(new ImageIcon(pathImg));
		JPanel panel = (JPanel)this.chessBoard.getComponent(this.getComponentFromXY(coord.x, coord.y));
		panel.add(piece);
	}
	

	private int getComponentFromXY(int x, int y) {
		return this.rows * y + x;
	}
	
	
	private Coord getCoordFromClick(int x, int y) {
		return new Coord(x/(700/8), y/(700/8));
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println();
		Coord point = getCoordFromClick(e.getX(), e.getY());
		this.chessGameController.move(new Coord(0,0), new Coord(point.x, point.y));
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
