package sort;

import java.util.Random;

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

    /**
     * 返回数组
     * @return 数组
     */
    public Integer[] getInts() {
        return mInts;
    }

    abstract long sort();

    /**
     * 打印出排序后的数组
     */
    void printSort() {
        sort();
        for (Integer i : mInts) {
            System.out.println(this.getClass().getName() + " ==> " + i);
        }
    }

    /**
     * 按秩交换原数组的两个元素
     * @param i 第一个待交换元素的秩
     * @param j 第二个待交换元素的秩
     */
    void swap(int i, int j) {
        Integer t = mInts[i];
        mInts[i] = mInts[j];
        mInts[j] = t;
    }

    /**
     * 前一个元素是否小于后一个元素
     * @param i 前一个元素
     * @param j 后一个元素
     * @return 真为小于
     */
    boolean less(Integer i, Integer j) {
        return  i.compareTo(j)<0;
    }

    /**
     * 可以优化到 O(logN)
     * 以输入为界桩，向后找到最小的元素
     * @param i 界桩的秩
     * @return 返回最小元素的秩
     */
    int min(int i) {
        int min = i;
        for (int j = i + 1; j < mLen; j++) {
            if (less(j, min)) min = j;
        }
        return min;
    }

    /**
     * 搜索特定元素的
     * @param lo 左界桩的秩
     * @param hi 右界桩的秩
     * @param target 待寻找元素的秩
     * @return 如果命中，返回靶的秩，如果没有，返回右界桩的秩
     */
    int search(int lo, int hi, int target) {
        for (int i = lo; i < hi; i++) {
            if (mInts[i] > target) return i;
        }
        return hi;
    }

    /**
     * 简单的检查是否已经排序
     * @return 是否有序
     */
    boolean check() {
        sort();
        boolean flag = true;
        if (mLen != mInts.length) return false;
        for (int i = 0; i < mLen - 1; i++) {
            if (less(mInts[i + 1], mInts[i])) {
                flag = false;
                System.out.println(this.getClass().getName() + " " + mInts[i] + " - " + mInts[i + 1] + " = " + ((mInts[i]) - (mInts[i + 1])));
            }
        }
        return flag;
    }

    /**
     * 置乱器，增大元素的混乱程度
     */
    void unSort() {
        for (int i = mLen ; i > 0; i--) {
            swap(i - 1, new Random().nextInt(mLen) % i);
        }
    }

    /**
     * 指定范围内向后移动一个单位
     * @param lo 左边界，闭区间
     * @param hi 右边界，闭区间
     */
    void moveOneStep(int lo, int hi) {
        System.arraycopy(mInts, lo, mInts, lo + 1, hi + 1 - lo);
    }

}
