import scala.reflect.makro.{Context => Ctx}

object Impls {
  def foo(unconventionalName: Ctx)(x: unconventionalName.Expr[Int]) = {
    import unconventionalName.mirror._
    val body = Block(
      Apply(Select(Ident(definitions.PredefModule), newTermName("println")), List(Literal(Constant("invoking foo...")))),
      Literal(Constant(())))
    Expr[Unit](body)
  }
}

object Macros {
  def foo(x: Int) = macro Impls.foo
}
