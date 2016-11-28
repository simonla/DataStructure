package sort;

/**
 * Created by simonla on 2016/11/28.
 * Have a good day!
 */
public class QuickSort extends Sort {

    QuickSort(Integer[] ints) {
        super(ints);
    }

    @Override
    long sort() {
        long t1 = System.currentTimeMillis();

        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }
}
