package pbasic.expr

import pbasic.BNode

trait Expression extends BNode



trait IntExpr extends Expression

case class Add(a: IntExpr, b: IntExpr) extends IntExpr(s"($a)+($b)")
case class Sub(a: IntExpr, b: IntExpr) extends IntExpr(s"($a)-($b)")
case class Mult(a: IntExpr, b: IntExpr) extends IntExpr(s"($a)*($b)")
case class Div(a: IntExpr, b: IntExpr) extends IntExpr(s"($a)/($b)")


trait Conditional extends Expression

case class Equals(a: IntExpr, b: IntExpr) extends Conditional(s"$a=$b")



trait StrExpr extends Expression