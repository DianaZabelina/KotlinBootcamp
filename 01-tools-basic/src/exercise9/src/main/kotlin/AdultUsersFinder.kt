package exercise9

fun readInt(prompt: String): Int {
    while (true) {
        print(prompt)
        val num = readlnOrNull()?.toIntOrNull()
        if (num != null) return num
        println("Couldn't parse a number. Please, try again")
    }
}

fun readString(prompt: String): String {
    while (true) {
        print(prompt)
        val str = readln()
        if (str.isNotEmpty()) return str
        println("Name cannot be empty. Please try again")
    }
}

fun readUsers(expectedSize: Int): List<User> {
    val users = mutableListOf<User>()

    repeat(expectedSize) {
        val name = readString("Enter a name: ")
        val age = readInt("Enter an age: ")

        if (age <= 0) {
            println("Incorrect input. Age <= 0")
            return@repeat
        }

        users.add(User(name, age))
    }

    return users
}

fun processUsers() {
    val size = readInt("Enter the number of users: ")
    if (size <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val users = readUsers(size)
    val adultNames =
        users
            .asSequence()
            .filter { it.age >= 18 }
            .map { it.name }
            .toList()

    if (adultNames.isNotEmpty()) {
        println(adultNames.joinToString(", "))
    }
}

fun main() {
    processUsers()
}
