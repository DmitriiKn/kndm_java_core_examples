import java.util.ArrayList;
import java.util.List;

public class TwoPointers {

    public static void main(String[] args) {
        System.out.println(exclude(new int[]{1, 2, 4, 7}, new int[]{2, 4, 6}));
        System.out.println(exclude(new int[]{1, 2, 10, 20, 40, 70}, new int[]{2, 4, 6, 10}));
        System.out.println(exclude(new int[]{1, 2, 4, 7}, new int[]{20, 40, 60}));
    }

    private static List<Integer> exclude(int[] nums1, int[] nums2) {
        List<Integer> retVal = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length ) {
            int num1 = nums1[i];
            int num2 = nums2[j];
            if (num1 < num2) {
                retVal.add(num1);
                i++;
            }
            if (num1 == num2) {
                i++;
                j++;
            }
            if (num1 > num2) {
                j++;
            }
        }

        for (int k = i;  k < nums1.length; k++) {
            retVal.add(nums1[k]);
        }
        return retVal;
    }


}
