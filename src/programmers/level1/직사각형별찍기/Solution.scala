package programmers.level1.직사각형별찍기

import scala.io.StdIn.readLine

object Solution {
  def main(args: Array[String]) {
    val n = readLine().split(" ")
    val (a, b) = (n(0).toInt, n(1).toInt)
    var i, j = 0

    for (i <- (1 to b); j <- (1 to a)) {
      print("*")
      if (j == a)
        println
    }
  }
}