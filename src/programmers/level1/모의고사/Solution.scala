package programmers.level1.모의고사

object Solution {
  def solution(answers: Vector[Int]): Vector[Int] = {
    val pattern1 = Vector(1, 2, 3, 4, 5)
    val pattern2 = Vector(2, 1, 2, 3, 2, 4, 2, 5)
    val pattern3 = Vector(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    val pattern1Cnt = answers.zipWithIndex.count(a => {
      a._1 == pattern1(a._2 % pattern1.size)
    })
    val pattern2Cnt = answers.zipWithIndex.count(a => {
      a._1 == pattern2(a._2 % pattern2.size)
    })
    val pattern3Cnt = answers.zipWithIndex.count(a => {
      a._1 == pattern3(a._2 % pattern3.size)
    })

    val patterns = Vector(pattern1Cnt, pattern2Cnt, pattern3Cnt)
    val max = patterns.max

    patterns.zipWithIndex.filter(s => {
      s._1 == max
    }).map(_._2 + 1)
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  def solutionByFirst(answers: Vector[Int]): Vector[Int] = {
    val patterns = Vector(
      Vector(1, 2, 3, 4, 5),
      Vector(2, 1, 2, 3, 2, 4, 2, 5),
      Vector(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    )

    var max = 0
    var index = 0

    patterns
      .map(p => {
        val result = comparePatternAndInput(p, answers)
        if (result > max)
          max = result
        result
      })
      .map(s => {
        index = index + 1
        (index, s)
      })
      .filter(max == _._2)
      .map(_._1)
  }

  def comparePatternAndInput(pattern: Vector[Int], input: Vector[Int]): Int = {
    var iter = pattern.iterator

    input.filter(i => {
      if (!iter.hasNext) {
        iter = pattern.iterator
      }
      i == iter.next
    }).size
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  def solutionByForLoop(answers: Vector[Int]): Vector[Int] = {
    val patterns = Vector(
      Vector(1, 2, 3, 4, 5),
      Vector(2, 1, 2, 3, 2, 4, 2, 5),
      Vector(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    )

    var i = 0
    var max = 0
    var result: Vector[Int] = Vector()

    for (i <- 0 to patterns.size - 1) {
      val pattern = patterns(i)
      var j = 0
      var cnt = 0
      for (j <- 0 to answers.size - 1) {
        if (answers(j) == pattern(j % pattern.size)) {
          cnt = cnt + 1
        }
      }
      if (max < cnt) {
        max = cnt
      }
      result = result :+ cnt
    }
    var results: Vector[Int] = Vector()

    for (i <- 0 to result.size - 1) {
      if (result(i) == max) {
        results = results :+ (i + 1)
      }
    }
    results
  }
}

object Main extends App {
  val input1 = Vector(1, 2, 3, 4, 5)
  val input2 = Vector(1, 3, 2, 4, 2)

  println(Solution.solution(input2))
}