package programmers.level1.자릿수더하기

object Solution {
  def solution(n: Int): Int = {
    n.toString.map(_.toInt - '0').sum
  }
}

object Main extends App {
  val input1 = 123
  val input2 = 987
  println(Solution.solution(input2))
}