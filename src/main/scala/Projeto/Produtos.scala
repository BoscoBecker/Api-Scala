package Produtos

import Projeto.Connect
import akka.http.scaladsl.server.Directives._
case class Produtos() {
  val connection = new Connect();
    object ProdutosRoute {
      val route =
        path("Produtos") {
          get {
            val result = connection
                          .SQLServerConnection
                          .executeQuery("select * from Produtos");
            complete(result.toString());
          }
        }
    }
}
