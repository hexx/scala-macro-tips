package com.github.hexx

import scala.reflect.macros.Context

trait Enclosing {
  def enclosingPosition = macro Enclosing.enclosingPositionImpl

  def warning = macro Enclosing.warningImpl

  def enclosingTrees = macro Enclosing.enclosingTreesImpl
}

object Enclosing {
  def enclosingPositionImpl(c: Context): c.Expr[(Int, Int)] = {
    import c.universe._
    val p = c.enclosingPosition
    reify((c.literal(p.line).splice, c.literal(p.column).splice))
  }

  def warningImpl(c: Context): c.Expr[Unit] = {
    import c.universe._
    c.warning(c.enclosingPosition, "Don't mind this message.")
    c.literalUnit
  }

  def enclosingTreesImpl(c: Context): c.Expr[(String, String, String)] = {
    import c.universe._
    val k = c.literal(c.enclosingClass.toString)
    val m = c.literal(c.enclosingMethod.toString)
    val u = c.literal(c.enclosingUnit.body.toString)
    reify((k.splice, m.splice, u.splice))
  }
}
