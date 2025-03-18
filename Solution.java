import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            System.out.println("for constant : " + i);
            int left = i + 1;
            int right = nums.length-1;

            while(left < right){
                if(nums[left] + nums[right] + nums[i] == 0){
                    System.out.print("coordinates");
                    System.out.print(left);
                    System.out.print(right);
                    result.add(Arrays.asList(nums[i],nums[left], nums[right]));
                    left++;
                    right--;
                }else if (nums[left] + nums[right] + nums[i] > 0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }

    public int removeDuplicates(int[] nums){
        int p1 = 0;
        int p2 = 1;

        while(p2 < nums.length){
            if (nums[p1] != nums[p2]){
                p1++;
                nums[p1] = nums[p2];
            }
            p2++;
        }

        return p1;
    }
}
