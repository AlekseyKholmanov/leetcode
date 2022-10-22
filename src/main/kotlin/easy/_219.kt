package easy

import java.lang.Math.abs

fun main(){
    val clas = Solution219()
    println(clas.containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3),2))
    println(clas.containsNearbyDuplicate(intArrayOf(1,0,1,1),1))
}

class Solution219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val hashMap = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
            if(hashMap.containsKey(i)){
                 if(kotlin.math.abs(index - hashMap[i]!!) <= k){
                     return true
                 }
            }
            hashMap[i] = index
        }
        return false
    }
}