package driving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    /*
    @dev variables being created in the beginning.
    */
    public static int total; //the amount of cars.
    public static ArrayList<Integer> destination; //the destination list.
    public static ArrayList<Integer> limits; //the maxspeed list.
    public static ArrayList<Car> cars = new ArrayList<>(); //the cars list.
    public static int reached; //number of cars reached destination.
    public static int distance; //the total distance of all cars after reaching destination.
    public static int time; //the total time of all cars after reaching destination.

    /*
    @dev the first method being run on start.
    */
    public static void main(String[] args) throws IOException {
        dest(); //sets the destinations.
        limits(); //sets the driving limits.
        questions(); //set the n amount of cars.
        add(); //add the cars to arraylist.
        drive(); //start the driving simulation.
    }

    /*
    @dev start the driving simulation. read comments for more information.
    */
    private static void drive(){
        while(true) {
            if(reached < total) { //checks if total amount of cars reached equals total amount of cars.
                Car car = random(); //choose a random car from arraylist.
                if (!car.isReached()) { //checks if car has been reached
                    car.setMaxspeed(random(limits)); //sets the driving speed.
                    car.setDriving(true); //sets the driving to true.
                    car.drive(); //drive the car.
                }
            } else {
                for(int i = 0; i < cars.size(); i++) { //loop through the arraylist.
                    distance += cars.get(i).getDestination(); //add destination to total distance.
                    time += cars.get(i).getMinutes();  //add time to total time.
                }
                System.out.println("The cars have driven a total distance of: "+distance+" km.");
                System.out.println("The total time is: "+time+" minutes.");
                break;
            }
        }
    }

    /*
    @dev add objects to a arraylist.
    */
    private static void dest() {
        destination = new ArrayList<>();
        destination.add(40);
        destination.add(100);
        destination.add(140);
    }

    /*
    @dev add objects to a arraylist.
    */
    private static void limits() {
        limits = new ArrayList<>();
        limits.add(2);
        limits.add(4);
        limits.add(6);
    }

    /*
    @dev adds a new car with random name and destination to arraylist cars.
    */
    private static void add() {
        int i = 65;
        while(total > cars.size()) {
            char name = (char) i++;
            Car car = new Car(name , random(destination));
            cars.add(car);
        }
    }

    /*
    @dev generate a random number from a list of array.

    @param list the arraylist being used.
    @returns a random number.
    */
    private static int random(ArrayList<Integer> list) {
        Random r = new Random();
        int random = list.get(r.nextInt(list.size()));
        return random;
    }

    /*
    @dev choose a random car from arraylist.

    @returns a car object.
    */
    private static Car random() {
        Random r = new Random();
        Car car = cars.get(r.nextInt(cars.size()));
        return car;
    }

    /*
    @dev print out question and enables bufferedreader.
    */
    private static void questions() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please choose the amount of cars being generated.");
        total = Integer.parseInt(input.readLine());
    }

    /*
    @dev increment reached variable by one if method is called.
    */
    public static void reached() {
        Main.reached++;
    }
}