package pbasic

trait BNode {
  def basic: String
  def toBasic: String = basic
  override def toString: String = basic
}

abstract case class Statement(basic: String) extends BNode

case class Block(lines: Seq[Statement]) extends BNode { val basic: String = lines.mkString("\n") }

case class Ident(basic: String) extends BNode

case class Comment(text: String) extends BNode { val basic: String = '\'' + text }
