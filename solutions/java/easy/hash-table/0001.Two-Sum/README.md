# [1. Two Sum](https://leetcode.com/problems/two-sum/)

---

# Problem Statement:  

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

### Example 1:
```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

### Example 2:
```
Input: nums = [3,2,4], target = 6
Output: [1,2]
```

### Example 3:
```
Input: nums = [3,3], target = 6
Output: [0,1]
```

### Constraints:
- ```2 <= nums.length <= 104```  
- ```-109 <= nums[i] <= 109```  
- ```-109 <= target <= 109```  
- **Only one valid answer exists.**  
 
**Follow-up:** Can you come up with an algorithm that is less than O(n2) time complexity?

---

# Approach
Java Solution to Two Sum. Provided solutions using a Single-Pass Hash Table as well as the Brute Force solution. Compared each solution and explained in detail how both work as well as Time and Space complexities of each implementation.

# Complexity
- **Time complexity (Hash Table):** $O(n)$ \- Iterate all nums from the input array once $O(n)$. In each iteration, we perform a lookup for  the current nums complement in the Hash Table in $O(1)$ time. Thus $O(n)$ time.
- **Time complexity (Brute Force):** $O(n^2)$ \- Iterate all nums from the input array $O(n)$ and for e/ element, check against all other nums in the input to find complement. $O(n)$ for each num in input arr so $O(n^2)$ total.

- **Space complexity (Hash Table):** $O(n)$ \- Worst case size of the Hash Table is the size of the input, thus we need $O(n)$ space.
- **Space complexity (Brute Force):** $O(1)$ \- Constant space used for the return value, independent from size of the input.
