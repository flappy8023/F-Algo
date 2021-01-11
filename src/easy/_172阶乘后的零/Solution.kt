package easy._172阶乘后的零

//给定一个整数 n，返回 n! 结果尾数中零的数量
class Solution {
    //2*5才会产生0，  5!=1*2*(2*2)*5,2远比5多，计算5的个数
    fun trailingZeroes(n: Int): Int {
        var count = 0
        var temp = n
        while (temp >= 5) {
            count += temp / 5
            temp = temp / 5
        }
        return count
    }

}

fun main() {
    println(Solution().trailingZeroes(10))
}