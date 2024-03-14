package Ping

import akka.http.scaladsl.server.Directives.{complete, get, path}
case class Ping() {
  object PingRoutes {
    val routes =
      path("ping") {
        get {
          complete("pong")
        }
      }
  }
}
