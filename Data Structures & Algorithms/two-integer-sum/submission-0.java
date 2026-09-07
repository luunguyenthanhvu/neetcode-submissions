class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap();
       for(int i = 0; i < nums.length; i++) {
            int dump = target - nums[i];
            if(map.containsKey(dump)) {
                return new int[] {map.get(dump), i};
            }
            map.put(nums[i], i);
       }
       return new int[]{};
    }
}
