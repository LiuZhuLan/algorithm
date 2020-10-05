package linkedList;

/**
 * @author LiuZhulan
 */
public class NodeUtil {


    public static Node build(int n) {
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

    public static void print(Node head) {

        Node cur = head;
        for (cur = head.next; cur != null; cur = cur.next) {
            System.out.print(cur.item + "->");
        }
    }
}
