package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiuZhulan
 */
public class LevelOrder {

    public static void main(String[] args) {


        TreeNode root=new TreeNode(3);
        TreeNode rootLeft=new TreeNode(6,null,null);
        TreeNode rootRight=new TreeNode(9);
        rootRight.left=new TreeNode(1,null,null);
        rootRight.right=new TreeNode(2,null,null);

        root.left=rootLeft;
        root.right=rootRight;

        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> lists = levelOrder.levelOrder(root);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();

        if(root==null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            //此处需要保存size，因为每次循环size都减1
            int size=queue.size();
            //循环次数为该层的节点数
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                temp.add(poll.val);
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            lists.add(temp);
        }

        return lists;
    }
}
