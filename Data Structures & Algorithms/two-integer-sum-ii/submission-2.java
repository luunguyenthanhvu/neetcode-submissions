class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int n=0; n < numbers.length; n++) {
            for (int m=0; m < numbers.length; m++) {
                if(numbers[n] + numbers[m] == target) {
                    return new int[]{n+1,m+1};
                }
            }
        }
        return new int[]{};
    }
}
