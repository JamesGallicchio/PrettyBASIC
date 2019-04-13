package pbasic

import pbasic.expr.Expression

abstract class BNode(basic: => String) {
  def toBasic: String = basic
  override def toString: String = basic
}

trait Statement extends BNode

case class Block(lines: Seq[Statement]) extends BNode(lines.mkString("\n"))

case class Ident(name: String) extends BNode(name)

case class Comment(text: String) extends BNode('\'' + text)
