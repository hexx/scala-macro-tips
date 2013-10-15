package com.github.hexx

import scala.reflect.macros.Context

object Enclosing {
  def enclosingPosition = macro enclosingPositionImpl

  def warning = macro enclosingTreesImpl

  def enclosingPositionImpl(c: Context): c.Expr[(Int, Int)] = {
    import c.universe._
    val p = c.enclosingPosition
    reify((c.literal(p.line).splice, c.literal(p.column).splice))
  }

  def warningImpl(c: Context): c.Expr[Unit] = {
    c.error(c.enclosingPosition, "Don't mind this message.")
    c.literalUnit
  }

  def enclosingTrees = macro enclosingTreesImpl

  def enclosingTreesImpl(c: Context): c.Expr[(String, String, String)] = {
    import c.universe._
    val k = c.literal(c.enclosingClass.toString)
    val m = c.literal(c.enclosingMethod.toString)
    val u = c.literal(c.enclosingUnit.body.toString)
    reify((k.splice, m.splice, u.splice))
  }

  implicit def enclosingImplicits = macro enclosingImplicitsImpl

  def enclosingImplicitsImpl(c: Context): c.Expr[String] = {
    c.literal(c.enclosingImplicits.mkString)
  }
}
