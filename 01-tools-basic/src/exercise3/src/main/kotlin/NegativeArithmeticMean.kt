package exercise3

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

fun arithmeticMean(numbers: List<Int>): Int? {
    var sum = 0
    var count = 0

    for (num in numbers) {
        if (num < 0) {
            sum += num
            count++
        }
    }

    return if (count == 0) null else sum / count
}

fun printResult(size: Int) {
    if (size <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val numbers = readNumbers(size, "Enter the numbers separated by spaces: ")
    val avg = arithmeticMean(numbers)
    println(avg?.toString() ?: "There are no negative elements")
}

fun main() {
    val size = readInt("Enter the number of elements: ")
    printResult(size)
}
