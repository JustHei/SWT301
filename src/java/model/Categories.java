package model;

/**
 *
 * @author havie
 */
public class Categories {
    private int ID;
    private String name;

    // Constructors
    public Categories() {
    }
    
    

    public Categories(String name) {
        this.name = name;
    }

    public Categories(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    
    

    // Getters and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Categories{" + " ID=" + ID + ", name=" + name  + '}';
    }


 
}
