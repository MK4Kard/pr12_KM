import kotlinx.coroutines.*
suspend fun main(){
    try {
        println("Выберите действие\n" +
                "1 - Блокировка\n" +
                "2 - Загружить пользователей")
        var v = readln()!!.toInt()

        when(v){
            1 -> block()
            2 -> load()
        }
    }
    catch (e:Exception){
        println("Неверные данные")
    }
}

suspend fun block(){
    try {
        runBlocking { delay(30000L) }

        var r: Repos = Repos()
        val sorted = r.p.sortedWith(compareBy<String> { s -> s.takeLastWhile { it.isDigit() }.toInt()})
        for (n in sorted){
            println(n)
        }
    }
    catch (e:Exception){
        println("Неверные данные")
    }
}

suspend fun load(){
    try {
        var r: Repos = Repos()
        var p = r.Input()
        GlobalScope.launch {
            for (i in 1..p){
                println("$i данные")
                r.Person()
            }
        }
        runBlocking { delay(30000L) }
    }
    catch (e:Exception){
        println("Неверные данные")
    }
}