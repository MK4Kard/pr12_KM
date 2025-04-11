class Repos {
    var p: ArrayList<String> = arrayListOf()
    fun Input(): Int{
        println("Введите количество пользователей")
        val n = readln()!!.toInt()
        if (n > 0){
            return n
        }
        else {
            println("Пользователей должно быть больше 0")
            return 1
        }
    }
    var rep = 0
    fun Person(){
        try {
            println("Введите имя пользователя")
            var name = readln()!!.toString()
            println("Введите токен")
            var token = readln()!!.toInt()
            println("Введите количество репозиториев")
            var reps = readln()!!.toInt()
            rep = reps
            var person = "$name $token $reps"
            p.add(person)
        }
        catch (e:Exception){
            println("Неверные данные")
        }
    }
}