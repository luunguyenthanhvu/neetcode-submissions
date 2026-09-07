class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int n=0; n < numbers.length; n++) {
            int m = n+1;
            while(m < numbers.length) {
                if((numbers[n] + numbers[m]) != target ) {
                    m++;
                    continue;
                }
                return new int[] {n+1, m+1};
            }
        }
        return new int[]{};
    }
}
