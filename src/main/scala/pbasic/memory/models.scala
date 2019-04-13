package memory

import pbasic.expr.{Expression, IntExpr}

sealed trait VarSize extends Expression {
  case class BIT extends VarSize("Bit")
  case class NIB extends VarSize("Nib")
  case class BYTE extends VarSize("Byte")
  case class WORD extends VarSize("Word")
}

case class VarDecl(id: Ident, size: VarSize) extends Statement(s"$id VAR $size")

case class ArrDecl(id: Ident, size: VarSize, count: Int) extends Statement(s"$id VAR $size($count)")

case class VarAssign(id: Ident, value: IntExpr) extends Statement(s"$id = $value")

case class ArrAssign(id: Ident, value: IntExpr, idx: IntExpr) extends Statement(s"$id($idx) = $value")

case class VarRef(id: Ident) extends IntExpr(s"$id")

case class ArrRef(id: Ident, idx: IntExpr) extends IntExpr(s"$id($idx)")
