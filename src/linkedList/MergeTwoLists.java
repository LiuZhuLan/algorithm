package linkedList;

/** 递归合并两个有序链表
 * @author LiuZhulan
 */
public class MergeTwoLists {


    public Node mergeTwoLists(Node l1, Node l2) {

        if(l1==null){
            return  l2;
        }
        if(l2==null){
            return  l1;
        }
        if(l1.item<l2.item){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        Node node1=NodeUtil.buildWithoutHead(1,5);
        Node node2=NodeUtil.buildWithoutHead(6,10);
        MergeTwoLists n=new MergeTwoLists();
        NodeUtil.printWithoutHead(n.mergeTwoLists(node1,node2));
    }
}
