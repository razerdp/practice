package tree.model;

public class TreeNode {
    private String data;

    private TreeNode lChild;
    private TreeNode rChild;

    public TreeNode() {
    }

    public TreeNode(String data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return lChild;
    }

    public TreeNode setLeft(TreeNode lChild) {
        this.lChild = lChild;
        return this;
    }

    public TreeNode getRight() {
        return rChild;
    }

    public TreeNode setRight(TreeNode rChild) {
        this.rChild = rChild;
        return this;
    }

    public String getData() {
        return data;
    }

    public TreeNode setData(String data) {
        this.data = data;
        return this;
    }


    @Override
    public String toString() {
        return data;
    }

}
