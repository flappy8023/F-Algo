package leetcode.easy._191位一的个数

class Solution {
    // you need treat n as an unsigned value

    fun hammingWeight(n:Int):Int {
        var temp = n
        var count = 0
        //每次判断最后一位是否为1，然后右移一位
        while (temp!=0){
            if(temp.and(1)==1){
                count++
            }
            temp=temp.ushr(1)
        }
        return count
    }

}

fun main() {
    println(Solution().hammingWeight(2))
}