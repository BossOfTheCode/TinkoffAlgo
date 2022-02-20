package contests.first

import java.util.*
import kotlin.system.exitProcess


fun main() {
    var input: String
    val scanner = Scanner(System.`in`)
    val queue = Queue()
    while (true) {
        input = scanner.nextLine()
        with (input) {
            when {
                startsWith("push") -> {
                    if (!queue.isFull()) {
                        queue.push(input.split(" ")[1].toInt())
                        println("ok")
                    }
                }
                equals("pop") -> {
                    if (!queue.isEmpty())
                        println(queue.pop())
                }
                equals("front") -> {
                    if (!queue.isEmpty())
                        println(queue.front())
                }

                equals("size") -> {
                    println(queue.size())
                }
                equals("clear") -> {
                    while (!queue.isEmpty())
                        queue.pop()
                    println("ok")
                }
                equals("exit") -> {
                    println("bye")
                    return
                }
            }
        }
    }
}

class Queue {
    private val maxSize: Int = 100
    private val array: IntArray = IntArray(maxSize)
    private var head: Int = 0
    private var tail: Int = -1
    private var size: Int = 0

    fun size(): Int {
        return size
    }

    fun push(n: Int) {
        if (tail == maxSize - 1)
            tail = -1
        array[++tail] = n
        size++
    }

    fun pop(): Int {
        val n = array[head++]
        size--
        if (head == maxSize)
            head = 0
        return n
    }

    fun front(): Int {
        return array[head]
    }

    fun isFull(): Boolean {
        return (size == maxSize)
    }

    fun isEmpty(): Boolean {
        return (size == 0)
    }
}