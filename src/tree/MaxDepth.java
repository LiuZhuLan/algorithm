package tree;

/** 二叉树的最大深度
 * @author LiuZhulan
 */
public class MaxDepth {

    public static void main(String[] args) {
        TreeNode treeNode = BuildTreeNodeByArray.buildSimpleTree();
        System.out.println(new MaxDepth().maxDepth(treeNode));
    }

    /**
     * 时间复杂度：O(n)O(n)，其中 nn 为二叉树节点的个数。每个节点在递归中只被遍历一次。
     * 空间复杂度：O(height)，其中 height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，
     * 因此空间复杂度等价于二叉树的高度
     *
     * @param node
     * @return
     */
    public int maxDepth(TreeNode node){

        if(node==null){
            return 0;
        }
        //当前节点是1的高度，然后取左右子树高度的最大值
        return Math.max(maxDepth(node.left),maxDepth(node.right))+1;

    }
}
