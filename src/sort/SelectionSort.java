package sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by simonla on 2016/11/21.
 * Have a good day!
 */
public class SelectionSort {
    private Integer[] mInts;
    private ArrayList<Integer> mList;

    public SelectionSort(Integer[] ints) {
        mInts = ints;
        mList = new ArrayList<>();
        Collections.addAll(mList, mInts);
    }

    public Integer[] getInts() {
        return mInts;
    }

    public long sort() {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < mInts.length; i++) {
            mInts[i] = selectMin();
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    private int selectMin() {
        int min = mList.get(0);
        for (int i = 0; i < mList.size(); i++) {
            if (min >= mList.get(i)) {
                min = mList.get(i);
                mList.remove(i);
            }
        }
        return min;
    }
}
