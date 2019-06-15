// Timothy Khal
// CS202 - Program #5
// Abstract base class, used to hold common fields that all derived classes have

import java.util.Arrays;

public abstract class vendor { // Abstract class of vendor
    protected String name; // Name of vendor
    protected String array[]; // Each vendor will have an array of vendor types
    protected float cost;

    public vendor(){ // Default constructor
        name = new String();
        array = new String[3]; // Each vendor will contain an array of x vendor types
    }

    public vendor(String name, float cost){ // Name constructor
        this.name = name;
        this.cost = cost;
        array = new String[3];
    }

    public vendor(String name, String array[]){ // Constructor to allocate memory for vendor fields
        this.name = new String(name);
        this.array = new String[array.length];
        System.arraycopy(array, 0, this.array, 0, this.array.length); // Is this correct for copying arrays?
    }

    public void setName(String vendorName){ // Setter for name
        this.name = vendorName;
    }

    public String getName(){ // Getter for name
        return name;
    }

    public void setCost(float cost){
        this.cost = cost;
    }

    public float getcost(){
        return cost;
    }

}




