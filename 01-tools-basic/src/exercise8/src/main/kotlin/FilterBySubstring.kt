package exercise8

fun readInt(prompt: String): Int {
    while (true) {
        print(prompt)
        val num = readlnOrNull()?.toIntOrNull()
        if (num != null) return num
        println("Couldn't parse a number. Please, try again")
    }
}

fun readStrings(expectedSize: Int): Array<String> = Array(expectedSize) { readln() }

fun manualContains(
    str: String,
    pattern: String,
): Boolean {
    if (pattern.isEmpty()) return true
    if (pattern.length > str.length) return false

    for (i in 0..str.length - pattern.length) {
        var match = true
        for (j in pattern.indices) {
            if (str[i + j] != pattern[j]) {
                match = false
                break
            }
        }

        if (match) return true
    }

    return false
}

fun stringFilter(
    input: Array<String>,
    pattern: String,
): List<String> {
    val res = mutableListOf<String>()

    for (str in input) {
        if (manualContains(str, pattern)) {
            res.add(str)
        }
    }

    return res
}

fun processStrings() {
    val size = readInt("Enter the number of strings: ")
    if (size <= 0) {
        println("Input error. Size <= 0")
        return
    }

    println("Enter strings:")
    val strings = readStrings(size)

    print("Enter a substring: ")
    val substring = readln()

    val filtered = stringFilter(strings, substring)
    println(filtered.joinToString(", "))
}

fun main() {
    processStrings()
}
