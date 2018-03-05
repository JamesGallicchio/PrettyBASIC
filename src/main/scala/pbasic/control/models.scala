package pbasic.control

import pbasic.{BNode, Block, Ident, Statement}
import pbasic.expr.{Conditional, IntExpr}

case class If(cond: Conditional, block: Block, elsBranches: Seq[(Conditional, Block)]*)(els: Block = null)
  extends Statement(
    s"IF ($cond) THEN\n$block\n" +
      elsBranches.map { case (c, b) =>
        s"ELSEIF ($c) THEN\n$b\n"
      }.mkString +
      Option(els).map(
        "ELSE\n" + _).getOrElse("") +
      "ENDIF")

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
  extends BNode(s"$ident:")

case class GoTo(ident: Ident)
  extends Statement(s"GOTO $ident")

case object Return
  extends Statement("RETURN")

case class Sub(ident: Ident, block: Block)
  extends Statement(
    s"""
       |$ident:
       |$block
       |$Return
   """.stripMargin)