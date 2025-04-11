import kotlinx.coroutines.*
suspend fun main(){
    try {
        var l: SideLength = SideLength()
        var s_l = l.Input()
        GlobalScope.launch {
            for (i in 1..s_l){
                println("$i раз")
                l.Length()
            }
        }
        runBlocking { delay(30000L) }
    }
    catch (e:Exception){
        println("Неверные данные")
    }
}