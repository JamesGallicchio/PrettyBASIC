package pbasic.expr

import pbasic.BNode


trait Expression extends BNode


abstract class IntExpr(val basic: String) extends Expression

case class Add(a: IntExpr, b: IntExpr) extends IntExpr(s"($a)+($b)")
case class Sub(a: IntExpr, b: IntExpr) extends IntExpr(s"($a)-($b)")
case class Mult(a: IntExpr, b: IntExpr) extends IntExpr(s"($a)*($b)")
case class Div(a: IntExpr, b: IntExpr) extends IntExpr(s"($a)/($b)")

case class IntConst(n: Int) extends IntExpr(n.toString)



abstract class Conditional(val basic: String) extends Expression

case class Equals(a: IntExpr, b: IntExpr) extends Conditional(s"$a=$b")
case class LessThan(a: IntExpr, b: IntExpr) extends Conditional(s"$a<$b")
case class GreaterThan(a: IntExpr, b: IntExpr) extends Conditional(s"$a>$b")


trait StrExpr extends Expression
