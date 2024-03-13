package Projeto

import akka.http.scaladsl.server.Directives._
class HelloRoute {
  object HelloRoutes {
    object HelloRoutes {
      val routes =
        path("hello") {
          get {
            complete("Hello, world!")
          }
        }
    }

  }


}
