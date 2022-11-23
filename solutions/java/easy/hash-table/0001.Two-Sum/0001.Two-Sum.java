class Solution {
    /**
     * Single-Pass Hash Table Used To Determine The Two Numbers In The Input Array That Add Up To The Target Number.
     * Definition - Complement: The number derived by subtracting a number from a base number (target).
     *
     * Time: O(n) - Iterate all nums from the input array once O(n). In each iteration, we perform a lookup for
     *              the current nums complement in the Hash Table in O(1) time. Thus O(n) time.
     * Space: O(n) - Worst case size of the Hash Table is the size of the input, thus we need O(n) space.
     */
    public int[] twoSum(int[] nums, int target) {
        // Default null/empty check
        if (nums == null || nums.length < 2 || nums.length > Math.pow(10, 4)) return null;

        // Init a Hash Table to store as key the int value at nums[index] and the index its located as value
        Map<Integer, Integer> hashTable = new HashMap<Integer, Integer>();

        // Iterate through all elements from input nums arr, inserting e/ element into the hashTable w/ value as key
        // and index (i) as value. Before insertion, check if there already exists an entry in the hashTable equal to
        // the current value at nums[i]'s complement of the target
        for (int i = 0; i < nums.length; i++)
        {
            // Find the complement of the current value of nums[i] that needs to be added to nums[i] to get to target
            int complement = target - nums[i];

            // Check if hashTable contains the current nums complement. If so, the answer has been found
            if (hashTable.containsKey(complement))
            {
                // Return a 2 element int arr containing the index in nums where the complement of nums[i] was found and i
                return new int[] { i, hashTable.get(complement) };
            }

            // Insert the current element into the Hash Table when no solution is found
            hashTable.put(nums[i], i);
        }

        // Default case where no two numbers add up to the target in the input nums array
        return null;
    }


    /**
     * Brute Force Approach Which Checks Each Element Of Input Array With All Other Elements Against Target.
     *
     * Time: O(n^2) - Iterate all nums from the input array and for e/ element, check against all other nums
     *                in the input to find complement. O(n) for each num in input arr so O(n^2) total.
     * Space: O(1) - Constant space used for the return value, independent from size of the input.
     */
    // public int[] twoSum(int[] nums, int target) {
    //     // Default null/empty check
    //     if (nums == null || nums.length < 2 || nums.length > Math.pow(10, 4)) return null;

    //     // Iterate through all nums excluding the last num in nums array and check all
    //     // other indices in nums after nums[i] to find target sum
    //     for (int i = 0; i < nums.length - 1; i++)
    //     {
    //         // Iterate through all nums in nums array starting one element after nums[i]
    //         // and check if nums[i] + nums[j] = target
    //         for (int j = i + 1; j < nums.length; j++)
    //         {
    //             // Check if the current num found at nums[j] is the complement of nums[i] needed to sum to the target
    //             if (nums[j] == target - nums[i])
    //             {
    //                 // Return a 2 element int arr containing the indices in nums that add up to the target int
    //                 return new int[] { i, j };
    //             }
    //         }
    //     }

    //     // Default case where no two numbers from the input nums array add up to the target
    //     return null;
    // }

}
