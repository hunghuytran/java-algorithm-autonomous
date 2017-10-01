package store;

/*
@dev the cart class for storing current user, usage and if it's occupied or not information.
*/
public class Cart {
    private int user;
    private boolean occupied;
    private int usage;
    private int id;

    public Cart(int id) {
        this.id = id;
    }

    /*
    @dev getter for usage.
    */
    public int getUsage() {
        return usage;
    }

    /*
    @dev setter for occupied.

    @param status either true or false depending on cart.
    */
    public void setOccupied(boolean status) {
        this.occupied = status;
        if(status) {
            this.usage++;
        }
    }


    /*
    @dev getter for occupied.
    */
    public boolean isOccupied() {
        return this.occupied;
    }


    /*
    @dev getter for user.
    */
    public int getUser() {
        return user;
    }

    /*
    @dev setter for user.

    @param user is the user id.
    */
    public void setUser(int user) {
        this.user = user;
    }

    /*
    @dev getter for id.
    */
    public int getId() {
        return id;
    }
}
