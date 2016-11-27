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
                //swap(j, j - 1);
                int target = mInts[j];
                int result = search(0, j-1, target);
                moveOneStep(result, j-1);
                mInts[result] = target;
            }
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }
}
