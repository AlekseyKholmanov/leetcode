package easy

fun main() {
    val sol = Solution392()
    println(sol.isFSubsequenceFixed("abc", "ahbgdc"))
    println(sol.isFSubsequenceFixed("axc", "ahbgdc"))
    println(sol.isFSubsequenceFixed("", "ahbgdc"))
    println(sol.isFSubsequenceFixed("b", "abc"))
}

class Solution392 {
    fun isSubsequence(s: String, t: String): Boolean {
        var indexForCheck = 0

        t.forEach { c ->
            if (indexForCheck >= s.length) {
                return indexForCheck == s.length
            }
            if (c == s[indexForCheck]) {
                indexForCheck++
            }
        }
        return indexForCheck == s.length
    }

    fun isFSubsequenceFixed(s: String, t: String): Boolean {
        var indexForCheck = 0
        var i = 0
        while (indexForCheck < s.length && i < t.length) {
            if (t[i] == s[indexForCheck]) {
                indexForCheck++
            }
            i++
        }
        return indexForCheck == s.length
    }
}