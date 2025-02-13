public class array {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 5, 2, 6};
        int target = 2;
        int count = countOccurrences(arr, target);
        System.out.println("The number " + target + " appears " + count + " times in the array.");
    }

    public static int countOccurrences(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
}
