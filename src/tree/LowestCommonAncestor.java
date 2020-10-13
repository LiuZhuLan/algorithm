package tree;

/**
 * 二叉树的最近公共祖先
 *   3
 *  6 5
 *  3和6的公共祖先是3
 * @author LiuZhulan
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

    }

    /**
     *  1.找到一个点，左边能找到p或q，右边能找到q和p，一定是最近的
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        if(root == null)        return null;
        //上面3和6的情况
        if(root.val == p.val || root.val == q.val)  return root;

        TreeNode findLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode findRight = lowestCommonAncestor(root.right, p, q);

        if(findLeft != null && findRight != null)
            return root;
        else if(findLeft == null)
            //左边找不到，找右边
            return findRight;
        else
            return findLeft;


    }
}
