package memory

import pbasic.expr.{Expression, IntExpr}

sealed trait VarSize extends Expression {
  case class BIT extends VarSize("Bit")
  case class NIB extends VarSize("Nib")
  case class BYTE extends VarSize("Byte")
  case class WORD extends VarSize("Word")
}

case class VarDecl(id: Ident, size: VarSize, count: Int = 1) extends
            Statement(s"$id VAR $size${if (count > 1) s"($count)" else ""}")

case class VarAssign(id: Ident, value: IntExpr, idx: Int = 0) extends
            Statement(s"${id.name}${if (idx > 0) s"($idx)" else ""} = ${value.toBasic}")

case class VarRef(id: Ident, idx: Int = 0) extends
            IntExpr(s"${id.name}${if (idx > 0) s"($idx)" else ""}")
