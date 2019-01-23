import org.scalatest.FunSuite

object RTUSet {
  /**
    * We define a set by its characteristic function
    */
  type Set = Int => Boolean

  /**
    * If  a set contains an element.
    */

  def contains(s: Set, elem: Int): Boolean = s(elem)
  // pec Set = Int => Boolean definicijas

  /**
    * Singleton set from one element
    */
  def singletonSet(elem: Int): Set = set => set == elem

  /**
    * Union of the two sets
    */
  def union(s: Set, t: Set): Set = x => s(x) || t(x)
  // def union(s: Set, t: Set): Set = (x : Int) => contains(s, x) || contains(t, x)

  /**
    * Intersection of the two sets
    */
  def intersect(s: Set, t: Set): Set = x => s(x) && t(x)
  // def intersect(s: Set, t: Set): Set = (x : Int) => contains(s, x) && contains(t, x)

  /**
    * Difference of two given sets
    */
  def diff(s: Set, t: Set): Set = x => s(x) && !t(x)
  // def diff(s: Set, t: Set): Set = (x : Int) => contains(s, x) && !contains(t, x)

  /**
    * Filter
    */
  def filter(s: Set, p: Int => Boolean): Set = x => s(x) && p(x)
  // def filter(s: Set, p: Int => Boolean): Set = (x : Int) => contains(s, x) && p(x)

  /** =========== For brave enough =========== */
  // sie 3 testi netika pilditi

  val bound = 1000

  /**
    * if  all bounded integers within s satisfy p
    */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (s(a) && !p(a)) false
      else iter(a + 1)
    }
    iter(-bound)
  }


  def exists(s: Set, p: Int => Boolean): Boolean = ???


  def map(s: Set, f: Int => Int): Set = (x: Int) => ???

  /**
    * Displays the contents of a set
    */
  def toString(s: Set): String = {
    ???
  }
}

class SimpleSuite extends FunSuite {

  test("Set contains a given element") {
    val s:RTUSet.Set = (x: Int) => x == 1
    assert(RTUSet.contains(s, 1))
  }

  test("Singleton set contains a given element") {
    val s:RTUSet.Set = RTUSet.singletonSet(2)
    assert(RTUSet.contains(s, 2))
  }

  test("Union set contains both elements") {
    val s = RTUSet.union(RTUSet.singletonSet(1),RTUSet.singletonSet(2))
    assert(RTUSet.contains(s, 1))
    assert(RTUSet.contains(s, 2))
  }

  test("Intersect set works correctly") {
    val s = RTUSet.intersect(RTUSet.union(RTUSet.singletonSet(1),RTUSet.singletonSet(2)),RTUSet.singletonSet(1))
    assert(RTUSet.contains(s, 1))
    assert(!RTUSet.contains(s, 2))
  }

  test("Filter set works correctly") {
    val s = RTUSet.filter(RTUSet.union(RTUSet.singletonSet(1),RTUSet.singletonSet(2)), (x: Int) => x == 1)
    assert(RTUSet.contains(s, 1))
    assert(!RTUSet.contains(s, 2))
  }

  test("Exists set works correctly") {
    val s = RTUSet.union(RTUSet.singletonSet(1),RTUSet.singletonSet(2))
    val s1 = RTUSet.exists(s, (x: Int) => x == 1)
    val s2 = RTUSet.exists(s, (x: Int) => x == 2)
    assert(s1)
    assert(s2)
  }

  test("Map set works correctly") {
    val s1 = RTUSet.map(RTUSet.singletonSet(1), (x: Int) => x * -1)
    assert(RTUSet.contains(s1,-1))
  }

  test("To String works correctly") {
    val s = RTUSet.union(RTUSet.singletonSet(1),RTUSet.singletonSet(2))
    assert(RTUSet.toString(s) == "{1,2}")
  }

}