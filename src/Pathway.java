/**
 * This class models an undirected Edge in the Graph implementation.
 * An Edge contains two vertices and a weight. If no weight is
 * specified, the default is a weight of 1. This is so traversing
 * edges is assumed to be of greater distance or cost than staying
 * at the given vertex.
 * 
 * This class also deviates from the expectations of the Comparable interface
 * in that a return value of 0 does not indicate that this.equals(other). The
 * equals() method only compares the vertices, while the compareTo() method 
 * compares the edge weights. This provides more efficient implementation for
 * checking uniqueness of edges, as well as the fact that two edges of equal weight
 * should be considered equitably in a pathfinding or spanning tree algorithm.
 * 
 * @author Michael Levet, modified by Vincent Fedetz
 */
public class Pathway{

    private City one, two;
    
    /**
     * 
     * @param one The first city in the Pathway
     * @param two The second city in the Pathway
     */
    public Pathway(City one, City two){
        this.one = (one.getLabel().compareTo(two.getLabel()) <= 0) ? one : two;
        this.two = (this.one == one) ? two : one;
    }  
    
    /**
     * 
     * @param current
     * @return The neighbor of current along this Pathway
     */
    public City getNeighbor(City current){
        if(!(current.equals(one) || current.equals(two))){
            return null;
        }
        
        return (current.equals(one)) ? two : one;
    }
    
    /**
     * 
     * @return City this.one
     */
    public City getOne(){
        return this.one;
    }
    
    /**
     * 
     * @return City this.two
     */
    public City getTwo(){
        return this.two;
    }
    
    /**
     * 
     * @return String A String representation of this Pathway
     */
    public String toString(){
        return "({" + one + ", " + two + "})";
    }
    
    /**
     * 
     * @return int The hash code for this Pathway 
     */
    public int hashCode(){
        return (one.getLabel() + two.getLabel()).hashCode(); 
    }
    
    /**
     * 
     * @param other The Object to compare against this
     * @return ture iff other is an Pathway with the same Cities as this
     */
    public boolean equals(Object other){
        if(!(other instanceof Pathway)){
            return false;
        }
        
        Pathway p = (Pathway)other;
        
        return p.one.equals(this.one) && p.two.equals(this.two);
    }

  
}
