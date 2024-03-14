import Produtos.Produtos
import Ping.Ping
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._

object Projeto extends App {
  implicit val system = ActorSystem("my-system")
  implicit val executionContext = system.dispatcher

  private val produto = Produtos();
  private val ping = Ping();

  private val combinedRoutes = concat(
    produto.ProdutosRoute.route,
    ping.PingRoutes.routes
  )

  private val bindingFuture = Http().newServerAt("localhost", 8080).bind(combinedRoutes)
  println(s"Server online at http://localhost:8080/ping \nPress RETURN to stop...")
  scala.io.StdIn.readLine()

  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())

  }
