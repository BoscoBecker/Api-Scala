package HelloRoute

import Projeto.Connect
import akka.http.scaladsl.server.Directives._
case class Hello() {
  val connection = new Connect();
    object HelloRoutes {
      val routes =
        path("hello") {
          get {
            val result = connection
                          .SQLServerConnection
                          .executeQuery("select * from Produtos");
            complete(result.toString());
          }
        }
    }
}
