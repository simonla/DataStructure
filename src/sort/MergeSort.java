package sort;

/**
 * Created by simonla on 2016/11/20.
 * Have a good day!
 */
public class MergeSort {
    private Integer[] mInts;

    public MergeSort(Integer[] ints) {
        mInts = ints;
    }

    public long sort() {
        long t1 = System.currentTimeMillis();
        mergeSort(0, mInts.length - 1);
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    private void mergeSort(int lo, int hi) {
        if (hi - lo < 2) return;
        int mi = (lo + hi) >> 1;
        mergeSort(lo, mi);
        mergeSort(mi, hi);
        merge(lo, mi, hi);
    }

    public Integer[] getInts() {
        return mInts;
    }

    private void merge(int lo, int mi, int hi) {
        int lb = mi - lo;
        int lc = hi - mi;
        int[] B = new int[lb];
        for (int i = 0; i < lb; B[i] = mInts[i++]) ;
        for (int i = 0, j = 0, k = 0; j < lb; ) {
            if ((k < lc) && (mInts[k + lb]) < B[j]) mInts[i++] = mInts[lb + k++];
            if (lc <= k || B[j] <= mInts[lb + k]) mInts[i++] = B[j++];
        }
    }

    public void sout() {
        for (Integer mInt : mInts) {
            System.out.println("归并排序："+mInt);
        }
    }
}
