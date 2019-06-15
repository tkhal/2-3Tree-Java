// Timothy Khal
// CS202 - Program #5

// Main.java - Used to gather information from user and call designated methods

import java.util.Scanner; // Used for reading in from user

public class main {
    public static void main(String args[]){
        Scanner read = new Scanner(System.in); // Creating scanner obj to read in
        tree treeObj = new tree(); // Object of 2-3 tree
        list listObj = new list(); // Object of linear linked list

        String response = null;
        treeObj.insert(); // Buidling the tree
        System.out.println("**note** To clear the input buffer, user has to hit 'enter' everytime after input");
        System.out.println();
        System.out.println("Menu -----");
        do {
            System.out.println("1) Add new vendor");
            System.out.println("2) Display all vendors");
            System.out.println("3) Retrieve a vendor");
            System.out.println("4) Retrieve all related items of a vendor");
            System.out.println("5) Quit");
            response = read.nextLine();
            read.nextLine();


            switch (response) {
                case "1":
                    System.out.println("What type of vendor would you like to add?\n");

                    System.out.println("1) Food vendor");
                    System.out.println("2) Alcohol vendor");
                    System.out.println("3) Music album vendor");
                    String vendorType = read.nextLine(); // Storing vendor type response inside of vendorType
                    read.nextLine();

                    switch (vendorType) {
                        case "1":
                            float foodCost; // Storing cost inside of foodCost
                            String foodName = "Food";
                            System.out.println("Please enter the cost in US dollars:\n $");
                            foodCost = read.nextFloat(); // Storing user response in temp float
                            read.nextLine();

                            vendor foodObj = new food(foodName, foodCost); // <-- Why unresolved symbol???
                            int i = listObj.insert(foodObj); // Calling the insert function, passing in the data we received from user

                            if (i == 0)
                                System.out.println("Failure: Two vendors of the same type cannot be added next to each other");

                            System.out.println("Success: Food vendor has been added!");


                            break;
                        case "2":
                            float alcoholCost; // Storing cost inside of alcoholCost
                            String alcoholName = "Alcohol";
                            int age;
                            System.out.println("Please enter the cost in US dollars:\n");
                            alcoholCost = read.nextFloat(); // Storing user response
                            System.out.println("Please enter your age to confirm you're 21+");
                            age = read.nextInt();
                            read.nextLine();

                            if (age < 21) {
                                System.out.println("Error, must be 21 to manage alcohol");
                                return;
                            }

                            vendor alcoholObj = new alcohol(alcoholName, alcoholCost, age);
                            int j = listObj.insert(alcoholObj);

                            if (j == 1)
                                System.out.println("Success: Alcohol vendor has been added!");
                            else if (j == 0)
                                System.out.println("Failure: Error adding alcohol vendor.");

                            break;

                        case "3":
                            float musicCost; // Storing cost inside of music cost
                            String album; // Used to store user response for album
                            String musicName = "Music";
                            System.out.println("Enter the name of an album you'd like to add");
                            album = read.nextLine();
                            read.nextLine();
                            System.out.println("Enter the cost of an album in US dollars");
                            musicCost = read.nextFloat();
                            read.nextLine();

                            vendor musicObj = new music(musicName, musicCost, album);

                            int k = listObj.insert(musicObj);

                            if (k == 1)
                                System.out.println("Success: Music vendor has been added!");
                            else if (k == 0)
                                System.out.println("Failure: Error adding alcohol vendor.");
                            break;

                        default:
                            System.out.println("Invalid option, please try again\n");
                            break;
                    }

                case "2":
                    System.out.println("All vendors:");
                    int i = treeObj.display();
                    int j = listObj.display();

                    break;


                case "3":
                    System.out.println("Which vendor do you want to search for?");

                    System.out.println("1) Food");
                    System.out.println("2) Music");
                    System.out.println("3) Alcohol");
                    String vendorSearch = read.nextLine();
                    read.nextLine();

                    switch (vendorSearch) {
                        case "1":
                            String foodSearch = "Food";

                            int checkFood = listObj.retrieve(foodSearch);

                            if (checkFood == 0)
                                System.out.println("No food vendors were found.");
                            else
                                System.out.println("Food vendor found!");
                            break;

                        case "2":
                            String musicSearch = "Music";

                            int checkMusic = listObj.retrieve(musicSearch);
                            if (checkMusic == 0)
                                System.out.println("No music album vendors were found.");
                            else
                                System.out.println("Music album vendor found!");
                            break;

                        case "3":
                            String alcoholSearch = "Music";

                            int checkAlcohol = listObj.retrieve(alcoholSearch);
                            if (checkAlcohol == 0)
                                System.out.println("No alcohol album vendors were found.");
                            else
                                System.out.println("Music album vendor found!");
                            break;
                    }

                case "4":
                    System.out.println("Which vendor do you want to search for?");

                    System.out.println("1) Food");
                    System.out.println("2) Music");
                    System.out.println("3) Alcohol");
                    String search = read.nextLine();
                    read.nextLine();

                    switch (search) {
                        case "1":
                            String foodSearch = "Food";

                            int checkFood = listObj.retrieveAll(foodSearch);

                            if (checkFood == 0)
                                System.out.println("No food vendors were found.");
                            else
                                System.out.println("There are: " + checkFood + " food vendors");
                            break;

                        case "2":
                            String musicSearch = "Music";

                            int checkMusic = listObj.retrieveAll(musicSearch);
                            if (checkMusic == 0)
                                System.out.println("No music album vendors were found.");
                            else
                                System.out.println("There are: " + checkMusic + " music album vendors vendors");
                            break;

                        case "3": {
                            String alcoholSearch = "Music";

                            int checkAlcohol = listObj.retrieveAll(alcoholSearch);
                            if (checkAlcohol == 0)
                                System.out.println("No alcohol album vendors were found.");
                            else
                                System.out.println("There are: " + checkAlcohol + " alcohol vendors");
                            break;
                        }
                        default:
                            System.out.println();
                            System.out.println();
                            break;
                    }

                case "5":

                    listObj.deleteList(); // Delete list...
                    treeObj.deleteTree(); // Delete tree...

                    System.out.println("All data has been deleted.");
                    System.exit(1);

                default:
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");

            }
        } while (response != "5");
    }
}
