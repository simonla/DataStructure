package tree;


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

    void traverSeInR(BinNode node) {
        if (node == null) return;
        traverSeInR(node.getLChild());
        visit(node);
        traverSeInR(node.getRChild());
    }

    void traverPreR(BinNode node) {
        if (node == null) return;
        visit(node);
        traverPreR(node.getLChild());
        traverPreR(node.getRChild());
    }

    void traverPostR(BinNode node) {
        if (node == null) return;
        traverPostR(node.getLChild());
        traverPostR(node.getRChild());
        visit(node);
    }

    void traverPreI(BinNode node) {
        Stack<BinNode> stack = new Stack<>();
        while (true) {
            visitAlongLeftBranch(node, stack);
            if (stack.empty()) break;
            node = stack.pop();
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