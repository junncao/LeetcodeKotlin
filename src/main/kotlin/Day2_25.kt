import kotlin.math.max

class Day2_25{
    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */

    class Solution {
        fun maxPathSum(root: TreeNode?): Int {
            var maxSum = Int.MIN_VALUE
            fun maxGain(root: TreeNode?): Int{
                if (root == null){
                    return 0
                }
                val leftMax = max(maxGain(root.left), 0)
                val rightMax = max(maxGain(root.right), 0)
                maxSum = max(leftMax + rightMax + root.`val`, maxSum)
                return max(leftMax, rightMax) + root.`val`  // 对父节点的贡献

            }
            maxGain(root)
            return maxSum
        }
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        var preIndex = 0
        fun arrayToTree(leftIndex: Int, rightIndex: Int): TreeNode? {
            if (leftIndex > rightIndex) return null
            val indexInorder = inorder.indexOf(preorder[preIndex])
            val root = TreeNode(preorder[preIndex++])
            root.left = arrayToTree(leftIndex, indexInorder - 1)
            root.right = arrayToTree(indexInorder + 1, rightIndex)
            return root
        }
        return arrayToTree(0, preorder.size - 1)
    }

    fun preTraverse(node: TreeNode?){
        if (node == null) return
        println(node.`val`)
        preTraverse(node.left)
        preTraverse(node.right)
    }

    fun inorderTraverse(node: TreeNode?){
        if (node == null) return
        inorderTraverse(node.left)
        println(node.`val`)
        inorderTraverse(node.right)
    }
}
fun main(args: Array<String>){
    val res = Day2_25().buildTree(intArrayOf(1 ,2 ,3 ,4 ,5 ,6, 7), intArrayOf(3, 2, 4, 1, 6, 5, 7))
    println(Day2_25().inorderTraverse(res))
}