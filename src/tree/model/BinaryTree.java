package tree.model;

import java.util.Random;

/**
 * 二叉树
 * 二叉树的定义：或为空，或只有根节点，或有左子树和右子树（5种基本形态）
 * 二叉树性质：
 * 1、在二叉树的第i层上至多有2^(i-1)个结点（i>=1）
 * 2、深度为k的二叉树至多有2^(k) - 1个结点（k>=1）
 * 3、对于任何一颗二叉树，如果其终端结点数为n，度数为2的结点数为m，则n = m + 1 * 4、具有n个结点的完全二叉树的深度为k = floor(log2(n)) + 1
 * 5、在含有n个结点的二叉链表中有n+1个空链域
 */
public class BinaryTree {
    private static Random sRandom = new Random();

    private TreeNode root;

    public static BinaryTree create(int length) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode("root");

        String[] datas = {"A","B","C","D","E","F","G","H","I"};
        int index = sRandom.nextInt(datas.length);

        while (index < length) {
            boolean isLeftNull = sRandom.nextBoolean();
            boolean isRightNull = sRandom.nextBoolean();
            while (isLeftNull && isRightNull) {
                isLeftNull = sRandom.nextBoolean();
                isRightNull = sRandom.nextBoolean();
            }
        }


    }

}
