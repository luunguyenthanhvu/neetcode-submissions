class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            int count = map.merge(n, 1, Integer::sum);
            if (count > nums.length / 2) {
                return n;
            }
        }
        return 0;
    }
}