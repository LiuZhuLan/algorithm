package tree;

import tree.BuildTreeNodeByArray;
import tree.TreeNode;

/**
 * @author LiuZhulan
 */
public class Test {

    public static void main(String[] args) {
        int[] arr={3,9,10,20,15,7};
        TreeNode build = BuildTreeNodeByArray.build(arr, 0, arr.length - 1);
        LevelOrder l=new LevelOrder();
        System.out.println(l.levelOrder(build));
    }
}
