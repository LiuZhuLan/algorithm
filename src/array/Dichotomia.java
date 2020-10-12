package array;

import java.util.Arrays;
import java.util.List;

/** 二分法：如果目标值存在返回下标，否则返回 -1
 * @author LiuZhulan
 */
public class Dichotomia {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int[] ints=new int[integers.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=integers.get(i);
        }
        Dichotomia d=new Dichotomia();
        System.out.println(d.dichotomia(ints, 4));

    }

    public int dichotomia(int[] arr,int k){

        int l=0;
        int r=arr.length-1;
        while (l<=r){
            int mid =(l+r)/2;
            if(k<arr[mid]){
                r=mid-1;
            }else if(k>arr[mid]){
                l=mid+1;
            }else {
                return mid;
            }
        }

        return -1;
    }
}
