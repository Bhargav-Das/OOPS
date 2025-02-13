public class missing_number {
    public static int findMissingNumber(int[] nums, int n) {
        int totalSum = n * (n + 1) / 2;
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num;
        }
        return totalSum - arraySum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 6, 2, 4};
        int n = 6; // Since the array should contain numbers from 1 to 6
        int missingNumber = findMissingNumber(nums, n);
        System.out.println("The missing number is: " + missingNumber);
    }
}
