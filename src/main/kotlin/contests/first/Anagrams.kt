package contests.first

fun main() {
    val firstInput:String = readLine()!!.trim()
    val secondInput:String = readLine()!!.trim()
    solve(firstInput, secondInput)
}

fun solve(first: String, second: String) {
    if (first.length != second.length)
        println("NO")
    else {
        val countOfCharsInFirstString: MutableMap<Char, Int> = mutableMapOf()
        val countOfCharsInSecondString: MutableMap<Char, Int> = mutableMapOf()
        for (c in first) {
            if (!countOfCharsInFirstString.containsKey(c))
                countOfCharsInFirstString[c] = 1
            else
                countOfCharsInFirstString[c] = countOfCharsInFirstString.getValue(c) + 1
        }
        for (c in second) {
            if (!countOfCharsInSecondString.containsKey(c))
                countOfCharsInSecondString[c] = 1
            else
                countOfCharsInSecondString[c] = countOfCharsInSecondString.getValue(c) + 1
        }
        if (countOfCharsInFirstString == countOfCharsInSecondString)
            println("YES")
        else
            println("NO")
    }
}

