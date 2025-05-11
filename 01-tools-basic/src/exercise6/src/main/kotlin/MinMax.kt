package exercise6

import java.io.File

const val RESULT_FILE = "result.txt"

fun getFilePath(prompt: String): String {
    print(prompt)
    return readln().takeIf { it.isNotEmpty() } ?: run {
        println("Input error. Path is empty")
        ""
    }
}

fun readFile(path: String): List<String>? {
    val file = File(path)
    return file.takeIf { it.exists() }?.readLines()
        ?: run {
            println("Input error. File doesn't exist")
            null
        }
}

fun parseSize(input: String): Int? =
    input.toIntOrNull()?.takeIf { it > 0 }
        ?: run {
            println("Input error. Size <= 0")
            null
        }

fun parseDoubles(input: String): List<Double> = input.trim().split(" ").mapNotNull { it.toDoubleOrNull() }

fun isValidFormat(lines: List<String>): Boolean {
    if (lines.size != 2) {
        println("Input error. File is empty or has invalid format")
        return false
    }

    return true
}

fun hasEnoughElements(
    expectedSize: Int,
    actualSize: Int,
): Boolean {
    if (actualSize != expectedSize) {
        println("Input error. Insufficient number of elements")
        return false
    }

    return true
}

fun writeResult(
    min: Double,
    max: Double,
) {
    File(RESULT_FILE).writeText("$min $max")
    println("Saving min and max values in file")
}

fun processFile() {
    val path = getFilePath("Enter the file path: ")
    if (path.isEmpty()) return

    val lines = readFile(path) ?: return
    if (!isValidFormat(lines)) return

    val size = parseSize(lines[0]) ?: return
    val numbers = parseDoubles(lines[1])
    if (!hasEnoughElements(size, numbers.size)) return

    val min = numbers.minOrNull() ?: return
    val max = numbers.maxOrNull() ?: return

    println("$size\n${numbers.joinToString(" ")}")
    writeResult(min, max)
}

fun main() {
    processFile()
}
