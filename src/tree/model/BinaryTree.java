package tree.model;

import utils.Log;
import utils.StringUtils;
import utils.ToolUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private List<TreeNode> nodeList;

    public static BinaryTree create() {
        return create("A", "B", "C", "D", "E", "F", "G", "H", "I");
    }

    public static BinaryTree create(String... sources) {
        BinaryTree tree = new BinaryTree();
        if (ToolUtils.isEmpty(sources)) return tree;

        final int length = sources.length;

        tree.nodeList = new ArrayList<>(length);

        //源数据
        List<String> sourceList = Arrays.asList(sources);

        //填入数据
        for (int i = 0; i < length; i++) {
            if (ToolUtils.isEmpty(sourceList)) break;
            if (tree.nodeList.size() == 0) {
                //随机取一个值作为根节点
                int rootIndex = sRandom.nextInt(sourceList.size());
                String rootData = sourceList.remove(rootIndex);
                tree.nodeList.add(new TreeNode("root : " + rootData));
            } else {
                String childData = sourceList.remove(sRandom.nextInt(sourceList.size()));
                tree.nodeList.add(new TreeNode(childData));
            }
        }


        //往父节点填入子节点，留下最后一个父节点处理，因为它可能没有右孩子
        for (int i = 0; i < length / 2 - 1; i++) {
            //第n个节点的左孩子是2n，右孩子是2n+1
            //如 1(2,3),2(4,5),3(6,7)
            //因为list从0开始计数，因此+1
            tree.nodeList.get(i).setLeft(tree.nodeList.get(i * 2 + 1));
            tree.nodeList.get(i).setRight(tree.nodeList.get(i * 2 + 2));
        }

        //留下最后一个父节点

        int lastIndex = length / 2 - 1;
        tree.nodeList.get(lastIndex).setLeft(tree.nodeList.get(lastIndex * 2 + 1));
        if (tree.nodeList.size() % 2 == 1) {
            //如果有奇数个节点，最后一个父节点才有右孩子
            tree.nodeList.get(lastIndex).setRight(tree.nodeList.get(lastIndex * 2 + 2));
        }

        Log.debug("=========构建完成，打印如下=========");
        StringBuilder builder = new StringBuilder();
        for (TreeNode treeNode : tree.nodeList) {
            builder.append(treeNode.getData());
            if (treeNode.getLeft() != null) {
                builder.append(" [ left = ")
                        .append(treeNode.getLeft().getData());
            }
            if (treeNode.getRight() != null) {
                builder.append(" , right = ")
                        .append(treeNode.getRight().getData())
                        .append("] , ");
            } else {
                builder.append(" , right = empty] , ");
            }
        }
        Log.debug(builder.toString());

        return tree;
    }

}
