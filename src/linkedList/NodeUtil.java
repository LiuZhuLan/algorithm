package linkedList;

/**
 * @author LiuZhulan
 */
public class NodeUtil {

    /**
     * 带头结点的链表，在第一个元素结点前插入和在其他位置的元素结点前插入的时候，都不会改变头指针的值
     * @param n
     * @return
     */
    public static Node buildWithHead(int n) {
        Node head = new Node();
        Node tmp;
        Node cur = head;
        for (int i = 1; i <= n; i++) {
            tmp = new Node();
            tmp.item = i;
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }

        return head;

    }

    /**
     * 不带头结点的链表，在第一个元素结点前插入的时候，会改变头指针的值
     * @param n
     * @return
     */
    public static Node buildWithoutHead(int n) {
        //首先初始化第一个结点
        Node head = new Node(1);
        Node cur = head;
        for (int i = 2; i <= n; i++) {
           cur.next=new Node(i);
           cur=cur.next;
        }

        return head;

    }


    public static void printWithHead(Node head) {

        Node cur = head;
        for (cur = head.next; cur != null; cur = cur.next) {
            System.out.print(cur.item + "->");
        }
    }

    public static void printWithoutHead(Node head) {

        Node cur = head;
        for (cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.item + "->");
        }
    }
}
