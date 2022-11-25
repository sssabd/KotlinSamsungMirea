
fun main() {
    val strNum = readln().split(' ')
    val k = strNum[0].toInt()
    val x = strNum[1].toInt()
    val y = strNum[2].toInt()
    if (x < k && y < k) {
        println(if (x > y) "${k - x}" else "${k - y}")
    }
    else if (x == y) {
        println("2")
    }
    else if (x-y == 1 || y-x == 1) println("1")
    else println("0")
}
