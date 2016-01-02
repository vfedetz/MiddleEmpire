import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Deck {
	
	// Deck Type Constants
	public final static int ATK = 0;
	public final static int DEF = 1;
	public final static int CON = 2;

	// Instance variables
    private Card[] deck; // contains all unused cards
    private Card[] discard; // contains all used cards
    private int cardsDrawn; // Keeps track of the number of cards that have been dealt from the deck so far.
    private final int type;
    private int x;
    private int y;
   
    /**
     * Constructor for Deck
     * creates a new shuffled deck of the given type
     * @param theType
     * @param xLoc
     * @param yLoc
     */
    public Deck(int theType, int xLoc, int yLoc) {
    	
    	if (theType != ATK && theType != DEF && theType != CON)
			throw new IllegalArgumentException("Illegal card type");
    	
    	switch (theType) {
    		
    		// ---- initializes the attack deck
	    	case Deck.ATK: 
	    		deck = new Card[20];
	            for ( int i = 0; i < 6; i++ ) {
	            	deck[i] = new Card(Card.ATK, Card.ATK_REMOVEROAD);	            	
	            }
	            for ( int j = 6; j < 18; j++ ) {
	            	deck[j] = new Card(Card.ATK, Card.ATK_OPPONENT);	            	
	            }
	            for ( int k = 18; k < 20; k++ ) {
	            	deck[k] = new Card(Card.ATK, Card.ATK_DOUBLE);	            	
	            }	           
	    		break; 
	    		
	    	// ---- initializes the defense deck
	    	case Deck.DEF: 
	    		//TODO
	    	
	    		break;
	    		
	    	// ---- initializes the construction deck
			case Deck.CON: 
				//TODO
				
				break;
    	}
    	
        this.shuffle();
        
        // set the deck location
        x = xLoc;	            
        y = yLoc;
        
        cardsDrawn = 0;
        type = theType;
    }

    // shuffle the given card list into a random order.
    public void shuffle() {
        for ( int i = deck.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsDrawn = 0;
    }

    /**
     * As cards are dealt from the deck, the number of cards left
     * decreases.  This function returns the number of cards that
     * are still left in the deck. It decreases by 1 each time the dealCard() method
     * is called.
     */
    public int cardsLeft() {
    	return deck.length - cardsDrawn;
    }
    
    public void printCardsRemaining() {
    	for (int i = cardsDrawn; i < deck.length; i++) {
    		System.out.println(deck[i].getTypeAsString());
    	}    
    }
    
    public void printCardsDrawn() {
    	for (int i = 0; i < cardsDrawn; i++) {
    		System.out.println(deck[i].getTypeAsString());
    	}    
    }

    /**
     * Removes the next card from the deck and return it.  It is illegal
     * to call this method if there are no more cards in the deck.  You can
     * check the number of cards remaining by calling the cardsLeft() function.
     * @return the card which is removed from the deck.
     * @throws IllegalStateException if there are no cards left in the deck
     */
    public Card dealCard() {
    	 if (cardsDrawn == deck.length) {
             throw new IllegalStateException("No cards are left in the deck.");
    	 }
         cardsDrawn++;
         System.out.println(deck[cardsDrawn - 1].getTypeAsString()); // DEBUG
         return deck[cardsDrawn - 1];
         // Programming note:  Cards are not literally removed from the array
         // that represents the deck.  We just keep track of how many cards
         // have been used.
    }
    
    public int getType() {
    	return type;
    }
    
    public int getX() {
    	return x;
    }
    
    public int getY() {
    	return y;
    }
    
    /**
     * Here we get the correct card back image based on this deck's type
	 * Note that we are not saving the image into an instance variable to save memory by only loading the image file when we need to draw it
     * @return
     */
    public Image getImage() {
    	String filename = "";
    	
    	switch (this.type) {
    		case (Deck.ATK):
    			filename = "cardBack.png";
    			break;
    		case (Deck.DEF):
    			filename = "cardBack.png";
    			break;
    		case (Deck.CON):
    			filename = "cardBack.png";
    			break;
    	}
        URL urlDeckImg = getClass().getResource("/img/" + filename);		
    	return new ImageIcon(urlDeckImg).getImage();
    }
    
    public int getWidth() {
    	return this.getImage().getWidth(null);
    }
    
    public int getHeight() {
    	return this.getImage().getHeight(null);
    }
}
