package contests.first

import java.util.*

fun main() {
    val s: String = readLine()!!
    val weights = readLine()!!.trim().split(" ")
    println(solve(s, weights))
}

fun solve(s: String, weights: List<String>): String {
    val alphabet = listOf(
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    )
    val charWeights = mutableMapOf<Char, Int>().apply { for (i in alphabet.indices) this[alphabet[i]] = weights.map{it.toInt()}[i] }
    val countOfCharsInString = mutableMapOf<Char, Int>()
    val costs: MutableMap<Char, Int> = mutableMapOf()
    for (c in s) {
        if (!countOfCharsInString.containsKey(c))
            countOfCharsInString[c] = 1
        else
            countOfCharsInString[c] = countOfCharsInString.getValue(c) + 1
    }
    for ((k, v) in countOfCharsInString) {
        if (v > 1)
            costs[k] = (s.length - 1) * charWeights.getValue(k)
        else
            costs[k] = 0
    }
    val stack: Stack<Char> = Stack()
    var result = ""
    for ((k, v) in costs.entries.sortedByDescending { it.value }) {
        if (v > 0)
            stack.push(k)
        else
            countOfCharsInString.remove(k)
        result += k

    }
    for ((k, v) in countOfCharsInString) {
        if (v > 2)
            result += k.toString().repeat(v-2)
    }
    countOfCharsInString.clear()
    while (!stack.isEmpty()) {
        result += stack.pop()
    }
    return result
}