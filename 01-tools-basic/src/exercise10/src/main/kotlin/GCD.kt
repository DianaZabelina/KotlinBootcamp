package exercise10

import kotlin.math.abs

fun readTwoInts(prompt: String): Pair<Int, Int> {
    while (true) {
        print(prompt)
        val parsed =
            readln().trim().split(" ").mapNotNull { it.toIntOrNull() }

        if (parsed.size != 2) {
            println("Couldn't parse a number. Please, try again")
        } else {
            return parsed[0] to parsed[1]
        }
    }
}

fun Int.gcd(other: Int): Int {
    var a = abs(this)
    var b = abs(other)

    while (b != 0) {
        a = b.also { b = a % b }
    }

    return a
}

fun main() {
    val (a, b) = readTwoInts("Enter two integers separated by a space: ")
    val res = a.gcd(b)
    println(res)
}
