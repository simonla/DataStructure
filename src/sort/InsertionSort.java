package sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by simonla on 2016/11/21.
 * Have a good day!
 */
public class InsertionSort {
    private Integer[] mIntegers;
    private ArrayList<Integer> mList;

    public InsertionSort(Integer[] integers) {
        mIntegers = integers;
    }

    public long sort() {
        mList = new ArrayList<>();
        Collections.addAll(mList, mIntegers);
        long t1 = System.currentTimeMillis();
        for (int i = 1; i < mList.size(); i++) {
            int target = mList.get(i);
            int rank = search(i,target);
            mList.remove(i);
            mList.add(rank,target);
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    private int search(int i, int target) {
        int j ;
        for (j=0; j < i; j++) {
            if (target<mList.get(j)) break;
        }
        return j;
    }

    public Integer[] getIntegers() {
        return mIntegers;
    }
}
