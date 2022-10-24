package easy

import kotlin.math.max

fun main() {

    val clas = Solution594()
    println(clas.findLHS(intArrayOf(1, 3, 2, 2, 5, 2, 3, 7)) == 5)
    println(clas.findLHS(intArrayOf(1, 2, 3, 4)) == 2)
    println(clas.findLHS(intArrayOf(1, 1, 1, 1)) == 0)
    println(clas.findLHS(intArrayOf(1, 3, 5, 7, 9, 11, 13, 15, 17)) == 0)
}

class Solution594 {
    fun findLHS(nums: IntArray): Int {
        val upperhashMap = hashMapOf<Int, Int>()
        val bottomhashMap = hashMapOf<Int, Int>()
        val sorted = nums.sorted()
        sorted.forEach {
            if (bottomhashMap.containsKey(it - 1)) {
                bottomhashMap[it - 1] = bottomhashMap[it - 1]?.plus(1) ?: 1
            }
            bottomhashMap[it] = bottomhashMap[it]?.plus(1) ?: 1
        }
        var maxValue = 0
        nums.forEach {
            if(bottomhashMap.containsKey(it-1))
            if (bottomhashMap[it-1]!! > maxValue) {
                maxValue = bottomhashMap[it-1]!!
            }
        }
        println("$maxValue $bottomhashMap $upperhashMap")

        return maxValue
    }
}