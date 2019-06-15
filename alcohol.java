// Timothy Khal
// CS202 - Program #5
// Derived class for alcohol, used to hold ID field and constructor

public class alcohol extends vendor {

    protected int id; // If age of consumer is less than 21, they cannot purchase food

    public int getId() { // Getter for ID
        return id;
    }
    public void setId(int id) { // Setter for ID
        this.id = id;
    }

    public alcohol(String name, float cost, int id){
        super(name, cost);

        this.id = id;

        this.array[0] = new String("Beer");
        this.array[1] = new String("Mixed drinks");
        this.array[2] = new String("Shots");

    }



}
