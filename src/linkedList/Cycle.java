package linkedList;

/**
 * 判断链表是否有环
 * @author LiuZhulan
 */
public class Cycle {

    /**
     * 核心：快指针走两步，慢指针走一步，如果快指针为空或者快指针的next为空，那么就结束
     * @param head
     * @return
     */
    private boolean hasCycle(Node head){

        if(head==null||head.next==null){
            return false;
        }

        Node p=head;
        Node q=head;
        while (p!=null&&p.next!=null){
            p=p.next.next;
            q=q.next;
            if(p==q){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        n1.next=n2;
        n2.next=n3;
        n3.next=n1;
        Cycle cycle=new Cycle();
        System.out.println(cycle.hasCycle(n1));

    }
}
