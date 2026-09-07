class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            map.merge(n, 1, Integer::sum);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());

        int n = nums.length / 2;
        int result = 0;
        int count = 0;
        for (int key : keys) {
            if (map.get(key) >= n && count < map.get(key)) {
                result = key;
                count = map.get(key);
            } 
        }
        return result;
    }
}