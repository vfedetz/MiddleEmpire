import java.awt.Image;

public class Piece {
	
	public static final int COLOR_WHITE = 0;
	public static final int COLOR_BLACK = 1;
	public static final int COLOR_RED= 2;
	public static final int COLOR_GREEN = 3;

	public static final int TYPE_EMPIRE = 1;
	public static final int TYPE_ROAD = 2;
	public static final int TYPE_STRONGHOLD = 3;
	public static final int TYPE_WALL = 4;
	
	private Image img;
	private int x;
	private int y;

	public Piece(Image img, int x, int y) {
		this.img = img;
		this.x = x;
		this.y = y;
	}

	public Image getImage() {
		return img;
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
		return img.getHeight(null);
	}

	public int getHeight() {
		return img.getHeight(null);
	}

}
