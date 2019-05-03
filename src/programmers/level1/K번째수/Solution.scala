package programmers.level1.K번째수

object Solution {
  def solution(array: Vector[Int], commands: Vector[Vector[Int]]): Vector[Int] = {
    commands.map(c => {
      array.zipWithIndex
        .filter(v => {
          v._2 >= c(0) - 1 && v._2 <= c(1) - 1
        }).map(_._1)
        .sortWith((a, b) => a < b).zipWithIndex
        .filter(_._2 == c(2) - 1)
        .map(_._1)
        .head
    })
  }
}

object Main extends App {
  val input1 = Vector(1, 5, 2, 6, 3, 7, 4)
  val commands = Vector(Vector(2, 5, 3), Vector(4, 4, 1), Vector(1, 7, 3))
  println(Solution.solution(input1, commands))
}