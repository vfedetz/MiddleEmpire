import java.util.*;


/**
 * This class models a simple, undirected graph using an 
 * incidence list representation. Vertices are identified 
 * uniquely by their labels, and only unique vertices are allowed.
 * At most one Edge per vertex pair is allowed in this Graph.
 * 
 * Note that the Graph is designed to manage the Edges. You
 * should not attempt to manually add Edges yourself.
 * 
 * Note that logically: cities = vertices, pathways = edges, and map=graph
 * 
 * @author Michael Levet, modified by Vincent Fedetz
 */

public class Map {
    
    private HashMap<String, City> cities;
    private HashMap<Integer, Pathway> pathways;
    
    public Map(){
        this.cities = new HashMap<String, City>();
        this.pathways = new HashMap<Integer, Pathway>();
    }
    
    /**
     * This constructor accepts an ArrayList<City> and populates
     * this.cities. If multiple City objects have the same label,
     * then the last City with the given label is used. 
     * 
     * @param cities The initial Cities to populate this Graph
     */
    public Map(ArrayList<City> cities){
        this.cities = new HashMap<String, City>();
        this.pathways = new HashMap<Integer, Pathway>();
        
        for(City c: cities){
            this.cities.put(c.getLabel(), c);
        }
        
    }
    
    
    
    /**
     * Accepts two cities and a weight, and adds the pathway 
     * ({one, two}) iff no Pathway relating one and two 
     * exists in the Map.
     * 
     * @param one The first City of the Pathway
     * @param two The second City of the Pathway
     * @return true iff no Pathway already exists in the Map
     */
    public boolean addPathway(City one, City two){
        if(one.equals(two)){
            return false; // a Pathway cannot connect a City to itself
        }
       
        //ensures the Pathway is not in the Map
        Pathway p = new Pathway(one, two);
        if(pathways.containsKey(p.hashCode())){
            return false;
        }
       
        //and that the Edge isn't already incident to one of the vertices
        else if(one.containsNeighbor(p) || two.containsNeighbor(p)){
            return false;
        }
            
        pathways.put(p.hashCode(), p);
        one.addNeighbor(p);
        two.addNeighbor(p);
        return true;
    }
    
    /**
     * 
     * @param p The Pathway to look up
     * @return true iff this Map contains the Pathway p
     */
    public boolean containsPathway(Pathway p){
        if(p.getOne() == null || p.getTwo() == null){
            return false;
        }
        
        return this.pathways.containsKey(p.hashCode());
    }
    
    
    /**
     * This method removes the specified Pathway from the Map,
     * including as each cities's incidence neighborhood.
     * 
     * @param p The Pathway to remove from the Map
     * @return Pathway The Pathway removed from the Map
     */
    public Pathway removePathway(Pathway p){
       p.getOne().removeNeighbor(p);
       p.getTwo().removeNeighbor(p);
       return this.pathways.remove(p.hashCode());
    }
    
    /**
     * 
     * @param city The City to look up
     * @return true iff this Map contains vertex
     */
    public boolean containsCity(City city){
        return this.cities.get(city.getLabel()) != null;
    }
    
    /**
     * 
     * @param label The specified City label
     * @return City The City with the specified label
     */
    public City getCity(String label){
        return cities.get(label);
    }
    
    /**
     * This method adds a City to the map. If a City with the same label
     * as the parameter exists in the Map, the existing City is overwritten
     * only if overwriteExisting is true. If the existing City is overwritten,
     * the Pathways incident to it are all removed from the Graph.
     * 
     * @param city
     * @param overwriteExisting
     * @return true iff city was added to the Map
     */
    public boolean addCity(City city, boolean overwriteExisting){
        City current = this.cities.get(city.getLabel());
        if(current != null){
            if(!overwriteExisting){
                return false;
            }
            
            while(current.getNeighborCount() > 0){
                this.removePathway(current.getNeighbor(0));
            }
        }        
        
        cities.put(city.getLabel(), city);
        return true;
    }
    
    /**
     * 
     * @param label The label of the City to remove
     * @return City The removed City object
     */
    public City removeCity(String label){
        City c = cities.remove(label);
        
        while(c.getNeighborCount() > 0){
            this.removePathway(c.getNeighbor((0)));
        }
        
        return c;
    }
    
    /**
     * 
     * @return Set<String> The unique labels of the Map's City objects
     */
    public Set<String> cityKeys(){
        return this.cities.keySet();
    }
    
    /**
     * 
     * @return Set<Pathway> The Pathways of this graph
     */
    public Set<Pathway> getPathways(){
        return new HashSet<Pathway>(this.pathways.values());
    }
    
    /**
     * Print this map to console to view text version
     */
    public void printMap(){
    	System.out.println("+++ Printing Text Version of Map ++++");
    	
    	for (String label: cities.keySet()){
    		System.out.println(label);
    		
    		for (int i=0; i<cities.get(label).getNeighborCount(); i++){
    			System.out.println("--Pathways: " + cities.get(label).getNeighbor(i).toString());
    		}
		}
	}
    
}
