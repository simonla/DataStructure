package sort;

/**
 * Created by simonla on 2016/11/28.
 * Have a good day!
 */
class QuickSort extends Sort {

    QuickSort(Integer[] ints) {
        super(ints);
    }

    @Override
    long sort() {
        long t1 = System.currentTimeMillis();
        quickSort(0, mLen - 1);
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    private void quickSort(int lo, int hi) {
        //递归基，并且对小数组做了优化，感觉不到10%左右的improve
        // if (hi <= lo) return;
        if (hi - lo <= 5) {
            insertionSort(lo, hi);
            return;
        }
        int j = partition(lo, hi);
        //划分后递归调用左右两个子序
        quickSort(lo, j - 1);
        quickSort(j + 1, hi);
    }

    private void insertionSort(int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(mInts[i - 1], mInts[i])) continue;
            int target = mInts[i];
            int result = search(lo, i - 1, target);
            moveOneStep(result, i - 1);
            mInts[result] = target;
        }
    }

    private int partition(int lo, int hi) {
        //两个指针，一个从lo开始，一个从hi开始做线性扫描
        int i = lo, j = hi + 1;
        //划分的界桩，未做任何优化
        Integer v = mInts[lo];
        //做三取样切分优化，取3为采样率，反而退化了,可能是因为数据已经很均匀了
        //Integer v = selectMid(lo, hi, 3);
        while (true) {
            while (less(mInts[++i], v)) if (i == hi) break;
            while (less(v, mInts[--j])) if (j == lo) break;
            if (i >= j) break;
            swap(i, j);
        }
        swap(lo, j);
        return j;
    }

    private Integer selectMid(int lo, int hi, int scale) {
        int v = mInts[lo];
        for (int i = lo; i <= hi && i - lo <= scale / 2; i++) {
            if (less(mInts[i + 1], mInts[i])) v = mInts[i];
        }
        return v;
    }
}
