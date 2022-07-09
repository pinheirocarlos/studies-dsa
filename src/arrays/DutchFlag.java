package arrays;

import java.util.Arrays;

public class DutchFlag {

    private int[] nums;

    public static void main(String[] args) {
        int[] teste = {1,0,1,2,0,1};
        DutchFlag dutchFlag = new DutchFlag(teste);
        dutchFlag.solve();
    }

    public DutchFlag(int[] nums){
        this.nums = nums;
    }

    public void solve() {
        int i = 0;
        int j = 0;
        int pivot = 1;
        int k = nums.length - 1;

        //linear running time O(N)
        while (j <= k) {
            if (nums[j] < pivot) {
                swap(i, j);
                i++;
                j++;
            } else if (nums[j] > pivot) {
                swap(j, k);
                k--;
            } else {
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));

    }

    public void swap(int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
