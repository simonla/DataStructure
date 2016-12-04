package tree;

/**
 * Created by simonla on 2016/12/2.
 * Have a good day!
 */
public class BinNode<T> {
    private T mData;
    private int mPosition;
    private BinNode<T> mLChild;
    private BinNode<T> mRChild;

    public BinNode(T data, int position) {
        mData = data;
        mPosition = position;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }

    public int getPosition() {
        return mPosition;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    public BinNode<T> getLChild() {
        return mLChild;
    }

    public BinNode<T> setLChild(BinNode<T> LChild) {
        mLChild = LChild;
        return this;
    }

    public BinNode<T> getRChild() {
        return mRChild;
    }

    public BinNode<T> setRChild(BinNode<T> RChild) {
        mRChild = RChild;
        return this;
    }
}
