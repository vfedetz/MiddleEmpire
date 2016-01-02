
public class Space {
	
	// Space type Constants
	public final static int CITY = 0;
	public final static int PATHWAY = 1;	
	
	// Instance variables
	private int type; // the type of space ie "city" or "pathway"
	private Piece piece = null; // the piece located in this space
	private int x; // x coord
	private int y; // y coord

	/**
	 * Constructor for Space
	 */
	public Space(int type, int x, int y) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	/**
	 * returns true if empty and false if filled
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (piece == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * returns the color of the piece occupying this space
	 * @return int
	 */
	public int colorOccupied() {
		return piece.getColor();		
	}
	
	/**
	 * this will assign the given piece to this space
	 * @param p
	 */
	public void addPiece(Piece p) {
		this.piece = p;
	}
	
	/**
	 * this will set the piece occupying this space to null
	 */
	public void removePiece() {
		this.piece = null;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Space[] adjacentSpaces() {
		// TODO - look into java map data structure to use
		return null;
	}
	

} // end Space class
