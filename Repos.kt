class Repos {
    val p: MutableList<String> = mutableListOf()

    fun Input(): Int {
        println("Введите количество пользователей:")
        val n = readln().toInt()
        if (n > 0) {
            return n
        } else {
            println("Количество пользователей должно быть больше 0")
            return 1
        }
    }

    fun Person() {
        try {
            println("Введите имя пользователя:")
            val name = readln().trim()
            println("Введите токен:")
            val token = readln().toInt()
            println("Введите количество репозиториев:")
            val reps = readln().toInt()

            val person = "$name $token $reps"
            p.add(person)
        } catch (e: Exception) {
            println("Ошибка при вводе данных")
        }
    }
}
