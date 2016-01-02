import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * all x and y coordinates point to the upper left position of a component all
 * lists are treated as 0 being the bottom and size-1 being the top piece
 * 
 */
public class BoardGui extends JPanel {

	private static final long serialVersionUID = 3114147670071466558L;

	// Board Constants
	private static final int BOARD_START_X = 301;
	private static final int BOARD_START_Y = 51;
	private static final int TILE_OFFSET_X = 50;
	private static final int TILE_OFFSET_Y = 50;

	// Instance variables
	private Image imgBackground;
	private List<Piece> pieces = new ArrayList<Piece>();
	private List<Deck> decks = new ArrayList<Deck>(); // should only ever be 3 decks
	private List<Space> spaces = new ArrayList<Space>();

	
	public BoardGui() {
		// load and set background image
		URL urlBackgroundImg = getClass().getResource("/img/board.png");
		this.imgBackground = new ImageIcon(urlBackgroundImg).getImage();

		// create and place decks
		createAndAddDeck(Deck.ATK, 0, 0);
		
		// create spaces
		createAndAddSpace(Space.CITY, BOARD_START_X + TILE_OFFSET_X * 0, BOARD_START_Y + TILE_OFFSET_Y * 0);
		createAndAddSpace(Space.CITY, BOARD_START_X + TILE_OFFSET_X * 1, BOARD_START_Y + TILE_OFFSET_Y * 1);
		createAndAddSpace(Space.CITY, BOARD_START_X + TILE_OFFSET_X * 2, BOARD_START_Y + TILE_OFFSET_Y * 2);
		createAndAddSpace(Space.CITY, BOARD_START_X + TILE_OFFSET_X * 3, BOARD_START_Y + TILE_OFFSET_Y * 3);
		
		// create and place pieces
		createAndAddPiece(Piece.COLOR_BLACK, Piece.TYPE_ROAD, BOARD_START_X + TILE_OFFSET_X * 0,
				BOARD_START_Y + TILE_OFFSET_Y * 0);
		createAndAddPiece(Piece.COLOR_WHITE, Piece.TYPE_EMPIRE, BOARD_START_X + TILE_OFFSET_X * 1,
				BOARD_START_Y + TILE_OFFSET_Y * 0);
		createAndAddPiece(Piece.COLOR_RED, Piece.TYPE_STRONGHOLD, BOARD_START_X + TILE_OFFSET_X * 2,
				BOARD_START_Y + TILE_OFFSET_Y * 0);
		createAndAddPiece(Piece.COLOR_GREEN, Piece.TYPE_WALL, BOARD_START_X + TILE_OFFSET_X * 3,
				BOARD_START_Y + TILE_OFFSET_Y * 0);

		// add mouse listeners to enable drag and drop
		PiecesDragAndDropListener listener = new PiecesDragAndDropListener(this.pieces, this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);

		// create application frame and set visible
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(this);
		f.setResizable(false);
		f.setSize(this.imgBackground.getWidth(null), this.imgBackground.getHeight(null));
	}

	/**
	 * create a game piece
	 * 
	 * @param color
	 *            color constant
	 * @param type
	 *            type constant
	 * @param x
	 *            x position of upper left corner
	 * @param y
	 *            y position of upper left corner
	 */
	private void createAndAddPiece(int color, int type, int x, int y) {
		
		Piece piece = new Piece(color, type, x, y);
		this.pieces.add(piece);
	}
	
	private void createAndAddDeck(int type, int x, int y) {
		Deck deck = new Deck(Deck.ATK, x, y);
		this.decks.add(deck);
	}
	
	private void createAndAddSpace(int type, int x, int y) {
		Space space = new Space(Space.CITY, x, y);
		this.spaces.add(space);
	}

	/**
	 * load image for given color and type. This method translates the color and
	 * type information into a filename and loads that particular file.
	 * 
	 * @param color
	 *            color constant
	 * @param type
	 *            type constant
	 * @return image
	 */
	

	
	@Override
	protected void paintComponent(Graphics g) {
		// draw background
		g.drawImage(this.imgBackground, 0, 0, null);
		
		// draw pieces
		for (Piece piece : this.pieces) {
			g.drawImage(piece.getImage(), piece.getX(), piece.getY(), null);
		}
		
		// draw decks
		for (Deck deck : this.decks) {
			g.drawImage(deck.getImage(), deck.getX(), deck.getY(), null);
		}
	}

	public static void main(String[] args) {
		/*
		// Testing on Console without GUI
		Deck d = new Deck(Deck.ATK,0,0);
		Hand h = new Hand();
		
		System.out.println("---card delt to hand");
		h.addCard(d.dealCard());
		System.out.println("---cards in hand");
		h.printHand();
		System.out.println("---cards drawn");
		d.printCardsDrawn();
		System.out.println("---cards remaining");
		d.printCardsRemaining();
		System.out.println("---play card in hand");
		h.removeCard(h.getCard(0));
		System.out.println("---discard pile");

		
		*/
		 
		// GUI Testing
		new BoardGui();
		
	}

}
