package Projeto
import akka.actor.ActorSystem

import java.sql.{Connection, DriverManager, ResultSet}
import scala.concurrent.ExecutionContextExecutor
case class Connect() {
  object SQLServerConnection {
    implicit val system: ActorSystem = ActorSystem("my-system")
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    private val url = "jdbc:sqlserver://;servername=DESKTOP-G0TT3JA\\SQLEXPRESS;databaseName=DB"
    private val username = "hollemax"
    private val password = "cidadao"

    def executeQuery(sql: String): Seq[String] = {
      var connection: Connection = null
      var resultSet: ResultSet = null
      var resultSeq: Seq[String] = Seq.empty

      try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
        connection = DriverManager.getConnection(url, username, password)
        val statement = connection.createStatement()
        resultSet = statement.executeQuery(sql)

        while (resultSet.next()) {
          val id = resultSet.getInt("id")
          val Nome = resultSet.getString("Nome")
          val Descricao = resultSet.getString("Descricao")
          resultSeq :+= s"${id.toString} -  $Nome - $Descricao"
          //val row: Seq[String] = fields.map(resultSet.getString)
          //resultSeq :+= row.toString()
        }
      } catch {
        case e: Exception => e.printStackTrace()
      } finally {
        if (resultSet != null) resultSet.close()
        if (connection != null) connection.close()
      }
      return resultSeq;
    }
  }
}
