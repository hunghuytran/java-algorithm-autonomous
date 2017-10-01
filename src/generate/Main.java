package generate;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
@dev homework to generate a certain amount of number.
     save them in a file with comma between the numbers.
     read the file.
     use threads to sum the values in the file.
     find available processors by printing * Runtime.getRuntime().availableProcessors() *.
*/
public class Main {
    /* global variables */
    /* @stringList is a list with strings */
    /* @total is the amount of number generated */
    /* @path is the location of text file */
    /* @status check if all methods are executed */
    /* @numbers arraylist which contain numbers */
    /* @interval the interval given */
    /* @compareSum the thread sum value */
    /* @threadsList this thread list stores the threads */
    /* @sum normal sum */
    /* @start the timer */
    /* @end the timer */
    private static StringBuffer stringList = new StringBuffer();
    private static int total;
    private static String path = "/home/brian/Documents/Java/src/generate/read.txt";
    private static boolean status;
    private static ArrayList<Integer> numbers = new ArrayList<>();
    private static int interval;
    private static int compareSum;
    private static List<Thread> threadsList = new ArrayList<>();
    private static int sum;
    private static long start;
    private static long end;

    /* main method used to start the program */
    public static void main(String[] args) throws Exception {
        /* @start assign the start time of the program */
        start = System.currentTimeMillis();
        status = generate();
        status = append();
        status = create();
        status = reader();
        status = count();
        status = start();
        result();
    }

    /*
    @dev generates the number based on keyboard input.
         convert from string to integer.
         return the answer to total.

    @return true or false depending on success.
    */
    private static boolean generate() throws IOException {
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Please enter your desired amount of number that you want to generate.");
        String answer = input.readLine();
        total = Integer.parseInt(answer);
        return true;
    }

    /*
    @dev append the amount of number generated in generate() to stringList.

    @return true or false depending on success.
    */
    private static boolean append() {
        for (int i = 0; i < total; i++) {
            stringList.append(i + ",");
        }
        return true;
    }

    /*
    @dev creates a file from stringList by first:
         - creating a file.
         - using BufferedWriter & FileWriter.
         - write to the file.
         - close the file.
    @return boolean value depending on success or error.
    */
    private static boolean create() throws IOException {
        try {
            File file = new File(path);
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(stringList.toString());
            writer.close();
            return true;
        }
        catch (FileNotFoundException error) {
            System.out.println("The writer could not write to file\nError: " + error);
            return false;
        }
    }

    /*
    @dev reads a file depending on given path.
         using BufferedReader & FileReader, same principle as write almost.
         define reading condition in reader in while loop.
         what this does:
         - read the whole file.
         - store strings in a list by comma.
         - convert and add to numbers ArrayList<Integer>.
    @return true or false depending on success.
    */
    private static boolean reader() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(",");
                for(int i = 0;i < temp.length; i++) {
                    numbers.add(Integer.parseInt(temp[i]));
                }
                /* check if the numbers are stored */
                System.out.println("\nOur arraylist: " + numbers);
            }
            return true;
        }
        catch (FileNotFoundException error) {
            System.out.println("Unable to find file.");
            return false;
        }
    }

    /*
    @dev count everything from the threads and execute when everything is done.
    */
    private static void result() throws Exception {
        for(Thread t : threadsList) {
            t.join();
        }

        if(status) {
            long end = System.currentTimeMillis();
            long time = (end - start);
            System.out.println("\nProgram executed successfully.\nThe execution time is: " + time + "ms");
            System.out.println("\nThe sum without threads is: " + sum + ".\nThe thread sum is: " + compareSum + ".");
        }
    }

    /*
    @dev starts a new thread with every initiation.
    */
    private static void threading(int id, int start, int end) {
        Runnable r = new Count(id, start, end);
        Thread t = new Thread(r);
        threadsList.add(t);
        t.start();
    }

    /*
    @dev counting method that will be used to add all the numbers together.
    */
    private static boolean count() {
        numbers.forEach((temp) -> {
            sum += temp;
        });
        end = System.currentTimeMillis();
        System.out.println("\nThe total time to execute normal without threading: " + (end - start) + "ms");
        end = (end - start);
        return true;
    }

    /*
    @dev loop and activates threads. this is where we use threads to count seperate for us.
         interval is given by dividing the size of array with number of processors.
         this may vary between computers.
         int i is outside of the loop because it needs to be incremented by interval with each loop.
    */
    private static boolean start() {
        int i = 0;
        int id = 1;
        interval = numbers.size() / Runtime.getRuntime().availableProcessors();
        for(;i < numbers.size(); i++) {
            threading(id, i,i + interval);
            i += interval;
            id++;
        }
        return true;
    }

    /*
    @dev get numbers ArrayList<Integer>.

    @return numbers ArrayList<Integer>.
    */
    public static ArrayList<Integer> getNumbers() {
        return numbers;
    }

    /*
    @dev sum it up.
    */
    public static void compareSum(int amount) {
        Main.compareSum += amount;
    }
}
