package contests.first

import java.util.*

fun main() {
    val input: List<String> = readLine()!!.trim().split(" ")
    println(solve(input))
}

fun solve(input: List<String>): Int {
    val stack: Stack<Int> = Stack()
    for (s in input) {
        when (s) {
            "+" -> {
                val secondOperand = stack.pop()
                val firstOperand = stack.pop()
                stack.push(firstOperand + secondOperand)
            }
            "-" -> {
                val secondOperand = stack.pop()
                val firstOperand = stack.pop()
                stack.push(firstOperand - secondOperand)
            }
            "*" -> {
                val secondOperand = stack.pop()
                val firstOperand = stack.pop()
                stack.push(firstOperand * secondOperand)
            }
            else -> stack.push(s.toInt())
        }
    }
    return stack.pop()
}