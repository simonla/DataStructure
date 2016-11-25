package sort;

/**
 * Created by simonla on 2016/11/20.
 * Have a good day!
 */
public class BubbleSort {
    private Integer[] mInts;

    public BubbleSort(Integer[] ints) {
        mInts = ints;
    }

    public long sort() {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < mInts.length - 1; i++) {
            for (int j = 0; j < mInts.length - 1 - i; j++) {
                if (mInts[j] > mInts[j+1]) {
                    int temp = mInts[j];
                    mInts[j] = mInts[j+1];
                    mInts[j+1] = temp;
                }
            }
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    public Integer[] getInts() {
        return mInts;
    }

    public void sout() {
        for (Integer mInt : mInts) {
            System.out.println("冒泡排序："+mInt);
        }
    }
}
