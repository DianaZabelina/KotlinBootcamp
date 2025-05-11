package exercise7

import java.util.Scanner

fun processSequence(sc: Scanner) {
    print("Enter the sequence of numbers: ")
    var prev: Int? = null
    var started = false
    var index = 0

    while (sc.hasNext()) {
        val num = sc.next().toIntOrNull()

        if (num == null) {
            println(if (!started) "Input error" else "The sequence is ordered in ascending order")
            return
        }

        if (prev != null && num < prev) {
            println("The sequence is not ordered from the ordinal number of the number $index")
            return
        }

        prev = num
        started = true
        index++
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    processSequence(sc)
}
