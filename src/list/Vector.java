package list;

import java.util.Random;

/**
 * Created by simonla on 2016/11/19.
 * Have a good day!
 */
public class Vector {
    private int mCapacity;
    private int mRank=0;
    private static final int DEFAULT_CAPACITY = 3;
    private Integer mElem[];

    public Vector(int capacity) {
        mCapacity = capacity;
        mElem = new Integer[mCapacity];
    }

    public Vector() {
        mElem = new Integer[mCapacity];
        mCapacity = DEFAULT_CAPACITY;
    }

    public int getSize() {
        return mElem.length;
    }

    public int getCapacity() {
        return mCapacity;
    }

    public int add(int elem,int rank) {
        expand();
        System.arraycopy(mElem, rank, mElem, rank + 1, mElem.length - rank);
        mElem[rank] = elem;
        return mRank;
    }

    public int add(int elem) {
       return add(elem, mElem.length);
    }

    private void expand() {
        if(mElem.length<mCapacity) return;
        if(mCapacity<DEFAULT_CAPACITY) mCapacity = DEFAULT_CAPACITY;
        Integer temp[] = mElem;
        mElem = new Integer[mCapacity >> 1];
        System.arraycopy(temp, 0, mElem, 0, temp.length);
    }

    private void shrink() {
        if(mCapacity<DEFAULT_CAPACITY<<1) return;
        if(mElem.length<<2>mCapacity) return;
        Integer[] temp = mElem;
        mElem = new Integer[mCapacity >>= 1];
        System.arraycopy(temp, 0, mElem, 0, temp.length);
    }

    public void unsort() {
        for (int i = 0; i < mElem.length; i++) {
            Random r = new Random();
            int random = r.nextInt(mElem.length);
            int temp = mElem[i];
            mElem[i] = mElem[random];
            mElem[random] = temp;
        }
    }

    public int find(int target) {
        for (int i = 0; i < mElem.length; i++) {
            if (mElem[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
