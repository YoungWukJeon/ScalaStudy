package programmers.level1.체육복

object Solution {
  def solution(n: Int, lost: Vector[Int], reserve: Vector[Int]): Int = {
    var tempReserve = reserve
    lost.count(p => {
      if (tempReserve.contains(p - 1)) {
        tempReserve = tempReserve.filterNot(_ == (p - 1))
        true
      } else if (tempReserve.contains(p + 1)) {
        tempReserve = tempReserve.filterNot(_ == (p + 1))
        true
      } else {
       false
      }
    }) + (n - lost.size)
  }
}

object Main extends App {
  val n1 = 5
  val lost1 = Vector(2, 4)
  val reserve1 = Vector(1, 3, 5)
  val n2 = 5
  val lost2 = Vector(2, 4)
  val reserve2 = Vector(3)
  val n3 = 3
  val lost3 = Vector(1, 2)
  val reserve3 = Vector(2, 3)
  println(Solution.solution(n3, lost3, reserve3))
}

