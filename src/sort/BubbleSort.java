package sort;

/**
 * Created by simonla on 2016/11/20.
 * Have a good day!
 */
class BubbleSort extends Sort {

    BubbleSort(Integer[] integers) {
        super(integers);
    }

    @Override
    public long sort() {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < mLen- 1; i++) {
            for (int j = 0; j < mLen - 1 - i; j++) {
                if (mInts[j] > mInts[j+1]) {
                    swap(j,j+1);
                }
            }
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }
}
