import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class MouseClickListener implements MouseListener, MouseMotionListener {

	// Instance variables
	private List<Space> spaces;
	private List<Deck> decks;
	private BoardGui boardGui;
	private Space selectedSpace = null; // contained the currently selected space
	

	public MouseClickListener(List<Space> spaces, List<Deck> decks, BoardGui boardGui) {
		this.spaces = spaces;
		this.boardGui = boardGui;
		this.decks = decks;
	}

	@Override
	public void mousePressed(MouseEvent evt) {
		int x = evt.getPoint().x;
		int y = evt.getPoint().y;
		
		// Check if a Space was clicked
		for (Space space : this.spaces) {			
			if( mouseOverSpace(space,x,y) ){ 
				this.spaceClicked(space, x, y);
				break;
			}			
		}			
		
		// Check if Deck was clicked
		for (Deck deck : this.decks) {
			if ( mouseOverDeck(deck,x,y)) {
				deckClicked(deck, x, y);
				break;
			}
		}

	}

	/**
	 * check whether the mouse is currently over this space
	 * @param space the current space
	 * @param x x coordinate of mouse
	 * @param y y coordinate of mouse
	 * @return true if mouse is over the space
	 */
	private boolean mouseOverSpace(Space space, int x, int y) {
		return space.getX() <= x 
			&& space.getX() + space.getWidth() >= x
			&& space.getY() <= y
			&& space.getY() + space.getHeight() >= y;
	}
	
	/**
	 * check whether the mouse is currently over this deck
	 * @param deck the current deck
	 * @param x x coordinate of mouse
	 * @param y y coordinate of mouse
	 * @return true if mouse is over the deck
	 */
	private boolean mouseOverDeck(Deck deck, int x, int y) {
		return deck.getX() <= x 
			&& deck.getX() + deck.getWidth() >= x
			&& deck.getY() <= y
			&& deck.getY() + deck.getHeight() >= y;
	}
	
	/**
	 * this method is called only when a space has been clicked
	 * it will determine the appropriate action... moving, placing, or removing a piece.
	 * @param space
	 * @param x
	 * @param y
	 */
	private void spaceClicked(Space space, int x, int y) {
		if (selectedSpace != null && !selectedSpace.isEmpty() && selectedSpace != space) { 
			// if user has previously selected a filled space, move the piece
			space.addPiece(selectedSpace.getPiece());
			selectedSpace.removePiece();
			selectedSpace = null;
			this.boardGui.repaint();
		}
		else { 
			// else we mark this space as currently selected
			selectedSpace = space;
			
		}
	}
	
	/**
	 * this method is called only when a deck has been clicked
	 * it will draw a card into the player's hand
	 * @param deck
	 * @param x
	 * @param y
	 */
	public void deckClicked(Deck deck, int x, int y) {
		deck.dealCard();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		return;
	}

	@Override
	public void mouseDragged(MouseEvent evt) {
	
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}
	
	@Override
	public void mouseMoved(MouseEvent arg0) {}

}
