package sort;

/**
 * Created by simonla on 2016/11/20.
 * Have a good day!
 */
//比快排更稳定，最坏也只有O(nlogn)
public class MergeSort extends Sort {
    private Integer[] aux;

    MergeSort(Integer[] integers) {
        super(integers);
    }

    @Override
    public long sort() {
        long t1 = System.currentTimeMillis();
        aux = new Integer[mLen];
        mergeSort(0, mLen - 1);
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    private void mergeSort(int lo, int hi) {
        //到达递归基，不能再分了
        if (hi == lo) return;
        int mi = (lo + hi) >> 1;
        mergeSort(lo, mi);
        mergeSort(mi + 1, hi);
        //对已经有序的数组，讲时间优化到常数级别，
        //而且，测试发现，对均匀分布的随机数来说，性能也有能够优化常系数(因为输入敏感，可能对稳定性有影响）
        if (mInts[mi] <= mInts[mi + 1]) return;
        //对小数组用插入排序计算来进行优化
        if (hi - lo < mLen / 50) {
            insertionSort(lo, hi);
        } else {
            merge(lo, mi, hi);
        }
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

    private void merge(int lo, int mi, int hi) {
        //mInts = B + C,即左半边 + 右半边
        int B = lo, C = mi + 1;
        System.arraycopy(mInts, lo, aux, lo, hi + 1 - lo);
        //无论如何，只会执行hi-lo+1次
        for (int k = lo; k <= hi; k++) {
            //如果左半边用尽，就取右半边的过来
            if (B > mi) mInts[k] = aux[C++];
                //如果右半边用尽，就取左半边的过来
            else if (C > hi) mInts[k] = aux[B++];
                //两边都没用尽，哪边边小就取过来
            else if (less(aux[C], aux[B])) mInts[k] = aux[C++];
            else mInts[k] = aux[B++];
        }
    }
}
