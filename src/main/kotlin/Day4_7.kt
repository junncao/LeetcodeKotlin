import kotlin.math.pow

class Day4_7 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null){
            return null
        }
        if (p == root || q == root){
            return root
        }
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        if (left != null && right != null){
            return root
        }
        return left?:right

    }
    fun countNodes(root: TreeNode?): Int {
        var l = root
        var r = root
        var leftHeight = 0
        var rightHeight = 0
        while (l != null){
            l = l.left
            leftHeight++
        }
        while (r != null){
            r = r.right
            rightHeight++
        }
        return if (leftHeight == rightHeight) {
            2.0.pow(leftHeight).toInt()  - 1
        }else{
            1 + countNodes(root?.left) + countNodes(root?.right)
        }
    }

}