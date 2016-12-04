package tree;

/**
 * Created by simonla on 2016/12/2.
 * Have a good day!
 */
public class BinTreeTest {
    public static void main(String[] args) {
        BinTree<Character> binTree = new BinTree<>(new BinNode<>('A', 1));
        binTree.getRoot().
                setLChild(new BinNode<Character>('B', 2)).
                getLChild().setLChild(new BinNode<Character>('D', 4)).setRChild(new BinNode<>('E', 5));
        binTree.getRoot().setRChild(new BinNode<Character>('C', 3)).getRChild()
                .setRChild(new BinNode<>('F', 6))
                .setLChild(new BinNode('G',7))
        .getLChild().setLChild(new BinNode('H',8))
        .setRChild(new BinNode<>('G',9));

        //binTree.traverSeInR(binTree.getRoot());
        //binTree.traverPreR(binTree.getRoot());
        //binTree.traverPostR(binTree.getRoot());
        binTree.traverInI(binTree.getRoot());
    }
}
