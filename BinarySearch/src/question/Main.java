package question;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(binarySearch(new int[]{1, 4, 6, 8, 10, 15, 27, 29, 30, 32, 56, 87}, 30));
    }

    public static int binarySearch(int[] arr, int search) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;

            if (arr[mid] > search)
                endIndex = mid - 1;
            else if (arr[mid] < search)
                startIndex = mid + 1;
            else
                return mid;
        }

        return -1;
    }
}
