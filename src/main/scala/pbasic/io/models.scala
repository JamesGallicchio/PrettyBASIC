package pbasic.io

import pbasic.expr.IntExpr
import pbasic.{BNode, Statement}

case class Pin private (int: Int) extends BNode(s"PIN_$int")

object Pin {
  val _0 = Pin(0)
  val _1 = Pin(1)
  val _2 = Pin(2)
  val _3 = Pin(3)
  val _4 = Pin(4)
  val _5 = Pin(5)
  val _6 = Pin(6)
  val _7 = Pin(7)
  val _8 = Pin(8)
  val _9 = Pin(9)
  val _10 = Pin(10)
  val _11 = Pin(11)
  val _12 = Pin(12)
  val _13 = Pin(13)
  val _14 = Pin(14)
  val _15 = Pin(15)
}

case class PulsOut(pin: Pin, duration: IntExpr) extends Statement(s"PULSOUT $pin, $duration")
