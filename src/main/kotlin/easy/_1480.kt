package easy


fun main(args: Array<String>) {
    test1()
}


class Solution1480 {
    fun runningSum(nums: IntArray): IntArray {
        val solution = IntArray(nums.size)
        nums.forEachIndexed { index, i ->
            println("$index $i")
            when (index) {
                0 -> {
                    solution[index] = (i)
                }
                else -> {
                    solution[index] = (solution[index-1] + i)
                }
            }
        }
        return  solution
    }
}


fun test1(){
    val intArray = listOf<Int>(1,2,3,4)
    val solution = Solution1480()
    val result  = solution.runningSum(intArray.toIntArray())
    println(result.toList() == listOf<Int>(1,3,6,10))

}