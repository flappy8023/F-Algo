package easy._190颠倒二进制位

class Solution {
    //    输入: 00000010100101000001111010011100
//    输出: 00111001011110000010100101000000
//    解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
//    因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000
    fun reverseBits(n: Int): Int {
        var temp = n
        var res = 0
        var power = 31
        while (temp!=0){
            res += (temp.and(1)).shl(power)
            temp = temp.shr(1)
            power--
        }
        return res
    }
}

fun main() {
    println(Solution().reverseBits(2))
}