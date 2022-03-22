class Day3_4 {
    fun minCoverString(s: String, t: String){
        val need = mutableMapOf<Char, Int>()
        val window = mutableMapOf<Char, Int>()
        for (c in t){
            if (need.contains(c)){
                need[c] = need[c]!! + 1
            }else{
                need[c] = 1
            }
        }
        var left = 0
        var right = 0
        var valid = 0
        while (right < s.length){
            val c = s[right]
            right++
            if (window.contains(c)){
                window[c] = window[c]!! + 1
            }else{
                window[c] = 1
            }
            if (window[c] == need[c]){
                valid++

            }
        }
    }
}