fun main() {
/*    volleyballOnMars()
    roomAndCarpet()
    howMuchNucleotides()
    println(countVowels(str = readln()))*/
    println(
        Robot(
            x = 1,
            y = 2,
            direction = Direction.LEFT
        )
    )
}
fun volleyballOnMars() {
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
fun roomAndCarpet () {
    val str = readln().split(' ')
    val a = str[0].toDouble()
    val b = str[1].toDouble()
    val m = str[2].toDouble()
    val n = str[3].toDouble()
    val res = if ((m<=a && n<=b) || (n<=a && m<=b)) "YES" else "NO"
    println(res)
}
fun howMuchNucleotides() {
    val str = readln()
    var adenin = 0
    var timin = 0
    var guanin = 0
    var citozin = 0
    for (i in str.indices) {
        when (str[i]) {
            'A' -> ++adenin
            'T' -> ++timin
            'G' -> ++guanin
            'C' -> ++citozin
        }
    }
    println("$adenin $timin $guanin $citozin")
}

fun countVowels(str: String) : Int {
    var vowelsInString = 0
    for (i in str.indices) {
        when (str[i]) {
            'a', 'e', 'i', 'o', 'u' -> ++vowelsInString
        }
    }
    return vowelsInString
}

enum class Direction {
    UP, DOWN, RIGHT, LEFT
}

fun moveRobot(
    r: Robot,
    toX: Int,
    toY: Int
) {
    val dx = toX - r.x
    val dy = toY - r.y

    if (dx >= 0) while (r.direction != Direction.RIGHT) r.turnRight()
    else while (r.direction != Direction.LEFT) r.turnRight()

    while (r.x != toX) r.stepForward()

    if (dy >= 0) while (r.direction != Direction.UP) r.turnRight()
    else while (r.direction != Direction.DOWN) r.turnRight()

    while (r.y != toY) r.stepForward()
}

class Robot (
    x: Int,
    y: Int,
    direction: Direction
){
    var x: Int = x
        private set
    var y: Int = y
        private set
    var direction: Direction = direction
        private set
    fun turnLeft() {
        direction = when (direction) {
            Direction.UP -> Direction.LEFT
            Direction.DOWN -> Direction.RIGHT
            Direction.RIGHT -> Direction.UP
            Direction.LEFT -> Direction.DOWN
        }
    }

    fun turnRight() {
        direction = when (direction) {
            Direction.UP -> Direction.RIGHT
            Direction.DOWN -> Direction.LEFT
            Direction.RIGHT -> Direction.DOWN
            Direction.LEFT -> Direction.UP
        }
    }

    fun stepForward() {
        when (direction) {
            Direction.UP -> y++
            Direction.DOWN -> y--
            Direction.RIGHT -> x++
            Direction.LEFT -> x--
        }
    }

    override fun toString(): String {
        return "x: $x, y: $y, dir: $direction"
    }
}

