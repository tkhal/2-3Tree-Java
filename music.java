// Timothy Khal
// CS202 - Program #5
// Derived class music, will hold name of album entered in by client

public class music extends vendor{
    protected String album;

    public String getAlbum() { // Getter for album
        return album;
    }

    public void setAlbum(String album) { // Setter for album
        this.album = album;
    }

    public music(String name, float cost, String album){ // Constructor for music
        super(name, cost); //

        this.album = album;

        this.array[0] = new String("Rock & Roll");
        this.array[1] = new String("Hip Hop");
        this.array[2] = new String("R&B");
    }

}

