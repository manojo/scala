import scala.reflect.mirror._

object Test extends App {
  def fooNoTypeTagHK[C[_], T] = {
    println(implicitly[TypeTag[C[T]]])
    println(implicitly[TypeTag[List[C[T]]]])
  }
  fooNoTypeTagHK[List, Int]
}