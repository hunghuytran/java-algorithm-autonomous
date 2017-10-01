package store;

/*
@dev the customer class to hold information about the current customer basically.
*/
public class Customer {
    public Main main;
    public boolean done;
    public boolean returned;

    public Customer() {
    }

    /*
    @dev check through the cart list for any free carts.
         if found then set user to current userId, set occupied and done to true.
    @param user the input user id.
    */
    public void shopping(int user) {
        for(Cart cart : main.getCarts()) {
            if(!cart.isOccupied()) {
                cart.setOccupied(true);
                cart.setUser(user);
                this.done = true;
                break;
            }
        }
    }

    /*
    @dev if the using is returning then we will iterate through the carts list on main.
         if cart is not occupied then, it will just skip over.
         if cart is occupied and if current user of the cart is equal then return.
         this increment used in main by one.
    @param user the input user id.
    */
    public void returned(int user) {
        for(Cart cart : main.getCarts()) {
            if(cart.isOccupied() && user == cart.getUser()) {
                cart.setOccupied(false);
                this.returned = true;
                main.increaseUsed();
                break;
            }
        }
    }
}
