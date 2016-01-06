
public class Player {
	// Player Color constants
	public static final int COLOR_WHITE = 0;
	public static final int COLOR_BLACK = 1;
	public static final int COLOR_RED = 2;
	public static final int COLOR_GREEN = 3;
	
	// Instance variables
	private Hand hand;
	private int color;
	
	public Player(int myColor){
		color = myColor;
		hand = new Hand();
	}
	
	/**
	 * draw a card from a given deck and place it into your hand
	 * @param d
	 */
	public void drawCard(Deck d) {
		
	}
	
	/**
	 * use card in hand and then remove it from the hand, adding it to discard pile
	 * @param c
	 * @return
	 */
	public Card useCard(Card c) {
		return null;
	}
	
	/**
	 * places piece of the players color onto the game board
	 * @param p
	 * @param s
	 */
	public void placePiece(Piece p, Space s){
		return;
	}
	
}
