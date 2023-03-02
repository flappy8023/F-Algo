package base.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 20, 23, 45, 323, 455, 634, 667, 909, 999, 10101, 11010, 11101};
        System.out.println("双闭区间二分查找 23，index = " + doubleClose(arr, 23));
        System.out.println("双闭区间二分查找 24，index = " + doubleClose(arr, 24));
        System.out.println("左闭右开二分查找 23，index = " + leftCloseRightOpen(arr, 23));
        System.out.println("左闭右开二分查找 24，index = " + leftCloseRightOpen(arr, 24));

    }

    private static int doubleClose(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        //[0,0]是包含一个元素的,停止条件start>end
        while (start <= end) {
            //防止（start+end）int范围溢出
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {//说明在[start,mid]区间内
                end = mid - 1;
            } else if (target > arr[mid]) {//说明在[mid,end]区间内
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static int leftCloseRightOpen(int[] arr, int target) {
        int start = 0, end = arr.length;
        //[0,0)不包含元素，停止条件start=end
        while (start < end) {
            int mid = start + (end - start)/2;
            if (target < arr[mid]) {
                end = mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else return mid;
        }
        return -1;
    }
}
