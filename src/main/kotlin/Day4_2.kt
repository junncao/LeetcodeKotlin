class Day4_2 {

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        //建立一个二维dp数组，dp[i][j] = dp[i-1][j]+dp[i][j-1]
        //if obstacleGrid[i][j]==1 then dp[i][j]=0
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        val dp = Array(m+1) { IntArray(n+1){ 0 } }
        dp[1][1] = 1 - obstacleGrid[0][0]
        for (i in 1 until m+1){
            for (j in 1 until n+1){
                if (i == 1 && j == 1) continue
                if (obstacleGrid[i-1][j-1] == 1){
                    dp[i][j] = 0
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]
                }
            }
        }
        return dp[m][n]
    }

    fun minPathSum(grid: Array<IntArray>): Int {
        for (i in 1 until grid.size){
            grid[i][0] = grid[i-1][0] + grid[i][0]
        }
        for (j in 1 until grid[0].size){
            grid[0][j] = grid[0][j-1] + grid[0][j]
        }
        for (i in 1 until grid.size){
            for (j in 1 until grid[0].size){
                grid[i][j] = kotlin.math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j]
            }
        }
        return grid.last().last()
    }

    fun climbStairs(n: Int): Int {
        val dp = IntArray(n+1 ){1}
        for (i in 2 until dp.size){
            dp[i] = dp[i-1] + dp[i-2]
        }
        return dp[n]
    }
}

fun main(){
    val s = Day4_2()
    println(s.uniquePathsWithObstacles(
        arrayOf(intArrayOf(0,0,0),
        intArrayOf(0,1,0),
        intArrayOf(0,0,0))
    ))
}