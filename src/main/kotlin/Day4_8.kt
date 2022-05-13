import java.util.*
import kotlin.math.max


class Day4_8 {

    var res = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        maxDepth(root)
        return res
    }

    fun maxDepth(root:TreeNode?): Int{
        if (root == null){
            return 0
        }
        val left = maxDepth(root.left)
        val right = maxDepth(root.right)
        res = kotlin.math.max(left + right, res)
        return 1 + kotlin.math.max(left, right)
    }

    var curDepth = 0
    var maxDepth = 0

    fun maxDepth(root: NodeN?): Int {
        traverse(root)
        return maxDepth


    }

    fun traverse(root: NodeN?){
        if (root == null){
            return
        }
        curDepth++
        maxDepth = kotlin.math.max(curDepth, maxDepth)
        for (child in root.children){
            traverse(child)
        }
        curDepth--

    }

}

class Solution652{
    val map = mutableMapOf<String, Int>()
    val res = LinkedList<TreeNode>()
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        duplicateTraverse(root)
        return res
    }

    private fun duplicateTraverse(root: TreeNode?): String {
        if (root == null){
            return "#"
        }
        val left = duplicateTraverse(root.left)
        val right = duplicateTraverse(root.right)
        val subtree = "${left},${right},${root.`val`}"
        val count = map.getOrDefault(subtree, 0)
        if (count == 1){
            res.add(root)
        }
        map[subtree] = count + 1
        return subtree
    }
}