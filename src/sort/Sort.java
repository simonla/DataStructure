package sort;

/**
 * Created by simonla on 2016/11/25.
 * Have a good day!
 */
public abstract class Sort {
    Integer[] mIntegers;

    public Sort(Integer[] integers) {
        mIntegers = integers;
    }

    public Integer[] getIntegers() {
        return mIntegers;
    }

    abstract long sort();

    public void sout() {
        for (Integer i : mIntegers) {
            System.out.println(i);
        }
    }

    public void swap(int i, int j) {
        Integer t = mIntegers[i];
        mIntegers[i] = mIntegers[j];
        mIntegers[j] = t;
    }
}
