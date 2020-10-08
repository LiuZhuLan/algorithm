package linkedList;

/**
 * 删除链表的倒数第n个节点
 * @author LiuZhulan
 */
public class RemoveNthFromEnd {

    public Node removeNthFromEnd(Node head, int n) {
        if(head==null){
            return head;
        }
        Node tmp=head;
        Node slow=head;
        Node fast=head;
        for(int i=0;i< n;i++){
            fast=fast.next;
        }
        /**
         * 无头结点的链表在删除第一个节点时候的特殊性，导致需要这样的判断
         */
        if(fast==null){
            return slow.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;
        return tmp;
    }

    public static void main(String[] args) {

        Node node = NodeUtil.buildWithoutHead(6);
        RemoveNthFromEnd r=new RemoveNthFromEnd();
        Node node1 = r.removeNthFromEnd(node, 6);
        NodeUtil.printWithoutHead(node1);
    }
}
