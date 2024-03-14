package Produtos
import Projeto.Connect
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives._
import play.api.libs.json.Json
//import io.circe._
//import io.circe.syntax._
case class Produtos() {
  val connection = new Connect();
    object ProdutosRoute {
      //private val sql = "SELECT * FROM Produtos"
      //private val fields = Seq("id", "nome", "descricao")

      val route =
        path("Produtos") {
           get {
            val result = connection
                          .SQLServerConnection
                          .executeQuery("SELECT * FROM Produtos");
             val json = Json.toJson(result)
             val entity = HttpEntity(ContentTypes.`application/json`, json.toString())
             complete(HttpResponse(StatusCodes.OK, entity = entity)) //VALID (RFC 8259) - application/json
          }
        }
    }
}
