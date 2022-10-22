package easy


fun main(){
    test724_1()
    test724_2()
    test724_3()
}

val solution = Solution724()

class Solution724 {

    fun recomended(nums: IntArray): Int {
        var sum = 0;
        var leftSum = 0;
        nums.forEach { sum+=it }
        nums.forEachIndexed { index, i ->
            if(leftSum == sum - leftSum - i){
                return index
            }
            leftSum+=i
        }
        return -1
    }
    fun pivotIndex(nums: IntArray): Int {
        var solveIndex = -1
        nums.forEachIndexed { index, i ->
            val fromStart = getSumFromStart(nums, index-1)
            val formEnd = getSumFromEnd(nums, index+1)
            if(fromStart == formEnd){
                solveIndex = index
                return solveIndex
            }
            if(fromStart>formEnd){
                return -1
            }
        }
        return solveIndex
    }

    fun getSumFromStart(nums: IntArray,elementCounts: Int):Int{
        if(elementCounts == -1){
            return  0
        }
        var sum  = 0
        for(i in 0 .. elementCounts){
            sum+=nums[i]
        }
        return sum
    }

    fun getSumFromEnd(nums: IntArray,elementCounts: Int): Int{
        if(elementCounts > nums.size){
            return 0
        }
        var sum  = 0
        for (i in nums.size -1 downTo elementCounts){
            sum+= nums[i]
        }
        return sum
    }

    /*
    recomended solution:
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
     */
}

fun test724_1(){
    val intArray = listOf<Int>(1,7,3,6,5,6)
    val result  = solution.pivotIndex(intArray.toIntArray())
    println(result == 3)
}
fun test724_2(){
    val intArray = listOf<Int>(1,2,3)
    val result  = solution.pivotIndex(intArray.toIntArray())
    println(result == -1)
}
fun test724_3(){
    val intArray = listOf<Int>(2,1,-1)
    val result  = solution.pivotIndex(intArray.toIntArray())
    println(result == 0)
}