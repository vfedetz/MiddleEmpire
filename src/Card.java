import java.awt.Image;

/**
 * An object of type Card represents a playing card from a standard Poker deck,
 * including Jokers. The card has a suit, which can be spades, hearts, diamonds,
 * clubs, or joker. A spade, heart, diamond, or club has one of the 13 values:
 * ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, or king. Note that "ace" is
 * considered to be the smallest value. A joker can also have an associated
 * value; this value can be anything and can be used to keep track of several
 * different jokers.
 */
public class Card {

	// Card Types
	public final static int ATK = 0;
	public final static int DEF = 1;
	public final static int CON = 2;

	// Attack Cards
	public final static int ATK_OPPONENT = 10;
	public final static int ATK_DOUBLE = 11;
	public final static int ATK_REMOVEROAD = 12;

	// Defense Cards
	public final static int DEF_BUILDROAD = 20;
	public final static int DEF_BUILDWALL = 21;
	public final static int DEF_DEFEND = 22;
	public final static int DEF_PICK2 = 23;

	// Construction Cards
	public final static int CON_BUILDANYSTR = 30;
	public final static int CON_UPGRADESTR = 31;
	public final static int CON_BUILDSTR_ETHIOPIA = 32;

	// instance variables
	private final int type;
	private final int subType;
	private Image img;

	/**
	 * Creates a card with a specified type.
	 * 
	 * @throws IllegalArgumentException
	 *             if the parameter values are not in the permissible ranges
	 */
	public Card(int theType, int theSubType) {
		if (theType != ATK && theType != DEF && theType != CON)
			throw new IllegalArgumentException("Illegal card type");
		if (theSubType != ATK_OPPONENT && theSubType != ATK_DOUBLE && theSubType != ATK_REMOVEROAD
				&& theSubType != DEF_BUILDROAD && theSubType != DEF_BUILDWALL && theSubType != DEF_DEFEND
				&& theSubType != DEF_PICK2 && theSubType != CON_BUILDANYSTR && theSubType != CON_UPGRADESTR
				&& theSubType != CON_BUILDSTR_ETHIOPIA)
			throw new IllegalArgumentException("Illegal card subType");
		subType = theSubType;
		type = theType;
	}

	public int getType() {
		return type;
	}
	
	public int getSubType() {
		return subType;
	}

	public String getTypeAsString() {
		switch (subType) {
		case ATK_OPPONENT:
			return "Attack an Opponent";
		case ATK_DOUBLE:
			return "Double Attack";
		case ATK_REMOVEROAD:
			return "Remove Road";
		case DEF_BUILDROAD:
			return "Build a Road";
		case DEF_BUILDWALL:
			return "City Wall";
		case DEF_DEFEND:
			return "Defend Against Attack";
		case DEF_PICK2:
			return "Pick 2 More Cards";
		case CON_BUILDANYSTR:
			return "Build Any Stronghold";
		case CON_UPGRADESTR:
			return "Upgrade Any Stronghold";
		case CON_BUILDSTR_ETHIOPIA:
			return "Build a Stronghold: Ethiopia";
		default:
			return "Error";
		}
	}

	public String toString() {
		return getTypeAsString();
	}

	public Image getImage() {
		return img;
	}

} // end class Card