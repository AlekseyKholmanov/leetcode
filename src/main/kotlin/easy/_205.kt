package easy

fun main() {
    val sol = Solution205()
    println(sol.isIsomorphic("egg", "add"))
    println(sol.isIsomorphic("foo", "bar"))
    println(sol.isIsomorphic("paper", "title"))
}

class Solution205 {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val firstHash = hashMapOf<Char, Int>()
        val secondHash = hashMapOf<Char, Int>()
        val firstResult = mutableListOf<Int>()
        val secondResult = mutableListOf<Int>()
        var firsIndex = 0
        var secondIndex = 0
        s.forEachIndexed { index, c ->
            if (!firstHash.containsKey(c)) {
                firstHash[c] = firsIndex
                firsIndex++
            }
            firstResult.add(firstHash[c]!!)
        }
        t.forEachIndexed { index, c ->
            if (!secondHash.containsKey(c)) {
                secondHash[c] = secondIndex
                secondIndex++
            }
            secondResult.add(secondHash[c]!!)
        }
        return firstResult == secondResult
    }
}