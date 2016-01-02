import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Space {
	
	// Space type Constants
	public final static int CITY = 0;
	public final static int PATHWAY = 1;
	
	// Space size Constanats
	public static final int SPACE_SIZE_X = 50;
	public static final int SPACE_SIZE_Y = 50;
	
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
	
	public Image getImage(){
		if (isEmpty()) {
			// this image represent an empty space
			URL urlEmptyImg = getClass().getResource("/img/empty.png");		
		    return new ImageIcon(urlEmptyImg).getImage(); 
		}
		else {
			return piece.getImage();
		}
	}
	
	public int getHeight() {
		return SPACE_SIZE_X;
	}
	
	public int getWidth() {
		return SPACE_SIZE_Y;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void printSpace() {
		String output = "I am a Space with x=" + x + " y=" + y + " type=" + type;
		if (this.isEmpty()) {
			output = output + " ... and I am currently empty";
		}
		else {
			output = output + " ... and I am currently filled with a " + piece.getColor() + " " + piece.getType() + " piece";
		}
		System.out.println(output);
	}
	
	public Space[] adjacentSpaces() {
		// TODO - look into java map data structure to use
		return null;
	}
	

} // end Space class
