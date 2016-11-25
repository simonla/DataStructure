package sort;

/**
 * Created by simonla on 2016/11/21.
 * Have a good day!
 */
class SelectionSort extends Sort {

    SelectionSort(Integer[] integers) {
        super(integers);
    }

    @Override
    public long sort() {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < mLen; i++) {
            swap(i, min(i));
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }
}
