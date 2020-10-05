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
            tmp.setItem(i);
            tmp.setNext(null);
            cur.setNext(tmp);
            cur = tmp;
        }

        return head;

    }

    public static void print(Node head) {

        Node cur = head;
        for (cur = head.getNext(); cur != null; cur = cur.getNext()) {
            System.out.print(cur.getItem() + "->");
        }
    }
}
