class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int result = Integer.MAX_VALUE;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            result = Math.min(nums[mid], result);
            if(nums[low] <= nums[mid]) {
                result = Math.min(result, nums[low]);
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        
        return result;
    }
}