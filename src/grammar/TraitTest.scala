package grammar

trait Similarity {
  def isSimilar(x: Any): Boolean
  def isNotSimilar(x: Any): Boolean = !isSimilar(x)
}    // template-method pattern 형태?

class Point2(xc: Int, yc: Int) extends Similarity {
  var x: Int = xc
  var y: Int = yc
  def isSimilar(obj: Any) =
    obj.isInstanceOf[Point2] &&
      obj.asInstanceOf[Point2].x == x
}

object TraitTest extends App {
  val p1 = new Point2(2, 3)
  val p2 = new Point2(2, 4)
  val p3 = new Point2(3, 3)

  println(p1.isNotSimilar(p2))
  println(p1.isNotSimilar(p3))
  println(p1.isNotSimilar(2))
}

