package com.github.hexx

import scala.reflect.macros.Context

object WTypeTag {
  def wtypetag[T](t: T) = macro impl[T]

  def impl[T: c.WeakTypeTag](c: Context)(t: c.Expr[T]) = {
    import c.universe._
    c.literal(weakTypeOf[T].toString)  }
}
