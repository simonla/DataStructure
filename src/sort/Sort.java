package sort;

/**
 * Created by simonla on 2016/11/25.
 * Have a good day!
 */
abstract class Sort {
    Integer[] mInts;
    int mLen;

    Sort(Integer[] ints) {
        mInts = ints;
        mLen = mInts.length;
    }

    public Integer[] getInts() {
        return mInts;
    }

    abstract long sort();

    void printSort() {
        sort();
        for (Integer i : mInts) {
            System.out.println(this.getClass().getName() + " ==> " + i);
        }
    }

    void swap(int i, int j) {
        Integer t = mInts[i];
        mInts[i] = mInts[j];
        mInts[j] = t;
    }

    boolean less(Integer i, Integer j) {
        return  i.compareTo(j)<0;
    }

    //可以优化到 O(logN)
    int min(int i) {
        int min = i;
        for (int j = i + 1; j < mLen; j++) {
            if (less(j, min)) min = j;
        }
        return min;
    }

    int search(int lo, int hi, int target) {
        for (int i = lo; i < hi; i++) {
            if (mInts[i] > target) return i;
        }
        return hi;
    }

    boolean check() {
        sort();
        boolean flag = true;
        if(mLen!=mInts.length) return false;
        for (int i = 0; i < mLen - 1; i++) {
            if (less(i + 1, i)) {
                flag = false;
                System.out.println(this.getClass().getName() + " " + mInts[i] + " - " + mInts[i + 1] + " = " + ((mInts[i]) - (mInts[i + 1])));
            }
        }
        return flag;
    }

    void moveOneStep(int lo, int hi) {
        System.arraycopy(mInts, lo, mInts, lo + 1, hi + 1 - lo);
    }

}
