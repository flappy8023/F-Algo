package base.sort;

public abstract class Sort {

    protected static int[] nums = new int[]{2,1,323,42,1,32,4,23424,45,0,23};
    public abstract void sort(int[] nums);

    protected void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
