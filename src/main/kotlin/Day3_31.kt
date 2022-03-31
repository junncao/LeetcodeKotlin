import com.sun.source.tree.Tree
import java.util.*
import kotlin.collections.LinkedHashMap

class Day3_31 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        var parents = mutableListOf<TreeNode>()
        val res = mutableListOf<List<Int>>()
        parents.add(root)
        while (parents.isNotEmpty()){
            val children = mutableListOf<TreeNode>()
            val tempList = mutableListOf<Int>()
            for (node in parents){
                tempList.add(node.`val`)
                if (node.left != null){
                    children.add(node.left!!)
                }
                if (node.right != null){
                    children.add(node.right!!)
                }
            }
            res.add(tempList)
            parents = children
        }
        return res
    }

    fun maxDepth(root: TreeNode?): Int {
        if (root == null){
            return 0
        }
        return kotlin.math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }

    fun flatten(root: TreeNode?): Unit {
        if (root == null) return
        flatten(root.left)
        flatten(root.right)
        val left = root.left
        val right = root.right
        root.left = null
        root.right = left
        var p = root!!
        while (p.right != null){
            p = p.right!!
        }
        p.right = right
    }

    fun connect(root: Node?): Node? {
        connectTwoNode(root?.left, root?.right)
        return root
    }

    fun connectTwoNode(left: Node?, right: Node?){
        if (left == null && right == null){
            return
        }
        left!!.next = right
        connectTwoNode(left.left, left.right)
        connectTwoNode(right!!.left,right.right)
        connectTwoNode(left.right, right.left)

    }

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val tempLeft = root.left
        root.left = root.right
        root.right = tempLeft
        invertTree(root.left)
        invertTree(root.right)
        return root
    }
    //从中序和后序来建立二叉树
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        var postIndex = postorder.size - 1
        fun arrayToTree(left: Int, right: Int): TreeNode?{
            if (left > right){
                return null
            }
            val inorderIndex = inorder.indexOf(postorder[postIndex])
            val root = TreeNode(postorder[postIndex--])
            //先右边再左边
            root.right = arrayToTree(inorderIndex + 1, right)
            root.left = arrayToTree(left, inorderIndex - 1)
            return root
        }
        return arrayToTree(0, postorder.size - 1)
    }

    fun sortedArrayToBST(nums: IntArray): TreeNode? {

        fun arrayToTree(left:Int, right:Int): TreeNode?{
            if (left > right) return null
            val mid = left + (right - left)/2
            val root = TreeNode(nums[mid])
            root.left = arrayToTree(left, mid - 1)
            root.right = arrayToTree(mid + 1, right)
            return root
        }
        return arrayToTree(0, nums.size - 1)
    }

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        //注意路劲的末尾一定要是叶子节点，也就是左右节点都是null
        if (root == null) return false
        if (root.left == null && root.right == null){
            return root.`val` == targetSum
        }
        return hasPathSum(root.left, targetSum - root.`val`) ||
                hasPathSum(root.right, targetSum - root.`val`)
    }

}
fun main(){
//    val s = Day3_31()
//    println(s.maxDepth(
//        TreeNode(2).apply {
//            left = TreeNode(3)
//            right = TreeNode(4)
//        }
//    ))


//    val codec = Codec()
//    val node = TreeNode(1).apply {
//        left = TreeNode(2)
//        right = TreeNode(3)
//    }
//    val s = codec.serialize(
//        node
//    )
//
//    val answer = codec.deserialize(s)
//    println(answer!!.`val`)
//    println(answer.left!!.`val`)
//    println(answer.right!!.`val`)



    val s = Day3_31()
//    val root = s.buildTree(intArrayOf(9,3,15,20,7), intArrayOf(9,15,7,20,3))
    val root = s.sortedArrayToBST(intArrayOf(-10,-3,0,5,9))
    root?.print()




}

class LRUCache(capacity: Int){
    val cap = capacity
    val map = LinkedHashMap<Int, Int>() // 有排序功能，晚加入的总在链表尾部
    fun get(key: Int): Int{
        if (map.contains(key)){
            val v = map[key]!!
            map.remove(key)
            map[key] = v
            return v
        }else{
            return -1
        }
    }

    fun put(key: Int, value: Int){
        if (map.containsKey(key)){
            map.remove(key)
            map[key] = value
            return
        }

        if (map.size >= cap){
            val first = map.keys.first()
            map.remove(first)
        }
        map[key] = value
    }

}

class Codec() {
    // Encodes a URL to a shortened URL.
    companion object{
        const val NULL = "#"
        const val SEP = ","
    }
    fun serialize(root: TreeNode?): String {
        val sb = StringBuilder()
        traverse(root, sb)
        return sb.toString()
    }

    fun traverse(root: TreeNode?, sb: StringBuilder){
        if (root == null){
            sb.append(NULL).append(SEP)
            return
        }
        sb.append(root.`val`).append(SEP)
        traverse(root.left, sb)
        traverse(root.right, sb)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val list = LinkedList<String>()
        for (c in data.split(SEP)){
            list.add(c)
        }
        return deserialize(list)
    }

    fun deserialize(data: LinkedList<String>): TreeNode?{
        val first = data.removeFirst() ?: return null
        if (first == NULL){
            return null
        }
        val root = TreeNode(first.toInt())
        root.left = deserialize(data)
        root.right = deserialize(data)
        return root
    }
}