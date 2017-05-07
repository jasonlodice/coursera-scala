package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))

  println("forall " + forall((e:Int) => e < 2000,(e:Int) => e % 2 == 0 ))

  printSet((e: Int) => e % 2 == 0)

  val identitySet = (e: Int) => true
  val doubleSet = map(identitySet, (e: Int) => e * 2);

  printSet(identitySet)
  printSet(doubleSet)
  println("doubleSet is all even " + forall(doubleSet, (p: Int) => p % 2 == 0))
}
