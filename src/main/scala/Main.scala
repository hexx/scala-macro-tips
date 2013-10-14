import com.github.hexx._

class Person(name: String, age: Int) {
  def hello = s"Hello, $name"
}

object Main extends App {
  val p = new Person("hogeika", 13) with Prefix with Enclosing

  // prefix
  println(p == p.prefix)
  println(p.prefixTree)
  println(p.prefixHello)
  println((new Person("hogeika", 13) with Prefix).prefixTree)

  // enclosing
  println(p.enclosingPosition)
  println(p.warning)
  def method = p.enclosingTrees
  val (classTree, methodTree, compileUnitTree) = method
  println(classTree)
  println(methodTree)
  println(compileUnitTree)
}
