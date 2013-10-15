import com.github.hexx._

class Person(name: String, age: Int) {
  def hello = s"Hello, $name"
}

object Main extends App {
  def prefix = {
    val p = new Person("hogeika", 13) with Prefix

    println(p == p.prefix)
    println(p.prefixTree)
    println(p.prefixHello)
    println((new Person("hogeika", 13) with Prefix).prefixTree)
  }

  def enclosing = {
    // enclosingPosition
    println(Enclosing.enclosingPosition)
    println(Enclosing.warning)

    // enclosingClass, enclosingMethod, enclosingUnit
    def method = Enclosing.enclosingTrees
    val (classTree, methodTree, compileUnitTree) = method
    println(classTree)
    println(methodTree)
    println(compileUnitTree)

    // enclosingImplicits
    import com.github.hexx.Enclosing._
    def method2(i: Int)(implicit s: String) = println(s)
    method2(123)
  }

  prefix
  enclosing
}
