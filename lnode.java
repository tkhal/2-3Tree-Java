// Timothy Khal
// CS202 - Program #5

// Node class - Each cnode will contain a reference to the abstract base class 'vendor'

public class lnode {

    //private int array[] = new int[3]; // Each cnode will contain an array of size 3
    //private String vendorName = new String(); // Each cnode will contain
    private lnode next; // Each cnode will contain a reference to a next reference
    protected vendor data; // Each cnode will have a reference to abstract class 'vendor'

    public lnode(){ // Default constructor
        next = null;
    }


    public lnode getNext(){ // Returns next reference
        return next;
    }
    public void setNext(lnode next){ // Sets next reference
        this.next = next;
    }
    public void setData(vendor data){ // Setter for data
        this.data = data;
    }
    public vendor getData(){ // Getter for data
        return data;
    }
}
