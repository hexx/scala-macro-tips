package com.github.hexx

import scala.reflect.macros.Context

object TypeFromTree {
  def typeFromTree[T](t: T) = macro impl[T]

  def intListType = macro intListTypeImpl

  def impl[T](c: Context)(t: c.Expr[T]) =
    c.literal(t.actualType.toString)

  def intListTypeImpl(c: Context) = {
    import c.universe._
    c.literal(c.typeCheck(q"List(1, 2, 3)").tpe.toString)
  }
}
