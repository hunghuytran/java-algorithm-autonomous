package generate;

/*
@dev this class will be used to count from ArrayList with our numbers.
     to be able to achieve concurrent programming, one must define range.
*/
public class Count implements Runnable {
    private int count;
    private Main main;
    private int start;
    private int end;
    private int id;

    /* constructor for our threading class */
    public Count(int id, int start, int end) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    /*
    @dev the method that will be run in this thread.
         goes through ArrayList<Integer> and only counts.

    */
    @Override
    public void run() {
        for(int i = 0;i < main.getNumbers().size() ;i++) {
            /* if i is higher or equal to start and end is higher or equal to i */
            if(i >= start && end >= i) {
                count += i;
            }
        }
        System.out.println("\nThread count:" + count + "\nProcessor: " + id);
        main.compareSum(count);
    }
}
