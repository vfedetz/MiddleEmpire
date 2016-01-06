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
	
	// Color Constants
	public static final int COLOR_WHITE = 0;
	public static final int COLOR_BLACK = 1;
	public static final int COLOR_RED = 2;
	public static final int COLOR_GREEN = 3;

	// Piece Type Constants
	public static final int TYPE_EMPIRE = 1;
	public static final int TYPE_ROAD = 2;
	public static final int TYPE_STRONGHOLD = 3;
	public static final int TYPE_WALL = 4;

	// Board Constants
	private static final int BOARD_START_X = 301;
	private static final int BOARD_START_Y = 51;

	// Instance variables
	private Image imgBackground;
	private List<Deck> decks = new ArrayList<Deck>(); // should only ever be 3 decks
	private List<Space> spaces = new ArrayList<Space>();
	private List<Player> players = new ArrayList<Player>();

	/**
	 * Constructor for the BoardGui class
	 * This will load and place the background image, the spaces, pieces, and decks... as well as initialize all the input listeners and JPanels etc
	 */
	public BoardGui() {
		// load and set background image
		URL urlBackgroundImg = getClass().getResource("/img/board.png");
		this.imgBackground = new ImageIcon(urlBackgroundImg).getImage();

		// ----
		
		// create Players
		createAndAddPlayer(Player.COLOR_BLACK);
		
		// ----
		
		// ----
				
		// create and place decks
		createAndAddDeck(Deck.ATK, 0, 0);
		
		// ----
		
		// create spaces
		// creating a 4 x 4 grid of cities for developing ONLY. Eventually these spaces must map to the cities/pathways on the background image
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				createAndAddSpace(Space.CITY, BOARD_START_X + Space.SPACE_SIZE_X * x, BOARD_START_Y + Space.SPACE_SIZE_Y * y);				
			}
		}

		// ----
		
		// create and place pieces
		createAndAddPiece(COLOR_BLACK, TYPE_ROAD, spaces.get(0));

		// ----

		// add mouse listeners to enable drag and drop
		MouseClickListener listener = new MouseClickListener(this.spaces, this.decks, this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		
		// ----

		// create application frame and set visible
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(this);
		f.setResizable(false);
		f.setSize(this.imgBackground.getWidth(null), this.imgBackground.getHeight(null));
	}

	private void createAndAddPiece(int color, int type, Space space) {
		Piece piece = new Piece(color, type, space);
		space.addPiece(piece);
	}
	
	private void createAndAddDeck(int type, int x, int y) {
		Deck deck = new Deck(Deck.ATK, x, y);
		this.decks.add(deck);
	}
	
	private void createAndAddSpace(int type, int x, int y) {
		Space space = new Space(Space.CITY, x, y);
		this.spaces.add(space);
	}
	
	private void createAndAddPlayer(int color) {
		Player p = new Player(color);
	}
	
	public void printSpaces() {
		for (Space space : this.spaces) {
			space.printSpace();
		}
	}
	


	
	@Override
	protected void paintComponent(Graphics g) {
		// draw background
		g.drawImage(this.imgBackground, 0, 0, null);
		
		// draw spaces
		for (Space space : this.spaces) {
			g.drawImage(space.getImage(), space.getX(), space.getY(), null);
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
		BoardGui b = new BoardGui();
		b.printSpaces();
	}

}
