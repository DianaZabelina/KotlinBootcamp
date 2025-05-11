package exercise5

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
): List<Double> {
    while (true) {
        print(prompt)
        val numbers = readlnOrNull()?.trim()?.split(" ")?.mapNotNull { it.toDoubleOrNull() } ?: emptyList()
        if (numbers.size == expectedSize) return numbers
        showParseError()
    }
}

fun selectionSort(numbers: MutableList<Double>) {
    for (i in 0..<numbers.size - 1) {
        var indexOfMin = i

        for (j in i + 1..<numbers.size) {
            if (numbers[j] < numbers[indexOfMin]) {
                indexOfMin = j
            }
        }

        numbers[i] = numbers[indexOfMin].also { numbers[indexOfMin] = numbers[i] }
    }
}

fun printResult(size: Int) {
    if (size <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val numbers = readNumbers(size, "Enter the numbers separated by spaces: ").toMutableList()
    selectionSort(numbers)
    println(numbers.joinToString(" "))
}

fun main() {
    val size = readInt("Enter the number of elements: ")
    printResult(size)
}
