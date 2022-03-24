class Day3_24 {
    fun rotate(matrix: Array<IntArray>): Unit {
        for (i in matrix.indices){
            for (j in 0 until i){
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
        val n = matrix.size
        for (i in matrix.indices){
            for (j in 0 until n/2){ // notice
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][n-1-j]
                matrix[i][n-1-j] = temp
            }
        }
    }


    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<Map<Char, Int>, ArrayList<String>>()
        for (s in strs){
            val key = countMap(s) // 也可以排序
            if (map.containsKey(key)){
                map[key]!!.add(s)
            }else{
                val list = ArrayList<String>()
                list.add(s)
                map[key] = list
            }
        }
        val res = mutableListOf<List<String>>()
        res.addAll(map.values)
        return res
    }

    fun countMap(s: String):Map<Char, Int>{
        val map = mutableMapOf<Char, Int>()
        for (c in s){
            if (map.containsKey(c)){
                map[c] = map[c]!! + 1
            }else{
                map[c] = 1
            }
        }
        return map
    }

    fun subsets(nums: IntArray): List<List<Int>> {
        val track = ArrayList<Int>()
        val res = ArrayList<List<Int>>()
        subsetBacktrack(nums, track, res, 0)
        return res
    }

    private fun subsetBacktrack(nums: IntArray, track: ArrayList<Int>, res: ArrayList<List<Int>>, start: Int){
        res.add(ArrayList(track))
        for (i in start until nums.size){
            track.add(nums[i])
            subsetBacktrack(nums, track, res, i+1)
            track.removeAt(track.size - 1)
        }
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (i in board.indices){
            for (j in board[0].indices){
                if (existBacktrack(board, word, i, j)){
                    return true
                }
            }

        }
        return false
    }

    private fun existBacktrack(board: Array<CharArray>, word: String, i: Int, j: Int): Boolean{
        if (word.isEmpty()) return true
        word.slice(1 until word.length)
        if (i < 0 || i >= board.size || j < 0 || j >= board[0].size || board[i][j] != word[0]){
            return false
        }
        val remainStr = word.slice(1 until word.length)
        val temp = board[i][j]
        board[i][j] = '#'
        val res = existBacktrack(board, remainStr,i+1, j) ||
                existBacktrack(board, remainStr, i, j+1) ||
                existBacktrack(board, remainStr, i-1, j) ||
                existBacktrack(board, remainStr, i, j-1)
        board[i][j] = temp
        return res
    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var pm = m-1
        var pn = n-1
        var tail = m+n-1
        while (pm >= 0 && pn >= 0){
            if (nums1[pm] > nums2[pn]){
                nums1[tail] = nums1[pm]
                pm--
            }else{
                nums1[tail] = nums2[pn]
                pn--
            }
            tail--
        }
        while (pn >= 0){
            nums1[pn] = nums2[pn]
            pn--
        }
    }
}

fun main(){
    val s = Day3_24()
//    val matrix = arrayOf(
//        intArrayOf(1,2,3),
//        intArrayOf(4,5,6),
//        intArrayOf(7,8,9)
//    )
//    println(s.rotate(matrix))
//    println(matrix[0].asList())
//    println(matrix[1].asList())
//    println(matrix[2].asList())
//    println(mapOf('d' to 2,'c' to 1) == mapOf('c' to 1, 'd' to 2))
//    println(s.groupAnagrams(arrayOf("qwee","eewq","weq","ewr","rew","rty","fgh")))
//    println(s.subsets(intArrayOf(1,2,3)))
    val nums1 = intArrayOf(2,3,5,0,0,0)
    val nums2 = intArrayOf(1,4,6)
    s.merge(nums1, 3, nums2, 3)
    println(nums1.toList())

}