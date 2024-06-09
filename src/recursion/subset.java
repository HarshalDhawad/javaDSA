package recursion;


import java.util.ArrayList;
import java.util.List;

public class subset {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        helper(nums, outer, inner, 0);
        return outer;
    }

    public static void helper(int[] nums, List<List<Integer>> outer, List<Integer> inner, int index) {
        if (nums.length == index) {
            outer.add(new ArrayList<>(inner)); // Add a copy of the inner list
            return;
        }
        // Exclude the current number
        helper(nums, outer, inner, index + 1);

        // Include the current number
        inner.add(nums[index]);
        helper(nums, outer, inner, index + 1);
        inner.remove(inner.size() - 1); // Backtrack to explore other possibilities
    }
}

