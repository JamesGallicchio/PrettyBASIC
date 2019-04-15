package pbasic.memory

import pbasic.expr.IntExpr
import pbasic.{BNode, Ident, Statement}

sealed abstract class VarSize(val basic: String) extends BNode

object VarSize {
  case object BIT extends VarSize("Bit")
  case object NIB extends VarSize("Nib")
  case object BYTE extends VarSize("Byte")
  case object WORD extends VarSize("Word")
}

case class VarDecl(id: Ident, size: VarSize) extends Statement(s"$id VAR $size")

case class ArrDecl(id: Ident, size: VarSize, count: Int) extends Statement(s"$id VAR $size($count)")

case class VarAssign(id: Ident, value: IntExpr) extends Statement(s"$id = $value")

case class ArrAssign(id: Ident, value: IntExpr, idx: IntExpr) extends Statement(s"$id($idx) = $value")

case class VarRef(id: Ident) extends IntExpr(s"$id")

case class ArrRef(id: Ident, idx: IntExpr) extends IntExpr(s"$id($idx)")
