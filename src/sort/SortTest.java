package sort;

import java.util.Random;

/**
 * Created by simonla on 2016/11/20.
 * Have a good day!
 */
public class SortTest {

    private static final int TEST_SCALE = 1000/2;

    private static final int MODE_THREAD = 0;
    private static final int MODE_DEFAULT = 1;
    private static final int MODE_CHECK = 2;
    private static final int MODE_FAST_GROUP = 3;
    private static final int MODE_SLOW_GROUP = 4;

    private static Integer[] mInts = new Integer[TEST_SCALE];

    public static void main(String[] args) {
        //mInts = getRandomArr();
        mInts = getRandomArr();
        doTest(MODE_CHECK);
        //QuickSort quickSort = new QuickSort(mInts);
        //printTime(quickSort);
    }

    private static void doTest(int mode) {
        BubbleSort bubbleSort = new BubbleSort(mInts);
        MergeSort mergeSort = new MergeSort(mInts);
        SelectionSort selectionSort = new SelectionSort(mInts);
        InsertionSort insertionSort = new InsertionSort(mInts);
        ShellSort shellSort = new ShellSort(mInts);
        QuickSort quickSort = new QuickSort(mInts);
        HeapSort heapSort = new HeapSort(mInts);

        switch (mode) {
            case MODE_CHECK:
                System.out.println(bubbleSort.getClass().getName() + " ==> " + bubbleSort.check());
                System.out.println(mergeSort.getClass().getName() + " ==> " + mergeSort.check());
                System.out.println(selectionSort.getClass().getName() + " ==> " + selectionSort.check());
                System.out.println(insertionSort.getClass().getName() + " ==> " + insertionSort.check());
                System.out.println(shellSort.getClass().getName() + " ==> " + shellSort.check());
                System.out.println(quickSort.getClass().getName() + " ==>" + quickSort.check());
                System.out.println(heapSort.getClass().getName() + " ==>" + heapSort.check());
                break;
            case MODE_THREAD:
                new Thread(() -> printTime(bubbleSort)).start();
                new Thread(() -> printTime(mergeSort)).start();
                new Thread(() -> printTime(selectionSort)).start();
                new Thread(() -> printTime(insertionSort)).start();

                new Thread(() -> printTime(shellSort)).start();
                new Thread(() -> printTime(quickSort)).start();
                new Thread(() -> printTime(heapSort)).start();
                break;
            case MODE_DEFAULT:
                long bubbleSortTime = bubbleSort.sort();
                new Thread(() -> printMultiple(mergeSort, bubbleSortTime)).start();
                new Thread(() -> printMultiple(insertionSort, bubbleSortTime)).start();
                new Thread(() -> printMultiple(selectionSort, bubbleSortTime)).start();
                new Thread(() -> printMultiple(shellSort, bubbleSortTime)).start();
                new Thread(() -> printMultiple(quickSort, bubbleSortTime)).start();
                new Thread(() -> printMultiple(heapSort, bubbleSortTime)).start();
                break;
            case MODE_FAST_GROUP:
                printTime(quickSort);
                printTime(mergeSort);
                printTime(shellSort);
                printTime(heapSort);
                break;
            case MODE_SLOW_GROUP:
                printTime(insertionSort);
                printTime(selectionSort);
                printTime(bubbleSort);
        }
    }

    private static void printTime(Sort sort) {
        System.out.println(sort.getClass().getName() + " ==> " + sort.sort() + " ms");
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
        for (int i = 0; i < TEST_SCALE; arr[i++] = new Random().nextInt()) ;
        return arr;
    }

    private static Integer[] getSortedArr() {
        Integer[] arr = new Integer[TEST_SCALE];
        for (int i = 0; i < TEST_SCALE; arr[i++] = i) ;
        return arr;
    }

    private static Integer[] getRepetitiveArr() {
        Integer[] arr = new Integer[TEST_SCALE];
        int a = new Random().nextInt();
        for (int i = 0; i < TEST_SCALE; i++) {
            arr[i] = a;
        }
        return arr;
    }
}
