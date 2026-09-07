class Solution {
     public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }
        List<Integer> keys = new ArrayList<>(countMap.keySet());
        keys.sort((a,b) -> countMap.get(b) - countMap.get(a));

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = keys.get(i);
        }
        return result;
    }
}
