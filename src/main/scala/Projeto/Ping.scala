package Ping

import akka.http.scaladsl.server.Directives.{complete, get, path}
class Ping {
  object Ping {
    val routes =
      path("ping") {
        get {
          complete("pong")
        }
      }
  }
}
