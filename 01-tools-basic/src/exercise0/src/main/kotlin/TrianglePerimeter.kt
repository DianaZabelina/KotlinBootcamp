package exercise0

import kotlin.math.pow
import kotlin.math.sqrt

fun readDouble(prompt: String): Double {
    while (true) {
        print(prompt)
        val num = readlnOrNull()?.toDoubleOrNull()
        if (num != null) return num
        println("Couldn't parse a number. Please, try again")
    }
}

fun dist(
    x1: Double,
    y1: Double,
    x2: Double,
    y2: Double,
): Double = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))

fun isTriangle(
    a: Double,
    b: Double,
    c: Double,
): Boolean = a + b > c && a + c > b && b + c > a

fun perimeter(
    a: Double,
    b: Double,
    c: Double,
): Double = a + b + c

fun main() {
    val x1 = readDouble("Enter x1: ")
    val y1 = readDouble("Enter y1: ")
    val x2 = readDouble("Enter x2: ")
    val y2 = readDouble("Enter y2: ")
    val x3 = readDouble("Enter x3: ")
    val y3 = readDouble("Enter y3: ")

    val sideAB = dist(x1, y1, x2, y2)
    val sideBC = dist(x2, y2, x3, y3)
    val sideCA = dist(x3, y3, x1, y1)

    if (isTriangle(sideAB, sideBC, sideCA)) {
        println("Perimeter: %.3f".format(perimeter(sideAB, sideBC, sideCA)))
    } else {
        println("It's not a triangle")
    }
}
