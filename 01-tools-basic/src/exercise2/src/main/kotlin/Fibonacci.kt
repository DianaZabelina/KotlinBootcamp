package exercise2

const val MIN_NUM = 0
const val MAX_NUM = 46

fun readInt(prompt: String): Int {
    while (true) {
        print(prompt)
        val num = readlnOrNull()?.toIntOrNull()
        if (num != null) return num
        println("Couldn't parse a number. Please, try again")
    }
}

fun fibonacci(num: Int): Int {
    val memo = mutableMapOf<Int, Int>()

    fun fib(x: Int): Int =
        when (x) {
            0 -> 0
            1 -> 1
            else -> memo.getOrPut(x) { fib(x - 1) + fib(x - 2) }
        }

    return fib(num)
}

fun printResult(num: Int) {
    when {
        num < MIN_NUM -> println("Too small n")
        num > MAX_NUM -> println("Too large n")
        else -> println(fibonacci(num))
    }
}

fun main() {
    val num = readInt("Enter a number: ")
    printResult(num)
}
