// File to support operations for the LLL reference
// Timothy Khal
// CS202 - Program #5

public class list { // LLL - Contains head reference with methods to insert, sort as inserted, and display
    private lnode head; // The list will have a rear pointer

    public lnode getHead() { // Getter for rear
        return head;
    }

    public list() { // Default constructor
        head = null;
    }

    // ============================================================

    public int insert(vendor toAdd) { // Insert method, two lnodes cannot be added at same time
        if (this.head == null) {
            this.head = new lnode();
            this.head.setData(toAdd); // Setting heads data
            this.head.setNext(null);
        } else {
            lnode temp = new lnode();
            temp.setData(toAdd);
            if (temp.getData().name.equals(this.head.getData().name)) // If two lnode are next to eachother, return 0
                return 0;
            temp.setNext(this.head);
            this.head = temp;
        }
        return 1;
    }
    // ============================================================

    public int display() { // Wrapper method for display
        return display(head);
    }

    private int display(lnode head) { // Recursive display method

        if (head == null) // At end of list
            return 0;

        System.out.println("Vendor type: " + head.getData().name);
        System.out.println("Categories:");
        for (int i = 0; i < 3; ++i)
            System.out.println(head.getData().array[i]);

        return display(head.getNext()) + 1;
    }


// ============================================================

    public int retrieve(String search){ // Wrapper method to retrieve a vendor
        int count = 0;
        count = retrieve(search, head, count);
        System.out.println(count);
        return count;

    }

    private int retrieve(String search, lnode head, int count){ // Method to retrieve a specific vendor
        if (head == null) return 1;

        if (head.getData().name.equals(search))
            return 1;

        return 1 + retrieve(search, head.getNext(), count);
    }

// ============================================================

    public int retrieveAll(String search){ // Function to retrieve all, displays and returns the number of items found
        return retrieveAll(search, head);
    }

    private int retrieveAll(String search, lnode head){ // Function to go through the list and retrieve all matching data
        if (head == null)
            return 0;

        if (head.getData().name.equals(search)) // If we find a match...
        {
            System.out.println("Vendor Type: " + head.getData().name); // Print out food type
            System.out.println("Categories:");
            for (int i = 0; i < 3; ++i) // Print out category array
                System.out.println(head.getData().array[i]);
            return 1 + retrieveAll(search, head.getNext()); // Return +1 and traverse to next node
        }

        else
            return retrieveAll(search, head.getNext()); // No +1, just traverse to next
    }

// ============================================================

    public void deleteList(){ // Wrapper method to delete list
        deleteList(head);
    }

    private void deleteList(lnode head){ // Function to delete list
        if (head != null)
            head = null;
    }




}

// Implement remove method
// use equals to strcmp
//   if (head.getData().getName().equals(string passed in from main))
//      delete




















