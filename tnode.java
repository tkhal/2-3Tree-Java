// tnode class that contains methods for insert function for 2-3 tree.

// Tim Khal
// CS202 - Program #5

import java.util.Scanner;
public class tnode {

    private tnode left; // Left child reference
    private tnode middle; // Middle child reference
    private tnode right; // Right child reference
    private tnode parent; // Node reference point back up the tree to previous parent tnode
    private int num1; // Integer holding first number, should be smaller than num2
    private int num2; // Integer holding second number, bigger than num1
    private list head; // Each tnode will have a head pointer to a LLL

    public tnode getLeft(){ // Getter for left reference
        return left;
    }

    public tnode getRight(){ // Getter for right reference
        return right;
    }

    public tnode getMiddle(){ // Getter for middle reference
        return middle;
    }

    public int getNum1(){ // Getter for num1
        return num1;
    }

    public int getNum2(){ // Getter for num2
        return num2;
    }

    tnode(){ // Node default constructor
        left = null;
        middle = null;
        right = null;
        parent = null;
        num1 = 0;
        num2 = 0;
        head = null;
    }

    private int data; // Integer data, used for adding

    public tnode(int data){ // Builds a new leaf tnode and sets the integer data
        this.num1 = data;
    }

    tnode (int data,  tnode prev){ // Node constructor -- builds new leaf tnode, sets parent pointer to point to prev tnode,
        // and inserts the integer data in the first slot (num1)
        this.parent = prev;
        this.num1 = data;
    }

    // Recursive function to insert data at a leaf
    public int insert(int toAdd){

        // If the tnode we're at is a leaf, then we insert
        if ((left == null) && (right == null) && (middle == null)) // All child pointers are null
        {
            if (this.num2 == 0) // Checking if there's a free spot at num2 to insert
            {
                if (toAdd >= num1) // If the new item is greater than num1
                    this.num2 = toAdd;
                else{ // Now check if the new number being added is LESS than num1
                    this.num2 = this.num1; // Replacing num2 with num1
                    this.num1 = toAdd; // New data is now in the place of num 1
                }
            }

            else  // Now check if leaf is has two data items. Split the tnode up if it does
            {
                leafSplit(toAdd);

               if (parent != null) // If the tnode above us exists, push up the tnode
                  this.parent.moveUp(this);

            }

            return 1; // If we get here, we've inserted a tnode at the leaf, so return 1 for successful insertion
        }

        // If the tnode is NOT a leaf, continue traversal until we find a leaf. We only insert at a leaf for 2-3 trees
        if (toAdd < num1) // New item is smaller than num1, so go left
            left.insert(toAdd);

        else if(num2 == 0) // If it's a 2-tnode, go right
            right.insert(toAdd);

        else
        {
            if (toAdd < num2) // If new number is greater than num1 and smaller than num2, then add with middle
                middle.insert(toAdd);
            else // If this if-statement executes, then the new number is the largest, so add with right
                right.insert(toAdd);
        }
        return 1;
    }

    private int leafSplit(int toAdd) // Method executes if a leaf node needs to be split
    {
        if (toAdd < num1) // Number being added is smaller than num1
        {
            left = new tnode(toAdd, this);
            right = new tnode(num2, this);
            num2 = 0;
        }
        else // Number being added is larger than num1
        {
            // Check and make sure that it's smaller than num2
            if (toAdd < num2)
            {
                left = new tnode(num1, this);
                right = new tnode(num2, this);
                num2 = 0;
                num1 = toAdd;
            }
            else // Check if the new item is larger than num2 and largest
            {
                left = new tnode(num1, this);
                right = new tnode(toAdd, this);
                num1 = num2;
                num2 = 0;

            }
        }
        return 1;
    }

    private int moveUp(tnode toPush) // Passing a tnode to push up
    {
        if (this.num2 == 0) // If it's a 2-tnode
        {
            if (toPush.num1 < this.num1) // If new tnodes num1 is smaller than this.num1
            {
                this.num2 = num1;
                this.num1 = toPush.num1;
                left = toPush.left;
                left.parent = this;
                middle = toPush.right;
                middle.parent = this;
            }
            else if (toPush.num1 >= this.num1) // If the tnode being pushed is larger or equal to this.num1
            {
                this.num2 = toPush.num1;
                middle = toPush.left;
                middle.parent = this;
                right = toPush.right;
                right.parent = this;
            }
            else // If it's a three tnode, it has to split again
            {
                threeSplit(toPush);
                // Could not figure out this function
                if (parent != null)
                    parent.moveUp(this);

            }
        }
        return 1;
    }

    private int threeSplit(tnode toSplit) // Splitting a node that's not a leaf
    {
        tnode temp; // Temp node

        if (toSplit.num1 < num1) // Item to add is smaller than num1
        {
            left = toSplit;
            left.parent = this;
            temp = new tnode(num2, this);
            temp.left = middle;
            temp.left.parent = temp;
            temp.right = right;
            temp.right.parent = temp;
            right = temp;
            middle = null;
        }
        else // If item is larger than num1
        {
                right = toSplit; // right pointer equal to split node
                right.parent = this; // right's parent referencing current obj
                temp = new tnode(num1, this); // Creating new node, parent pointer is referencing this obj, this.num1 = num1
                temp.left = left;
                temp.left.parent = temp;
                temp.right = middle;
                temp.right.parent = temp;
                left = temp;
                num1 = num2;
                num2 = 0;
                middle = null;
        }
        return 1;
    }





}
