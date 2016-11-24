package sort;

import java.util.Random;

/**
 * Created by simonla on 2016/11/20.
 * Have a good day!
 */
public class Test {

    private static final int TEST_SCALE = 10;

    public static void main(String[] args) {
        Integer[] ints = new Integer[TEST_SCALE];

        for (int i = 0; i < TEST_SCALE; i++) {
            ints[i] = new Random().nextInt();
        }

        new Thread(() -> {
            BubbleSort bubbleSort = new BubbleSort(ints);
            System.out.println("bubble time: " + bubbleSort.sort() + "ms");
        }).start();

        new Thread(() -> {
            MergeSort mergeSort = new MergeSort(ints);
            System.out.println("merge time: " + mergeSort.sort() + "ms");
        }).start();

        new Thread(() -> {
            //与bubble一样都是 O(n^2) 但是减少了swap的操作次数
            SelectionSort selectionSort = new SelectionSort(ints);
            System.out.println("selection time: " + selectionSort.sort() + "ms");
        }).start();

        new Thread(() -> {
            //最好 O(n) 平均 O(n^2) 但是是 in-place 的，只需 O(1) 的额外空间
            InsertionSort insertionSort = new InsertionSort(ints);
            System.out.println("insertion time:" + insertionSort.sort() + "ms");
        }).start();

        // FIXME: 2016/11/21 不知道为什么传进去的东西明明不一样，却又一样
        //check(bubbleSort.getInts(), mergeSort.getInts());
        //check(bubbleSort.getInts(), selectionSort.getInts());
    }

    private static void check(Integer[] checked, Integer[] target) {
        boolean isRight = true;
        for (int i = 0; i < TEST_SCALE - 1; i++) {
            if (checked[i].intValue() != target[i].intValue()) {
                isRight = false;
                break;
            }
        }
        System.out.println("正确性检查: " + isRight);
    }
}
