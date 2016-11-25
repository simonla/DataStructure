package sort;

/**
 * Created by simonla on 2016/11/21.
 * Have a good day!
 */
public class InsertionSort {
    private Integer[] mIntegers;

    public InsertionSort(Integer[] integers) {
        mIntegers = integers;
    }

    public long sort() {
        long t1 = System.currentTimeMillis();
        for (int i = 1; i < mIntegers.length; i++) {
            int target = mIntegers[i];
            if(target>mIntegers[i-1]) continue;
            int search = search(0, i, target);//在有序的部分寻找插入位置
            move(search, i);//腾出位置
            mIntegers[search] = target;
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    private void move(int lo, int hi) {
        System.arraycopy(mIntegers, lo, mIntegers, lo + 1, hi - lo);
    }

    private int search(int lo, int hi,int target) {
        for (int i = lo; i < hi; i++) {
            if(mIntegers[i]>target) return i;
        }
        return hi;
    }

    public Integer[] getIntegers() {
        return mIntegers;
    }

    public void sout() {
        for (Integer mInt : mIntegers) {
            System.out.println("插入排序："+mInt);
        }
    }
}
