object Main {

  def main(args: Array[String]) {
    val size = io.StdIn.readInt()
    val magic = Array.ofDim[Int](size, size)
    for (i <- 0 to size-1)
      magic(i) = io.StdIn.readLine().split(' ').map { _.toInt }
    val sum = getSum(size, magic)
    var skipped = false
    do {
      var b = false
      for (i1 <- 0 to magic.length-1) {
        for (i2 <- 0 to magic(i1).length-1) {
          if (magic(i1)(i2) == 0) {
            var n = -1
            if (getZeroCount(magic(i1)) <= 1)
              n = sum - magic(i1).sum
            else {
              val h = getHeight(size, magic, i2)
              if (getZeroCount(h) <= 1)
                n = sum - h.sum
            }
            if (n >= 0) {
              magic(i1)(i2) = n
              if (!b)
                skipped = false
            } else {
              b = true
              skipped = true
            }
          }
        }
      }
    } while(skipped)
    for (line <- magic)
      println(line.mkString(" "))
  }

  def getHeight(size: Int, magic: Array[Array[Int]], x: Int): Array[Int] = {
    val array = new Array[Int](size)
    for (i <- 0 to size-1)
      array(i) = magic(i)(x)
    array
  }

  def getSlant(size: Int, magic: Array[Array[Int]], x: Int): Array[Int] = {
    val array = new Array[Int](size)
    var h = size -1
      for (i <- 0 to size-1) {
        if (x == 0)
          array(i) = magic(i)(i)
        else if (x == size -1)
          array(i) = magic(h)(i)
          h = h - 1
      }
    array
  }

  def getZeroCount(array: Array[Int]): Int = {
    var c = 0
    for (line <- array)
      if (line == 0)
        c = c + 1
    c
  }

  def getSum(size: Int, magic: Array[Array[Int]]): Int = {
    for (i <- 0 to size-1) {
      val w = magic(i)
      if (!w.exists(_ == 0))
        return w.sum
      val h = getHeight(size, magic, i)
      if (!h.exists(_ == 0))
        return h.sum
    }
    val ls = getSlant(size, magic, 0)
    if (!ls.exists(_ == 0))
      return ls.sum
    val rs = getSlant(size, magic, size-1)
    if (!rs.exists(_ == 0))
      return rs.sum
    throw new IllegalArgumentException
  }
}
