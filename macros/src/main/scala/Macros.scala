import scala.reflect.macros.Context
import scala.language.experimental.macros
import scala.annotation.StaticAnnotation

object AntMacro {
  def impl(c: Context)(annottees: c.Tree*): c.Tree = {
    import c.universe._
    c.typecheck(annottees.head).symbol.asType.toType.decls // ok
//    c.typecheck(annottees.head).toString // throws error
//    c.typecheck(annottees.head).symbol.asType.toType.members  // throws error
    q"""class A { def ask() = println("OK") }"""
  }
}

class Ant extends StaticAnnotation {
  def macroTransform(annottees: Any*): Unit = macro AntMacro.impl
}