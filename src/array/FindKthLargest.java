package array;

import java.util.PriorityQueue;

/**
 * 寻找数组的第K大元素(最小堆实现）
 * 最小堆同样适用于动态数组，即数组不是固定的
 * @author LiuZhulan
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums,int k){

        PriorityQueue<Integer> p=new PriorityQueue<Integer>(
                (n1,n2) -> n1-n2
        );

        for (int num : nums) {
            p.add(num);
            if(p.size()>k){
                p.poll();
            }
        }

        /**
         * 剩下的元素都是数组里面最大的，而且堆顶是元素是堆里面最小的，所以是第K大
         */
        return p.poll();
    }

    public static void main(String[] args) {
        int[] array={1,2,3,4,6,7,8,5};
        FindKthLargest f=new FindKthLargest();
        System.out.println(f.findKthLargest(array,5));
    }
}
