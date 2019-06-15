// Timothy Khal
// CS202 - Program #5
// Derived class for food, used to hold constructors and initialize arrays

public class food extends vendor {

    public food(){ // Default constructor
        super(); // When a food object is instantiated, parent constructor is invoked
        this.array[0] = new String("Hamburger");
        this.array[1] = new String("Hotdog");
        this.array[2] = new String("Corndog");
        cost = 0;
    }

    public food(String name, float cost){ // Constructor for name & cost
        super(name, cost);

        this.array[0] = new String("Hamburger");
        this.array[1] = new String("Hotdog");
        this.array[2] = new String("Corndog");

    }



}
