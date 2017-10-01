package driving;

public class Car {
    Main main;
    int distance;
    int destination;
    int maxspeed;
    int currentspeed;
    int minutes;
    boolean driving;
    boolean reached;
    char name;

    /*
    @dev the constructor for the car which is required on creation.

    @param name the name of the car.
    @param distance the destination of the car.
    */
    Car(char name, int distance) {
        this.distance = distance; //set distance.
        this.destination = this.distance; //set destination to distance.
        this.name = name; //set name.
        minutes = 0; //minutes equals zero.
    }

    /*
    @dev the driving method for a car.
    */
    public void drive() {
       while (distance > 0 && driving) { //loop while distance is greater than zero and driving equals true.
           if (distance > (maxspeed / 2)) { //check if distance is greather than maxspeed divided by two.
               currentspeed = maxspeed; //set currentspeed to maxspeed;
               distance -= (currentspeed / 2); //subtract distance.
               minutes++; //increment time by one minute.
               System.out.println(name+" has been driving for "+minutes+" minutes. "+distance+" km to destination.");
               driving = false; //set driving to false;
           } else {
               currentspeed = distance * 2; //set currentspeed to distance multiplied with two.
               distance = 0; //set distance to 0.
               minutes++; //increment time by one minute.
               System.out.println(name+" has reached the destination in "+minutes+" minutes.");
               main.reached(); //call the reached method in main class.
               reached = true; //set reached to true.
               driving = false; //set driving to false.
               break;
           }
       }
    }

    /*
    @dev getter and setters below this line.
    */
    public void setDriving(boolean driving) {
        this.driving = driving;
    }

    public void setMaxspeed(int maxspeed) {
        this.maxspeed = maxspeed;
    }

    public int getDestination() {
        return destination;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isReached() {
        return reached;
    }
}
