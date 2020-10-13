package tree;

/** 给定一个有序数组，构建一棵二叉树
 * @author LiuZhulan
 */
public class BuildTreeNodeByArray {

    public static TreeNode build(int [] arr,int l,int r){

        TreeNode treeNode=null;
        if(l<=r){
            treeNode=new TreeNode();
            int mid=(l+r+1)/2;
            treeNode.val=arr[mid];
            treeNode.left=build(arr,l,mid-1);
            treeNode.right=build(arr,mid+1,r);
        }else {
            return null;
        }
        return treeNode;

    }

    public static TreeNode buildSimpleTree(){
        int[] arr={3,9,10,20,15,7};
        return BuildTreeNodeByArray.build(arr, 0, arr.length - 1);
    }
}
