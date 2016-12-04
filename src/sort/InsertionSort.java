package sort;

/**
 * Created by simonla on 2016/11/21.
 * Have a good day!
 */
class InsertionSort extends Sort {

    InsertionSort(Integer[] integers) {
        super(integers);
    }

    @Override
    public long sort() {
        long t1 = System.currentTimeMillis();
        for (int i = 1; i < mLen; i++) {
            if (less(mInts[i - 1], mInts[i])) continue;
            int target = mInts[i];
            int result = search(0, i - 1, target);
            moveOneStep(result, i - 1);
            mInts[result] = target;
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }
}
