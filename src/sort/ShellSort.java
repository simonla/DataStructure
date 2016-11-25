package sort;

/**
 * Created by simonla on 2016/11/25.
 * Have a good day!
 */
public class ShellSort extends Sort {

    public ShellSort(Integer[] integers) {
        super(integers);
    }

    public long sort() {
        long t1 = System.currentTimeMillis();

        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }
}
