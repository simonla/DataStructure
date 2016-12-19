package tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by simonla on 2016/11/30.
 * Have a good day!
 */
public class BinTree<T> {
    private int mHigh = -1;
    private BinNode<T> mRoot;

    BinTree(BinNode<T> root) {
        mRoot = root;
    }

    BinNode getRoot() {
        return mRoot;
    }

    private void visit(BinNode node) {
        System.out.println(node.getData());
    }

    //中序递归
    void traverSeInR(BinNode node) {
        if (node == null) return;
        traverSeInR(node.getLChild());
        visit(node);
        traverSeInR(node.getRChild());
    }

    //先序递归
    void traverPreR(BinNode node) {
        if (node == null) return;
        visit(node);
        traverPreR(node.getLChild());
        traverPreR(node.getRChild());
    }

    //后序递归
    void traverPostR(BinNode node) {
        if (node == null) return;
        traverPostR(node.getLChild());
        traverPostR(node.getRChild());
        visit(node);
    }

    //先序迭代
    void traverPreI(BinNode node) {
        Stack<BinNode> stack = new Stack<>();
        while (true) {
            visitAlongLeftBranch(node, stack);
            if(stack.empty()) break;
            node = stack.pop();
        }
    }

    //中序迭代
    void traverInI(BinNode node) {
        Stack<BinNode> stack = new Stack<>();
        while (true) {
            goAlongLeftBranch(node, stack);
            if(stack.empty()) break;
            node = stack.pop();
            visit(node);
            node = node.getRChild();
        }
    }

    //层序遍历
    void traverLevel(BinNode node) {
        Queue<BinNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            visit(node);
            if(node.getLChild()!=null) queue.add(node.getLChild());
            if(node.getRChild()!=null) queue.add(node.getRChild());
        }
    }

    private void goAlongLeftBranch(BinNode node, Stack<BinNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.getLChild();
        }
    }

    private void visitAlongLeftBranch(BinNode node, Stack<BinNode> stack) {
        while (node != null) {
            stack.push(node.getRChild());
            visit(node);
            node = node.getLChild();
        }
    }
}