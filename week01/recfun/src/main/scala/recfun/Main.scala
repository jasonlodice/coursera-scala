package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    balance("(if (zero? x) max (/ 1 x))".toList)
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (r == 0 && c == 0) 1
    else if (r == 0 && c != 0) 0
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def recursebalance(r: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) r == 0
      else if (chars.head == '(') recursebalance(r + 1, chars.tail)
      else if (chars.head == ')' && r >= 1) recursebalance(r - 1, chars.tail)
      else if (chars.head == ')' && r < 1) false
      else recursebalance(r, chars.tail)
    }
    recursebalance(0, chars)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0) 1
    else if(money > 0 && !coins.isEmpty)
      countChange(money - coins.head,coins) + countChange(money, coins.tail)
    else 0
  }
}
