package contests.first

// import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val N: Int = readLine()!!.toInt()
    var input: String
    val queue: ArrayDeque<Int> = ArrayDeque()
    for (i in 0 until N) {
        input = readLine()!!
        with(input) {
            when {
                startsWith("+") -> queue.addLast(input.split(" ")[1].toInt())
                startsWith("*") -> {
                    if (queue.size % 2 == 0)
                        queue.add(queue.size / 2, input.split(" ")[1].toInt())
                    else
                        queue.add(queue.size / 2 + 1, input.split(" ")[1].toInt())
                }
                equals("-") -> {
                    if (!queue.isEmpty())
                        println(queue.removeFirst())
                }
            }
        }
    }
}