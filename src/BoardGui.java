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

	private static final int BOARD_START_X = 301;
	private static final int BOARD_START_Y = 51;

	private static final int TILE_OFFSET_X = 50;
	private static final int TILE_OFFSET_Y = 50;

	private Image imgBackground;
	private List<Piece> pieces = new ArrayList<Piece>(); // 0 = bottom, size-1 = top
	private List<Deck> decks = new ArrayList<Deck>(); // should only ever be 3 decks

	
	public BoardGui() {
		// load and set background image
		URL urlBackgroundImg = getClass().getResource("/img/board.png");
		this.imgBackground = new ImageIcon(urlBackgroundImg).getImage();

		// create and place decks
		createAndAddDeck(Deck.ATK, 0, 0);
		
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
		//
		PiecesDragAndDropListener listener = new PiecesDragAndDropListener(this.pieces, this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);

		// create application frame and set visible
		//
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
		Image img = this.getImageForPiece(color, type);
		Piece piece = new Piece(img, x, y);
		this.pieces.add(piece);
	}
	
	private void createAndAddDeck(int type, int x, int y) {
		Deck deck = new Deck(Deck.ATK, x, y);
		this.decks.add(deck);
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
	private Image getImageForPiece(int color, int type) {
		String filename = "";

		switch (type) {
		case Piece.TYPE_EMPIRE:
			filename += "e";
			break;
		case Piece.TYPE_ROAD:
			filename += "r";
			break;
		case Piece.TYPE_STRONGHOLD:
			filename += "s";
			break;
		case Piece.TYPE_WALL:
			filename += "w";
			break;
		}

		switch (color) {
		case Piece.COLOR_WHITE:
			filename += "w";
			break;
		case Piece.COLOR_BLACK:
			filename += "b";
			break;
		case Piece.COLOR_RED:
			filename += "r";
			break;
		case Piece.COLOR_GREEN:
			filename += "g";
			break;
		}

		filename += ".png";

		URL urlPieceImg = getClass().getResource("/img/" + filename);
		return new ImageIcon(urlPieceImg).getImage();
	}

	private Image getImageForCard(int type, int subType) {
		String filename = "";

		switch (type) {
		case Card.ATK:
			filename += "ATK_";
			break;
		case Card.DEF:
			filename += "DEF_";
			break;
		case Card.CON:
			filename += "CON_";
			break;
		}

		switch (subType) {
		case Card.ATK_DOUBLE:
			filename += "ad";
			break;
		case Card.ATK_OPPONENT:
			filename += "ao";
			break;
		case Card.ATK_REMOVEROAD:
			filename += "rr";
			break;
		case Card.CON_BUILDANYSTR:
			filename += "bas";
			break;
		case Card.CON_UPGRADESTR:
			filename += "us";
			break;
		case Card.CON_BUILDSTR_ETHIOPIA:
			filename += "bs_eth";
			break;
		case Card.DEF_BUILDROAD:
			filename += "br";
			break;
		case Card.DEF_BUILDWALL:
			filename += "bw";
			break;
		case Card.DEF_DEFEND:
			filename += "da";
			break;
		case Card.DEF_PICK2:
			filename += "p2";
			break;
		}

		filename += ".png";

		URL urlCardImg = getClass().getResource("/img/" + filename);
		return new ImageIcon(urlCardImg).getImage();
	}

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
		Deck d = new Deck(Deck.ATK);
		Hand h = new Hand();
		
		System.out.println("---card delt");
		h.addCard(d.dealCard());
		System.out.println("---cards in hand");
		h.printHand();
		System.out.println("---cards discarded");
		d.printCardsDiscarded();
		System.out.println("---cards remaining");
		d.printCardsRemaining();
		*/
		
		 
		// GUI Testing
		new BoardGui();
		
	}

}
