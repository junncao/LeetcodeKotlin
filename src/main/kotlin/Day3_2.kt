import kotlin.math.max

class Day3_2 {
    fun longestPalindrome(s: String): String{
        fun palindrome(l: Int, r: Int): String{
            var left = l
            var right = r
            while (left >= 0 && right < s.length && s[left] == s[right]){
                left--
                right++
            }
            return s.substring(left + 1, right)
        }
        var res = ""
        for (i in s.indices){
            val sub1 = palindrome(i, i)
            val sub2 = palindrome(i, i+1)
            res = if (res.length >= sub1.length) res else sub1
            res = if (res.length >= sub2.length) res else sub2
        }
        return res

    }
}

fun main() {
    val res = Day3_2().longestPalindrome("qwerewrqrqrrwefefedfv")
    println(res)
}