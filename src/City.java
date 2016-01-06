import java.util.ArrayList;

/**
 * This class models a city in a map. A label for this city is required. 
 * Note that the Map object only accepts one City per label,
 * so uniqueness of labels is important. This ctiy's neighborhood
 * is described by the Pathway incident to it. 
 *
 * @author Michael Levet, modified by Vincent Fedetz
 */
public class City {

    private ArrayList<Pathway> neighborhood;
    private String label;
    
    /**
     * 
     * @param label The unique label associated with this City
     */
    public City(String label){
        this.label = label;
        this.neighborhood = new ArrayList<Pathway>();
    }
    
    
    /**
     * This method adds an Pathway to the incidence neighborhood of this graph iff
     * the pathway is not already present. 
     * 
     * @param pathway The pathway to add
     */
    public void addNeighbor(Pathway pathway){
        if(this.neighborhood.contains(pathway)){
            return;
        }
        
        this.neighborhood.add(pathway);
    }
    
    
    /**
     * 
     * @param other The pathway for which to search
     * @return true iff other is contained in this.neighborhood
     */
    public boolean containsNeighbor(Pathway other){
        return this.neighborhood.contains(other);
    }
    
    /**
     * 
     * @param index The index of the Pathway to retrieve
     * @return Pathway The Pathway at the specified index in this.neighborhood
     */
    public Pathway getNeighbor(int index){
        return this.neighborhood.get(index);
    }
    
    
    /**
     * 
     * @param index The index of the pathway to remove from this.neighborhood
     * @return Pathway The removed Pathway
     */
    public Pathway removeNeighbor(int index){
        return this.neighborhood.remove(index);
    }
    
    /**
     * 
     * @param e The Pathway to remove from this.neighborhood
     */
    public void removeNeighbor(Pathway e){
        this.neighborhood.remove(e);
    }
    
    
    /**
     * 
     * @return int The number of neighbors of this City
     */
    public int getNeighborCount(){
        return this.neighborhood.size();
    }
    
    
    /**
     * 
     * @return String The label of this City
     */
    public String getLabel(){
        return this.label;
    }
    
    
    /**
     * 
     * @return String A String representation of this City
     */
    public String toString(){
        return "City: " + label;
    }
    
    /**
     * 
     * @return The hash code of this City's label
     */
    public int hashCode(){
        return this.label.hashCode();
    }
    
    /**
     * 
     * @param other The object to compare
     * @return true iff other instance of City and the two City objects have the same label
     */
    public boolean equals(Object other){
        if(!(other instanceof City)){
            return false;
        }
        
        City v = (City)other;
        return this.label.equals(v.label);
    }
    
    /**
     * 
     * @return ArrayList<Pathway> A copy of this.neighborhood. Modifying the returned
     * ArrayList will not affect the neighborhood of this City
     */
    public ArrayList<Pathway> getNeighbors(){
        return new ArrayList<Pathway>(this.neighborhood);
    }


    
}
