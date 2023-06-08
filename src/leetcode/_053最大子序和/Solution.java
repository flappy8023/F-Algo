package leetcode._053最大子序和;

/*给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

        示例:

        输入: [-2,1,-3,4,-1,2,1,-5,4]
        输出: 6
        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
        进阶:

        如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。*/
public class Solution {

    //贪心算法
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum >= 0) {
                sum += nums[i];
            } else {//若该元素之前的所有元素之和小于0则抛弃
                sum = nums[i];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    // Kadane算法扫描一次整个数列的所有数值，
// 在每一个扫描点计算以该点数值为结束点的子数列的最大和（正数和）。
// 该子数列由两部分组成：以前一个位置为结束点的最大子数列、该位置的数值。
// 因为该算法用到了“最佳子结构”（以每个位置为终点的最大子数列都是基于其前一位置的最大子数列计算得出,
// 该算法可看成动态规划的一个例子。
// 状态转移方程：sum[i] = max{sum[i-1]+a[i],a[i]}
// 其中(sum[i]记录以a[i]为子序列末端的最大序子列连续和)
    public int maxSubArray1(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }


    //分治法
//
//    对于一个区间 [l, r]，我们可以维护四个量：
//
//    lSum 表示 [l, r] 内以 l 为左端点的最大子段和
//    rSum 表示 [l, r] 内以 r 为右端点的最大子段和
//    mSum 表示 [l, r]内的最大子段和
//    iSum 表示 [l, r] 的区间和
//    以下简称 [l, m]为 [l, r] 的「左子区间」，[m + 1, r] 为[l,r] 的「右子区间」。我们考虑如何维护这些量呢（如何通过左右子区间的信息合并得到 [l, r] 的信息）？对于长度为 1 的区间 [i, i]四个量的值都和 ai相等。对于长度大于 1的区间：
//
//    首先最好维护的是 iSum，区间 [l, r]的 iSum 就等于「左子区间」的 iSum 加上「右子区间」的 iSum。
//    对于 [l, r] 的 lSum，存在两种可能，它要么等于「左子区间」的 lSum，要么等于「左子区间」的 iSum 加上「右子区间」的 lSum，二者取大。
//    对于 [l, r] 的 rSum，同理，它要么等于「右子区间」的 rSum，要么等于「右子区间」的 iSum 加上「左子区间」的 rSum，二者取大。
//    当计算好上面的三个量之后，就很好计算 [l, r]的 mSum 了。我们可以考虑 [l, r]的 mSum 对应的区间是否跨越 m——它可能不跨越 m，也就是说 [l, r] 的 mSum 可能是「左子区间」的 mSum 和 「右子区间」的 mSum 中的一个；它也可能跨越 m，可能是「左子区间」的 rSum 和 「右子区间」的 lSum 求和。三者取大。
//    这样问题就得到了解决。
    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }

    }

    public int maxSubArray2(int nums[]) {
        return getInfo(nums, 0,nums.length-1).mSum;
    }

    public Status getInfo(int[] nums, int l, int r) {
        if (l == r) return new Status(nums[l], nums[l], nums[l], nums[l]);
        int m=(l+r)>>1;
        Status lSub = getInfo(nums,l,m        );
        Status rSub = getInfo(nums,m+1,r);
        return pushUp(lSub,rSub);
    }

    private Status pushUp(Status lSub, Status rSub) {
        int iSum = lSub.iSum+rSub.iSum;
        int lSum = Math.max(lSub.lSum,lSub.iSum+rSub.lSum);
        int rSum = Math.max(rSub.rSum,rSub.iSum+lSub.rSum);
        int mSum = Math.max(Math.max(lSub.mSum,rSub.mSum),lSub.rSum+rSub.lSum);
        return new Status(lSum,rSum,mSum,iSum);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution().maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution().maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
