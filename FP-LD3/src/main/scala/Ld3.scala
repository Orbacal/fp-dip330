object Ld3 extends App {
  println(sqrt(16d))

  def square(a:Double): Double = a*a

  def sqrt(x: Double): Double = improve(x, 1d)

  def isGoodEnough(x: Double, y:Double): Boolean = Math.abs(square(y)-x) < 0.001

  def improve(x: Double, y: Double): Double = {
    val yNew = (x/y + y)/2
    if(!isGoodEnough(x,yNew)) improve(x, yNew)
    else yNew
  }
}