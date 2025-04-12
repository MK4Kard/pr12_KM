import kotlinx.coroutines.*
suspend fun main() {
    val repos = Repos()

    while (true) {
        try {
            println(
                "Выберите действие:\n" +
                        "1 - Блокировка\n" +
                        "2 - Загрузить пользователей\n" +
                        "3 - Выход"
            )
            val v = readln().toInt()

            when (v) {
                1 -> block(repos)
                2 -> load(repos)
                3 -> {
                    println("Выход...")
                    break
                }
                else -> println("Неверный выбор")
            }
        } catch (e: Exception) {
            println("Неверные данные")
        }
    }
}
suspend fun block(repos: Repos) {
    try {
        if (repos.p.isEmpty()) {
            println("Нет данных для блокировки. Сначала загрузите пользователей.")
            return
        }

        val sorted = repos.p.sortedWith(compareBy { s ->
            s.takeLastWhile { it.isDigit() }.toIntOrNull() ?: 0
        })

        for (n in sorted) {
            println(n)
        }
        delay(3000L)
    } catch (e: Exception) {
        println("Ошибка при блокировке: ${e.message}")
    }
}
suspend fun load(repos: Repos) {
    try {
        val n = repos.Input()

        coroutineScope {
            repeat(n) {
                println("Введите данные для пользователя ${it + 1}:")
                repos.Person()
            }
        }

        println("Загружено пользователей: ${repos.p.size}")
        delay(3000L)
    } catch (e: Exception) {
        println("Ошибка при загрузке: ${e.message}")
    }
}
