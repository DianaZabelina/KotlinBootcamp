package exercise4

import kotlin.math.abs

fun showParseError() = println("Couldn't parse a number. Please, try again")

fun readInt(prompt: String): Int {
    while (true) {
        print(prompt)
        val num = readlnOrNull()?.toIntOrNull()
        if (num != null) return num
        showParseError()
    }
}

fun readNumbers(
    expectedSize: Int,
    prompt: String,
): List<Int> {
    while (true) {
        print(prompt)
        val numbers = readlnOrNull()?.trim()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: emptyList()
        if (numbers.size == expectedSize) return numbers
        showParseError()
    }
}

fun hasSameFirstAndLastDigit(num: Int): Boolean {
    val absNum = abs(num)
    val last = absNum % 10
    var first = absNum

    while (first >= 10) {
        first /= 10
    }

    return first == last
}

fun printResult(size: Int) {
    if (size <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val numbers = readNumbers(size, "Enter the numbers separated by spaces: ")
    val matches = numbers.filter { hasSameFirstAndLastDigit(it) }

    println(if (matches.isEmpty()) "There are no such elements" else matches.joinToString(" "))
}

fun main() {
    val size = readInt("Enter the number of elements: ")
    printResult(size)
}
