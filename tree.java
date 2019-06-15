// Timothy Khal
// CS202 - Program #5

// File to support methods for 2-3 tree. Includes insert, display, and delete. Retrieve & Retrieve all are contained within the list class

import java.util.Random;

public class tree {
    protected tnode root; // Root of the tree

    public int insert(){ // Wrapper insert function, passes random values to insert integer data in the tree.
        Random rn = new Random();


        for (int i = 0; i < 10; ++i)
        {
            insert(3);
            insert(5);
            insert(9);
            insert(5);
            insert(8);
            insert(1);
            insert(7);
            insert(4);
            insert(3);
        }
        return 1;
    }

    protected int insert(int toAdd){ // Insert function, calls tnode insert function and passes in integer data

        tnode object = new tnode();

        return object.insert(toAdd);

    }

    public int display(){ // Wrapper method to display all data
        return display(root);

    }

    protected int display(tnode root) // Method to display all data in 2-3 tree
    {
        if (root == null)
            return 0;

        if (root.getLeft() == null && root.getRight() == null) // If tnode is a leaf
        {
            System.out.println(root.getNum1());
            System.out.println(root.getNum2());
            return 1;
        }
        else if (root.getLeft() != null && root.getRight() != null) // Node has 2 children
        {
            display(root.getLeft());
            System.out.println(root.getNum1());
            System.out.println(root.getNum2());
        }
        else if (root.getLeft() != null && root.getMiddle() != null && root.getRight() != null) // Node has 3 children
        {
            display(root.getLeft());
            System.out.println(root.getNum1());

            display(root.getMiddle());
            System.out.println(root.getRight());

            display(root.getRight());
        }
        return 1;
    }

    public void deleteTree(){ // Wrapper delete method
       deleteTree(root);
    }

    private void deleteTree(tnode root){ // If the tree exists, delete tree
        if (root != null)
            root = null;
    }





}
