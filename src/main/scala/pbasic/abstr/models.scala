package pbasic.abstr

import pbasic.control.SubRoutine
import pbasic.expr.{Conditional, Expression}
import pbasic.memory.VarSize
import pbasic.{Block, Ident}


case class Variable(name: Ident, vtype: Variable.Type)
object Variable {
  sealed trait Type
  
  case class Size(t: VarSize) extends Type
  implicit val Size2Type: VarSize => Type = Size
  
  case class Array(t: VarSize, size: Int) extends Type
}


case class Program(vars: Seq[Variable], subs: Traversable[SubRoutine], main: Block)


case class Function[-T <: Expression, +R <: Expression]() {
  def apply(t: T): Nothing = ???
}

case class Match[T <: Expression](in: T, cases: Seq[(Conditional, Block)])
