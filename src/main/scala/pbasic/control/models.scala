package pbasic.control

import pbasic.{BNode, Block, Ident, Statement}
import pbasic.expr.{Conditional, IntExpr}
import pbasic.utils.OptParams.?


case class If(cond: Conditional, body: Block)(els: ?[ElseStatement] = None)
  extends Statement(
    s"""
       |IF ($cond) THEN
       |$body${els.map("\n" + _.basic).getOrElse("")}
       |ENDIF
    """.stripMargin)

sealed abstract class ElseStatement(val basic: String) extends BNode

case class ElseIf(cond: Conditional, body: Block)(els: ?[ElseStatement])
  extends ElseStatement(s"ELSEIF ($cond) THEN\n$body")

case class Else(body: Block)
  extends ElseStatement(s"ELSE\n$body")


case class For(counter: Ident, start: IntExpr, end: IntExpr, block: Block)
  extends Statement(
    s"""
       |FOR $counter = $start TO $end
       |$block
       |NEXT
    """.stripMargin)

case class Do(block: Block)
  extends Statement(
    s"""
       |DO
       |$block
       |LOOP
    """.stripMargin)

case class DoWhile(cond: Conditional, block: Block)
  extends Statement(
    s"""
       |DO WHILE($cond)
       |$block
       |LOOP
    """.stripMargin)

case class DoUntil(cond: Conditional, block: Block)
  extends Statement(
    s"""
       |DO UNTIL($cond)
       |$block
       |LOOP
    """.stripMargin)

case class DoLoopWhile(cond: Conditional, block: Block)
  extends Statement(
    s"""
       |DO
       |$block
       |LOOP WHILE($cond)
    """.stripMargin)

case class DoLoopUntil(cond: Conditional, block: Block)
  extends Statement(
    s"""
       |DO
       |$block
       |LOOP UNTIL($cond)
    """.stripMargin)

case class Label(ident: Ident)
  extends BNode { val basic = s"$ident:" }

case class GoTo(ident: Ident)
  extends Statement(s"GOTO $ident")

case class SubRoutine(ident: Ident, body: Block)
  extends Statement(
    s"""
      |$ident:
      |$body
      |RETURN
    """.stripMargin)

case class GoSub(ident: Ident) extends Statement(s"GOSUB $ident")

case object Return extends Statement("RETURN")