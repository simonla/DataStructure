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
            for (int j = i; j > 0 && less(j, j - 1); j--) {
                int target = mInts[i];
                int result = search(0, j, target);
                moveOneStep(result, j);
                mInts[result] = target;
            }
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }
}
