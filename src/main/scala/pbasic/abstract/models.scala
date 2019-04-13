package abstract

import pbasic.{Ident, Statement}
import pbasic.control.{Label, Return}
import pbasic.expr.{Expression, Conditional}
import pbasic.memory.VarSize


case class Variable(name: Ident, type: Variable.Type) 
object Variable {
  sealed trait Type
  
  case class Size(t: VarSize) extends Type
  implicit Size2Type: VarSize => Type = Size(_)
  
  case class Array(t: VarSize, size: Int)
}


case class Subprogram(name: Ident, body: Seq[Statement])
    extends Block(
      Label(name) +:
      body :+
      Return)


case class Program(vars: Seq[Variable], subs: Traversable[Subprogram], main: Block)

case class AnonymousIdent extends Ident


case class Function[-T <: Expression, +R <: Expression]() {
  def apply(t: T): Abstraction[R] = 

case class Match[T <: Expression](in: T, cases: Seq[(Conditional, Block)])
