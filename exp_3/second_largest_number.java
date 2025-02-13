public class second_largest_number {
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest && num != firstLargest) {
                secondLargest = num;
            }
        }

        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {12, 32, 22, 54, 39, 53, 19};
        int result = findSecondLargest(arr);
        System.out.println("The second largest number is: " + result);
    }
}
