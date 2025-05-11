package exercise1

fun readInt(prompt: String): Int {
    while (true) {
        print(prompt)
        val num = readlnOrNull()?.toIntOrNull()
        if (num != null) return num
        println("Couldn't parse a number. Please, try again")
    }
}

fun calculateTime(rawTime: Int): Triple<Int, Int, Int> {
    val h = rawTime / 3600
    val m = (rawTime % 3600) / 60
    val s = rawTime % 60

    return Triple(h, m, s)
}

fun formatTime(
    h: Int,
    m: Int,
    s: Int,
): String = "%02d:%02d:%02d".format(h, m, s)

fun printResult(rawTime: Int) {
    if (rawTime < 0) {
        println("Incorrect time")
        return
    }

    val (h, m, s) = calculateTime(rawTime)
    println(formatTime(h, m, s))
}

fun main() {
    val rawTime = readInt("Enter time in seconds: ")
    printResult(rawTime)
}
