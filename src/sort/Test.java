package sort;

import java.util.Random;

/**
 * Created by simonla on 2016/11/20.
 * Have a good day!
 */
public class Test {

    private static final int TEST_SCALE = 1000000;

    private static final int MODE_THREAD = 0;
    private static final int MODE_DEFAULT = 1;
    private static final int MODE_CHECK = 3;

    private static Integer[] mInts = new Integer[TEST_SCALE];

    public static void main(String[] args) {
        for (int i = 0; i < TEST_SCALE; i++) {
            mInts[i] = new Random().nextInt();
          //  mInts[i] = i;
        }
        doTest(MODE_THREAD);
    }

    private static void doTest(int mode) {
        BubbleSort bubbleSort = new BubbleSort(mInts);
        MergeSort mergeSort = new MergeSort(mInts);
        SelectionSort selectionSort = new SelectionSort(mInts);
        InsertionSort insertionSort = new InsertionSort(mInts);

        switch (mode) {
            case MODE_CHECK:
                bubbleSort.sort();
                bubbleSort.sout();

                mergeSort.sort();
                mergeSort.sout();

                selectionSort.sort();
                selectionSort.sout();

                insertionSort.sort();
                insertionSort.sout();
                break;
            case MODE_THREAD:
                new Thread(() -> System.out.println("bubble time: " + bubbleSort.sort() + "ms")).start();

                new Thread(() -> System.out.println("merge time: " + mergeSort.sort() + "ms")).start();

                new Thread(() -> {
                    //与bubble一样都是 O(n^2) 但是减少了swap的操作次数
                    System.out.println("selection time: " + selectionSort.sort() + "ms");
                }).start();

                new Thread(() -> {
                    //最好 O(n) 平均 O(n^2) 但是是 in-place 的，只需 O(1) 的额外空间
                    System.out.println("insertion time:" + insertionSort.sort() + "ms");
                }).start();
                break;
            case MODE_DEFAULT:
                System.out.println("bubble time: " + bubbleSort.sort() + "ms");
                System.out.println("merge time: " + mergeSort.sort() + "ms");
                System.out.println("selection time: " + selectionSort.sort() + "ms");
                System.out.println("insertion time:" + insertionSort.sort() + "ms");
                break;
        }
    }
}
