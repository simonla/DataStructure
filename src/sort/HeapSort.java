package sort;

/**
 * Created by simonla on 2016/12/2.
 * Have a good day!
 */
public class HeapSort extends Sort {

    HeapSort(Integer[] ints) {
        super(ints);
    }

    @Override
    long sort() {
        long t1 = System.currentTimeMillis();
        int N = mLen;
        for(int k =mLen/2;k>=1;k--) {
            sink(k);
            while (mLen > 1) {
                swap(1, N--);
                sink(1);
            }
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    private void sink(int k) {
        while (2 * k <= mLen) {
            int j = 2 * k;
            if (j < mLen && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }
}
