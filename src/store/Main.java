package store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
@dev main class, duh.
*/
public class Main {

    /*
    @dev implement shop wagons to customers and calculate the time.
         this is based on the fact that a customer can only shop if he has a cart.
         else that customer needs to wait and queue for a cart.
         a customer comes in at different moment that why the customer are randomized.
         this could be changed if we want some customers to skip cart.
    */
    private static ArrayList<Customer> customers = new ArrayList<>(); // customers arraylist.
    public static ArrayList<Cart> carts = new ArrayList<>(); // cart arraylist.
    private static int total; // people.
    private static int used; // n amount of people that left the supermarket.
    private static int time; // total time.
    private static int max; // total n amount carts.
    private static int usage; // total amount all carts have been used.

    /*
    @dev the main method being run when hit start.
    */
    public static void main(String[] args) throws IOException {
        questions();
        customers();
        carts();
        run();
    }

    /*
    @dev add customers to arraylist customers.
         holds our customers.
    */
    private static void customers() {
        while (customers.size() < total) {
            Customer c = new Customer();
            customers.add(c);
        }
    }

    /*
    @dev add cart to arraylist carts.
         holds our carts.
    */
    private static void carts() {
        int i = 1;
        while (carts.size() < max) {
            Cart c = new Cart(i);
            carts.add(c);
            i++;
        }
    }

    /*
    @dev the simulator being run.
    */
    private static void run() {
        while (true) {
            int next = (int) (Math.random() * customers.size());
            time++;
            if (used < total) {
                Customer customer = customers.get(next);
                int userId = next;
                if (customer.done) { // if the customer is done then return equals true.
                    customer.returned(userId);
                } else {
                    customer.shopping(userId);
                }
            } else {
                display();
                break;
            }
        }
    }

    /*
    @dev display usage of each cart
    */
    public static void display() {
        for(Cart cart : carts) {
            System.out.println("Cart " + cart.getId() + " has been used " + cart.getUsage() + " times.");
            usage += cart.getUsage();
        }
        int hours = time / 60;
        int days = hours / 24;
        System.out.println("The total time of shopping is "
                + time + " minutes or "
                + hours + " hours or "
                + days + " days. The total used equals " + usage
        );
    }

    /*
    @dev print out question and enables bufferedreader.
    */
    private static void questions() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please choose the amount of people that will visit the supermarket.");
        total = Integer.parseInt(input.readLine());
        System.out.println("Please choose the amount of carts that will be produced.");
        max = Integer.parseInt(input.readLine());
    }

    /*
    @dev return cart arraylist.
    */
    public static ArrayList<Cart> getCarts() {
        return carts;
    }

    /*
    @dev increment used by one. used to keep track of counting.
    */
    public static void increaseUsed() {
        Main.used++;
    }
}
