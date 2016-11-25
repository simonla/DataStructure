package sort;

/**
 * Created by simonla on 2016/11/21.
 * Have a good day!
 */
public class SelectionSort {
    private Integer[] mInts;

    public SelectionSort(Integer[] ints) {
        mInts = ints;
    }

    public Integer[] getInts() {
        return mInts;
    }

    public long sort() {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < mInts.length; i++) {
            swap(i, selectMin(i));
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    //可以优化到 O(logN)
    private int selectMin(int i) {
        int min = i;
        for (int j = i + 1; j < mInts.length; j++) {
            if (mInts[j] < mInts[min]) min = j;
        }
        return min;
    }

    private void swap(int a, int b) {
        int temp = mInts[a];
        mInts[a] = mInts[b];
        mInts[b] = temp;
    }

    public void sout() {
        for (Integer mInt : mInts) {
            System.out.println("选择排序："+mInt);
        }
    }
}
