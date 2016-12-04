package sort;

/**
 * Created by simonla on 2016/11/25.
 * Have a good day!
 */
class ShellSort extends Sort {

    ShellSort(Integer[] integers) {
        super(integers);
    }

    public long sort() {
        long t1 = System.currentTimeMillis();
        //步长h
        int h = 1;
        while (h < mLen / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < mLen; i++)
                for (int j = i; j >= h && less(mInts[j], mInts[j - h]); j -= h)
                    swap(j, j - h);
            h = h / 3;
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }
}
