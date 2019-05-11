package grammar

class Point1(xc: Int, yc: Int) {
  var x: Int = xc
  var y: Int = yc
  def move(dx: Int, dy: Int): Unit = {
    x += dx
    y += dy
  }
  override def toString(): String = "(" + x + ", " + y + ")"
}

object ClassTest extends App {
  val p = new Point1(5, 3)
  println(p)
  p.move(10, 10)
  println(p)
}