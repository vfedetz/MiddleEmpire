import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class SpacesMouseClickListener implements MouseListener, MouseMotionListener {

	// Instance variables
	private List<Space> spaces;
	private BoardGui boardGui;	
	private Space selectedSpace = null; // contained the currently selected space
	

	public SpacesMouseClickListener(List<Space> spaces, BoardGui boardGui) {
		this.spaces = spaces;
		this.boardGui = boardGui;
	}

	@Override
	public void mousePressed(MouseEvent evt) {
		int x = evt.getPoint().x;
		int y = evt.getPoint().y;
		
		// find out which piece to move.
		for (int i = this.spaces.size()-1; i >= 0; i--) {
			
			Space space = this.spaces.get(i);
			
			if( mouseOverSpace(space,x,y) ){ 
				space.printSpace(); // DEBUG
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
			&& space.getX()+space.getWidth() >= x
			&& space.getY() <= y
			&& space.getY()+space.getHeight() >= y;
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
