import HelloRoute.HelloRoute
import Ping.Ping
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object Projeto extends App {
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val hello = new HelloRoute();
  val ping = new Ping();

  val combinedRoutes = concat(
    hello.HelloRoutes.routes,
    ping.Ping.routes
  )


  val bindingFuture = Http().newServerAt("localhost", 8080).bind(combinedRoutes)
  println(s"Server online at http://localhost:8080/ping\nPress RETURN to stop...")
  scala.io.StdIn.readLine()

  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())

  }
