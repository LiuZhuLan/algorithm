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


    public static void main(String[] args) {
        Node head = NodeUtil.build(5);
        NodeUtil.print(head);
        System.out.println();
        Reverse1 reverse1=new Reverse1();
        reverse1.reverse(head);
        NodeUtil.print(head);
    }
}
