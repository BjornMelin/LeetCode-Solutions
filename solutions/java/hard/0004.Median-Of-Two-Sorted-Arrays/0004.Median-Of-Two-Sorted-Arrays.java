class Solution {

    /**
     * Solution To Find Median Of The Two Sorted Arrays Uses A Binary Search Implementation
     * To Ignore Half Of Each Array In Each Step Recursively By Comparing Medians Of Remaining Arrays Each Step.
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Default edge case checks for invalid inputs
        if (nums1 == null || nums2 == null
            || nums1.length < 0 || nums2.length < 0
            || nums1.length > 1000 || nums2.length > 1000)
        {
            return 0.0;
        }

        int m = nums1.length;           // nums1 array is of size m
        int n = nums2.length;           // nums2 array is of size n

        // Note we leave as integers so we can reference an index, java auto throws away remainder after the decimal when int
        int left = (m + n + 1) / 2;     // Left middle index in the merged array of nums1 & nums2
        int right = (m + n + 2) / 2;    // Right middle index in the merged array of nums1 & nums2

        // Recursively find the median of the two sorted arrays
        double medianInMerged = (findKthHelper(nums1, nums2, 0, 0, left) + findKthHelper(nums1, nums2, 0, 0, right)) / 2;
        return medianInMerged;
    }

    /**
     * Finds The Kth Element From Two Combined Arrays A + B.
     * If the nums1.length + nums2.length is odd, the 2 function will return the same number
     * Else if nums1.length + nums2.length is even, the 2 function will return the left number and right number that make up a median
     */
    private double findKthHelper(int[] A, int[] B, int aStart, int bStart, int k) {
        // All elements in array A have been searched, return kth element in array B
        if (aStart > A.length - 1)
        {
            return B[bStart + k - 1];
        }
        // All elements in array B have been searched, return kth element in array A
        if (bStart > B.length - 1)
        {
            return A[aStart + k - 1];
        }
        // When only searching one element (k = 1), return the min of the two first numbers in A and B
        if (k == 1)
        {
            return Math.min(A[aStart], B[bStart]);
        }

        // Init ints used to store middle index values from A and B
        int aMid = Integer.MAX_VALUE;
        int bMid = Integer.MAX_VALUE;

        // Find the middle element in array A
        if (aStart + (k / 2) - 1 < A.length)
        {
            aMid = A[aStart + (k / 2) - 1];
        }
        // Find the middle element in array B
        if (bStart + (k / 2) - 1 < B.length)
        {
            bMid = B[bStart + (k / 2) - 1];
        }

        // Compare middle values in A and B then dispose of half of the one of A or B and divide k by 2
        if (aMid < bMid)
        {
            // Recursively call function to find kth element in the the right side of A and B combined
            return findKthHelper(A, B, aStart + (k / 2), bStart, k - (k / 2));
        }
        else
        {
            // Recursively call function to find kth element A and the right side of B
            return findKthHelper(A, B, aStart, bStart + (k / 2), k - (k / 2));
        }
    }

}
