package linkedList;

/**
 * 插入法实现链表逆序
 * 参考链接：https://blog.csdn.net/qty4505861/article/details/90081863
 * @author LiuZhulan
 */
public class Reverse1 {

    private void reverse(Node head){
        if(head==null||head.next==null){
            return ;
        }
        /**
         * 前提：当前只能根据head和cur进行操作.第一个节点为尾节点，以第二个节点进行插入
         * 1.将节点1的下一个引用置为空
         * 2.将节点2的引用置为节点1
         * 3.将头节点的引用置为节点2
         * 4.
         */
        Node cur=head.next.next;
        head.next.next=null;
        Node next;
        while (cur!=null){
            next=cur.next;
            cur.next=head.next;
            head.next=cur;
            cur=next;
        }
    }

    /**
     * 核心：让第一个节点去和最后的null连接，然后依次迭代
     * 1.先保存第二个节点
     * 2.让第一个节点指向前面的节点，第一次即是节点最后
     * 3.更新pre节点为第一个节点，head赋值给pre
     * 4.循环迭代
     * @param head
     * @return
     */
    private Node reverseWithoutHead(Node head){
        if(head==null){
            return head;
        }

        Node pre=null;
        Node next;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public static void main(String[] args) {

        //带有头节点的链表反转
        Node head = NodeUtil.buildWithHead(5);
        NodeUtil.printWithHead(head);
        System.out.println();
        Reverse1 reverse1=new Reverse1();
        reverse1.reverse(head);
        NodeUtil.printWithHead(head);

        //不带头节点的链表反转
        System.out.println();
        Node head1 = NodeUtil.buildWithoutHead(5);
        NodeUtil.printWithoutHead(head1);
        System.out.println();
        Node node = reverse1.reverseWithoutHead(head1);
        NodeUtil.printWithoutHead(node);
    }
}
