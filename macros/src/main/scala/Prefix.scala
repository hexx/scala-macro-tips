package com.github.hexx

import scala.reflect.macros.Context

trait Prefix {
  def prefix = macro Prefix.prefixImpl
  def prefixTree = macro Prefix.prefixTreeImpl
  def prefixHello = macro Prefix.prefixHelloImpl
}

object Prefix {
  def prefixImpl(c: Context): c.Expr[Any] = {
    import c.universe._
    c.prefix
  }

  def prefixTreeImpl(c: Context): c.Expr[String] = {
    import c.universe._
    c.literal(showRaw(c.prefix.tree))
  }

  def prefixHelloImpl(c: Context): c.Expr[Any] = {
    import c.universe._
    c.Expr[Any](q"${c.prefix.tree}.hello")
  }
}
