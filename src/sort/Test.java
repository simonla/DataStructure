package sort;

import java.util.Random;

/**
 * Created by simonla on 2016/11/20.
 * Have a good day!
 */
public class Test {

    private static final int TEST_SCALE = 10000;

    private static final int MODE_THREAD = 0;
    private static final int MODE_DEFAULT = 1;
    private static final int MODE_CHECK = 3;

    private static Integer[] mInts = new Integer[TEST_SCALE];

    public static void main(String[] args) {
        mInts = getRandomArr();
        //mInts = getSortArr();
        //new Thread(() ->doTest(MODE_DEFAULT)).start();
        new Thread(() -> doTest(MODE_THREAD)).start();
    }

    private static void doTest(int mode) {
        BubbleSort bubbleSort = new BubbleSort(mInts);
        //MergeSort mergeSort = new MergeSort(mInts);
        SelectionSort selectionSort = new SelectionSort(mInts);
        InsertionSort insertionSort = new InsertionSort(mInts);
        ShellSort shellSort = new ShellSort(mInts);

        switch (mode) {
            case MODE_CHECK:
                bubbleSort.check();
                //mergeSort.check();
                selectionSort.check();
                insertionSort.check();
                shellSort.check();
                break;
            case MODE_THREAD:
                new Thread(() -> printTime(bubbleSort)).start();
                //new Thread(() -> printTime(mergeSort)).start();
                new Thread(() -> printTime(selectionSort)).start();
                new Thread(() -> printTime(insertionSort)).start();
                new Thread(() -> printTime(shellSort)).start();
                break;
            case MODE_DEFAULT:
                long bubbleSortTime = bubbleSort.sort();
                //new Thread(() -> printMultiple(mergeSort, bubbleSortTime)).start();
                new Thread(() -> printMultiple(insertionSort, bubbleSortTime)).start();
                new Thread(() -> printMultiple(selectionSort, bubbleSortTime)).start();
                new Thread(() -> printMultiple(shellSort, bubbleSortTime)).start();
                //最好 O(n) 平均 O(n^2) 但是是 in-place 的，只需 O(1) 的额外空间，输入敏感
                //与bubble一样都是 O(n^2) 但是减少了swap的操作次数
                //插入排序的优化版本
                break;
        }
    }

    private static void printTime(Sort sort) {
        System.out.println(sort.getClass().getName() + " ===> " + sort.sort() + " ms" + " check: " + sort.check());
    }

    private static void printMultiple(Sort sort, long index) {
        long comp = sort.sort();
        if (comp == 0) {
            System.out.println(sort.getClass().getName() + " is too fast");
            return;
        }
        double multiple = index / comp;
        System.out.println(sort.getClass().getName() + " " + multiple + "X faster than bubble");
    }

    private static Integer[] getRandomArr() {
        Integer[] arr = new Integer[TEST_SCALE];
        for (int i = 0; i < TEST_SCALE; i++) {
            arr[i] = new Random().nextInt(TEST_SCALE);
        }
        return arr;
    }

    private static Integer[] getSortArr() {
        Integer[] arr = new Integer[TEST_SCALE];
        for (int i = 0; i < TEST_SCALE; i++) {
            arr[i] = i;
        }
        return arr;
    }

}
