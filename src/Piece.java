import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Piece {
	
	public static final int COLOR_WHITE = 0;
	public static final int COLOR_BLACK = 1;
	public static final int COLOR_RED= 2;
	public static final int COLOR_GREEN = 3;

	public static final int TYPE_EMPIRE = 1;
	public static final int TYPE_ROAD = 2;
	public static final int TYPE_STRONGHOLD = 3;
	public static final int TYPE_WALL = 4;
	
	private int color;
	private int type;
	private int x;
	private int y;

	public Piece(int myColor, int myType, int myX, int myY) {
		this.color = myColor;
		this.type = myType;
		this.x = myX;
		this.y = myY;
	}
	
	/**
	 *  Loads the correct image for this piece
	 *  Note that we are not saving the image into an instance variable to save memory by only loading the image file when we need to draw it
	 * @return
	 */
	 public Image getImage() {		
		String filename = "";

		switch (this.type) {
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

		switch (this.color) {
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return this.getImage().getHeight(null);
	}

	public int getHeight() {
		return this.getImage().getHeight(null);
	}
	
	public int getColor() {
		return color;
	}
	
	public int getType() {
		return type;
	}

}
