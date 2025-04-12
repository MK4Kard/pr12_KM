import kotlin.math.*

class SideLength {
    fun Input(): Int{
        println("Введите сколько раз найти длину стороны фигуры")
        val n = readln()!!.toInt()
        if (n > 0){
            return n
        }
        else {
            println("Количество действий должно быть больше 0")
            return 1
        }
    }
    fun Length(){
        try {
            println("Введите первое число")
            var a = readln()!!.toDouble()
            println("Введите второе число")
            var b = readln()!!.toDouble()
            println("Введите угол")
            var alf = readln()!!.toDouble()
            if (a>=0.1&&b>=0.1&&alf>=0){
                println("Выберите для какой фигуры найти длину стороны\n" +
                        "1 - треугольник, 2 - прямоугольник, 3 - параллелограмм")
                var v = readln()!!.toInt()
                if (v == 1){
                    val otv1 = (Math.pow(a,2.0)+Math.pow(b,2.0))-2*a*b*cos(alf)
                    println("c = ${String.format("%.2f", otv1)}")
                }
                else if (v == 2){
                    val otv2 = a*b
                    println("c = ${String.format("%.2f", otv2)}")
                }
                else if (v == 3){
                    val otv3 = a*b*sin(alf)
                    println("c = ${String.format("%.2f", otv3)}")
                }
                else {
                    println("Действие не выбрано")
                }
            }
        }
        catch (e:Exception){
            println("Неверные данные")
        }
    }
}
