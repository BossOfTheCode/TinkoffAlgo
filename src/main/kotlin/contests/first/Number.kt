package contests.first

import java.util.*

fun main() {
    val input: MutableList<String> = System.`in`.bufferedReader().readLines().toMutableList()
    println(solve(input))
}

fun solve(input: MutableList<String>): String {
    if (input.size == 1)
        return input.joinToString()
    val comparator = Comparator<String> {o1, o2 ->
        when {
            (o1 + o2 > o2 + o1) -> -1
            (o1 + o2 == o2 + o1) -> 0
            else -> 1
        }
    }
    return input.sortedWith(comparator).joinToString(separator = "")
}
