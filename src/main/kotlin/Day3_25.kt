import java.util.*
import kotlin.collections.ArrayList

class Day3_25 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val res = ArrayList<IntArray>()
        intervals.sortBy { it[0] }
        for (interval in intervals){
            if (res.isEmpty() || res.last()[1] < interval[0]){
                res.add(interval)
            }else{
                res.last()[1] = kotlin.math.max(interval[1], res.last()[1])
            }
        }
        return res.toTypedArray()
    }
}

fun main(){
    val s = Day3_25()
    val res = s.merge(arrayOf(intArrayOf(1,4), intArrayOf(2,3), intArrayOf(6,7)))
    println(res[0].toList())
    println(res[1].toList())
}